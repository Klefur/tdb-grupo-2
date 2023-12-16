package com.tbd.lab3.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Projections;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tbd.lab3.models.Voluntary;
import com.tbd.lab3.repositories.VoluntaryRepository;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class VoluntaryService {

    @Autowired
    VoluntaryRepository voluntaryRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/voluntaries")
    public List<Voluntary> getAllVoluntaries() {
        return voluntaryRepository.findAll();
    }


    @GetMapping("/voluntaries/{rut}")
    public List<Voluntary> getVoluntaryByRut(@PathVariable("rut") String rut) {
        return voluntaryRepository.findByRut(rut);
    }

    @GetMapping("/voluntaries/count")
    public String countVoluntary(){
        long total = voluntaryRepository.count();
        return String.format("Tienes %s Voluntarios", total);
    }

    @PostMapping("/voluntaries")
    @ResponseBody
    public Voluntary createVoluntary(@RequestBody Voluntary voluntary){
        return voluntaryRepository.save(voluntary);
    }

    @PutMapping("/voluntaries/{rut}")
    @ResponseBody
    public String editVoluntary(@PathVariable("rut") String rut, @RequestBody Voluntary voluntary){
        voluntary.setRut(rut);
        voluntaryRepository.save(voluntary);
        if (!voluntaryRepository.findByRut(rut).isEmpty()){
            return "Edited voluntary";
        }else{
            return "Voluntary not found";
        }
    }

    @DeleteMapping("/voluntaries/{id_voluntary}")
    public String deleteVoluntaryAbility(@PathVariable("id_voluntary") ObjectId id_voluntary){
        Voluntary voluntary = voluntaryRepository.findBy_id(id_voluntary).get(0);
        voluntaryRepository.delete(voluntary);
        boolean result = voluntaryRepository.findByRut(voluntary.getRut()).isEmpty();
        if(result){
            return "Deleted Voluntary";
        }
        else{
            return "Voluntary not found";
        }
    }

    @DeleteMapping("/voluntaries")
    public String deleteAllVoluntaries(){
        voluntaryRepository.deleteAll();
        if(voluntaryRepository.findAll().isEmpty()){
            return "Deleted voluntaries";
        }else{
            return "Not deleted";
        }
    }

    @GetMapping("/count-abilities-voluntaries")
    public List<Document> countAbilitiesVoluntaries(){
        MongoCollection<Document> collection = mongoTemplate.getCollection("Voluntary");

        Bson unwind = Aggregates.unwind("$abilities");
        Bson group = Aggregates.group("$rut",
                Accumulators.sum("count", 1),
                Accumulators.first("rut", "$rut"));
        Bson project = Aggregates.project(Projections.fields(
                Projections.excludeId(),
                Projections.include("count"),
                Projections.computed("rut", "$rut")
        ));

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(unwind, group, project));

        List<Document> voluntariesAbilities = new ArrayList<>();

        for(Document doc : result){
            voluntariesAbilities.add(doc);
        }

        return voluntariesAbilities;
    }
}

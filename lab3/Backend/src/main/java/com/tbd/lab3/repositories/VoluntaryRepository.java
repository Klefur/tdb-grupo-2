package com.tbd.lab3.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.tbd.lab3.models.Voluntary;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/*
 * This interface class represents the voluntary repository.
 * */
public interface VoluntaryRepository extends MongoRepository<Voluntary, ObjectId>{

    @Query("{ 'voluntary.rut' :  ?0}")
    List<Voluntary> findByRut(String rut);

    List<Voluntary> findBy_id(ObjectId id);
}

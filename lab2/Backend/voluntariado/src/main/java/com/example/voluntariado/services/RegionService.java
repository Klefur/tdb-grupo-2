package com.example.voluntariado.services;

import com.example.voluntariado.models.Region;
import com.example.voluntariado.repositories.RegionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class RegionService {
    private final RegionRepository regionRepository;

    RegionService(RegionRepository regionRepository){
        this.regionRepository = regionRepository;
    }

    @GetMapping("/regions")
    public List<Region> getAllRegions(){
        return regionRepository.getAllRegions();
    }

    @GetMapping("/regions/{gid}")
    public List<Region> getRegionById(@PathVariable("gid") int gid){
        return regionRepository.getRegionById(gid);
    }

    @PostMapping("/regions")
    @ResponseBody
    public Region createRegion(@RequestBody Region region){
        return regionRepository.createRegion(region);
    }

    @PutMapping("/regions/{gid}")
    public Region editRegion(@PathVariable("gid") int gid, @RequestBody Region region){
        region.setGid(gid);
        if(regionRepository.editRegion(region)){
            return region;
        }else{
            return null;
        }
    }

    @DeleteMapping("/regions/{gid}")
    public Region deleteRegion(@PathVariable("gid") int gid){
        Region region = regionRepository.getRegionById(gid).get(0);
        if(regionRepository.deleteRegion(gid)){
            return region;
        }else{
            return null;
        }
    }

    @DeleteMapping("/regions")
    public int deleteAllRegions(){
        return regionRepository.deleteAllRegions();
    }

}

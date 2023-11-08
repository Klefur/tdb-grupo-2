package com.example.voluntariado.repositories;

import com.example.voluntariado.models.Region;

import java.util.List;

/*
* This interface represents a region repository.
* */
public interface RegionRepository {
    public List<Region> getAllRegions();
    public List<Region> getRegionById(Integer id);
    public Region createRegion(Region region);
    public boolean editRegion(Region region);
    public boolean deleteRegion(Integer id);
    public int deleteAllRegions();
}

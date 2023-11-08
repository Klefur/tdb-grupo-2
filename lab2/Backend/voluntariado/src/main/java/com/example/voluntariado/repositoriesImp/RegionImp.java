package com.example.voluntariado.repositoriesImp;

import com.example.voluntariado.models.Region;
import com.example.voluntariado.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

/*
* This class represents an implementation of region repository.
* */
@Repository
public class RegionImp implements RegionRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Region> getAllRegions(){
        try(Connection connection = sql2o.open()){
            return connection
                    .createQuery("SELECT * FROM \"region\"")
                    .executeAndFetch(Region.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Region> getRegionById(Integer gid){
        try(Connection connection = sql2o.open()){
            return connection
                    .createQuery("SELECT * FROM \"region\" WHERE region.gid =:gid")
                    .addParameter("gid", gid)
                    .executeAndFetch(Region.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Region createRegion(Region region){
        try(Connection connection = sql2o.open()){
            int insertedId = (int) connection
                    .createQuery("INSERT INTO \"region\" (region_name, geometry) VALUES (:region_name, :geometry", true)
                    .addParameter("region_name", region.getRegion_name())
                    .addParameter("geometry", region.getGeometry())
                    .executeUpdate()
                    .getKey();
            region.setGid(insertedId);
            return region;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean editRegion(Region region){
        try(Connection connection = sql2o.open()){
            connection
                    .createQuery("UPDATE \"region\" SET region_name = :region_name, geometry = :geometry WHERE gid =:gid")
                    .addParameter("gid", region.getGid())
                    .addParameter("region_name", region.getRegion_name())
                    .addParameter("geometry", region.getGeometry())
                    .executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteRegion(int gid){
        try(Connection connection = sql2o.open()){
            connection
                    .createQuery("DELETE FROM \"region\" WHERE gid = :gid")
                    .addParameter("gid", gid)
                    .executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public int deleteAllRegions(){
        int total = 0;
        try(Connection connection = sql2o.open()){
            total = connection.createQuery("DELETE FROM \"region\"")
                    .executeUpdate()
                    .getResult();
        }
        return total;
    }
}

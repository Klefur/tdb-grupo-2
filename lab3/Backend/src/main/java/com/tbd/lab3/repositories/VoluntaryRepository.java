package com.tbd.lab3.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.tbd.lab3.models.Voluntary;

/*
 * This interface class represents the voluntary repository.
 * */
public interface VoluntaryRepository extends MongoRepository<Voluntary, ObjectId>{
}

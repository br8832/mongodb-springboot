package com.example.mdbspringboot.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.mdbspringboot.model.DatabaseSequence;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

//Credit: https://github.com/eugenp/tutorials/blob/master/persistence-modules/spring-boot-persistence-mongodb/README.md

@Service
public class SequenceGenerator {
	

    private MongoOperations mongoOperations;

    @Autowired
    public SequenceGenerator(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public int generateSequence(String seqName) {

        DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                DatabaseSequence.class);
        return (int) (!Objects.isNull(counter) ? counter.getSeq() : 1);

    }
}
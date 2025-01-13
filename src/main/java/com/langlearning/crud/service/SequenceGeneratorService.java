package com.langlearning.crud.service;

import com.langlearning.crud.entity.DatabaseSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class SequenceGeneratorService {

    @Autowired
    private MongoOperations mongoOperations;

    public int generateSequence(String seqName) {
        System.out.println("Looking for sequence: " + seqName);
        DatabaseSequence counter = mongoOperations.findAndModify(
                Query.query(where("_id").is(seqName)),
                new Update().inc("seq", 1),
                DatabaseSequence.class);

        if (counter == null) {
            System.err.println("Sequence not found: " + seqName);
            throw new IllegalArgumentException("Sequence not found: " + seqName);
        }

        System.out.println("Generated sequence: " + counter.getSeq());
        return counter.getSeq();
    }
}
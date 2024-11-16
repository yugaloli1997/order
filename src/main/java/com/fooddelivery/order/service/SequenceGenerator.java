package com.fooddelivery.order.service;

import com.fooddelivery.order.entity.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;



@Service
public class SequenceGenerator {

    @Autowired
    private MongoOperations mongoOperations;

    public int generateNextOrderID() {
        Query query = new Query(Criteria.where("_id").is("sequence"));
        Update update = new Update().inc("sequence", 1);

        // Setting options for upsert and returnNew, removing unnecessary locale/collation settings
        FindAndModifyOptions options = new FindAndModifyOptions().returnNew(true).upsert(true);

        Sequence counter = mongoOperations.findAndModify(query, update, options, Sequence.class);
        return Objects.requireNonNull(counter).getSequence();
    }

}

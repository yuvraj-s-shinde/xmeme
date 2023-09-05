package com.crio.starter.repositoryservices;

import java.util.Objects;
import com.crio.starter.data.SequenceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class SequenceGenerator {

    @Autowired
    private MongoOperations mongoOperations;

    @Autowired
    public SequenceGenerator(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public long generateSequence(String seqName) {
        Criteria criteria = new Criteria("_id").is(seqName);
        Query query = Query.query(criteria);
        FindAndModifyOptions options = new FindAndModifyOptions();
        options.returnNew(true).upsert(true);

        SequenceEntity memeCounter = mongoOperations.findAndModify(query,
                new Update().inc("seq",1), options,
                SequenceEntity.class);
        return !Objects.isNull(memeCounter) ? memeCounter.getSeq() : 1;
    }
}
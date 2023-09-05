package com.crio.starter.repositoryservices;

import com.crio.starter.data.MemesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
public class MemeListener extends AbstractMongoEventListener<MemesEntity> {

    private SequenceGenerator sequenceGenerator;

    @Autowired
    public MemeListener(SequenceGenerator sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<MemesEntity> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator.generateSequence(MemesEntity.SEQUENCE_NAME));
        }
    }
}
package com.crio.starter.repositoryservices;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.concurrent.Future;
import com.crio.starter.data.MemesEntity;
import com.crio.starter.dto.Meme;
import com.crio.starter.exchange.CreateMemeRequest;
import com.crio.starter.exchange.GetMemeRequest;
import com.crio.starter.repository.MemesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.scheduling.annotation.Async;

public class MemesRepositoryServiceImpl implements MemesRepositoryService {

  @Autowired
  MemesRepository memesRepository;

  @Autowired
  private MongoOperations mongoOperations;

  public MemesRepositoryServiceImpl() {
  }

  @Autowired
  public MemesRepositoryServiceImpl(MongoOperations mongoOperations) {
    this.mongoOperations = mongoOperations;
  }
  
  public Meme createMeme(CreateMemeRequest createMemeRequest) {
    Query query = new Query();
    query.addCriteria(Criteria.where("").andOperator(Criteria.where("name").is(createMemeRequest.getName()), 
                                                     Criteria.where("url").is(createMemeRequest.getUrl()),
                                                     Criteria.where("caption").is(createMemeRequest.getCaption())));
    List<MemesEntity> existingMemes = mongoOperations.find(query, MemesEntity.class);
    
    if (existingMemes.size() != 0) {
      return null;
    } else {
      MemesEntity memeDocument  = new MemesEntity();
      memeDocument.setCaption(createMemeRequest.getCaption());
      memeDocument.setName(createMemeRequest.getName());
      memeDocument.setUrl(createMemeRequest.getUrl());
      memesRepository.save(memeDocument);

      return new Meme(memeDocument.getId(), memeDocument.getName(), memeDocument.getUrl(), memeDocument.getCaption());
    }
  }

  public List<Meme> getMemes() {
    List<MemesEntity> memesEntities = memesRepository.findAll();
    List<Meme> memes = new ArrayList<>();
    for (MemesEntity memesEntity: memesEntities) {
      memes.add(new Meme(memesEntity.getId(), memesEntity.getName(), memesEntity.getUrl(), memesEntity.getCaption()));
    }
    return memes;
  }

  public Meme getMemeById(GetMemeRequest getMemeRequest) {
    // List<MemesEntity> memesEntities = memesRepository.findAll();
    // for (MemesEntity memesEntity: memesEntities) {
    //   if (memesEntity.getId() == Long.parseLong(getMemeRequest.getId())) {
    //     return new Meme(memesEntity.getId(), memesEntity.getName(), memesEntity.getUrl(), memesEntity.getCaption()); 
    //   }
    // }
    // return null;
    
    Optional<MemesEntity> memesEntityOptional  = memesRepository.findById(Long.parseLong(getMemeRequest.getId()));
    if (memesEntityOptional.isPresent()) {
      MemesEntity memesEntity = memesEntityOptional.get();
       return new Meme(memesEntity.getId(), memesEntity.getName(), memesEntity.getUrl(), memesEntity.getCaption());
    }
    return null;
  }
}
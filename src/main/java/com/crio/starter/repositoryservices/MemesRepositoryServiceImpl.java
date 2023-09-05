package com.crio.starter.repositoryservices;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.concurrent.Future;
import com.crio.starter.data.MemesEntity;
import com.crio.starter.dto.Meme;
import com.crio.starter.exchange.CreateMemeRequest;
import com.crio.starter.repository.MemesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

public class MemesRepositoryServiceImpl implements MemesRepositoryService {

  @Autowired
  MemesRepository memesRepository;
  
  public Meme createMeme(CreateMemeRequest createMemeRequest) {
    MemesEntity memeDocument  = new MemesEntity();
    memeDocument.setCaption(createMemeRequest.getCaption());
    memeDocument.setName(createMemeRequest.getName());
    memeDocument.setUrl(createMemeRequest.getUrl());
    memesRepository.save(memeDocument);

    return new Meme(memeDocument.getId(), memeDocument.getName(), memeDocument.getUrl(), memeDocument.getCaption());  
  }
  
}
package com.crio.starter.service;

import com.crio.starter.exchange.CreateMemeRequest;
import com.crio.starter.exchange.CreateMemeResponse;
import com.crio.starter.repositoryservices.MemesRepositoryService;
import com.crio.starter.repository.MemesRepository;
import com.crio.starter.data.MemesEntity;
import java.util.Optional;
import com.crio.starter.exchange.ResponseDto;
import com.crio.starter.repository.GreetingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemesServiceImpl implements MemesService {

  @Autowired
  private MemesRepositoryService memesRepositoryService;

  public CreateMemeResponse createMeme(CreateMemeRequest createMemeRequest) {
    Optional<MemesEntity> meme = memesRepositoryService.createMeme(createMemeRequest);
    if (meme.isPresent()) {
      return new CreateMemeResponse(meme.get().getId());
    }
    else {
      return null;
    }
  }
}

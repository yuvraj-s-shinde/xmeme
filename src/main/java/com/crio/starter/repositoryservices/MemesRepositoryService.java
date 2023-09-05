package com.crio.starter.repositoryservices;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;
import com.crio.starter.data.MemesEntity;
import com.crio.starter.dto.Meme;
import com.crio.starter.exchange.CreateMemeRequest;
import org.springframework.scheduling.annotation.Async;

public interface MemesRepositoryService {

  public Meme createMeme(CreateMemeRequest createMemeRequest);

}
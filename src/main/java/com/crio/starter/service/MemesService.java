package com.crio.starter.service;

import com.crio.starter.exchange.CreateMemeRequest;
import com.crio.starter.exchange.CreateMemeResponse;
import com.crio.starter.exchange.ResponseDto;
import com.crio.starter.repository.GreetingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface MemesService {

  public CreateMemeResponse createMeme(CreateMemeRequest createMemeRequest);
}

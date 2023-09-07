package com.crio.starter.service;

import com.crio.starter.exchange.CreateMemeRequest;
import com.crio.starter.exchange.GetMemeResponse;
import com.crio.starter.exchange.CreateMemeResponse;
import com.crio.starter.exchange.GetMemeRequest;
import com.crio.starter.exchange.ResponseDto;
import com.crio.starter.repository.GreetingsRepository;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.stereotype.Service;

public interface MemesService {

  public CreateMemeResponse createMeme(CreateMemeRequest createMemeRequest);
  public List<GetMemeResponse> getMemes();
  public GetMemeResponse getMemeById(GetMemeRequest getMemeRequest);


}

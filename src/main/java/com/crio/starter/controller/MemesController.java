package com.crio.starter.controller;

import com.crio.starter.exchange.CreateMemeRequest;
import com.crio.starter.exchange.CreateMemeResponse;
import com.crio.starter.exchange.ResponseDto;
import com.crio.starter.service.GreetingsService;
import com.crio.starter.service.MemesService;
import lombok.RequiredArgsConstructor;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// import org.springframework.http.ResponseEntity;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MemesController {

  @Autowired
  private MemesService memesService;

  @PostMapping("/memes")
  public CreateMemeResponse createMeme (@Valid CreateMemeRequest createMemeRequest) {
    CreateMemeResponse createMemeResponse;
    createMemeResponse = memesService.createMeme(createMemeRequest);
    return createMemeResponse;
  }
}

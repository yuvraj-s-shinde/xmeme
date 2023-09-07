package com.crio.starter.controller;

import com.crio.starter.exchange.CreateMemeRequest;
import com.crio.starter.exchange.GetMemeResponse;
import com.crio.starter.exchange.CreateMemeResponse;
import com.crio.starter.exchange.GetMemeRequest;
import com.crio.starter.exchange.ResponseDto;
import com.crio.starter.service.GreetingsService;
import com.crio.starter.service.MemesService;
import lombok.RequiredArgsConstructor;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

// import org.springframework.http.ResponseEntity;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MemesController {

  @Autowired
  private MemesService memesService;

  @PostMapping("/memes")
  public ResponseEntity<CreateMemeResponse> createMeme (@Valid @RequestBody CreateMemeRequest createMemeRequest) {
    CreateMemeResponse createMemeResponse;
    createMemeResponse = memesService.createMeme(createMemeRequest);
    if (createMemeResponse == null) {
      return new ResponseEntity<>(createMemeResponse, HttpStatus.CONFLICT);
    }
    return new ResponseEntity<>(createMemeResponse, HttpStatus.CREATED);
  }
    
  @GetMapping("/memes")
  public List<GetMemeResponse> getMemes() {
    List<GetMemeResponse> getMemesResponse = memesService.getMemes();
    return getMemesResponse;
  }

  @GetMapping("/memes/{id}")
  public ResponseEntity<GetMemeResponse> getMemeById(@PathVariable String id) {
    GetMemeRequest getMemeRequest = new GetMemeRequest(id);
    GetMemeResponse getMemeResponse = memesService.getMemeById(getMemeRequest);
    if (getMemeResponse == null) {
      return new ResponseEntity<>(getMemeResponse, HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(getMemeResponse, HttpStatus.OK);
  }
}

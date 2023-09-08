package com.crio.starter.service;

import com.crio.starter.exchange.CreateMemeRequest;
import com.crio.starter.exchange.GetMemeResponse;
import com.crio.starter.exchange.CreateMemeResponse;
import com.crio.starter.exchange.GetMemeRequest;
import com.crio.starter.repositoryservices.MemesRepositoryService;
import com.crio.starter.repository.MemesRepository;
import com.crio.starter.data.MemesEntity;
import com.crio.starter.dto.Meme;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import com.crio.starter.exchange.ResponseDto;
import com.crio.starter.repository.GreetingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
// @RequiredArgsConstructor
public class MemesServiceImpl implements MemesService {

  @Autowired
  private MemesRepositoryService memesRepositoryService;

  public CreateMemeResponse createMeme(CreateMemeRequest createMemeRequest) {
    Meme meme = memesRepositoryService.createMeme(createMemeRequest);
    if (meme == null) {
      return null;
    } else {
      return new CreateMemeResponse(String.valueOf(meme.getId()));
    }
  }

  public List<GetMemeResponse> getMemes() {
    List<Meme> memes = memesRepositoryService.getMemes();
    List<Meme> latest100Memes = new ArrayList<>();
    List<GetMemeResponse> getMemeResponse = new ArrayList<>();
    if (memes.size() > 100) {
      latest100Memes = memes.subList(memes.size() - 100, memes.size());
    }
    else {
      latest100Memes = memes;
    }
    Collections.reverse(latest100Memes);
    // int count = 0;
    for (Meme meme: latest100Memes) {
      // if (count < 100) {
      getMemeResponse.add(new GetMemeResponse(String.valueOf(meme.getId()), meme.getName(), meme.getUrl(), meme.getCaption()));
        // count++;
      // }
      // else {
      //   break;
      // }
    }
    
    // Collections.sort(getMemeResponse, new Comparator<GetMemeResponse>() {
    //   @Override
    //   public int compare(GetMemeResponse m1, GetMemeResponse m2) {
    //     return m1.getId().compareTo(m2.getId());
    //   }
    // });
    return getMemeResponse;

  }

  public GetMemeResponse getMemeById(GetMemeRequest getMemeRequest) {
    Meme meme = memesRepositoryService.getMemeById(getMemeRequest);
    if (meme != null) {
      return new GetMemeResponse(String.valueOf(meme.getId()), meme.getName(), meme.getUrl(), meme.getCaption());
    } else {
      return null;
    }
  }
}

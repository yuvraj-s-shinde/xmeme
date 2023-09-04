package com.crio.starter.repositoryservices;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;
import com.crio.starter.data.MemesEntity;
import com.crio.starter.dto.Memes;
import com.crio.starter.exchange.CreateMemeRequest;
import org.springframework.scheduling.annotation.Async;

public interface MemesRepositoryService {

  /**
   * Get the list of open restaurants within the specified serving radius.
   *   - Use the Haversine formula to find the distance between two lat/longs.
   *   - Ensure the restaurant is open currently.
   * @param latitude coordinates near which we have to search for restaurant
   * @param longitude coordinates near which we have to search for restaurant
   * @param currentTime current time
   * @param servingRadiusInKms serving radius
   * @return list of open restaurants within the specified radius or
   *     empty list if there is none
   */
  Optional<MemesEntity> createMeme(CreateMemeRequest createMemeRequest);

}
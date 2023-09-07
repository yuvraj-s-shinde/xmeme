package com.crio.starter.repository;

import java.util.List;
import java.util.Optional;
import com.crio.starter.data.MemesEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemesRepository extends MongoRepository<MemesEntity, Long> {
  // Optional<MemesEntity> findById(String id);
  // List<MemesEntity> findAll();
}

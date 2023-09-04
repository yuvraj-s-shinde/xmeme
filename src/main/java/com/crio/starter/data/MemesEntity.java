package com.crio.starter.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "memes")
@NoArgsConstructor
public class MemesEntity {

  @Id
  private String id;

  @NotNull
  private String name;

  @NotNull
  private String url;

  @NotNull
  private String caption;

}

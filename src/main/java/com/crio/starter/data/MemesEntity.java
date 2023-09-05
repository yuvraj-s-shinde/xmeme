package com.crio.starter.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "memes")
@NoArgsConstructor
public class MemesEntity {

  @Transient
  public static final String SEQUENCE_NAME = "meme_sequences";

  @Id
  private long id;

  @NotNull
  private String name;

  @NotNull
  private String url;

  @NotNull
  private String caption;

  public MemesEntity( String name, String caption, String url) {
    this.caption = caption;
    this.name = name;
    this.url = url;
  }

}

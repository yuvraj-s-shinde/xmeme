package com.crio.starter.exchange;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateMemeRequest {

  @NotNull
  private String name;

  @NotNull
  private String url;

  @NotNull
  private String caption;

}


package com.crio.starter.exchange;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class GetMemeResponse {

  @NotNull
  private String id;

  @NotNull
  private String name;

  @NotNull
  private String url;

  @NotNull
  private String caption;

}


package com.crio.starter.exchange;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
//@NoArgsConstructor
public class CreateMemeResponse {

  @NotNull
  private String id;

}


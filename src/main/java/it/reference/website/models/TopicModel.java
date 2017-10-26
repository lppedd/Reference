package it.reference.website.models;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class TopicModel
{
   @NotBlank
   @Size(max = 50)
   public String title;

   @NotBlank
   public String description;

   @NotNull
   public long areaId;
}

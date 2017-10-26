package it.reference.website.models;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class TopicModel
{
   @NotBlank
   @Size(max = 50)
   private String title;

   @NotBlank
   private String description;

   @NotNull
   private long areaId;
   private List<ParagraphModel> paragraphs;
}

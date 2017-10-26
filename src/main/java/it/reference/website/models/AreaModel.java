package it.reference.website.models;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class AreaModel
{
   @NotBlank
   @Size(max = 50)
   private String name;
   private List<TopicModel> topics;
}

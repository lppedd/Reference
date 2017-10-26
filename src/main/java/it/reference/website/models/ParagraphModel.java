package it.reference.website.models;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class ParagraphModel
{
   @NotBlank
   @Length(max = 50)
   private String title;
   
   @NotBlank
   private String text;
   private List<ParagraphModel> subParagraphs;
}

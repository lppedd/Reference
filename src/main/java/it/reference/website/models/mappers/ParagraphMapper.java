package it.reference.website.models.mappers;

import it.reference.website.entities.Paragraph;
import it.reference.website.models.ParagraphModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ParagraphMapper
{
   Paragraph paragraphModelToParagraph(final ParagraphModel paragraphModel);
   
   ParagraphModel paragraphToParagraphModel(final Paragraph paragraph);
   
   List<Paragraph> paragraphModelsToParagraphs(final List<ParagraphModel> paragraphModels);
   
   List<ParagraphModel> paragraphsToParagraphModels(final List<Paragraph> paragraphs);
}

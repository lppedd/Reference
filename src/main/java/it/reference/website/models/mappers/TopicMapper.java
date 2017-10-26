package it.reference.website.models.mappers;

import it.reference.website.entities.Topic;
import it.reference.website.models.TopicModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = ParagraphMapper.class)
public interface TopicMapper
{
   Topic topicModelToTopic(final TopicModel topicModel);

   TopicModel topicToTopicModel(final Topic topic);

   List<Topic> topicModelsToTopics(final List<TopicModel> topicModels);

   List<TopicModel> topicsToTopicModels(final List<Topic> topics);
}

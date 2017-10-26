package it.reference.website.models.mappers;

import it.reference.website.entities.Topic;
import it.reference.website.models.TopicModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TopicMapper
{
	Topic topicModelToTopic(final TopicModel topicModel);
}

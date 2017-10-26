package it.reference.website.models.mappers;

import it.reference.website.entities.Area;
import it.reference.website.models.AreaModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = TopicMapper.class)
public interface AreaMapper
{
   Area areaModelToArea(final AreaModel areaModel);
   
   AreaModel areaToAreaModel(final Area area);
   
   List<Area> areaModelsToAreas(final List<AreaModel> areaModels);
   
   List<AreaModel> areasToAreaModels(final List<Area> areas);
}

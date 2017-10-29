package it.reference.website.models.mappers;

import it.reference.website.entities.Writer;
import it.reference.website.models.WriterModel;
import it.reference.website.models.mappers.utils.StringMapperUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Mapper(componentModel = "spring", uses = StringMapperUtils.class)
public abstract class WriterMapper
{
   @Autowired
   private BCryptPasswordEncoder bCryptPasswordEncoder;
   
   @Mapping(target = "password", qualifiedByName = "encodePassword")
   public abstract Writer wrtierModelToWriter(final WriterModel writerModel);
   
   @Mapping(target = "password", ignore = true)
   public abstract WriterModel writerToWriterModel(final Writer writer);
   
   @Named("encodePassword")
   public String encodePassword(final String password) {
      return bCryptPasswordEncoder.encode(password);
   }
}

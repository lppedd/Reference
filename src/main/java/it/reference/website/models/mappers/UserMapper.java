package it.reference.website.models.mappers;

import it.reference.website.entities.security.User;
import it.reference.website.models.UserModel;
import it.reference.website.models.mappers.utils.StringMapperUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Mapper(componentModel = "spring", uses = StringMapperUtils.class)
public abstract class UserMapper
{
   @Autowired
   private BCryptPasswordEncoder bCryptPasswordEncoder;
   
   @Mapping(target = "password", qualifiedByName = "encodePassword")
   public abstract User userModelToUser(final UserModel userModel);
   
   @Mapping(target = "password", ignore = true)
   public abstract UserModel userToUserModel(final User user);
   
   @Named("encodePassword")
   public String encodePassword(final String password) {
      return bCryptPasswordEncoder.encode(password);
   }
}

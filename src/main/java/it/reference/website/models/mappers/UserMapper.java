package it.reference.website.models.mappers;

import it.reference.website.entities.security.User;
import it.reference.website.models.UserModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Mapper(componentModel = "spring")
public abstract class UserMapper
{
   @Autowired
   private BCryptPasswordEncoder bCryptPasswordEncoder;

   @Mapping(target = "password", ignore = true)
   public abstract User userModelToUser(final UserModel userModel);

   @Mapping(target = "password", ignore = true)
   public abstract UserModel userToUserModel(final User user);

   @AfterMapping
   protected void setEncodedPassword(final UserModel userModel, @MappingTarget final User user) {
      user.setPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
   }
}

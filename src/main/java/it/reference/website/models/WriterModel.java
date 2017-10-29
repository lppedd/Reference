package it.reference.website.models;

import it.reference.website.annotations.FieldsMatch;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@FieldsMatch(
         value = { "password", "comparisonPassword" },
         message = "Passwords do not match")
public class WriterModel
{
   @Email
   @Length(max = 100)
   private String email;
   
   @NotBlank
   @Length(min = 2, max = 15)
   private String username;
   
   @NotBlank
   @Length(max = 25)
   private String password;
   
   @NotBlank
   @Length(max = 25)
   private String comparisonPassword;
   
   @Length(max = 50)
   private String name;
   
   @Length(max = 50)
   private String surname;
}

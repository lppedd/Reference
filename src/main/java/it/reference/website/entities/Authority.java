package it.reference.website.entities;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
@Data
public class Authority
{
   @Getter
   public enum AuthorityRole
   {
      ROLE_ADMINISTRATOR,
      ROLE_REVISER,
      ROLE_USER
   }
   
   @Id
   @Enumerated(EnumType.STRING)
   private AuthorityRole authorityRole;
   
   public Authority() {
      authorityRole = AuthorityRole.ROLE_USER;
   }
   
   public Authority(final AuthorityRole authorityRole) {
      this.authorityRole = authorityRole;
   }
}

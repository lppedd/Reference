package it.reference.website.entities.security;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Authority implements GrantedAuthority
{
   @Id
   @Column(columnDefinition = "CHAR(20)")
   private String authority;

   @Column(length = 50)
   private String description;
}

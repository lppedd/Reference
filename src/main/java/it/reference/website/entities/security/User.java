package it.reference.website.entities.security;

import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class User implements UserDetails
{
   @Id
   @Column(length = 100)
   private String email;

   @Column(columnDefinition = "char(15)", unique = true)
   private String username;

   @Column(length = 100, nullable = false)
   private String password;

   @Column(length = 50)
   private String name;

   @Column(length = 50)
   private String surname;

   private boolean enabled = true;
   private boolean accountNonExpired = true;
   private boolean accountNonLocked = true;
   private boolean credentialsNonExpired = true;

   @ManyToMany(fetch = FetchType.EAGER)
   private List<Authority> authorities;
}

package it.reference.website.entities;

import it.reference.website.entities.Authority.AuthorityRole;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.mapstruct.ap.internal.util.Collections;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Writer
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
   
   @Setter(AccessLevel.PRIVATE)
   @ManyToMany(fetch = FetchType.EAGER)
   private Set<Authority> authorities = Collections.asSet(new Authority(AuthorityRole.ROLE_USER));
   
   public void addAuthority(final AuthorityRole authorityRole) {
      authorities.add(new Authority(authorityRole));
   }
   
   public void removeAuthority(final AuthorityRole authorityRole) {
      authorities.removeIf(authority -> authority.getAuthorityRole() == authorityRole);
   }
}

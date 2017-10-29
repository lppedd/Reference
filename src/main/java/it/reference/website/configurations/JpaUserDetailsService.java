package it.reference.website.configurations;

import it.reference.website.entities.Writer;
import it.reference.website.services.WriterService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class JpaUserDetailsService implements UserDetailsService
{
   private final WriterService writerService;
   
   public JpaUserDetailsService(final WriterService writerService) {
      this.writerService = writerService;
   }
   
   @Override
   public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
      final Writer writer = writerService.getWriter(username.toLowerCase());
      return new User(
               writer.getUsername(),
               writer.getPassword(),
               writer.isEnabled(),
               writer.isAccountNonExpired(),
               writer.isCredentialsNonExpired(),
               writer.isAccountNonLocked(),
               writer.getAuthorities()
                     .stream()
                     .map(authority -> new SimpleGrantedAuthority(authority.getAuthorityRole().name()))
                     .collect(Collectors.toSet()));
   }
}

package it.reference.website.configurations;

import it.reference.website.services.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class JpaUserDetailsService implements UserDetailsService
{
   private final UserService userService;
   
   public JpaUserDetailsService(final UserService userService) {
      this.userService = userService;
   }
   
   @Override
   public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
      return userService.getUser(username.toLowerCase());
   }
}

package it.reference.website.configurations;

import it.reference.website.entities.Authority;
import it.reference.website.entities.Authority.AuthorityRole;
import it.reference.website.repositories.AuthorityRepository;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SeedingConfigurarion
{
   private final AuthorityRepository authorityRepository;
   
   public SeedingConfigurarion(final AuthorityRepository authorityRepository) {
      this.authorityRepository = authorityRepository;
   }
   
   @EventListener
   public void seed(final ContextRefreshedEvent contextRefreshedEvent) {
      authorityRepository.save(new Authority(AuthorityRole.ROLE_ADMINISTRATOR));
      authorityRepository.save(new Authority(AuthorityRole.ROLE_REVISER));
      authorityRepository.save(new Authority(AuthorityRole.ROLE_USER));
   }
}

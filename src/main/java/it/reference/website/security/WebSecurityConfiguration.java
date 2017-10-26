package it.reference.website.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter
{
   @Override
   protected void configure(final HttpSecurity http) throws Exception {
      http
           .formLogin()
           .loginPage("/signin").permitAll()
           .defaultSuccessUrl("/areas")
           .and()
           .logout().logoutSuccessUrl("/areas")
           .and()
           .csrf().disable()
           .authorizeRequests()
           .antMatchers("/admin/**").hasAuthority("ADMIN")
           .anyRequest().permitAll();
   }

   @Bean
   public BCryptPasswordEncoder bCryptPasswordEncoder() {
      return new BCryptPasswordEncoder();
   }

   @Bean
   public DaoAuthenticationProvider daoAuthenticationProvider(
        final JpaUserDetailsService jpaUserDetailsService,
        final BCryptPasswordEncoder bCryptPasswordEncoder) {
      final DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
      daoAuthenticationProvider.setUserDetailsService(jpaUserDetailsService);
      daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder);
      return daoAuthenticationProvider;
   }
}

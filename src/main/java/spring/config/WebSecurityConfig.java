package spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import spring.service.imp.UserServiceImp;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)     // for @PreAuthorize access
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserServiceImp userServiceImp;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // it is kind of protection

                .authorizeRequests()
                .antMatchers("/registration").not().fullyAuthenticated()   // permission only when NOT authorized
                .antMatchers().hasAnyAuthority()

                .antMatchers("/**/update/**", "/**/create/**", "/**/delete/**", "/**/image/**")
                .hasAnyRole("ADMIN", "MODERATOR") // for all tables

                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login")

                .defaultSuccessUrl("/welcome", true).permitAll()
                .and().logout().permitAll().logoutSuccessUrl("/login")
                .and().exceptionHandling().accessDeniedPage("/forbidden");
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userServiceImp).passwordEncoder(bCryptPasswordEncoder());
    }
}
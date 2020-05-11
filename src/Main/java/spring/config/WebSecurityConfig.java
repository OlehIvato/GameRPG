package spring.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import spring.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // це якогось роду захист

                .authorizeRequests()
                .antMatchers("/registration").not().fullyAuthenticated()   // дозвіл тільки коли не авторизований

                .antMatchers("/admin/set_role/1", "/admin/deleteUser/1", "/admin/all_users_information/1").denyAll()   // це заборонити зміну ролі адміну і видаляти
                .antMatchers("/admin/**",
                        "/**/update/**",
                        "/**/create/**",
                        "/**/delete/**",
                        "/**/image/**").hasRole("ADMIN")                              // всі перечислені операції тільки для адміна


                .antMatchers("/login").permitAll()

                //все інше треба authenticated
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login")
                .defaultSuccessUrl("/welcome", true).permitAll()
                .and()
                .logout().permitAll().logoutSuccessUrl("/login");
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
    }

}

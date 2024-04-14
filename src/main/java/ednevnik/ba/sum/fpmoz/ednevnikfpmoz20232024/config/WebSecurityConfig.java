package ednevnik.ba.sum.fpmoz.ednevnikfpmoz20232024.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static javax.management.Query.and;

@Configuration
public class WebSecurityConfig {
    @Autowired
    public class WebSecurityConfig {
        @Autowired
        private DataSource dataSource;

        @Bean
        public BCryptPasswordEncoder userDetailsService() {
            return new BCryptPasswordEncoder();
        }
        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .requestMatchers("/register")
                    .permitAll()
                    .anyRequest()
                    .authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .usernameParameter("email")
                    .passwordParameter("password")
                    .defaultSuccessUrl("/user")
                    .permitAll();
                    .and().logout()
                    .logoutSuccessUrl("/login")
                    .permitAll();

                    http.authenticationProvider(authenticationProvider());
                    http.headers().frameOptions().disable();
            return http.build();
        }
    }

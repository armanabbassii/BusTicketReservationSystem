package ir.maktabsharif.busticketreservationsystem.config;

import ir.maktabsharif.busticketreservationsystem.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserService userService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(auth -> auth
                        .requestMatchers("/user/register/**").hasRole("USER_ROLE")
                        .requestMatchers("/user/admin/**").hasRole("ADMIN_ROLE")
                        .requestMatchers("/user/company/**").hasRole("COMPANY_ROLE")
                        .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout") // redirect after logout
                        .permitAll() //Allow everyone to see login page
                );
        return httpSecurity.build();
    }
    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails student = User.withDefaultPasswordEncoder()
                .username("student")
                .password("12345")
                .roles("USER")
                .build();
        return userDetailsService();

    }
}

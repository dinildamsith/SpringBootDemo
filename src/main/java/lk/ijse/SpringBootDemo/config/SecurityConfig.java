package lk.ijse.SpringBootDemo.config;

import lk.ijse.SpringBootDemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor //
@EnableMethodSecurity
public class SecurityConfig {

    private final UserService userService;
    private final JWTConfigFilter jwtConfigFilter;


//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests()       // ena request authorize karanaluu
//                .anyRequest().authenticated() //   ena onem request ekak authenticated karla
//                .and()                      // saha
//                .httpBasic();              // httpbasic kiyana machinism eken
//        return http.build();
//    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails buildUser = User.withDefaultPasswordEncoder()
//                .username("kamal")
//                .password("1234")
//                .roles("USER").build();
//        return new InMemoryUserDetailsManager(buildUser);
//    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req->req.requestMatchers("api/v1/auth/**") // ena one requ autheticate karn kiynwa
                        .permitAll()
                        .anyRequest()
                        .authenticated())

                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))// userge data log wela logut wenkn data saver ekek save kargana epa kiyane
                .authenticationProvider(authenticationProvider()).addFilterBefore(jwtConfigFilter, UsernamePasswordAuthenticationFilter.class);
                 return httpSecurity.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userService.userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;

    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
            return  authenticationConfiguration.getAuthenticationManager();

    }

}

package be.pxl.gilles.courseapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
@Configuration
@CrossOrigin
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Value(value = "${auth0.apiAudience}")
    private String apiAudience;
    @Value(value = "${auth0.issuer}")
    private String issuer;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JwtWebSecurityConfigurer
                .forRS256(apiAudience, issuer)
                .configure(http)
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/v1/bikes").permitAll()
                //.antMatchers(HttpMethod.GET,"api/v1/bikes").permitAll()
                //.antMatchers(HttpMethod.GET,"/api/v1/bikes/**").permitAll()
                .antMatchers(HttpMethod.GET,"/api/lobbies").permitAll()
                .antMatchers(HttpMethod.POST,"/api/lobbies").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/bikes").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/bikes/**").permitAll()
                //.antMatchers(HttpMethod.GET, "/api/v1/bikes").hasAuthority("view:registrations")
                //.antMatchers(HttpMethod.GET, "/api/v1/bikes/**").hasAuthority("view:registration")
                .anyRequest().authenticated();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }

}
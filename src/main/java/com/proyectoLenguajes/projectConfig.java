
package com.proyectoLenguajes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class projectConfig implements WebMvcConfigurer{
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/registro").setViewName("/registro");
        registry.addViewController("/crear-usuario").setViewName("/crear-usuario");
    }
    
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((request) -> request
                .requestMatchers("/", "/index", "/errores/**","/registro/**","/crear-usuario/**",
                        "/libreta/**", "/Sedes/**", "/PlanE/**","/EnfoqueH/**","/Tienda/**",
                        "/Matricula/guardar/**",  "/Actividades/**","/Contactenos/**","/carrito/**",
                     "/Carrito/**","/Profesores/**", "/webjars/**","/css/**","/img/**","/actualizar-libreta/**")
                .permitAll()
                .requestMatchers(
                        "/matricula/**","/matricular-estudiante/**","/libreta/**","/detalleLibreta/**",
                        "/actualizar-libreta/**","/eliminar-libreta/**"
                ).hasAnyRole("USER","ADMIN")
                )
                .formLogin((form) -> form
                .loginPage("/login").permitAll())
                .logout((logout) -> logout.permitAll());
        return http.build();
    }
    
}

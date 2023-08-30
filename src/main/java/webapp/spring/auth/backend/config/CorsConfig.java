package webapp.spring.auth.backend.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
@EnableConfigurationProperties({CorsSettings.class})
@Slf4j
public class CorsConfig {

    private final CorsSettings webConfigProperties;

    public CorsConfig(CorsSettings webConfigProperties) {
        this.webConfigProperties = webConfigProperties;
    }


    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        log.trace("CorsConfigurationSource{}");
        CorsSettings.Cors cors = webConfigProperties.getCors();

        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList(cors.getAllowedOrigins()));
        configuration.setAllowedMethods(Arrays.asList(cors.getAllowedMethods()));
        configuration.setMaxAge(cors.getMaxAge());
        configuration.setAllowedHeaders(Arrays.asList(cors.getAllowedHeaders()));
        configuration.setExposedHeaders(Arrays.asList(cors.getExposedHeaders()));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration.applyPermitDefaultValues());
        return source;
    }

    @Bean
    public WebMvcConfigurer corsWebMvcConfig() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                CorsSettings.Cors cors = webConfigProperties.getCors();
                log.trace("WebMvcConfigurer getAllowedOrigins: {}", cors.getAllowedOrigins());
                registry.addMapping("/**")
                        .allowedOrigins(cors.getAllowedOrigins())
                        .allowedMethods(cors.getAllowedMethods())
                        .maxAge(cors.getMaxAge())
                        .allowedHeaders(cors.getAllowedHeaders())
                        .exposedHeaders(cors.getExposedHeaders());
            }
        };
    }


    @Bean
    public WebFluxConfigurer corsWebfluxConfig() {
        return new WebFluxConfigurer() {
            public void addCorsMappings(CorsRegistry registry) {
                CorsSettings.Cors cors = webConfigProperties.getCors();
                log.trace("WebFluxConfigurer getAllowedOrigins: {}", cors.getAllowedOrigins());
                registry.addMapping("/**")
                        .allowedOrigins(cors.getAllowedOrigins())
                        .allowedMethods(cors.getAllowedMethods())
                        .maxAge(cors.getMaxAge())
                        .allowedHeaders(cors.getAllowedHeaders())
                        .exposedHeaders(cors.getExposedHeaders());
            }
        };
    }
}

package org.com.lr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LiuRanWebMvcConfigure implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .allowCredentials(false)
        .allowedMethods("POST","GET","DELTETE","PUT","OPTIONS")
        .allowedOrigins("*");
  }
}

package iq.threed.webshop;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration file used to manage pictures in the application.
 */
@Configuration
public class AdditionalResourceWebConfiguration implements WebMvcConfigurer {

    /**
     * Register the location "upload" as a place to locate the images.
     *
     * @param registry registry
     */
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file://" + System.getProperty("user.dir") + "/upload/");
    }
}

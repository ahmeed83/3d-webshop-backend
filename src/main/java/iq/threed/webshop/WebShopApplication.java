package iq.threed.webshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Spring Boot Application.
 */
@SpringBootApplication
@EnableJpaAuditing
@PropertySources({
        @PropertySource("classpath:datasource.properties"),
        @PropertySource("classpath:email.properties")
})
public class WebShopApplication {
    /**
     * Spring main class.
     *
     * @param args args
     */
    public static void main(final String[] args) {
        SpringApplication.run(WebShopApplication.class, args);
    }

    /**
     * Bean that been used for incrementing values.
     *
     * @return AtomicLong
     */
    @Bean
    public AtomicLong atomicLong() {
        return new AtomicLong();
    }
}

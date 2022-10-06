package ie.lochlann;

import ie.lochlann.entities.Director;
import ie.lochlann.entities.Movie;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
@ComponentScan("ie.lochlann")
public class Config {

    @Bean
    MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

    @Bean
    Director lochlann() {
        return new Director("Lochlann", "O'Neill", true);
    }

    @Bean
    Movie lordOfTheRings() {
        return new Movie("The Lord of the Rings: The Fellowship of the Ring", "December 19, 2001", 897700000.0, lochlann());
    }

    @Bean
    Movie theLastSamurai() {
        return new Movie("The Last Samurai", "January 9, 2004", 456800000.0, lochlann());
    }

    @Bean
    Movie kungFuPanda() {
        return new Movie("Kung Fu Panda", "July 4, 2008", 631700000.0, lochlann());
    }

}

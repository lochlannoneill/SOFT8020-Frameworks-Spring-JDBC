package ie.lochlann;

import ie.lochlann.entities.Director;
import ie.lochlann.entities.Movie;
import org.h2.tools.Server;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@ComponentScan("ie.lochlann")
public class Config {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema.sql")
                .addScript("classpath:data.sql").build();
    }

//    @Bean
//    public JdbcTemplate jdbcTemplate(){
//        return new JdbcTemplate(dataSource());
//    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource());
    }

    @Bean(initMethod = "start") // uses the start() method of the bean to start the web server
    public Server h2WebServer() throws SQLException {
        return Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082");
    }

    @Bean
    MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

    @Bean
    Director lochlann() {
        return new Director(1, "Lochlann", "O'Neill", true);
    }

    @Bean
    Movie lordOfTheRings() {
//        return new Movie(1, "The Lord of the Rings: The Fellowship of the Ring", "December 19, 2001", 897700000.0, lochlann());
        return new Movie(1, "The Lord of the Rings: The Fellowship of the Ring", "December 19, 2001", 897700000.0, 1);
    }

    @Bean
    Movie theLastSamurai() {

//        return new Movie(2, "The Last Samurai", "January 9, 2004", 456800000.0, lochlann());
        return new Movie(2, "The Last Samurai", "January 9, 2004", 456800000.0, 1);
    }

    @Bean
    Movie kungFuPanda() {

//        return new Movie(3, "Kung Fu Panda", "July 4, 2008", 631700000.0, lochlann());
        return new Movie(3, "Kung Fu Panda", "July 4, 2008", 631700000.0, 2);
    }

}

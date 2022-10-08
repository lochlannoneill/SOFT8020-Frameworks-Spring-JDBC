package ie.lochlann.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Component

public class Movie {
    private int movie_id;
    private String title;
    private String date_released;
    private double earnings;
//    private Director director;
    private int director_id;

    // is this 'constructor overloading'
    // so a school doesn't REQUIRE a faculty??
//    public Movie(String t, String dr, float r) {
//        this.title = t;
//        this.date_released = dr;
//        this.ratings = r;
//          this.takings = tk;
//    }

}

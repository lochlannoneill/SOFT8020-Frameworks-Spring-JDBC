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

//  constructor overloading so a Movie doesn't REQUIRE a director
    public Movie(int mid, String t, String dr, double e) {
        this.movie_id = mid;
        this.title = t;
        this.date_released = dr;
        this.earnings = e;
    }

}

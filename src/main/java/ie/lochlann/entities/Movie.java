package ie.lochlann.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Movie {
    private int movieId;
    private String title;
    private String releaseDate;
    private double earnings;
    private int directorId;

//  constructor overloading so a Movie doesn't REQUIRE a director
    public Movie(int mid, String t, String rd, double e) {
        this.movieId = mid;
        this.title = t;
        this.releaseDate = rd;
        this.earnings = e;
    }

}

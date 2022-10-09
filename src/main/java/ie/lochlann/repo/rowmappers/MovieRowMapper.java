package ie.lochlann.repo.rowmappers;

import ie.lochlann.entities.Movie;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieRowMapper implements RowMapper<Movie> {
    @Override
    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
        Movie movie = new Movie();
        movie.setMovieId(rs.getInt(1));
        movie.setTitle(rs.getString(2));
        movie.setReleaseDate(rs.getString(3));
        movie.setEarnings(rs.getDouble(4));
        movie.setDirectorId(rs.getInt(5));
        return movie;
    }
}

package ie.lochlann.repo;

import ie.lochlann.entities.Movie;
import ie.lochlann.repo.rowmappers.MovieRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepoImpl implements MovieRepo {

    @Autowired
//    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public int count() {
        String sql = "select count(*) from movie";
        Integer number = namedParameterJdbcTemplate.getJdbcTemplate().queryForObject(sql, Integer.class);
        return number != null? number: -1;
    }

    @Override
    public List<Movie> findAll() {
        String sql = "select * from movie";
        return namedParameterJdbcTemplate.getJdbcTemplate().query(sql, new MovieRowMapper());
    }

    @Override
    public List<Movie> findMoviesByDirector(int id) {
        String sql = "select * from movie where directorId = :directorId";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("directorId", id);
        return namedParameterJdbcTemplate.query(sql, sqlParameterSource, new MovieRowMapper());
    }

    @Override
    public Movie findById(int id) {
        String sql = "select * from movie where movieId = :movieId";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("movieId", id);
        return namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource, new MovieRowMapper());
    }

    public boolean exists(int id) {
        String sql = "select count(*) from movie where movieId = :movieId";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("movieId", id);
        Integer number = namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource, Integer.class);
        return number != null && number == 1;
    }

    public boolean existsByName(String title) {
        String sql = "select count(*) from movie where title = :title"; // TODO sql name like *x*
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("title", title);
        Integer number = namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource, Integer.class);
        return number != null && number == 1;
    }

    @Override
    public int deleteMovie(int id) {
        String sql = "delete from movie where movieId = :movieId";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("movieId", id);
        return namedParameterJdbcTemplate.update(sql, sqlParameterSource); //returns number of records changed. 0 or 1
    }

    @Override
    public int createMovie(int movieId, String title, String releaseDate, double earnings, int directorId) {
        return 0;
    }

    @Override
    public int changeMovieEarnings(int id, double newEarnings) {
        String sql = "update movie set earnings = :newEarnings where movieId = :movieId";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("movieId", id)
                .addValue("newEarnings", newEarnings);
        return namedParameterJdbcTemplate.update(sql, sqlParameterSource);
    }

    @Override
    public int changeDirector(int movieId, int newDirectorId) {
        String sql = "update movie set directorId = :newDirectorID where movieId = :movieId";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("movieId", movieId)
                .addValue("directorId", newDirectorId);
        return namedParameterJdbcTemplate.update(sql, sqlParameterSource);
    }
}

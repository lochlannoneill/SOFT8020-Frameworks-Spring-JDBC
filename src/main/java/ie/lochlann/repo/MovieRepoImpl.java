package ie.lochlann.repo;

import ie.lochlann.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
        return number != null? number: -1; // if number is not null then return number, otherwise return -1 // TODO others
    }

    @Override
    public List<Movie> getAll() {
        String sql = "select * from movie";
        return namedParameterJdbcTemplate.getJdbcTemplate().query(sql, new MovieRowMapper());
    }

    @Override
    public Movie findById(int movie_id) {
        String sql = "select * from movie where movie_id = :movie_id";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("movie_id", movie_id);
        return namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource, new MovieRowMapper());
    }

    public boolean exists(int movie_id) {
        String sql = "select count(*) from movie where movie_id = :movie_id";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("movie_id", movie_id);
        Integer number = namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource, Integer.class);
        return number != null && number == 1;
    }

    public boolean existsByName(String title) {
        String sql = "select count(*) from movie where title = :name"; // TODO sql name roughly like *x*
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("title", title);
        Integer number = namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource, Integer.class);
        return number != null && number == 1;
    }
}

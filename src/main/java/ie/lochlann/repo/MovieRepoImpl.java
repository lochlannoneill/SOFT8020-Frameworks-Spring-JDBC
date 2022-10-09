package ie.lochlann.repo;

import ie.lochlann.entities.Movie;
import ie.lochlann.entities.Result;
import ie.lochlann.repo.rowmappers.MovieRowMapper;
import ie.lochlann.repo.rowmappers.ResultRowMapper;
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

//    @Override
//    public List<Movie> findAll() {
//        String sql = "select * from movie";
//        return namedParameterJdbcTemplate.getJdbcTemplate().query(sql, new MovieRowMapper());
//    }

    @Override
    public List<Result> findAll() {
        String sql = "select concat(d.fname, ' ' , d.lname) as name, m.title from movie m inner join director d on d.directorId = m.directorId";
        return namedParameterJdbcTemplate.getJdbcTemplate().query(sql, new ResultRowMapper());
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

//    @Override
//    // TODO
//    public List<Result> findHighestEarnings() {
//        String sql = "select m.movieId, m.earnings, d.directorId from ";
//        return namedParameterJdbcTemplate.getJdbcTemplate().query(sql, new ResultRowMapper());
//    }

    @Override
    public Result findMovieTitleAndDirectorName(int movieId) {
//        String sql = "select m.movieId, m.title, m.releaseDate, m.earnings, m.directorId, d.directorid, d.fname, d.lname, d.stillActive from movie m inner join director d on d.directorId = m.directorId where m.movieId = :movieId";
        String sql = "select m.movieId, d.fname, d.lname from movie m inner join director d on d.directorId = m.directorId where m.movieId = :movieId";
//        String sql = "select * from movie m inner join director d on d.directorId = m.directorId where m.movieId = :movieId";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("movieId", movieId);
        return namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource, new ResultRowMapper());
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
    public int addMovie(Movie movie) {
        String sql = "insert into movie values (:movieId, :title, :releaseDate, :earnings, :directorId)";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("movieId", movie.getMovieId())
                .addValue("title", movie.getTitle())
                .addValue("releaseDate", movie.getReleaseDate())
                .addValue("earnings", movie.getEarnings())
                .addValue("directorId", movie.getDirectorId());
        return namedParameterJdbcTemplate.update(sql, sqlParameterSource);
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

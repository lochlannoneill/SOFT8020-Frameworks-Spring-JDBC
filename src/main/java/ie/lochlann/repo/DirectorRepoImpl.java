package ie.lochlann.repo;

import ie.lochlann.entities.Director;
import ie.lochlann.entities.rowmappers.DirectorRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DirectorRepoImpl implements DirectorRepo {

    @Autowired
//    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public int count() {
        String sql = "select count(*) from director";
        Integer number = namedParameterJdbcTemplate.getJdbcTemplate().queryForObject(sql, Integer.class);
        return number != null? number: -1; // if number is not null then return number, otherwise return -1
    }

    @Override
    public List<Director> getAll() {
        String sql = "select * from director";
        return namedParameterJdbcTemplate.getJdbcTemplate().query(sql, new DirectorRowMapper());
    }

    @Override
    public Director findById(int id) {
        String sql = "select * from director where directorId = :directorId";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("directorId", id);
        return namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource, new DirectorRowMapper());
    }

    public boolean exists(int id) {
        String sql = "select count(*) from director where directorId = :directorId";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("directorId", id);
        Integer number = namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource, Integer.class);
        return number != null && number == 1;
    }

    public boolean existsByName(String name) {
        String sql = "select count(*) from director where fname = :fname";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("fname", name);
        Integer number = namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource, Integer.class);
        return number != null && number == 1;
    }

    @Override
    public int deleteDirector(int id) {
        String sql = "delete from director where directorId = :directorId";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("directorId", id);
        return namedParameterJdbcTemplate.update(sql, sqlParameterSource);
    }

    @Override
    public int createDirector(Director newDirector) {
        String sql = "INSERT INTO director VALUES (:directorId, :fname, :lname, :stillActive)";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("directorId", newDirector.getDirectorId())
                .addValue("fname", newDirector.getFname())
                .addValue("lname", newDirector.getLname())
                .addValue("stillActive", newDirector.isStillActive());
        return namedParameterJdbcTemplate.update(sql, sqlParameterSource);
    }

    @Override
    public int changeDirectorActive(int id, boolean newActive) {
        String sql = "UPDATE director SET stillActive = :newActive WHERE directorId = :directorId";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("directorId", id)
                .addValue("newActive", newActive);
        return namedParameterJdbcTemplate.update(sql, sqlParameterSource);
    }

    @Override
    public double getAverageEarningsByDirector(int id) {
       String sql = "SELECT AVG(earnings) FROM movie WHERE directorId = :directorId";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("directorId", id);
        Double average = namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource, Double.class);
        return average != null? average: -1.0; // if number is not null then return number, otherwise return -1
    }

    @Override
    public int getInactiveCount() {
//        String sql = "SELECT count(CASE WHEN stillActive THEN 1 END) FROM director";
        String sql = "SELECT COALESCE(sum(CASE WHEN stillActive THEN 0 ELSE 1 END),0) FROM director";
        Integer number = namedParameterJdbcTemplate.getJdbcTemplate().queryForObject(sql, Integer.class);
        return number != null? number: -1;
    }

}

package ie.lochlann.repo;

import ie.lochlann.entities.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
        String sql = "select * from director where director_id = :directorId";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("directorId", id);
        return namedParameterJdbcTemplate.queryForObject(sql, sqlParameterSource, new DirectorRowMapper());
    }
}

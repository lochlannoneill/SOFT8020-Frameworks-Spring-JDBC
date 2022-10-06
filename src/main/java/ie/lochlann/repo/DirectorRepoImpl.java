package ie.lochlann.repo;

import ie.lochlann.entities.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DirectorRepoImpl implements DirectorRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        String sql = "select count(*) from director";
        Integer number = jdbcTemplate.queryForObject(sql, Integer.class);
        return number != null? number: -1; // if number is not null then return number, otherwise return -1
    }

    @Override
    public List<Director> getAll() {
        String sql = "select * from director";
        return jdbcTemplate.query(sql, new DirectorRowMapper());
    }
}

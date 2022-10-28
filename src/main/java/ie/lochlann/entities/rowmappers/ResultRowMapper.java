package ie.lochlann.entities.rowmappers;

import ie.lochlann.entities.Result;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultRowMapper implements RowMapper<Result> {
    @Override
    public Result mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Result(rs.getString("name"), rs.getString("movie.title"));
    }
}

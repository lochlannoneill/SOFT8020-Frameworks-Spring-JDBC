package ie.lochlann.entities.rowmappers;

import ie.lochlann.entities.HighestEarnings;
import ie.lochlann.entities.Result;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HighestEarningsRowMapper implements RowMapper<HighestEarnings> {
    @Override
    public HighestEarnings mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new HighestEarnings(rs.getString(1), rs.getDouble(2), rs.getString(3));
    }
}

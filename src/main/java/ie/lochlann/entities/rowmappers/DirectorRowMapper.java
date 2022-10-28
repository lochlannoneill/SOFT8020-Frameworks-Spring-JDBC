package ie.lochlann.entities.rowmappers;

import ie.lochlann.entities.Director;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DirectorRowMapper implements RowMapper<Director> {
    @Override
    public Director mapRow(ResultSet rs, int rowNum) throws SQLException {
        Director director = new Director();
        director.setDirectorId(rs.getInt(1));
        director.setFname(rs.getString(2));
        director.setLname(rs.getString(3));
        director.setStillActive(rs.getBoolean(4));
        //director.setDirectorId(rs.getInt(5));
        return director;
    }
}

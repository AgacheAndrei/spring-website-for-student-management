package isi.proiect.studentmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDAO
{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public UserDAO(JdbcTemplate jdbcTemplate)
    {

        this.jdbcTemplate = jdbcTemplate;
    }
    public void save(User user)
    {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("users").usingColumns("id","email","rol","password");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(user);

        insertActor.execute(param);
    }
    public User get(String email, String password) {
        try {
            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
            return jdbcTemplate.queryForObject(sql, new Object[]{email, password}, new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setEmail(rs.getString("email"));
                    user.setRol(rs.getString("rol"));
                    user.setPassword(rs.getString("password"));

                    return user;
                }
            });
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    public User getRol(String email, String password, String rol) {
        try {

            String sql = "SELECT * FROM users WHERE email = ? AND password = ? and rol = ?";
            return jdbcTemplate.queryForObject(sql, new Object[]{email, password, rol}, new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setEmail(rs.getString("email"));
                    user.setRol(rs.getString("rol"));
                    user.setPassword(rs.getString("password"));

                    return user;
                }
            });
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}

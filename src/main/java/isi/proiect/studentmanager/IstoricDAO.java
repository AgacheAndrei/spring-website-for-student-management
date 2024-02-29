package isi.proiect.studentmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class IstoricDAO
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public IstoricDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Istoric> list()
    {
        String sql = "select * from istoric";
        List<Istoric> list= jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Istoric.class));
        return list;
    }
    public void save(Istoric istoric)
    {
        String sql = "INSERT INTO bd.istoric (user, eveniment ) VALUES (?,?)";
        jdbcTemplate.update(sql, istoric.getUser(), istoric.getEveniment());
    }
}

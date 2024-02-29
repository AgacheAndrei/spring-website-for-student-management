package isi.proiect.studentmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class ElevDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ElevDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Elev> list()
    {
        String sql = "select * from elev";
        List<Elev> listElevi= jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Elev.class));
        return listElevi;
    }
    public void save(Elev elev) {
        try {
            SimpleJdbcInsert insertElev = new SimpleJdbcInsert(jdbcTemplate);
            insertElev.withTableName("elev").usingColumns("nr_matricol", "CNP", "nume", "prenume", "nr_telefon", "adresa", "medie", "acte_adi", "codclasa");

            SqlParameterSource param = new BeanPropertySqlParameterSource(elev);

            insertElev.execute(param);
        } catch (Exception e) {
            // Log the exception or handle it in a way that suits your application
            System.err.println("Error occurred during insert operation: " + e.getMessage());
        }
    }


    public Elev get(int nr_matricol)
    {
        String sql = "select * from elev where nr_matricol= ?";
        Object[] args = {nr_matricol};
        Elev elev = jdbcTemplate.queryForObject(sql,
                args,
                BeanPropertyRowMapper.newInstance(Elev.class));
        return elev;
    }
    public void update(Elev elev)
    {
        String sql = "UPDATE elev SET CNP=:CNP, nume=:nume, prenume=:prenume, nr_telefon=:nr_telefon, adresa=:adresa, medie=:medie, acte_adi=:acte_adi,codclasa=:codclasa WHERE nr_matricol=:nr_matricol";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(elev);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql,param);
    }
    public void delete(int nr_matricol)
    {
        String sql = "delete from elev where nr_matricol = ?";
        jdbcTemplate.update(sql,nr_matricol);
    }
    public List<Elev> bursieri()
    {
        String sql="SELECT * FROM bd.elev,bd.bursieri where elev.nr_matricol=bursieri.nr_matricol";
        List<Elev> listElevi= jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Elev.class));
        return listElevi;
    }
    public List<Elev> filterElev(String classCode, Double minMedie, Double maxMedie,Boolean bursier,Boolean nonbursier, String asc) {
        StringBuilder query = new StringBuilder("SELECT * FROM elev WHERE 1=1");
        if(bursier!=null)
        {
            if(bursier)
            {
                query= new StringBuilder("SELECT * FROM bd.elev,bd.bursieri where elev.nr_matricol=bursieri.nr_matricol ");

            }

        }
        if(nonbursier!=null)
        {
            if(nonbursier)
            {
                query= new StringBuilder("select * from elev where nr_matricol not in (SELECT bd.elev.nr_matricol FROM bd.elev,bd.bursieri where elev.nr_matricol=bursieri.nr_matricol)");

            }

        }
        if (bursier != null && nonbursier != null) {
            query = new StringBuilder("SELECT * FROM elev WHERE 1=1");
        }



        if (minMedie != null) {
            query.append(" AND medie >= ").append(minMedie);
        }

        if (maxMedie != null) {
            query.append(" AND medie <= ").append(maxMedie);
        }
        if (classCode != null) {

            if(!classCode.isEmpty())
            {
                query.append(" AND codclasa = '").append(classCode).append("'");
            }
        }
        if(asc!=null){
            if(asc.contains("asc"))
            {

                query.append(" order by medie asc");

            }
            else
            {
                query.append(" order by medie desc");
            }
        }


        //System.out.println("Generated SQL Query: " + query);

        return jdbcTemplate.query(query.toString(), new RowMapper<Elev>() {
            @Override
            public Elev mapRow(ResultSet rs, int rowNum) throws SQLException {
                Elev elev = new Elev();
                elev.setNr_matricol(rs.getInt("nr_matricol"));
                elev.setCNP(rs.getString("CNP"));
                elev.setNume(rs.getString("nume"));
                elev.setPrenume(rs.getString("prenume"));
                elev.setNr_telefon(rs.getString("nr_telefon"));
                elev.setAdresa(rs.getString("adresa"));
                elev.setMedie(rs.getFloat("medie"));
                elev.setActe_adi(rs.getString("acte_adi"));
                elev.setCodclasa(rs.getInt("codclasa"));
                return elev;
            }
        });
    }

    public List<Elev> cautaElev(String nrMatricol) {
        StringBuilder query = new StringBuilder("SELECT * FROM elev");

        if (nrMatricol != null && !nrMatricol.isEmpty()) {
            // Append the condition for a specific nr_matricol if provided
            query.append(" WHERE nr_matricol = ").append(nrMatricol);
        }


        return jdbcTemplate.query(query.toString(), new RowMapper<Elev>() {
            @Override
            public Elev mapRow(ResultSet rs, int rowNum) throws SQLException {
                Elev elev = new Elev();
                elev.setNr_matricol(rs.getInt("nr_matricol"));
                elev.setCNP(rs.getString("CNP"));
                elev.setNume(rs.getString("nume"));
                elev.setPrenume(rs.getString("prenume"));
                elev.setNr_telefon(rs.getString("nr_telefon"));
                elev.setAdresa(rs.getString("adresa"));
                elev.setMedie(rs.getFloat("medie"));
                elev.setActe_adi(rs.getString("acte_adi"));
                elev.setCodclasa(rs.getInt("codclasa"));
                return elev;
            }
        });
    }

    public List<Map<String, Object>> getBurse_per_profil() {
        String sql = "select profil.nume_profil as 'Nume Profil', sum(tip_bursa.valoare) as 'Suma per Profil' from profil,specializare,clasa, elev ,bursieri, tip_bursa where bursieri.codbur=tip_bursa.codbur and elev.nr_matricol=bursieri.nr_matricol and elev.codclasa = clasa.codclasa and specializare.codsp=clasa.codsp and profil.codpr=specializare.codpr group by profil.nume_profil";
        return jdbcTemplate.queryForList(sql);
    }
    public List<Map<String, Object>> getBursepe_per_tip_bursa() {
        String sql = "select  tip_bursa.nume as 'Tip Bursa',sum(tip_bursa.valoare) as 'Suma per Categorie' from tip_bursa, bursieri where tip_bursa.codbur=bursieri.codbur group by tip_bursa.nume";
        return jdbcTemplate.queryForList(sql);
    }
    public List<Map<String,Object>> getValoare_burse_per_student()
    {
        String sql = "select  elev.nume,elev.prenume, sum(tip_bursa.valoare) as 'Suma per Elev' from tip_bursa, bursieri,elev where tip_bursa.codbur=bursieri.codbur and elev.nr_matricol=bursieri.nr_matricol group by elev.nume,elev.prenume";
        return jdbcTemplate.queryForList(sql);
    }

    public List<Map<String,Object>> getNr_total_bursieri()
    {
        String sql = "SELECT count(*) as 'Numar total de elevi bursieri' FROM bd.elev,bd.bursieri where elev.nr_matricol=bursieri.nr_matricol";
        return jdbcTemplate.queryForList(sql);
    }
    public List<Map<String,Object>> getNr_total_nebursieri()
    {
        String sql = "select count(*) as 'Numar total de elevi nebursieri' from elev where nr_matricol not in (SELECT bd.elev.nr_matricol FROM bd.elev,bd.bursieri where elev.nr_matricol=bursieri.nr_matricol)";
        return jdbcTemplate.queryForList(sql);
    }
    public List<Map<String,Object>> getBursieri()
    {
        String sql = "SELECT * FROM bursieri";
        return jdbcTemplate.queryForList(sql);
    }
    public List<Map<String,Object>> getBurse()
    {
        String sql = "SELECT * FROM tip_bursa;";
        return jdbcTemplate.queryForList(sql);
    }
    public List<Map<String,Object>> getValoareBursePerClase()
    {
        String sql="select clasa.nume as 'Nume Clase', sum(tip_bursa.valoare) as 'Suma per Clasa' from clasa, elev ,bursieri, tip_bursa where bursieri.codbur=tip_bursa.codbur and elev.nr_matricol=bursieri.nr_matricol and elev.codclasa = clasa.codclasa group by clasa.nume";
        return jdbcTemplate.queryForList(sql);
    }
    public List<Map<String,Object>> getValoareBursePerSpecializare()
    {
        String sql="select specializare.nume_sp as 'Nume Specializare', sum(tip_bursa.valoare) as 'Suma per Spercializare' from specializare,clasa, elev ,bursieri, tip_bursa where bursieri.codbur=tip_bursa.codbur and elev.nr_matricol=bursieri.nr_matricol and elev.codclasa = clasa.codclasa and specializare.codsp=clasa.codsp group by specializare.nume_sp";
        return jdbcTemplate.queryForList(sql);
    }

}

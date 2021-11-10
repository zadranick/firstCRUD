package za.dranick.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import za.dranick.models.Hero;

import java.util.List;

@Component
public class HeroicDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public HeroicDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Hero> index() {
        return jdbcTemplate.query("SELECT * FROM superheroes", new BeanPropertyRowMapper<>(Hero.class));
    }

    public Hero show(int id) {
        return jdbcTemplate.query("SELECT * FROM superheroes WHERE id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Hero.class))
                .stream().findAny().orElse(null);
    }




}

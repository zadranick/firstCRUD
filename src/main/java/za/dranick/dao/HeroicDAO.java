package za.dranick.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import za.dranick.models.HeroModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class HeroicDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public HeroicDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<HeroModel> index() {
        return jdbcTemplate.query("SELECT * FROM superheroes", new BeanPropertyRowMapper<>(HeroModel.class));
    }

}

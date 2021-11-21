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

    public void save(Hero hero) {
        jdbcTemplate.update("INSERT INTO superheroes(name, align, hair, gender, appearances, year, universe)" +
                        " VALUES(?, ?, ?, ?, ?, ?, ?)",
                hero.getName(), hero.getAlign(),hero.getHair(), hero.getGender(),
                hero.getAppearances(), hero.getYear(), hero.getUniverse());
    }

    public void update(int id, Hero updatedHero) {
        jdbcTemplate.update("UPDATE superheroes SET name=?, align=?, hair=?, gender=?, appearances=?, " +
                "year=?, universe=?  WHERE id=?",
                updatedHero.getName(),updatedHero.getAlign(),updatedHero.getHair(), updatedHero.getGender(),
                updatedHero.getAppearances(), updatedHero.getYear(), updatedHero.getUniverse(),  id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM superheroes WHERE id=?", id);
    }


}

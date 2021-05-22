package ru.itis.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcRepositoryImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;

  /*  public void insertTestLandLord(){
        jdbcTemplate.update()
    }
*/
}

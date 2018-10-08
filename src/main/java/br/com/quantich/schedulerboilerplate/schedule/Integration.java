package br.com.quantich.schedulerboilerplate.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Integration {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Scheduled(fixedDelay = 2)
    public void readInt100() {
        jdbcTemplate.query("select 1 from inte_100", rs -> {});
        System.out.println("teste");
    }
}

package br.com.quantich.schedulerboilerplate.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;

@Component
public class Integration {
//    @Autowired
//    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource primaryDataSource;

    @Autowired
    DataSource secondaryDataSource;

    @Scheduled(fixedDelay = 200)
    public void readInt100() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(primaryDataSource);
        jdbcTemplate.query("select 1 from inte_100", rs -> {});
        System.out.println("teste");
    }

    @Scheduled(fixedDelay = 200)
    public void readInt1022() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(secondaryDataSource);
        jdbcTemplate.query("select 1 from inte_100", rs -> {});
        System.out.println("teste 2");
    }
}

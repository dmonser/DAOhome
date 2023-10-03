package ru.netology.DAOhome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Objects;

@SpringBootApplication
public class DaOhomeApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DaOhomeApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

}

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
public class DaOhomeApplication implements CommandLineRunner {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DaOhomeApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

	@Override
	public void run(String... args) throws SQLException {
		var parameters = new HashMap<String, Object>();
		parameters.put("name", "ivan");

		var result = namedParameterJdbcTemplate.queryForObject("select * from netology.customers as C " +
						"join netology.orders as O on C.id = O.customer_id " +
						"where lower(C.\"name\") = :name limit 100",
				parameters, (ResultSet rs, int rowNum) -> {
					var name = rs.getString("name");
					var surname = rs.getString("surname");
					var productName = rs.getString("product_name");

					return new Person(name, surname, productName);
				});

		System.out.println(result);
	}

	public static class Person {
		private String name;
		private String surname;
		private String productName;

		public Person(String name, String surname, String productName) {
			this.name = name;
			this.surname = surname;
			this.productName = productName;
		}

		@Override
		public String toString() {
			return "Person{" +
					"name=" + name +
					",surname=" + surname + "}, " +
					"product_name=" + productName;
		}
	}
}

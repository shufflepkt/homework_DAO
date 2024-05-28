package com.example.homework_dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class HomeworkDaoApplication /*implements CommandLineRunner*/ {
//    @Autowired
//    private DataSource dataSource;
//
//    @Autowired
//    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public static void main(String[] args) {
        new SpringApplication(HomeworkDaoApplication.class).run(args);
    }

//    @Override
//    public void run(String... args) throws SQLException {
//        Connection connection = dataSource.getConnection();
//        Statement statement = connection.createStatement();
//
//        ResultSet resultSet = statement.executeQuery("select* from netology2.employees");
//
//        while (resultSet.next()) {
//            System.out.print(resultSet.getInt(1) + " ");
//            System.out.print(resultSet.getString(2) + " ");
//            System.out.print(resultSet.getInt(3) + " ");
//            System.out.print(resultSet.getString(4) + " ");
//            System.out.print(resultSet.getInt(5) + " ");
//            System.out.print(resultSet.getString(6) + " ");
//            System.out.print(resultSet.getInt(7) + "\n");
//        }
//
//
//        String name = "alexey";
//        Map<String, Object> params = new HashMap<>();
//        params.put("name", name);
//        List<String> products = namedParameterJdbcTemplate.query("select product_name " +
//                "from homework.orders_1 o " +
//                "inner join homework.customers_1 c on o.customer_id = c.id " +
//                "where lower(c.\"name\") = :name", params, (rs, rowNum) -> {
//            String product = rs.getString("product_name");
//            return product;
//        });
//
//        products.forEach(System.out::println);
//    }

}

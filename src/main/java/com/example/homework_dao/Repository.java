package com.example.homework_dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@org.springframework.stereotype.Repository
public class Repository {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final String scriptFileName = "myScript.sql";
    private final String columnName = "product_name";
    private String script;

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getProductName(String name) {
        script = read(scriptFileName);

        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        List<String> products = namedParameterJdbcTemplate.query(script + "'" + name + "'", params, (rs, rowNum) -> {
            String product = rs.getString(columnName);
            return product;
        });

        return products;
    }
}

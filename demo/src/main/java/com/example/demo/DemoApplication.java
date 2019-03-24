package com.example.demo;

import au.com.bytecode.opencsv.CSVReader;
import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoApplication {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		SpringApplication.run(DemoApplication.class, args);

		/*
		To-do
		1. loo crud https://juliuskrah.com/tutorial/2017/02/15/crud-operations-with-hibernate-and-jpa/
		2. kasuta crud operatsioone ja loe sisse CSV-st ning pane baasi
		   https://howtodoinjava.com/apache-commons/parse-read-write-csv-opencsv/
		   https://www.youtube.com/watch?v=3_40oiUdLG8&index=6&list=PLXk7NJ2IjKyE3abKviidXSUxOdLmGM5bd&t=0s
		3. Kas siit saab findAll abiga teha vajalikke otsinguid?
		   https://www.baeldung.com/spring-boot-hibernate
		 */

		//Build reader instance
		// CSVReader reader = new CSVReader(new FileReader("src/BX-Users.csv"), ';', '"', 1);
		CSVReader reader = new CSVReader(
				new InputStreamReader(new FileInputStream("src/BX-Users.csv"), "UTF-8"),
				';', '"', 1);

		//Read all rows at once
		List<String[]> allRows = reader.readAll();

		UserRepositoryImpl userRepositoryImlp = new UserRepositoryImpl();

		//Read CSV line by line and use the string array as you want
		for(String[] row : allRows){

			int userId = (char) Integer.parseInt(row[0]);
			String location = row[1];

			int age = Integer.parseInt(row[2]);
			User user = new User(userId, location, age);
			userRepositoryImlp.create(user);

		}
	}

}

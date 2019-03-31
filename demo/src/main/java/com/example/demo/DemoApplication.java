package com.example.demo;

// import au.com.bytecode.opencsv.CSVReader;
import com.example.demo.Entity.Book;
import com.example.demo.Entity.Rating;
import com.example.demo.Entity.User;
import com.example.demo.Repository.BookRepositoryImpl;
import com.example.demo.Repository.RatingRepositoryImpl;
import com.example.demo.Repository.UserRepositoryImpl;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVReader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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
		UserRepositoryImpl userRepositoryImlp = new UserRepositoryImpl();
		CSVReader reader = new CSVReader(new FileReader("src/BX-Users-10K.csv"), ';', '"', 1);

		List<String[]> allRowsUser = reader.readAll();
		for(String[] row : allRowsUser){
			int userId = (char) Integer.parseInt(row[0]);
			String location = row[1];
			String str = row[2];
			int number = 0;
			try
			{
				if(str != null)
					number = Integer.parseInt(str);
			}
			catch (NumberFormatException e)
			{
				number = 0;
			}
			int age = number;
			User user = new User(userId, location, age);
			userRepositoryImlp.create(user);
		}


		/*
		String[] nextLine;
		while ((nextLine = reader.readNext()) != null) {
			// nextLine[] is an array of values from the line
			// System.out.println(nextLine[0] + nextLine[1] + nextLine[2]);
			int userId = (char) Integer.parseInt(nextLine[0]);
			String location = nextLine[1];
			String str = nextLine[2];
			int number = 0;
			try
			{
				if(str != null)
					number = Integer.parseInt(str);
			}
			catch (NumberFormatException e)
			{
				number = 0;
			}
			int age = number;
			User user = new User(userId, location, age);
			userRepositoryImlp.create(user);
		}
		*/

		RatingRepositoryImpl ratingRepositoryImpl = new RatingRepositoryImpl();
		CSVReader readerRating = new CSVReader(new FileReader("src/BX-Book-Ratings-10K.csv"), ';', '"', 1);
		// String[] nextLineRating;
		List<String[]> allRowsRating = reader.readAll();
		for(String[] row : allRowsRating){
			//System.out.println(id);
			//id++;
			int userId = (char) Integer.parseInt(row[0]);
			String isbn = row[1];
			int bookRating = (char) Integer.parseInt(row[2]);
			Rating rating = new Rating(userId, isbn, bookRating);
			ratingRepositoryImpl.create(rating);
		}

		BookRepositoryImpl bookRepositoryImpl = new BookRepositoryImpl();
		CSVReader readerBook = new CSVReader(new FileReader("src/BX-Books-10K.csv"), ';', '"', 1);
		List<String[]> allRowsBook = reader.readAll();
		for(String[] row : allRowsBook){
			String isbn = row[0];
			String bookTitle = row[1];
			String bookAuthor = row[2];
			int year = (char) Integer.parseInt(row[3]);
			String publisher = row[4];
			String imageUrlS = row[5];
			String imageUrlM = row[6];
			String imageUrlL = row[7];
			Book book = new Book(isbn, bookTitle, bookAuthor, year, publisher, imageUrlS, imageUrlM, imageUrlL);
			bookRepositoryImpl.create(book);
		}

		List result = userRepositoryImlp.search("Denmark");
		for (Object member : result) {
			System.out.println(member);
		}

		List topResult = ratingRepositoryImpl.topItems();
		System.out.println(topResult);





		/*CSVReader reader = new CSVReader(new FileReader("src/BX-Users-10K.csv"), ';', '"', 1);
		/*CSVReader reader = new CSVReader(
				new InputStreamReader(new FileInputStream("src/BX-Users-10K.csv"), "UTF-8"),
				';', '"', 1);*/

		//Read all rows at once
		/*List<String[]> allRows = reader.readAll();

		UserRepositoryImpl userRepositoryImlp = new UserRepositoryImpl();

		//Read CSV line by line and use the string array as you want
		for(String[] row : allRows){

			int userId = (char) Integer.parseInt(row[0]);
			String location = row[1];

			int age = Integer.parseInt(row[2]);
			User user = new User(userId, location, age);
			userRepositoryImlp.create(user);

		}*/


		/*
		String SAMPLE_CSV_FILE_PATH = "src/BX-Users-10K.csv";

		UserRepositoryImpl userRepositoryImlp = new UserRepositoryImpl();

		Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
		// CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
		CSVReader csvReader = new CSVReader(reader);

			// Reading Records One by One in a String array
		String[] nextRecord;
		nextRecord = csvReader.readNext();
		System.out.println(Arrays.toString(nextRecord));
		while ((nextRecord = csvReader.readNext()) != null) {
			System.out.println(nextRecord);
			int userId = (char) Integer.parseInt(nextRecord[0]);
			String location = nextRecord[1];
			int age = Integer.parseInt(nextRecord[2]);
			User user = new User(userId, location, age);
			System.out.println("print");
			userRepositoryImlp.create(user);
		}
		*/
	}
	/*public List<String[]> oneByOne(Reader reader) throws Exception {
		List<String[]> list = new ArrayList<>();
		CSVReader csvReader = new CSVReader(reader);
		String[] line;
		while ((line = csvReader.readNext()) != null) {
			list.add(line);
		}
		reader.close();
		csvReader.close();
		return list;
	}

	public String oneByOneExample() throws Exception {
		Reader reader = Files.newBufferedReader(
				ClassLoader.getSystemResource("src/BX-Users-10K.csv").toURI());
		return CsvReaderExamples.oneByOne(reader).toString();
	}*/


}

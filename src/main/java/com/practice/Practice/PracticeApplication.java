package com.practice.Practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.practice.Practice.entity.Office;
import com.practice.Practice.repository.OfficeRepository;

@SpringBootApplication
public class PracticeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
	}

	@Autowired
	private OfficeRepository officeRepository;

	@Override
	public void run(String... args) throws Exception {
	}
}

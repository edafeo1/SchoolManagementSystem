package com.fegoEdafe.SchoolSystem;

import com.fegoEdafe.SchoolSystem.model.Students;
import com.fegoEdafe.SchoolSystem.services.ImplementationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//
@SpringBootApplication
public class SchoolSystemApplication  {

@Autowired
private final ImplementationService<Students> studentService;

	public SchoolSystemApplication(ImplementationService<Students> studentService) {
		this.studentService = studentService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SchoolSystemApplication.class, args);
	}


		public void run(String... args) throws Exception{
		for (int i =0; i < 100; i++) {
			Students s = new Students();
			s.setFirstName("Fego");
			s.setLastName("Test User");
			s.setEmail("9787456545");
			s.setEmail("hi@gmail.com");

			studentService.Save(s);
		}
	}
}
  
package com.jordan.programa;


import com.jordan.programa.dominios.Pessoa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProgramaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgramaApplication.class, args);

		Pessoa p = new Pessoa("jordan");
		System.out.println(p);

	}

}

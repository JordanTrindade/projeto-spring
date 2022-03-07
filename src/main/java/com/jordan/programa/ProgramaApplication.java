package com.jordan.programa;

import java.util.Arrays;

import com.jordan.programa.dominios.Categoria;
import com.jordan.programa.repositories.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProgramaApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository cR;
	
	public static void main(String[] args) {
		SpringApplication.run(ProgramaApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");

		cR.saveAll(Arrays.asList(cat1,cat2));
	}

}

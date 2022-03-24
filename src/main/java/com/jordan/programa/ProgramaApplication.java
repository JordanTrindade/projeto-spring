package com.jordan.programa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.jordan.programa.dominios.Categoria;
import com.jordan.programa.dominios.Cidade;
import com.jordan.programa.dominios.Estado;
import com.jordan.programa.dominios.Produto;
import com.jordan.programa.repositories.CategoriaRepository;
import com.jordan.programa.repositories.CidadeRepository;
import com.jordan.programa.repositories.EstadoRepository;
import com.jordan.programa.repositories.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProgramaApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository cR;
	@Autowired
	private ProdutoRepository pR;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProgramaApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");

		Produto p1 = new Produto(null, "computador", 2000.00);
		Produto p2 = new Produto(null, "impressora", 800.00);
		Produto p3 = new Produto(null, "mouse", 80.00);

	
		List<Categoria> adcCat = new ArrayList<>();
		adcCat.add(cat1); 
		adcCat.add(cat2); 
	
		
		List<Produto> adcProd = new ArrayList<>();
		adcProd.add(p1);adcProd.add(p2);adcProd.add(p3);

		cat1.getProdutos().addAll(adcProd);
		cat2.getProdutos().add(p2);

		
		p1.getCategorias().add(cat1);
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().add(cat1);

		cR.saveAll(adcCat);
		pR.saveAll(adcProd);

		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "Sao Paulo");

		Cidade c1 = new Cidade(null, "Uberlandia",est1);
		Cidade c2 = new Cidade(null, "São Pualo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().add(c1);
		est2.getCidades().add(c2);
		est2.getCidades().add(c3);

		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		
	}

}

package com.jordan.programa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.jordan.enums.TipoCliente;
import com.jordan.programa.dominios.Categoria;
import com.jordan.programa.dominios.Cidade;
import com.jordan.programa.dominios.Cliente;
import com.jordan.programa.dominios.Endereco;
import com.jordan.programa.dominios.Estado;
import com.jordan.programa.dominios.Produto;
import com.jordan.programa.repositories.CategoriaRepository;
import com.jordan.programa.repositories.CidadeRepository;
import com.jordan.programa.repositories.ClienteRepository;
import com.jordan.programa.repositories.EnderecoRepository;
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
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;
	
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
		
		//clientes e pedidos

		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "153123581235", TipoCliente.PESSOAFISICA);

		Endereco e1 = new Endereco(null, "Rua flores", "300", "Apto 203", "Jardim", "31234124", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "3877012", cli1, c2);

		String t1 = "87654321";
		String t2 = "12345678";

		cli1.getTelefones().add(t1);
		cli1.getTelefones().add(t2);

		cli1.getEnderecos().add(e1);
		cli1.getEnderecos().add(e2);

		clienteRepository.save(cli1);
		enderecoRepository.saveAll(Arrays.asList(e1,e2));

		
	}

}

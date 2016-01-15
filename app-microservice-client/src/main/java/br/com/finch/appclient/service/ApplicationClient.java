package br.com.finch.appclient.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.finch.appclient.dao.AbstractDAO;
import br.com.finch.appclient.to.Pessoa;

/**
 * 
 * @author Renan
 * @since 14/01/2016
 * @version 1.0
 * 
 *          Classe responsável pela configuração dos serviços para consumo via
 *          REST.
 *
 */

@Configuration
@EnableAutoConfiguration
@EnableEurekaClient
@RestController
public class ApplicationClient {

	// Objeto que contem os métodos para realizar operações CRUD.
	AbstractDAO abDAO = new AbstractDAO();

	public static void main(String[] args) throws Exception {

		SpringApplication.run(ApplicationClient.class, args);
	}

	/**
	 * Serviço responsável por manter cadastro de pessoa.
	 * 
	 * @param nome
	 *            - varíavel correspondente ao nome completo da pessoa.
	 * @param cpf
	 *            - varáivel correspondente ao Cadastro de Pessoa Física da
	 *            pessoa.
	 * @param rg
	 *            - varíavel correspondente ao Registro Geral da pessoa.
	 */
	@RequestMapping("/api/cadastro/manterpessoa/{nome}/{cpf}/{rg}")
	public void manterCadastroPessoa(@PathVariable String nome,
			@PathVariable String cpf, @PathVariable String rg) {

		try {

			Pessoa pessoa = new Pessoa();
			pessoa.setNome(nome);
			pessoa.setCpf(cpf);
			pessoa.setRg(rg);
			abDAO.saveOrUpdate(pessoa);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping("/")
	public String hello() {
		return "Hello Broww!!";
	}

}

package br.com.eureka.apiclient.service;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.MongoException;

import br.com.eureka.apiclient.domain.Person;
import br.com.eureka.apiclient.repository.PersonRepository;

@RestController
@RequestMapping("/person")
public class PersonService {

	private PersonRepository clientRepository;

	private Logger logger = Logger.getLogger(PersonService.class);

	@RequestMapping("/save/{nome}/{cpf}/{rg}")
	public void savePerson(@PathVariable String nome, @PathVariable String cpf, @PathVariable String rg) {

		try {

			Person person = new Person();
			person.setNome(nome);
			person.setCpf(cpf);
			person.setRg(rg);
			//clientRepository.save(person);

		} catch (MongoException e) {
			logger.error("Error save person ", e);
		}

	}

}

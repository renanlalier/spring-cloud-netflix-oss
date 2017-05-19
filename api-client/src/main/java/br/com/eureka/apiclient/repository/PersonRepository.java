package br.com.eureka.apiclient.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.eureka.apiclient.domain.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

}

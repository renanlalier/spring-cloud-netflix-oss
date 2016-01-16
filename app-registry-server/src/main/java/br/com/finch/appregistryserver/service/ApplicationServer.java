package br.com.finch.appregistryserver.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 
 * @author Renan
 * @since 14/01/2016
 * @version 1.0
 * 
 *          Classe responsável por executar o servidor de registro de acordo com
 *          as configurações definidas no application.yml
 */

@SpringBootApplication
@EnableEurekaServer
@EnableDiscoveryClient
public class ApplicationServer {

	public static void main(String[] args) throws Exception {

		SpringApplication.run(ApplicationServer.class, args);

	}

}

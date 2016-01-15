package br.com.finch.appmicroserviceclient.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.ogm.cfg.OgmConfiguration;

/**
 * 
 * @author Renan
 * @since 14/01/2016
 * @version 1.0
 * 
 *          Classe responsável por criar uma factory de conexões para o MongoDB
 *          de acordo com as configurações definidas no hibernate.cfg
 *
 */
public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {

		try {
			Configuration cfg = new OgmConfiguration().configure();
			return cfg.buildSessionFactory(new StandardServiceRegistryBuilder()
					.applySettings(cfg.getProperties()).build());
		} catch (Throwable e) {
			System.out.println("Erro: " + e.getMessage());
			throw new ExceptionInInitializerError();
		}

	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}

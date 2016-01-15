package br.com.finch.appmicroserviceclient.dao;

import java.io.Serializable;

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.finch.appmicroserviceclient.util.HibernateUtil;

/**
 * 
 * @author Renan
 * @since 14/01/2016
 * @version 1.0
 * 
 *          Classe responsável por manter as operações de CRUD.
 */
public class AbstractDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param object
	 *            - Refere-se a um objeto qualquer recebido por parametro para
	 *            persistência.
	 * @throws Exception
	 *             - lança exception em caso de erros.
	 * 
	 *             Método responsável por obter uma connection e realizar as
	 *             operações de Insert ou Update para objeto recebido por
	 *             paramêtro.
	 */
	public void saveOrUpdate(Object object) throws Exception {

		Session session = null;
		Transaction transaction = null;

		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(object);
			transaction.commit();

		} catch (PersistenceException e) {
			transaction.rollback();
			throw new Exception(e.getMessage());
		} finally {
			session.close();
		}
	}
}

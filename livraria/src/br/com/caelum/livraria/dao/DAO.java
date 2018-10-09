package br.com.caelum.livraria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public class DAO<T> {

	private final Class<T> classe;
	private EntityManager em;
	
	public DAO(EntityManager manager, Class<T> classe) {
		this.classe = classe;
		this.em = manager;
	}

	public void adiciona(T t) {

		// consegue a entity manager

		// abre transacao
		em.getTransaction().begin();

		// persiste o objeto
		em.persist(t);

		// commita a transacao
		em.getTransaction().commit();

		// fecha a entity manager
	}

	public void remove(T t) {
		em.getTransaction().begin();

		em.remove(em.merge(t));

		em.getTransaction().commit();
	}

	public void atualiza(T t) {
		em.getTransaction().begin();

		em.merge(t);

		em.getTransaction().commit();
	}

	public List<T> listaTodos() {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = em.createQuery(query).getResultList();

		return lista;
	}

	public T buscaPorId(Integer id) {
		T instancia = em.find(classe, id);
		return instancia;
	}

	public int contaTodos() {
		long result = (Long) em.createQuery("select count(n) from livro n")
				.getSingleResult();

		return (int) result;
	}

	public List<T> listaTodosPaginada(int firstResult, int maxResults) {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = em.createQuery(query).setFirstResult(firstResult)
				.setMaxResults(maxResults).getResultList();

		return lista;
	}
	
	public int quantidadeDeElementos() {
		
		
		long resul = (Long) em.createQuery("select count(n) from " + classe.getSimpleName() + " n").getSingleResult();
		
		
		return (int) resul;
	}

}

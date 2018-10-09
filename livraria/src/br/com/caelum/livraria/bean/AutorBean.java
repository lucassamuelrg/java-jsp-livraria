package br.com.caelum.livraria.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;

@Named
@ViewScoped
public class AutorBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Autor autor = new Autor();
	
	@Inject
	AutorDao dao;
	
	
	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Autor getAutor() {
		return autor;
	}

	public List<Autor> getAutores() {
		return this.dao.listaTodos();
	}

	public String gravar() {
		System.out.println("Gravando autor " + this.autor.getNome());

		if (this.autor.getId() == null) {
			this.dao.adiciona(this.autor);
		} else {
			this.dao.atualiza(this.autor);
		}

		this.autor = new Autor();

		return "livro?faces-redirect=true";
	}

	public void carregar(Autor autor) {
		System.out.println("Carregando autor");
		this.autor = autor;
	}

	public void remover(Autor autor) {
		System.out.println("Removendo autor");
		this.dao.remove(autor);
	}

	public void carregaPeloId() {
		Integer id = this.autor.getId();
		this.autor = this.dao.buscaPorId(id);
		if (this.autor == null) {
			this.autor = new Autor();
		}
	}
}

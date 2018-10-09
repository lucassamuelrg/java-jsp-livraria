package br.com.caelum.livraria.modelo;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.caelum.livraria.dao.LivroDao;

@SuppressWarnings("serial")
public class LivroDataModel extends LazyDataModel<Livro> {

	  @Inject
	    private LivroDao livroDAO;

	    @PostConstruct
	    void init(){
	        super.setRowCount(livroDAO.quantidadeDeElementos());
	    }

	    @Override
	    public List<Livro> load(int inicio, int quantidade, String sortField, SortOrder sortOrder,
	            Map<String, Object> filters) {
	        return livroDAO.listaTodosPaginada(inicio, quantidade);
	    }

	
}

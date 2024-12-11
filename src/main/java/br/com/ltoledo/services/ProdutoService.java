package br.com.ltoledo.services;

import br.com.ltoledo.dao.IProdutoDAO;
import br.com.ltoledo.domain.Produto;
import br.com.ltoledo.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
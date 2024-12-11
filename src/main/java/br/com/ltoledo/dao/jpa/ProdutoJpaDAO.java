package br.com.ltoledo.dao.jpa;

import br.com.ltoledo.dao.generic.jpa.GenericJpaDAO;
import br.com.ltoledo.domain.jpa.ProdutoJpa;

public class ProdutoJpaDAO extends GenericJpaDAO<ProdutoJpa, Long> implements IProdutoJpaDAO {

	public ProdutoJpaDAO() {
		super(ProdutoJpa.class);
	}

}
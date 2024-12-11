package br.com.ltoledo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.ltoledo.dao.ClienteDaoMock;
import br.com.ltoledo.dao.IClienteDAO;
import br.com.ltoledo.domain.Cliente;
import br.com.ltoledo.exceptions.DAOException;
import br.com.ltoledo.exceptions.TipoChaveNaoEncontradaException;
import br.com.ltoledo.services.ClienteService;
import br.com.ltoledo.services.IClienteService;

public class ClienteServiceTest {
	
	private IClienteService clienteService;
	
	private Cliente cliente;
	
	public ClienteServiceTest() {
		IClienteDAO dao = new ClienteDaoMock();
		clienteService = new ClienteService(dao);
	}
	
	@Before
	public void init() {
		cliente = new Cliente();
		cliente.setCpf(12312312312L);
		cliente.setNome("Ludmyla");
		cliente.setCidade("Minas Gerais");
		cliente.setEnd("End");
		cliente.setEstado("MG");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		
	}
	
	@Test
	public void pesquisarCliente() throws DAOException {
		Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		Boolean retorno = clienteService.cadastrar(cliente);
		
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluirCliente() throws DAOException {
		clienteService.excluir(cliente.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		cliente.setNome("Ludmyla Toledo");
		clienteService.alterar(cliente);
		
		Assert.assertEquals("Ludmyla Toledo", cliente.getNome());
	}
}
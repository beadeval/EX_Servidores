package unir.exa.ventas.modelo.dao;

import java.util.List;

import unir.exa.ventas.modelo.entity.Cliente;

public interface ClienteDao {

	Cliente buscarUno(int idCliente);
	List<Cliente> buscarTodos();
	Cliente insertOne(Cliente cliente);
	int deleteOne(int idCliente);
	int updateOne(Cliente cliente);
	List<Cliente> buscarPorCategoria(int categoria);



}

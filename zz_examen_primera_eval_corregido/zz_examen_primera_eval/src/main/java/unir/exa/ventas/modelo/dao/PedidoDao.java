package unir.exa.ventas.modelo.dao;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import unir.exa.ventas.modelo.entity.Cliente;
import unir.exa.ventas.modelo.entity.Comercial;
import unir.exa.ventas.modelo.entity.Pedido;

public interface PedidoDao {
	Pedido buscarUno(int idPedido);
	List<Pedido> buscarTodos();
	Pedido insert(Pedido pedido);
	int delete(int idPedido);
	int updateOne(Pedido pedido);
	
	List<Pedido> pedidoFindByCliente(int idCliente);
	List<Pedido> pedidoFindByComercial(int idComercial);
	List<Cliente> findClientesByIdPedido(int idPedido);
	List<Comercial> findComercialesByIdPedido(int idPedido);
	
	

   
}

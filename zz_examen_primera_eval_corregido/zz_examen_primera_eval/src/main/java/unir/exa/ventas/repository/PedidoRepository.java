package unir.exa.ventas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import unir.exa.ventas.modelo.entity.Cliente;
import unir.exa.ventas.modelo.entity.Comercial;
import unir.exa.ventas.modelo.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
	@Query("select p from Pedido p where p.idPedido = ?1") //Consulta personalizada
	//Se busca un 'Cliente' donde el ID sea igual al primer parámetro
	public Pedido pedidoPorIdPedido(int idPedido); //Este método ejecuta la anotación @Query, se
	//espera un ID para devolver el Cliente
	
	//PEDIDO POR CLIENTE
	@Query("SELECT p FROM Pedido p WHERE p.cliente.idCliente = ?1")
    public List<Pedido> pedidoFindByCliente(int idCliente);
	
	//PEDIDO POR COMERCIAL
	@Query("SELECT p FROM Pedido p WHERE p.comercial.idComercial = ?1")
    public List<Pedido> pedidoFindByComercial(int  idComercial);
	

	//CLIENTE POR PEDIDO
	@Query("SELECT p.cliente FROM Pedido p WHERE p.idPedido = :idPedido")
     List<Cliente> findClientesByIdPedido(@Param("idPedido") int idPedido);
	
	//COMERCIAL POR PEDIDO
	@Query("SELECT p.comercial FROM Pedido p WHERE p.idPedido = :idPedido")
	List<Comercial> findComercialesByIdPedido(@Param("idPedido") int idPedido);
		
	
    //CLIENTES POR COMERCIAL
	@Query("SELECT p FROM Pedido p JOIN p.comercial WHERE p.comercial.idComercial =?1")
     List<Pedido> clientesPorComercial(int idComercial);
}
	


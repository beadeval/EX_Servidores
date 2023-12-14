package unir.exa.ventas.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import unir.exa.ventas.modelo.entity.Cliente;
import unir.exa.ventas.modelo.entity.Comercial;
import unir.exa.ventas.modelo.entity.Pedido;
import unir.exa.ventas.repository.ClienteRepository;
import unir.exa.ventas.repository.ComercialRepository;
import unir.exa.ventas.repository.PedidoRepository;

@Repository
public class PedidoImplDaoMy8 implements PedidoDao {

	@Autowired
	private PedidoRepository prepo;
	
	@Autowired
	private ClienteRepository crepo;
	
	@Autowired
	private ComercialRepository corepo;
	
	@Override
	public Pedido buscarUno(int idPedido) {
		return prepo.findById(idPedido).orElse(null);
	}

	@Override
	public List<Pedido> buscarTodos() {
		return prepo.findAll();
	}

	@Override
	public Pedido insert(Pedido pedido) {
		try { //Para eso, metemos un try
			return prepo.save(pedido); //el método save vale para insertar y modificar (tira unas select previa con el 
			//objeto que tú le mandas, te lo inserta, y si lo ve, lo modifica)
		}catch(Exception e) {
			e.printStackTrace(); //Para saber de dónde viene el error
			return null;
		}
	
	}

	@Override
	public int delete(int idPedido) {

		 if (buscarUno(idPedido) != null) { //Si buscarUno pasando el ID es distinto de null, siginfica que hay cliente
				//Pues le metemos el método porque seguro que está
				prepo.deleteById(idPedido); //Devuelve void (si no lo encuentra, casca así que hay que trabajarlo)
				return 1; //Significa que me he cargado una fila
				
		   	}else
				return 0; //Significa que no hay cliente
		   
	}
	
	@Override
	public int updateOne(Pedido pedido) {
		if (buscarUno(pedido.getIdPedido()) != null) { //Se verifica si existe una cuenta en la BBDD igual a la que se quiere actualizar,
            //mediante la función buscarUna utilizando el dato del ID
         prepo.save(pedido); //Utiliza el método 'save' de la CuentaRepository para actualizar la información
         return 1;

         }else
          return 0;
         }

	@Override
	public List<Pedido> pedidoFindByCliente(int idCliente) {
		return prepo.pedidoFindByCliente(idCliente);
	}

	@Override
	public List<Pedido> pedidoFindByComercial(int idComercial) {
		return prepo.pedidoFindByComercial(idComercial);
	}

	@Override
	public List<Cliente> findClientesByIdPedido(int idPedido) {
		return prepo.findClientesByIdPedido(idPedido);
	}

	@Override
	public List<Comercial> findComercialesByIdPedido(int idPedido) {
	    return prepo.findComercialesByIdPedido(idPedido);
	}
	


}

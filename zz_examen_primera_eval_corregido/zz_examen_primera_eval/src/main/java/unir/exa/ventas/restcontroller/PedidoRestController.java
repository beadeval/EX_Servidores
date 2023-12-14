package unir.exa.ventas.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import unir.exa.ventas.modelo.entity.Cliente;
import unir.exa.ventas.repository.PedidoRepository;

@RestController
public class PedidoRestController {

	@Autowired
	private PedidoRepository prepo;
	
	
	//CLIENTE POR COMERCIAL
	@GetMapping ("todosPedidos/{idComercial}")
	public List <Cliente> clientesPorComercial (@PathVariable int idComercial){
		
		return prepo.clientesPorComercial(idComercial)
				.stream()
				.map (ele -> ele.getCliente())
				.distinct().toList();
	}
}

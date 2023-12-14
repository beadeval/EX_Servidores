package unir.exa.ventas.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import unir.exa.ventas.modelo.entity.Cliente;
import unir.exa.ventas.repository.ClienteRepository;

@Repository 

public class ClienteImplDaoMy8 implements ClienteDao {
	
	@Autowired
	private ClienteRepository crepo;

	@Override
	public Cliente buscarUno(int idCliente) {
		return crepo.findById(idCliente).orElse(null);
	}

	@Override
	public List<Cliente> buscarTodos() {
		return crepo.findAll();
	}
	 
	@Override
	public Cliente insertOne (Cliente cliente) {
		try { //Para eso, metemos un try
			return crepo.save(cliente); //el método save vale para insertar y modificar (tira unas select previa con el 
			//objeto que tú le mandas, te lo inserta, y si lo ve, lo modifica)
		}catch(Exception e) {
			e.printStackTrace(); //Para saber de dónde viene el error
			return null;
		}
	}
	

	@Override
	public int deleteOne (int idCliente) {
	   if (buscarUno(idCliente) != null) { //Si buscarUno pasando el ID es distinto de null, siginfica que hay cliente
		//Pues le metemos el método porque seguro que está
		crepo.deleteById(idCliente); //Devuelve void (si no lo encuentra, casca así que hay que trabajarlo)
		return 1; //Significa que me he cargado una fila
		
   	}else
		return 0; //Significa que no hay cliente
   }
	

	@Override
	public int updateOne(Cliente cliente) {
		if (buscarUno(cliente.getIdCliente()) != null) { //Se verifica si existe una cuenta en la BBDD igual a la que se quiere actualizar,
            //mediante la función buscarUna utilizando el dato del ID
         crepo.save(cliente); //Utiliza el método 'save' de la CuentaRepository para actualizar la información
         return 1;

         }else
          return 0;
         }

	@Override
	public List<Cliente> buscarPorCategoria(int categoria) {
		return crepo.findByCategoria(categoria);
	}

	

}


	

	



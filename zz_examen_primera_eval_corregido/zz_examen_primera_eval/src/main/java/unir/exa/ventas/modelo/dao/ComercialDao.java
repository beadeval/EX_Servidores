package unir.exa.ventas.modelo.dao;

import java.util.List;

import unir.exa.ventas.modelo.entity.Cliente;
import unir.exa.ventas.modelo.entity.Comercial;

public interface ComercialDao {
	Comercial buscarUno(int idComercial);
	List<Comercial> buscarTodos();
	Comercial insertOne (Comercial comercial);
	int delete(int idComercial);
	int updateOne(Comercial comercial);
	/*List<Cliente> findClientesByComercialId(int idComercial);*/
	

}

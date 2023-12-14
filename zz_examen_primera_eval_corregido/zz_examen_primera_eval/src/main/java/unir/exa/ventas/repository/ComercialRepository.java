package unir.exa.ventas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import unir.exa.ventas.modelo.entity.Cliente;
import unir.exa.ventas.modelo.entity.Comercial;
import unir.exa.ventas.modelo.entity.Pedido;

public interface ComercialRepository extends JpaRepository<Comercial, Integer> {

	@Query("select c from Comercial c where c.idComercial = ?1") //Consulta personalizada
	//Se busca un 'Cliente' donde el ID sea igual al primer parámetro
	
	public Comercial comercialPorIdComercial(int idComercial); //Este método ejecuta la anotación @Query, se
	//espera un ID para devolver el Cliente

	/*@Query("SELECT c.clientes FROM Comercial c WHERE c.id = :comercialId")
    List<Cliente> findClientesByComercialId(@Param("idComercial") int idComercial);*/
	
	

}
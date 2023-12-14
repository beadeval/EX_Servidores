package unir.exa.ventas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import unir.exa.ventas.modelo.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

		@Query("select c from Cliente c where c.idCliente = ?1") //Consulta personalizada
		//Se busca un 'Cliente' donde el ID sea igual al primer parámetro
		public Cliente clientePorIdCliente(int idCliente); //Este método ejecuta la anotación @Query, se
		//espera un ID para devolver el Cliente
		
		//CLIENTE POR CATEGORIA
		 @Query("SELECT c FROM Cliente c WHERE c.categoria = ?1")
		  List<Cliente> findByCategoria(int categoria);
		
	
}

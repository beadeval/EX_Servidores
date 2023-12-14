package unir.exa.ventas.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import unir.exa.ventas.modelo.entity.Cliente;
import unir.exa.ventas.modelo.entity.Comercial;
import unir.exa.ventas.repository.ComercialRepository;

@Repository

public class ComercialImplDaoMy8 implements ComercialDao {

	@Autowired
	private ComercialRepository corepo;
	
	@Override
	public Comercial buscarUno(int idComercial) {
		return corepo.findById(idComercial).orElse(null);
		}
	

	@Override
	public List<Comercial> buscarTodos() {
		return corepo.findAll();
	}

	@Override
	public Comercial insertOne(Comercial comercial) {
		try { //Para eso, metemos un try
			return corepo.save(comercial); //el método save vale para insertar y modificar (tira unas select previa con el 
			//objeto que tú le mandas, te lo inserta, y si lo ve, lo modifica)
		}catch(Exception e) {
			e.printStackTrace(); //Para saber de dónde viene el error
			return null;
		}
	
	}

	@Override
	public int delete(int idComercial) {
		 if (buscarUno(idComercial) != null) { //Si buscarUno pasando el ID es distinto de null, siginfica que hay cliente
				//Pues le metemos el método porque seguro que está
				corepo.deleteById(idComercial); //Devuelve void (si no lo encuentra, casca así que hay que trabajarlo)
				return 1; //Significa que me he cargado una fila
				
		   	}else
				return 0; //Significa que no hay cliente
		   }

	@Override
	public int updateOne(Comercial comercial) {
		if (buscarUno(comercial.getIdComercial()) != null) { //Se verifica si existe una cuenta en la BBDD igual a la que se quiere actualizar,
            //mediante la función buscarUna utilizando el dato del ID
         corepo.save(comercial); //Utiliza el método 'save' de la CuentaRepository para actualizar la información
         return 1;

         }else
          return 0;
         }

	
}




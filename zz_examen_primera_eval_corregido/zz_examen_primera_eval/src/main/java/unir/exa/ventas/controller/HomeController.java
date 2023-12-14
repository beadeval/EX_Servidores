package unir.exa.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import unir.exa.ventas.modelo.dao.ClienteDao;
import unir.exa.ventas.modelo.dao.ComercialDao;
import unir.exa.ventas.modelo.dao.PedidoDao;
import unir.exa.ventas.modelo.entity.Cliente;
import unir.exa.ventas.modelo.entity.Comercial;
import unir.exa.ventas.modelo.entity.Pedido;

@Controller

public class HomeController {
	
	@Autowired
	private ClienteDao cdao;
	@Autowired
	private ComercialDao codao;
	@Autowired
	private PedidoDao pdao;
	
	
    // VER DETALLE CLIENTE
	@GetMapping("/verDetalleCliente/{idCliente}") //Método mapeado que responde solicitudes GET que coincide con dicha URL
	public String verCliente(@PathVariable("idCliente") int idCliente, Model model) {
			
			//Se accede al ID solicitado a través de @Path y se llama al método findById(). Si existe,se
			//muestra el detalle del evento (los atributos)
			Cliente cliente = cdao.buscarUno(idCliente);
			if (cliente != null) {
				model.addAttribute("cliente", cliente);
				return "verDetalleCliente";
			}
			else {
				model.addAttribute("mensaje", "Este cliente no existe");
				return "forward:/";
			}
			
		}
	
	// VER DETALLE COMERCIAL
	@GetMapping("/verDetalleComercial/{idComercial}") //Método mapeado que responde solicitudes GET que coincide con dicha URL
	public String verComercial(@PathVariable("idComercial") int idComercial, Model model) {
			
			//Se accede al ID solicitado a través de @Path y se llama al método findById(). Si existe,se
			//muestra el detalle del evento (los atributos)
			Comercial comercial = codao.buscarUno(idComercial);
			if (comercial != null) {
				model.addAttribute("comercial", comercial);
				return "verDetalleComercial";
			}
			else {
				model.addAttribute("mensaje", "Este comercial no existe");
				return "forward:/";
			}
			
		}
	
	// VER DETALLE PEDIDO
		@GetMapping("/verDetallePedido/{idPedido}") //Método mapeado que responde solicitudes GET que coincide con dicha URL
		public String verPedido(@PathVariable("idPedido") int idPedido, Model model) {
				
				//Se accede al ID solicitado a través de @Path y se llama al método findById(). Si existe,se
				//muestra el detalle del evento (los atributos)
				Pedido pedido = pdao.buscarUno(idPedido);
				if (pedido != null) {
					model.addAttribute("pedido", pedido);
					return "verDetallePedido";
				}
				else {
					model.addAttribute("mensaje", "Este pedido no existe");
					return "forward:/";
				}
				
			}
	//MOSTRAR UN CLIENTE
		@GetMapping("/mostrarCliente/{idCliente}")
		public String buscarClientePorId(@PathVariable("idCliente") int idCliente, Model model) {
	        // Buscar el pedido por su ID utilizando el método buscarPorId en el PedidoDAO
	       Cliente cliente = cdao.buscarUno(idCliente);

	        if (cliente != null) {
	            // Si se encuentra el pedido, agregarlo al modelo y mostrar la vista con los detalles del pedido
	            model.addAttribute("cliente", cliente);
	            return "mostrarCliente";
	        } else {
	            // Si el pedido no se encuentra, agregar un mensaje al modelo y redirigir a una página de error
	            model.addAttribute("mensaje", "El cliente no fue encontrado");
	            return "paginaDeError";
	        }
	    }
		
		
	//MOSTRAR UN COMERCIAL
		@GetMapping("/mostrarComercial/{idComercial}") 
		public String buscarComercialpoprId(@PathVariable("idComercial") int idComercial, Model model) {
	        // Buscar el pedido por su ID utilizando el método buscarPorId en el PedidoDAO
	        Comercial comercial = codao.buscarUno(idComercial);

	        if (comercial != null) {
	            // Si se encuentra el pedido, agregarlo al modelo y mostrar la vista con los detalles del pedido
	            model.addAttribute("comercial", comercial);
	            return "mostrarComercial";
	        } else {
	            // Si el pedido no se encuentra, agregar un mensaje al modelo y redirigir a una página de error
	            model.addAttribute("mensaje", "El comercial no fue encontrado");
	            return "paginaDeError";
	        }
	    }
		
	//MOSTRAR UN PEDIDO
		@GetMapping("/mostrarPedido/{idPedido}")
		public String buscarPedidoPorId(@PathVariable("idPedido") int idPedido, Model model) {
	        // Buscar el pedido por su ID utilizando el método buscarPorId en el PedidoDAO
	        Pedido pedido = pdao.buscarUno(idPedido);

	        if (pedido != null) {
	            // Si se encuentra el pedido, agregarlo al modelo y mostrar la vista con los detalles del pedido
	            model.addAttribute("pedido", pedido);
	            return "mostrarPedido";
	        } else {
	            // Si el pedido no se encuentra, agregar un mensaje al modelo y redirigir a una página de error
	            model.addAttribute("mensaje", "El pedido no fue encontrado");
	            return "paginaDeError";
	        }
	    }
		
		
	//MOSTRAR TODOS LOS CLIENTES
    	@GetMapping("/mostrarClientes")
    	 public String todosClientes(Model model) {
            model.addAttribute("clientes", cdao.buscarTodos()); // Pasar directamente los clientes al modelo
            return "mostrarClientes"; // Nombre de tu vista para mostrar los clientes
        }
		
	//MOSTRAR TODOS LOS COMERCIALES
    	@GetMapping("/mostrarComerciales")
    	 public String todosComerciales(Model model) {
            model.addAttribute("comerciales", codao.buscarTodos()); // Pasar directamente los clientes al modelo
            return "mostrarComerciales"; // Nombre de tu vista para mostrar los clientes
        }
		
	//MOSTRAR TODOS LOS PEDIDOS
		@GetMapping("/mostrarPedidos")
		 public String todosPedidos(Model model) {
            model.addAttribute("pedidos", pdao.buscarTodos()); // Pasar directamente los clientes al modelo
            return "mostrarPedidos"; // Nombre de tu vista para mostrar los clientes
        }
		
		
	
	//DAR DE ALTA UN CLIENTE
		@PostMapping("/altaCliente")
	    public String altaCliente(@RequestBody Cliente cliente, Model model) {
	        Cliente clienteNuevo = new Cliente();

	        try {
	            clienteNuevo = cdao.insertOne(cliente); // Guarda el cliente en la base de datos
	        } catch (Exception e) {
	            e.printStackTrace(); // Manejo de la excepción si ocurre algún error al guardar el cliente
	        }

	        if (clienteNuevo != null) {
	            // Agrega el cliente guardado al modelo para mostrarlo en la vista
	            model.addAttribute("cliente", clienteNuevo);
	            // Devuelve la vista donde se muestra el cliente
	            return "redirect:/mostrarClientes"; // Reemplaza esto con el nombre de tu vista
	        } else {
	            // Manejar el caso donde no se pudo guardar el cliente
	            // Redirigir o mostrar un mensaje de error, según tus necesidades
	            return "error"; // Vista de error, cámbialo según la estructura de tu proyecto
	        }
	    }
		//ALTA CLIENTE
				@GetMapping("/altaCliente") //Controlador que maneja una solocitud por GET
				
				//El controlador prepara un formulario vacío para crear un nuevo evento y muestra la vista "formAlta" 
				//donde los usuarios pueden ingresar los detalles del evento.
				
				public String mostrarFormularioCliente(Model model) {
					    Cliente cliente = new Cliente(); // crea un nuevo evento u obtén uno de tu base de datos
					    model.addAttribute("cliente", cliente );
					    return "formAltaCliente";
				}
	

		
	//DAR DE ALTA UN COMERCIAL
		@PostMapping("/altaComercial")
	    public String altaComercial(@ModelAttribute Comercial comercial, Model model) {
	        Comercial comercialNuevo = new Comercial();

	        try {
	            comercialNuevo = codao.insertOne(comercial); // Guarda el cliente en la base de datos
	        } catch (Exception e) {
	            e.printStackTrace(); // Manejo de la excepción si ocurre algún error al guardar el cliente
	        }

	        if (comercialNuevo != null) {
	            // Agrega el cliente guardado al modelo para mostrarlo en la vista
	            model.addAttribute("comercial", comercialNuevo);
	            // Devuelve la vista donde se muestra el cliente
	            return "redirect:/mostrarComerciales"; // Reemplaza esto con el nombre de tu vista
	        } else {
	            // Manejar el caso donde no se pudo guardar el cliente
	            // Redirigir o mostrar un mensaje de error, según tus necesidades
	            return "error"; // Vista de error, cámbialo según la estructura de tu proyecto
	        }
	    }
		
		//ALTA COMERCIAL
				@GetMapping("/altaComercial") //Controlador que maneja una solocitud por GET
				
				//El controlador prepara un formulario vacío para crear un nuevo evento y muestra la vista "formAlta" 
				//donde los usuarios pueden ingresar los detalles del evento.
				
				public String mostrarFormularioComercial(Model model) {
					    Comercial comercial = new Comercial(); // crea un nuevo evento u obtén uno de tu base de datos
					    model.addAttribute("comercial", comercial );
					    return "formAltaComercial";
				}
	
	
	//DAR DE ALTA UN PEDIDO
		@PostMapping("/altaPedido")
	    public String altaPedido(@RequestBody Pedido pedido, Model model) {
	        Pedido pedidoNuevo = new Pedido();

	        try {
	            pedidoNuevo = pdao.insert(pedido); // Guarda el cliente en la base de datos
	        } catch (Exception e) {
	            e.printStackTrace(); // Manejo de la excepción si ocurre algún error al guardar el cliente
	        }

	        if (pedidoNuevo != null) {
	            // Agrega el cliente guardado al modelo para mostrarlo en la vista
	            model.addAttribute("pedido", pedidoNuevo);
	            // Devuelve la vista donde se muestra el cliente
	            return "redirect:/mostrarPedidos"; // Reemplaza esto con el nombre de tu vista
	        } else {
	            // Manejar el caso donde no se pudo guardar el cliente
	            // Redirigir o mostrar un mensaje de error, según tus necesidades
	            return "error"; // Vista de error, cámbialo según la estructura de tu proyecto
	        }
	    }
	
		//ALTA PEDIDO
		@GetMapping("/altaPedido") //Controlador que maneja una solocitud por GET
		
		//El controlador prepara un formulario vacío para crear un nuevo evento y muestra la vista "formAlta" 
		//donde los usuarios pueden ingresar los detalles del evento.
		
		public String mostrarFormularioPedido(Model model) {
			    Pedido pedido = new Pedido(); // crea un nuevo evento u obtén uno de tu base de datos
			    model.addAttribute("pedido", pedido );
			    return "formAltaPedido";
		}
		
	 //ELIMINAR CLIENTE
		@GetMapping("/eliminarCliente/{id}") //Método mapeado que responde solicitudes GET que coincide con dicha URL
		public String eliminarCliente(@PathVariable("id") int idCliente, Model model) {
				
			 if (codao.delete(idCliente) == 1) {
			        model.addAttribute("mensaje", "Cliente eliminado con éxito");
			    } else {
			        model.addAttribute("mensaje", "El cliente no ha podido ser eliminado");
			    }

			    return "redirect:/mostrarClientes"; // Retornar la vista que muestra la lista de comerciales
			}


		
     //ELIMINAR COMERCIAL
		@GetMapping("/eliminarComercial/{id}")
		public String eliminarComercial(@PathVariable("id") int idComercial, Model model) {
		    if (codao.delete(idComercial) == 1) {
		        model.addAttribute("mensaje", "Comercial eliminado con éxito");
		    } else {
		        model.addAttribute("mensaje", "El comercial no ha podido ser eliminado");
		    }
		    return "redirect:/mostrarComerciales"; // Retornar la vista que muestra la lista de comerciales
		}


	
	//ELIMINAR PEDIDO
		@GetMapping("/eliminarPedido/{id}") //Método mapeado que responde solicitudes GET que coincide con dicha URL
		public String eliminarPedido(@PathVariable("id") int idPedido, Model model) {
			 if (codao.delete(idPedido) == 1) {
			        model.addAttribute("mensaje", "Pedido eliminado con éxito");
			    } else {
			        model.addAttribute("mensaje", "El pedido no ha podido ser eliminado");
			    }
			    return "redirect:/mostrarPedidos"; // Retornar la vista que muestra la lista de comerciales
			}

		
		
		

		//MODIFICAR CLIENTE
			  @GetMapping("/modificarCliente/{id}")
			    public String modificarCliente (@PathVariable int id, Model model) {
			        Cliente cliente = cdao.buscarUno(id);
			        
			        if (cliente != null) {
			            model.addAttribute("cliente", cliente);
			            return "formModificarCliente"; // Nombre de la vista HTML de modificación
			        } else {
			            // Manejar el caso donde el comercial no se encuentra, por ejemplo, mostrar un mensaje de error
			            return "error"; // Vista de error, cámbialo según la estructura de tu proyecto
			        }
			    }
			
			@PostMapping("/modificarCliente")
		    public String formModificarCliente(@ModelAttribute Cliente cliente) {
		        try {
		            cdao.updateOne(cliente);
		            return "redirect:/mostrarClientes"; // Redirige a la lista de comerciales después de la modificación
		        } catch (Exception e) {
		            e.printStackTrace();
		            // Manejar el caso de error, por ejemplo, mostrar un mensaje de error
		            return "error"; // Vista de error, cámbialo según la estructura de tu proyecto
		        }
		    }
	
	//MODIFICAR COMERCIAL
		  @GetMapping("/modificarComercial/{id}")
		    public String modificarComercial(@PathVariable int id, Model model) {
		        Comercial comercial = codao.buscarUno(id);
		        
		        if (comercial != null) {
		            model.addAttribute("comercial", comercial);
		            return "formModificarComercial"; // Nombre de la vista HTML de modificación
		        } else {
		            // Manejar el caso donde el comercial no se encuentra, por ejemplo, mostrar un mensaje de error
		            return "error"; // Vista de error, cámbialo según la estructura de tu proyecto
		        }
		    }
		
		@PostMapping("/modificarComercial")
	    public String formModificarComercial(@ModelAttribute Comercial comercial) {
	        try {
	            codao.updateOne(comercial);
	            return "redirect:/mostrarComerciales"; // Redirige a la lista de comerciales después de la modificación
	        } catch (Exception e) {
	            e.printStackTrace();
	            // Manejar el caso de error, por ejemplo, mostrar un mensaje de error
	            return "error"; // Vista de error, cámbialo según la estructura de tu proyecto
	        }
	    }
		//MODIFICAR COMERCIAL
		  @GetMapping("/modificarPedido/{id}")
		    public String modificarPedido(@PathVariable int id, Model model) {
		        Pedido pedido = pdao.buscarUno(id);
		        
		        if (pedido != null) {
		            model.addAttribute("pedido", pedido);
		            return "formModificarPedido"; // Nombre de la vista HTML de modificación
		        } else {
		            // Manejar el caso donde el comercial no se encuentra, por ejemplo, mostrar un mensaje de error
		            return "error"; // Vista de error, cámbialo según la estructura de tu proyecto
		        }
		    }
		
		@PostMapping("/modificarPedido")
	    public String formModificarPedido(@ModelAttribute Pedido pedido) {
	        try {
	            pdao.updateOne(pedido);
	            return "redirect:/mostrarPedidos"; // Redirige a la lista de comerciales después de la modificación
	        } catch (Exception e) {
	            e.printStackTrace();
	            // Manejar el caso de error, por ejemplo, mostrar un mensaje de error
	            return "error"; // Vista de error, cámbialo según la estructura de tu proyecto
	        }
	    }
		
	//VER CLIENTES POR CATEGORIA
		@GetMapping("/clientesPorCategoria/{categoria}")
	    public String obtenerClientesPorCategoria(@PathVariable int categoria, Model model) {
	        List<Cliente> clientesPorCategoria = cdao.buscarPorCategoria(categoria);

	        model.addAttribute("clientesPorCategoria", clientesPorCategoria);
	        return "clientesPorCategoria"; // Nombre de tu vista para mostrar los clientes por categoría
	    }
	
	//VER PEDIDOS POR CLIENTES
		@GetMapping("/pedidosPorCliente/{idCliente}")
	    public String obtenerPedidosPorCliente(@PathVariable int idCliente, Model model) {
	        List<Pedido> pedidosPorCliente = pdao.pedidoFindByCliente(idCliente);

	        model.addAttribute("pedidosPorCliente", pedidosPorCliente);
	        return "pedidosPorCliente"; // Vista para mostrar los pedidos por cliente
	    }
		
	//VER PEDIDOS POR COMERCIALES
		@GetMapping("/pedidosPorComercial/{idComercial}")
	    public String obtenerPedidosPorComercial(@PathVariable int idComercial, Model model) {
	        List<Pedido> pedidosPorComercial = pdao.pedidoFindByComercial(idComercial);

	        model.addAttribute("pedidosPorComercial", pedidosPorComercial);
	        return "pedidosPorComercial"; // Vista para mostrar los pedidos por cliente
	    }
		
	
	//VER CLIENTE POR PEDIDO
		 @GetMapping("/mostrarClientesPorPedido/{idPedido}")
	    public String obtenerClientesPorPedido(@PathVariable int idPedido, Model model) {
	        List<Cliente> clientesDelPedido = pdao.findClientesByIdPedido(idPedido);

	        model.addAttribute("clientes", clientesDelPedido);
	        return "mostrarClientesPorPedido"; // Esto asume que tienes un archivo HTML llamado "clientes.html" en tu directorio de plantillas Thymeleaf
	    }
	

	//VER COMERCIAL POR PEDIDO
		 @GetMapping("/mostrarComercialesPorPedido/{idPedido}")
		    public String obtenerComercialesPorPedido(@PathVariable int idPedido, Model model) {
		        List<Comercial> comercialesDelPedido = pdao.findComercialesByIdPedido(idPedido);

		        model.addAttribute("comerciales", comercialesDelPedido);
		        return "mostrarComercialesPorPedido"; // Esto asume que tienes un archivo HTML llamado "clientes.html" en tu directorio de plantillas Thymeleaf
		    }
    
}
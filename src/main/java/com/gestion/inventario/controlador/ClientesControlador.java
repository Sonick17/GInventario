
package com.gestion.inventario.controlador;

import com.gestion.inventario.excepciones.ResourceNotFoundException;
import com.gestion.inventario.modelo.Clientes;
import com.gestion.inventario.modelo.Medicamentos;
import com.gestion.inventario.repositorio.ClientesRepositorio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v1")
public class ClientesControlador {

	@Autowired
	private ClientesRepositorio repositorio;

	@GetMapping("/clientes")
	public List<Clientes> ListarTodosLosClientes() {
		return repositorio.findAll();
	}
	
	//Add Clientes
    @PostMapping("/clientes")
    public Clientes guardarClientes(@RequestBody Clientes Clientes) {
    	return repositorio.save(Clientes);
    }

    //Search Clientes
    @GetMapping("/clientes/{id}")
    public ResponseEntity<Clientes> obtenerClientePorId(@PathVariable Long id_cli){
    	Clientes Cliente= repositorio.findById(id_cli)
    			.orElseThrow(() -> new ResourceNotFoundException("No exite el Cliente con el ID:" + id_cli));
    	return ResponseEntity.ok(Cliente);	
    }
    
    //Update Clientes
    @PutMapping("/clientes/{id}")
    public ResponseEntity<Clientes> actualizarClientePorId(@PathVariable Long id_cli, @RequestBody Clientes detallesClientes){
    	Clientes Cliente= repositorio.findById(id_cli)
    			.orElseThrow(() -> new ResourceNotFoundException("No exite el Cliente con el ID:" + id_cli));
    	Cliente.setNombre_cli(detallesClientes.getNombre_cli());    	
    	Cliente.setApellido_cli(detallesClientes.getApellido_cli());
    	Cliente.setTelefono_cli(detallesClientes.getTelefono_cli());
    	Cliente.setCorreo(detallesClientes.getCorreo());    	
    	
    	Clientes Clienteactualizado= repositorio.save(Cliente);
    	return ResponseEntity.ok(Clienteactualizado);	
    }
    
    //Delete Cliente
    @DeleteMapping("/medicamentos/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarCliente(@PathVariable Long id_cli){
		Clientes Cliente = repositorio.findById(id_cli)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el Cliente con el ID : " + id_cli));
		repositorio.delete(Cliente);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }

}
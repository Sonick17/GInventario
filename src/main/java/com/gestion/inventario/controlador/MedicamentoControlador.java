
package com.gestion.inventario.controlador;

import com.gestion.inventario.excepciones.ResourceNotFoundException;
import com.gestion.inventario.modelo.Medicamentos;
import com.gestion.inventario.repositorio.MedicamentoRepositorio;

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
@RequestMapping("/api/v1/")
public class MedicamentoControlador {
   
    @Autowired
    private MedicamentoRepositorio repositorio;
    
    //Listar todos los medicamentos
    @GetMapping("/medicamentos")
    public List<Medicamentos> listarTodosLosMedicamentos(){
        return repositorio.findAll();
    }
    
    // Agregar Medicamento
    @PostMapping("/medicamentos")
    public Medicamentos guardarMedicamento(@RequestBody Medicamentos medicamentos) {
    	return repositorio.save(medicamentos);
    }
    
    //Buscar el Medicamento
    @GetMapping("/medicamentos/{id}")
    public ResponseEntity<Medicamentos> obtenerMedicamentoPorId(@PathVariable Long id){
    	Medicamentos medicamento= repositorio.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("No exite el medicamento con el ID:" + id));
    	return ResponseEntity.ok(medicamento);	
    }
    
    //Actualizar Medicamento
    @PutMapping("/medicamentos/{id}")
    public ResponseEntity<Medicamentos> actualizarMedicamentoPorId(@PathVariable Long id, @RequestBody Medicamentos detallesMedicamentos){
    	Medicamentos medicamento= repositorio.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("No exite el medicamento con el ID:" + id));
    	medicamento.setNombre(detallesMedicamentos.getNombre());
    	medicamento.setCantidad(detallesMedicamentos.getCantidad());
    	medicamento.setStock(detallesMedicamentos.getStock());
    	medicamento.setPrecio(detallesMedicamentos.getPrecio());
    	medicamento.setFechaV(detallesMedicamentos.getFechaV());
    	
    	Medicamentos medicamentoactualizado= repositorio.save(medicamento);
    	return ResponseEntity.ok(medicamentoactualizado);	
}
    // Eliminar Medicamento
    @DeleteMapping("/medicamentos/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarEmpleado(@PathVariable Long id){
		Medicamentos medicamento = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el medicamento con el ID : " + id));
		repositorio.delete(medicamento);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
}
}
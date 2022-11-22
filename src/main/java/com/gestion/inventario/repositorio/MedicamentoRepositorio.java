
package com.gestion.inventario.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.inventario.modelo.Medicamentos;

@Repository
public interface MedicamentoRepositorio extends JpaRepository<Medicamentos,Object>{
    
}

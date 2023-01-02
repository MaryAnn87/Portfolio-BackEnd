package com.portfolio.web.Repository;

import com.portfolio.web.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepEducacion extends JpaRepository<Educacion, Integer>{
    public Optional<Educacion> findByNombreInstitucion(String nombreInstitucion);
     public boolean existsByNombreInstitucion(String nombreInstitucion);
     
     public Optional<Educacion> findByTituloEd(String tituloEd);
     public boolean existsByTituloEd(String tituloEd);
     
     public Optional<Educacion> findByPeriodo(String periodo);
     public boolean existsByPeriodo(String periodo);
     
     public Optional<Educacion> findByDescripcionEd(String descripcionEd);
     public boolean existsByDescripcionEd(String descripcionEd);
     
}

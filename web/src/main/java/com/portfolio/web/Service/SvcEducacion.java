package com.portfolio.web.Service;

import com.portfolio.web.Entity.Educacion;
import com.portfolio.web.Repository.RepEducacion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SvcEducacion {

    @Autowired
    RepEducacion repEducacion;

    public List<Educacion> list() {
        return repEducacion.findAll();

    }

    public Optional<Educacion> getOne(int id) {
        return repEducacion.findById(id);
    }

    public Optional<Educacion> getByNombreInstitucion(String nombreInstitucion) {
        return repEducacion.findByNombreInstitucion(nombreInstitucion);
    }

     public void save(Educacion educacion) {
        repEducacion.save(educacion);
    }

    public void delete(int id) {
        repEducacion.deleteById(id);
    }

    //metodo que busca si existe la educacion por id, nombre de institucion o titulo adquirido
    public boolean existsById(int id) {
        return repEducacion.existsById(id);
    }
    
    public boolean existsByNombreInstitucion(String nombreInstitucion) {
        return repEducacion.existsByNombreInstitucion(nombreInstitucion);
    }
    
    
}

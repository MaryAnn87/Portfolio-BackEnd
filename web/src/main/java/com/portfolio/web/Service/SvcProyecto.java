package com.portfolio.web.Service;

import com.portfolio.web.Entity.Proyecto;
import com.portfolio.web.Repository.RepProyecto;
import java.util.List;
import java.util.Optional;

public class SvcProyecto {

    RepProyecto repProyecto;

    public List<Proyecto> list() {
        return repProyecto.findAll();

    }

    public Optional<Proyecto> getOne(int id) {
        return repProyecto.findById(id);
    }

    public Optional<Proyecto> getByNombrePr(String nombrePr) {
        return repProyecto.findByNombrePr(nombrePr);
    }

    public void save(Proyecto exp) {
        repProyecto.save(exp);
    }

    public void delete(int id) {
        repProyecto.deleteById(id);
    }

    //metodo que busca si existe la experiencia por id o nombre
    public boolean existsById(int id) {
        return repProyecto.existsById(id);
    }

    public boolean existsByNombrePr(String nombrePr) {
        return repProyecto.existsByNombrePr(nombrePr);
    }
}

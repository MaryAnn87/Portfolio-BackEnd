package com.portfolio.web.Controller;

import com.portfolio.web.Dto.DtoEducacion;
import com.portfolio.web.Entity.Educacion;
import com.portfolio.web.Security.Controller.Mensaje;
import com.portfolio.web.Service.SvcEducacion;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")

public class CtrEducacion {

    @Autowired
    SvcEducacion svcEducacion;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = svcEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id) {
        //validacion si no existe ese id
        if (!svcEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = svcEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!svcEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        svcEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoEducacion) {
        if (StringUtils.isBlank(dtoEducacion.getTituloEd())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = new Educacion(dtoEducacion.getNombreInstitucion(), dtoEducacion.getTituloEd(), dtoEducacion.getPeriodo(), dtoEducacion.getDescripcionEd());
        svcEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoEducacion) {
        if (!svcEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        //validacion de nombre de institucion
        if (svcEducacion.existsByNombreInstitucion(dtoEducacion.getNombreInstitucion()) && svcEducacion.getByNombreInstitucion(dtoEducacion.getNombreInstitucion()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa institucion ya existe"), HttpStatus.BAD_REQUEST);
        }

        //validacion de titulo 
        if (svcEducacion.existsByTituloEd(dtoEducacion.getTituloEd()) && svcEducacion.getByTituloEd(dtoEducacion.getTituloEd()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese titulo ya existe"), HttpStatus.BAD_REQUEST);
        }

        //validacion de campo vacio
        if (StringUtils.isBlank(dtoEducacion.getNombreInstitucion())) {
            return new ResponseEntity(new Mensaje("El campo no debe estar vacio!"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoEducacion.getTituloEd())) {
            return new ResponseEntity(new Mensaje("El campo no debe estar vacio!"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoEducacion.getPeriodo())) {
            return new ResponseEntity(new Mensaje("El campo no debe estar vacio!"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoEducacion.getDescripcionEd())) {
            return new ResponseEntity(new Mensaje("El campo no debe estar vacio!"), HttpStatus.BAD_REQUEST);
        }

        //actualizacion del objecto
        Educacion educacion = svcEducacion.getOne(id).get();

        educacion.setNombreInstitucion(dtoEducacion.getNombreInstitucion());
        educacion.setTituloEd(dtoEducacion.getTituloEd());
        educacion.setPeriodo(dtoEducacion.getPeriodo());
        educacion.setDescripcionEd(dtoEducacion.getDescripcionEd());

        svcEducacion.save(educacion);

        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }
}

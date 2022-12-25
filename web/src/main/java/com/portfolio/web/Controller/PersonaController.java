package com.portfolio.web.Controller;

import com.portfolio.web.Entity.Persona;
import com.portfolio.web.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    

    @GetMapping ("personas/traer")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "La persona ha sido creada correctamente";
    }
    
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
       ipersonaService.deletePersona(id);
       return "La persona ha sido eliminada correctamente";
    }
    
    // url: port/personas/editar/567/nombre&apellido&img
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam ("nombre") String newNombre,
                               @RequestParam ("apellido") String newApellido,
                               @RequestParam ("img") String newImg){
        Persona persona = ipersonaService.findPersona(id);
        persona.setNombre(newNombre);
        persona.setApellido(newApellido);
        persona.setImg(newImg);
        
        ipersonaService.savePersona(persona);
        return persona;
        
    }
}



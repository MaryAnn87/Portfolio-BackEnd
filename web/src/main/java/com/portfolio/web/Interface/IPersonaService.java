package com.portfolio.web.Interface;

import com.portfolio.web.Entity.Persona;
import java.util.List;



public interface IPersonaService {
    //traer una lista de persona
    public List<Persona> getPersona();
    
    //guardar objeto de tipo persona
    public void savePersona(Persona persona);
    
    //eliminar usuario pero buscandolo por ID
    public void deletePersona (Long id);
    
    //buscar persona por id
    public Persona findPersona(Long id);
}
    

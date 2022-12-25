package com.portfolio.web.Interface;

import com.portfolio.web.Entity.Persona;
import java.util.List;

public interface IPersonaService {
   
    //traer una lista de personas
    public List<Persona> getPersona();
    
    //Guardar objeto de tipo persona
    public void savePersona(Persona persona);
    
    //eliminar objeto de tipo persona pero buscandolo por id
    public void deletePersona (Long id);
    
    //Buscar persna por id
    public Persona findPersona (Long id);
    
}

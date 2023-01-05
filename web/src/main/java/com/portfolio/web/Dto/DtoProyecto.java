package com.portfolio.web.Dto;

import javax.validation.constraints.NotBlank;

public class DtoProyecto {
    @NotBlank
    private String nombrePr;
    @NotBlank
    private String descripcionPr;
    
    //constructores
     public DtoProyecto() {
    }

    public DtoProyecto(String nombrePr, String descripcionPr) {
        this.nombrePr = nombrePr;
        this.descripcionPr = descripcionPr;
    }
     
    //getters & setters

    public String getNombrePr() {
        return nombrePr;
    }

    public void setNombrePr(String nombrePr) {
        this.nombrePr = nombrePr;
    }

    public String getDescripcionPr() {
        return descripcionPr;
    }

    public void setDescripcionPr(String descripcionPr) {
        this.descripcionPr = descripcionPr;
    }
    
}

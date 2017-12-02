/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dato;

/**
 *
 * @author camilo
 */
public class GaleriaJc {

    private int ID_Galeria;
    private int ID_ArtistaFK;
    private String nombre;
    private String estilo;
    private String tecnica;
    private int Valor;

    public GaleriaJc() {
    }

    public int getID_Galeria() {
        return ID_Galeria;
    }

    public void setID_Galeria(int ID_Galeria) {
        this.ID_Galeria = ID_Galeria;
    }

    public int getID_ArtistaFK() {
        return ID_ArtistaFK;
    }

    public void setID_ArtistaFK(int ID_ArtistaFK) {
        this.ID_ArtistaFK = ID_ArtistaFK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    public int getValor() {
        return Valor;
    }

    public void setValor(int Valor) {
        this.Valor = Valor;
    }

}

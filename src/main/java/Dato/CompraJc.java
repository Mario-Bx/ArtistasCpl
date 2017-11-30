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
public class CompraJc {
    private int ID_Compra ;
private int ID_CompradorFK ;
private int ID_GaleriaFK;
private int ID_MedioPagoFK ;

    public CompraJc() {
    }

    public int getID_Compra() {
        return ID_Compra;
    }

    public void setID_Compra(int ID_Compra) {
        this.ID_Compra = ID_Compra;
    }

    public int getID_CompradorFK() {
        return ID_CompradorFK;
    }

    public void setID_CompradorFK(int ID_CompradorFK) {
        this.ID_CompradorFK = ID_CompradorFK;
    }

    public int getID_GaleriaFK() {
        return ID_GaleriaFK;
    }

    public void setID_GaleriaFK(int ID_GaleriaFK) {
        this.ID_GaleriaFK = ID_GaleriaFK;
    }

    public int getID_MedioPagoFK() {
        return ID_MedioPagoFK;
    }

    public void setID_MedioPagoFK(int ID_MedioPagoFK) {
        this.ID_MedioPagoFK = ID_MedioPagoFK;
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocrproject;

/**
 *
 * @author Alan
 */
public class Buscador{
    
    private String cad = "";
    private String termino;
    private String[] palabras;
    
    public Buscador(){
 
    }
    public void Encontrar(String cadena){
        this.cad = cadena;
        Directorio dir = new Directorio();
        this.termino = dir.getTermino();
        System.out.println("PALABRA A BUSCAR "+this.termino );
        System.out.println("TEXTO DE ARCHIVO "+this.cad);
        
//        boolean res = l.getTexto().contains(cad);
//        System.out.println("TXTO OBTENIDO "+l.getTexto());
//        System.out.println("FICHERO EN CLASE BUSCADOR "+ l.getFichero());
////        this.palabras = this.cad.split("//s+");
//        if(res){
//            System.out.println("PALABRA ENCONTRADA EN "+ l.getFichero());
//        }
//        else{
//            System.out.println("TEXTO NO ENCONTRADO en "+ l.getFichero() );
//        }
    
    }

    public String getTermino() {
        return termino;
    }

    public void setTermino(String termino) {
        this.termino = termino;
    }

    public String getCad() {
        return cad;
    }

    public void setCad(String cad) {
        this.cad = cad;
    }
    public String toString(){
        String s= "";
        return s;
    }
    
}

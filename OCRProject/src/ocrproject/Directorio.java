/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocrproject;

import java.io.File;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Alan
 */
public class Directorio {

    private String ruta = "";
    private String busqueda ="";
    private File[] archivos;
    private File fichero;
    private Lector l = new Lector();
    

    public Directorio() {

    }

    public Directorio(String s,String b) {
        this.busqueda = b;
         
        this.ruta = s;
        this.fichero = new File(ruta);
        this.archivos = this.fichero.listFiles();
        Clasificacion(this.archivos);
    }

    public void Clasificacion(File[] archivos) {
        this.archivos = archivos;
        for (int x = 0; x < this.archivos.length; x++) {
            File fichero = this.fichero;
            fichero = this.archivos[x];
            String ext = FilenameUtils.getExtension(fichero.toString());//obtener extención
            ext = ext.toLowerCase();
            //System.out.println("LA EXTENSION ES " +ext);
            if (ext.equals("png") || ext.equals("jpg") || ext.equals("jpeg")) {
                
                l.analisisOCR(fichero);
                
                
                
            } else if (ext.equals("pdf")) {
                
                l.analisisPDF(fichero);
                

//                analisisPDF a = new analisisPDF ();
            }
//            else if (ext.equals("txt")|| ext.equals("docx")){
//            
//            
//            }
//            else{
//                System.out.println("Texto no reconocido");
//            }

        }
        
        l.close();
    }

    public String getRuta() {
        return ruta;
    }

    public File[] getArchivos() {
        return archivos;
    }

    public File getFichero() {
        return fichero;
    }

    public String toString() {
        String s = "";
        return s;
    }

    public String getBusqueda() {
        return this.busqueda;
    }

    public void c(String busqueda) {
        this.busqueda = busqueda;
    }

}

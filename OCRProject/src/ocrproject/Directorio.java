/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocrproject;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Alan
 */
public class Directorio {

    private String ruta = "";
    private String termino = "";
    private File[] archivos;
    private File fichero;
    private String texto;
    private Lector l = new Lector();

    public Directorio() {

    }

    public Directorio(String ruta, String termino) {
        this.termino = termino;
        this.ruta = ruta;
        this.fichero = new File(this.ruta);
        this.archivos = this.fichero.listFiles();
        Clasificacion(this.archivos);
    }

    public void Clasificacion(File[] archivos) {
        this.archivos = archivos;
        for (int x = 0; x < this.archivos.length; x++) {
            
            this.fichero = this.archivos[x];
            String ext = FilenameUtils.getExtension(this.fichero.toString());//obtener extención
            ext = ext.toLowerCase();
            //System.out.println("LA EXTENSION ES " +ext);
            if (ext.equals("png") || ext.equals("jpg") || ext.equals("jpeg")) {

                l.analisisOCR(fichero);
                this.texto = l.getTexto();
//                System.out.println("ESTE ES EL TEXTO DE JPEG " + texto);
                Buscador(texto,termino);

            } else if (ext.equals("pdf")) {

                l.analisisPDF(fichero);
                this.texto = l.getTexto();
                Buscador(texto,termino);
//                System.out.println("ESTE ES EL TEXTO DE PDF " + texto);

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

    public void Buscador(String texto, String termino) {
        this.texto = texto;
        this.termino = termino;
        boolean res = l.getTexto().contains(termino);
        if (res) {
            try {
                Desktop.getDesktop().open(fichero);
            } catch (IOException ex) {
                Logger.getLogger(Directorio.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("TEXTO NO ENCONTRADO en " + fichero);
        }

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

    public String getTermino() {
        return termino;
    }

    public void setTermino(String termino) {
        this.termino = termino;
    }

}

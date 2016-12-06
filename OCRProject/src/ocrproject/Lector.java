/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocrproject;

import com.asprise.ocr.Ocr;
import com.asprise.util.pdf.PDFReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alan
 */
public class Lector {

    private Ocr ocr = new Ocr();
    private String texto = "";
    private File fichero;
    private PDFReader lector;

    public Lector() {

    }

    public void analisisOCR(File fichero) {
        this.fichero = fichero;
        Ocr.setUp();
        ocr.startEngine("spa", Ocr.SPEED_FASTEST);
        this.texto = ocr.recognize(new File[]{fichero}, Ocr.RECOGNIZE_TYPE_ALL, Ocr.OUTPUT_FORMAT_PLAINTEXT, 0, null);
//        System.out.println("LECTOR ANALISIS OCR :"+cadena);
//        Buscador b = new Buscador();
//        b.Encontrar(cadena);
       
//        System.out.println(fichero);

//        s = ocr.recognize(f.toString(), -1, 100, 100, 400, 200, Ocr.RECOGNIZE_TYPE_TEXT, Ocr.OUTPUT_FORMAT_PLAINTEXT);
//        System.out.println("El resultado es " + this.texto);
    }

    public void analisisPDF(File fichero) {
        this.fichero = fichero;
        try {
            lector = new PDFReader(fichero);
            lector.open();
            int paginas = lector.getNumberOfPages();
            for (int i = 0; i < paginas; i++) {
                this.texto = lector.extractTextFromPage(i);
//                System.out.println("LECTOR ANALISIS PDF :" + cadena);
//                Buscador b = new Buscador();
//                b.Encontrar(cadena);
                
//                System.out.println(fichero);
//                 
//                System.out.println("EL PDF QUE SE LEYO " + texto);
            }

            lector.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close() {
        ocr.stopEngine();
    }

    public String getTexto() {
        return this.texto;
    }

    public File getFichero() {
        return fichero;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}

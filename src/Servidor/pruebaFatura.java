/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servidor;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import java.text.SimpleDateFormat;
/**
 *
 * @author angel
 */
public class pruebaFatura {
    public static void main(String[] args) {
        new pruebaFatura();
    }
    
    public pruebaFatura(){
        pdf();
    }
    
    private void pdf() {
        try {
            FileOutputStream archivo;
            File file = new File("src/pdf/venta.pdf");
            archivo = new FileOutputStream(file);
            Document doc = new Document();
            PdfWriter.getInstance (doc, archivo);
            doc.open();
            Image img = Image.getInstance("src/imagenes/inventarioIMG.jpg");

            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD);
            fecha.add(Chunk.NEWLINE);
            Date date = new Date();
            fecha.add("Factura: 1" + " Fecha: " + new SimpleDateFormat("dd-MM-yyyy").format(date) + "\n\n");

            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);
            float[] ColumnsEncabezado = new float[]{20f, 30f, 70f, 40f};
            Encabezado.setWidths(ColumnsEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);

            Encabezado.addCell(img);

            String ruc = "212454545";
            String nom = "Vida informatico";
            String tel = "45454545";
            String dir = "Lima";
            String ra = "Vida informatico";

            Encabezado.addCell("");
            Encabezado.addCell("Ruc: " + ruc + "\nNombre: " + nom + "\nTelefono: " + tel + "\nDireccion: " + dir + "\nRazon: " + ra);
            Encabezado.addCell(fecha);
            doc.add(Encabezado);
            
            //Datos del cliente
            Paragraph cli = new Paragraph();
            cli.add(Chunk.NEWLINE);
            cli.add("Datos del cliente" + "\n\n");
            doc.add(cli);

            PdfPTable tablacli = new PdfPTable(4);
            tablacli.setWidthPercentage(100);
            tablacli.getDefaultCell().setBorder(0);
            float[] ColumnasCli = new float[]{20f, 50f, 30f, 40f};
            tablacli.setWidths(ColumnasCli);
            tablacli.setHorizontalAlignment(Element.ALIGN_LEFT);

            PdfPCell celda1 = new PdfPCell(new Phrase("Cédula/RIF", negrita));
            PdfPCell celda2 = new PdfPCell(new Phrase("Nombre", negrita));
            PdfPCell celda3 = new PdfPCell(new Phrase("Telefono", negrita));
            PdfPCell celda4 = new PdfPCell(new Phrase("Direccion", negrita));

            celda1.setBorder(0);
            celda2.setBorder(0);
            celda3.setBorder(0);
            celda4.setBorder(0);

            tablacli.addCell(celda1);
            tablacli.addCell(celda2);
            tablacli.addCell(celda3);
            tablacli.addCell(celda4);
            tablacli.addCell("30827205");
            tablacli.addCell("Angelo Vásquez");
            tablacli.addCell("0424-4040241");
            tablacli.addCell("mi casa");
            doc.add(tablacli);
            
             //productos
            PdfPTable tablapro = new PdfPTable(4);
            tablapro.setWidthPercentage(100);
            tablapro.getDefaultCell().setBorder(0);
            float[] ColumnaPro = new float[]{20f, 50f, 30f, 40f};
            tablapro.setWidths(ColumnaPro);
            tablapro.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell pro1 = new PdfPCell(new Phrase("Cant.", negrita));
            PdfPCell pro2 = new PdfPCell(new Phrase("Descripción", negrita));
            PdfPCell pro3 = new PdfPCell(new Phrase("Precio U.", negrita));
            PdfPCell pro4 = new PdfPCell(new Phrase("Precio T.", negrita));

            // Quitar bordes a las celdas
            pro1.setBorder(0);
            pro2.setBorder(0);
            pro3.setBorder(0);
            pro4.setBorder(0);

            // Establecer color de fondo para las celdas (corregido)
            pro1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            pro2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            pro3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            pro4.setBackgroundColor(BaseColor.LIGHT_GRAY);

            // Añadir celdas a la tabla
            tablapro.addCell(pro1);
            tablapro.addCell(pro2);
            tablapro.addCell(pro3);
            tablapro.addCell(pro4);

            // Llenar la tabla con datos de TableVenta
//            for (int i = 0; i < TableVenta.getRowCount(); i++) {
//                String producto = TableVenta.getValueAt(i, 1).toString();
//                String cantidad = TableVenta.getValueAt(i, 2).toString();
//                String precio = TableVenta.getValueAt(i, 3).toString();
//                String total = TableVenta.getValueAt(i, 4).toString();
//
//                tablapro.addCell(cantidad);
//                tablapro.addCell(producto);
//                tablapro.addCell(precio);
//                tablapro.addCell(total);
//            }

            // Añadir la tabla al documento (esto debería estar después del bucle)
            doc.add(tablapro);
            
            Paragraph total = new Paragraph();
            total.add(Chunk.NEWLINE);
            total.setAlignment(Element.ALIGN_RIGHT);
            total.add("Total a pagar: " + "100"+"                                   ");
            doc.add(total);
            
            doc.close();
            archivo.close();
               
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


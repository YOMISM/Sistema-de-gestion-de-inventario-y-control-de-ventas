/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ventanas;

import static VentanasEmergentes.BuscadorProductos.abrirBuscador;
import inventario.DetallesVenta;
import inventario.ObtenerParametros;
import inventario.Productos;
import inventario.ProductosBD;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class ajustesInventarioPanel extends javax.swing.JPanel {

    /**
     * Creates new form productosPanel
     */
    public ajustesInventarioPanel() {
        initComponents();
    }
    double precio = 0;
    Connection conexion;
    DefaultTableModel modeloProductos;
    ObtenerParametros parametros;
    ProductosBD productoBD;
    Productos productoSeleccionado = null;
    boolean agregar = true;
    TreeMap<String,DetallesVenta> productos;
    
     public ajustesInventarioPanel(Connection con, ObtenerParametros parametros) {
        conexion = con;
        this.parametros = parametros;
        productoBD = new ProductosBD(con);
        initComponents();
        productos = new TreeMap<>();
        modeloProductos = (DefaultTableModel) tablaVentas.getModel();
        cantidadSpinner.setValue(0);
    }
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        codigoTexto = new javax.swing.JTextField();
        BuscarBoton = new javax.swing.JButton();
        eliminarBoton = new javax.swing.JButton();
        terminarBoton = new javax.swing.JButton();
        cancelarBoton = new javax.swing.JButton();
        cantidadSpinner = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        seleccionarBoton = new javax.swing.JButton();
        productoLabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        accionCombo = new javax.swing.JComboBox<>();

        setName("ajustesInventarioPanel"); // NOI18N
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanel7.setFocusable(false);
        jPanel7.setName(""); // NOI18N

        scrollPane.setViewportBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        scrollPane.setFocusCycleRoot(true);
        scrollPane.setFont(new java.awt.Font("Yu Gothic UI", 0, 48)); // NOI18N

        tablaVentas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Cantidad", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaVentas.setRowHeight(40);
        tablaVentas.setShowHorizontalLines(true);
        tablaVentas.setShowVerticalLines(true);
        tablaVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaVentasMouseClicked(evt);
            }
        });
        tablaVentas.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                tablaVentasCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        scrollPane.setViewportView(tablaVentas);
        if (tablaVentas.getColumnModel().getColumnCount() > 0) {
            tablaVentas.getColumnModel().getColumn(1).setResizable(false);
            tablaVentas.getColumnModel().getColumn(2).setResizable(false);
            tablaVentas.getColumnModel().getColumn(3).setResizable(false);
        }

        codigoTexto.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        codigoTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoTextoActionPerformed(evt);
            }
        });
        codigoTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoTextoKeyPressed(evt);
            }
        });

        BuscarBoton.setText("Buscar");
        BuscarBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BuscarBotonMouseClicked(evt);
            }
        });
        BuscarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarBotonActionPerformed(evt);
            }
        });

        eliminarBoton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        eliminarBoton.setText("Eliminar");
        eliminarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarBotonActionPerformed(evt);
            }
        });

        terminarBoton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        terminarBoton.setText("Terminar");
        terminarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terminarBotonActionPerformed(evt);
            }
        });

        cancelarBoton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cancelarBoton.setText("Cancelar");
        cancelarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBotonActionPerformed(evt);
            }
        });

        cantidadSpinner.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cantidadSpinner.setEnabled(false);
        cantidadSpinner.setName(""); // NOI18N
        cantidadSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cantidadSpinnerStateChanged(evt);
            }
        });
        cantidadSpinner.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                cantidadSpinnerInputMethodTextChanged(evt);
            }
        });
        cantidadSpinner.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidadSpinnerKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Cantidad:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Código:");

        seleccionarBoton.setText("Seleccionar");
        seleccionarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarBotonActionPerformed(evt);
            }
        });

        productoLabel.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        productoLabel.setForeground(new java.awt.Color(102, 102, 102));
        productoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        productoLabel.setText("Nombre del producto");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText(":");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Acción:");

        accionCombo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        accionCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Agregar", "Retirar" }));
        accionCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollPane)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(eliminarBoton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(terminarBoton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelarBoton)))
                        .addContainerGap())
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(productoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(codigoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BuscarBoton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(seleccionarBoton))
                            .addComponent(jLabel7))
                        .addGap(6, 6, 6)
                        .addComponent(jLabel11)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(accionCombo, 0, 300, Short.MAX_VALUE)
                            .addComponent(cantidadSpinner))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel11))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(codigoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BuscarBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(seleccionarBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15)
                        .addComponent(productoLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(accionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidadSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminarBoton)
                    .addComponent(terminarBoton)
                    .addComponent(cancelarBoton))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        add(jPanel7);
    }// </editor-fold>//GEN-END:initComponents

    private void tablaVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaVentasMouseClicked
        JTable tabla = (JTable)evt.getComponent();
        String codigo = String.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 0));
        try{
            productoSeleccionado = productoBD.getProducto(codigo);
            cantidadSpinner.setEnabled(true);
            cantidadSpinner.setValue(tabla.getValueAt(tabla.getSelectedRow(), 2));
            productoLabel.setText(productoSeleccionado.getNombre());
        }
        catch(SQLException e){
            System.err.println("Error en ventasPanel tablaVentasMouseClicked "+ e.getMessage());
        }
    }//GEN-LAST:event_tablaVentasMouseClicked

    private void cantidadSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cantidadSpinnerStateChanged
        int valor = (int)cantidadSpinner.getValue();
        DetallesVenta detalles;
            try{
                if(productoSeleccionado != null && valor > productoSeleccionado.getCantidad() && !agregar){
                    JOptionPane.showMessageDialog(null, "Solo hay "+ productoSeleccionado.getCantidad()+ " unidades de " + productoSeleccionado.getNombre());
                    valor = productoSeleccionado.getCantidad();
                    cantidadSpinner.setValue(valor);
                }
                else{
                    if(tablaVentas != null){
                        tablaVentas.setValueAt(valor, tablaVentas.getSelectedRow(), 2);
                    }

                    if(valor < 0){
                        valor = 0;

                    }
                    cantidadSpinner.setValue(valor);
                    tablaVentas.setValueAt(valor, tablaVentas.getSelectedRow(), 2);
                    detalles = productos.get(productoSeleccionado.getCodigo());
                    detalles.setCantidad(valor);
                    productos.put(productoSeleccionado.getCodigo(),detalles);
                    System.out.println(detalles.getCantidad());
                }    
            }
            catch(Exception e){
                System.err.println("error en ventasPanel cantidadSpinnerStateChanged en tabla: " + e.getMessage());
            }
 
    }//GEN-LAST:event_cantidadSpinnerStateChanged

    private void cantidadSpinnerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadSpinnerKeyTyped

    }//GEN-LAST:event_cantidadSpinnerKeyTyped

    private void cantidadSpinnerInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_cantidadSpinnerInputMethodTextChanged
        System.out.println("cambio texto");
    }//GEN-LAST:event_cantidadSpinnerInputMethodTextChanged

    private void tablaVentasCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tablaVentasCaretPositionChanged
        System.out.println("cambio");
    }//GEN-LAST:event_tablaVentasCaretPositionChanged

    private void eliminarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBotonActionPerformed
        try {
            eliminarProducto();
        } catch (SQLException ex) {
            Logger.getLogger(ajustesInventarioPanel.class.getName()).log(Level.SEVERE, "Error en ventasPanel", ex);
        }
    }//GEN-LAST:event_eliminarBotonActionPerformed

    private void terminarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminarBotonActionPerformed
        ajustarProductos();
        reiniciarValores();
        limpiarTablas();
    }//GEN-LAST:event_terminarBotonActionPerformed

    private void seleccionarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarBotonActionPerformed
        abrirBuscador(conexion, parametros, this);
    }//GEN-LAST:event_seleccionarBotonActionPerformed

    private void cancelarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBotonActionPerformed
        reiniciarValores();
        limpiarTablas();
    }//GEN-LAST:event_cancelarBotonActionPerformed

    private void BuscarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarBotonActionPerformed

    }//GEN-LAST:event_BuscarBotonActionPerformed

    private void BuscarBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarBotonMouseClicked
        cargarProducto(codigoTexto.getText());
        codigoTexto.setText("");
    }//GEN-LAST:event_BuscarBotonMouseClicked

    private void codigoTextoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoTextoKeyPressed
        int key = evt.getKeyCode();
        boolean enter = key == 10;

        if ((enter)){
            cargarProducto(codigoTexto.getText());
            codigoTexto.setText("");
        }
    }//GEN-LAST:event_codigoTextoKeyPressed

    private void codigoTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoTextoActionPerformed

    private void accionComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionComboActionPerformed
        String accion = (String)accionCombo.getSelectedItem();
        if(accion.equals("Agregar")){
            agregar = true;
        }
        else{
            agregar = false;
        }       
    }//GEN-LAST:event_accionComboActionPerformed
    public boolean ajustarProductos(){
        boolean ok = false;
        try{
            ProductosBD productoBD = new ProductosBD(conexion);
            Productos producto = new Productos();
            for (DetallesVenta detalles : productos.values()) {
                producto = productoBD.getProducto(detalles.getIdProducto());
                if (agregar){
                    producto.setCantidad(producto.getCantidad()+detalles.getCantidad());
                }
                else{
                    producto.setCantidad(producto.getCantidad()-detalles.getCantidad());
                }
                productoBD.actualizarCantidad(producto);
            }
                JOptionPane.showMessageDialog(null, "Ajuste realizado con exito");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al realizar el ajuste");
            System.err.println("Error en ajusteInventarioPanel ajustarProductos " + e.getMessage());
        }
        return ok;
    }
    
    //Reinicia los valores despues de una venta 
    private void reiniciarValores(){
        codigoTexto.setText("");
        precio = 0;
        productoSeleccionado = null;
        agregar = false;
        productos = new TreeMap<>();
        cantidadSpinner.setValue(1);
        long tiempoActual = System.currentTimeMillis();
        Date date = new Date(tiempoActual);
    }
    

    public void cargarProducto(String codigoProducto){
        try{
            Productos producto = productoBD.getProducto(codigoProducto);
            DetallesVenta detalles = new DetallesVenta();
            if(producto.getNombre() != null){
                precio = producto.getPrecioCosto()+producto.getPrecioCosto()*producto.getGanancia()/100+(producto.getPrecioCosto()+producto.getPrecioCosto()*producto.getGanancia()/100)*producto.getIva()/100;                
                productoLabel.setText(producto.getNombre());
                modeloProductos.addRow(new Object[]{producto.getCodigo(), producto.getNombre(),0, redondear(precio)});
                
                detalles.setIdProducto(codigoProducto);
                detalles.setCantidad(0);
                detalles.setPrecioUnidad(Double.parseDouble(redondear(precio)));
                detalles.setIdVenta(parametros.getFactura());
                productos.put(detalles.getIdProducto(),detalles);
            }
            else{
                JOptionPane.showMessageDialog(null, "No se ha encontrado ese producto");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error en ajustesInventarioPanel cargarProducto " + e.getMessage());
        }
    }
    
    private void eliminarProducto() throws SQLException{
        int columna = tablaVentas.getSelectedRow();
        DetallesVenta detalles;
        String codigo = (String) tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 0);
        detalles = productos.get(productoSeleccionado.getCodigo());
        productos.remove(productoSeleccionado.getCodigo(),detalles);
        modeloProductos.removeRow(columna);
        cantidadSpinner.setEnabled(false);
        cantidadSpinner.setValue(1);  
    }
    

     
    private void limpiarTablas(){
        int cantidad =modeloProductos.getRowCount()-1;  
        for(int i=cantidad;i>=0;i--){ 
            modeloProductos.removeRow(i);
        }
    }
    
    public static boolean contiene(String[] array, int size, String objeto) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(objeto)) {
                return true; // El objeto ya existe
            }
        }
        return false; // El objeto no existe
    }

    private String redondear(double numero){
        int decimales = 2;
        String resultado;
        BigDecimal bd = new BigDecimal(numero);
        bd = bd.setScale(decimales, RoundingMode.HALF_UP);
        resultado = bd.toString();
        return resultado;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuscarBoton;
    private javax.swing.JComboBox<String> accionCombo;
    private javax.swing.JButton cancelarBoton;
    private javax.swing.JSpinner cantidadSpinner;
    private javax.swing.JTextField codigoTexto;
    private javax.swing.JButton eliminarBoton;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel productoLabel;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JButton seleccionarBoton;
    private javax.swing.JTable tablaVentas;
    private javax.swing.JButton terminarBoton;
    // End of variables declaration//GEN-END:variables
}

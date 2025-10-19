/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ventanas;

import static Reportes.Ticket.imprimir;
import static VentanasEmergentes.BuscadorProductos.abrirBuscador;
import static VentanasEmergentes.agregarCliente.crearVentanaCliente;
import inventario.Clientes;
import inventario.ClientesBD;
import inventario.DepartamentoBD;
import inventario.DetallesVenta;
import inventario.DetallesVentaBD;
import inventario.ObtenerParametros;
import inventario.Productos;
import inventario.ProductosBD;
import inventario.Ventas;
import inventario.VentasBD;
import java.awt.Component;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class ventasPanel extends javax.swing.JPanel {

    /**
     * Creates new form productosPanel
     */
    public ventasPanel() {
        initComponents();
    }
    double total = 0;
    double precio = 0;
    double iva = 0;
    double totalBs = 0;
    Connection conexion;
    DefaultTableModel modeloAgregar;
    DefaultTableModel modeloProductos;
    AgregarDatos agregadorDatos;
    ajustes ajustess;
    ObtenerParametros parametros;
    DepartamentoBD departamentosBD;
    ProductosBD productoBD;
    Productos productoSeleccionado = null;
    Ventas venta = new Ventas();
    boolean verificarCliente = false;
    TreeMap<String,DetallesVenta> detallesVenta;
    
     public ventasPanel(Connection con, ObtenerParametros parametros) {
        conexion = con;
        this.parametros = parametros;
        departamentosBD = new DepartamentoBD(con);
        productoBD = new ProductosBD(con);
        initComponents();
        detallesVenta = new TreeMap<>();
        cedulaTexto.requestFocus();
        modeloProductos = (DefaultTableModel) tablaVentas.getModel();
        agregadorDatos= new AgregarDatos();
        cantidadSpinner.setValue(1);
        long tiempoActual = System.currentTimeMillis();
        Date date = new Date(tiempoActual);
        venta.setFecha(date);
        venta.setIdVenta(parametros.getFactura());
    }

  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        codigoTexto = new javax.swing.JTextField();
        BuscarBoton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        cantidadSpinner = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nombreTexto = new javax.swing.JTextField();
        cedulaTexto = new javax.swing.JTextField();
        direccionTexto = new javax.swing.JTextField();
        BuscarBoton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        precioBolivaresTexto = new javax.swing.JLabel();
        precioEtiqueta = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        BuscarBoton1 = new javax.swing.JButton();

        setName("ventasPanel"); // NOI18N
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
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                tablaVentasCaretPositionChanged(evt);
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

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setText("Terminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton3.setText("Cancelar");

        cantidadSpinner.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cantidadSpinner.setEnabled(false);
        cantidadSpinner.setName(""); // NOI18N
        cantidadSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cantidadSpinnerStateChanged(evt);
            }
        });
        cantidadSpinner.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                cantidadSpinnerInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        cantidadSpinner.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidadSpinnerKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Cantidad:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Nombre:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Dirección:");

        nombreTexto.setEditable(false);
        nombreTexto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nombreTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTextoActionPerformed(evt);
            }
        });

        cedulaTexto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cedulaTexto.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cedulaTextoAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        cedulaTexto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cedulaTextoFocusLost(evt);
            }
        });
        cedulaTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cedulaTextoKeyPressed(evt);
            }
        });

        direccionTexto.setEditable(false);
        direccionTexto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        BuscarBoton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BuscarBoton3.setText("Buscar");
        BuscarBoton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarBoton3ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setMaximumSize(new java.awt.Dimension(108, 132));
        jPanel1.setMinimumSize(new java.awt.Dimension(108, 132));
        jPanel1.setName(""); // NOI18N
        jPanel1.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Precio:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Precio Bs:");

        precioBolivaresTexto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        precioBolivaresTexto.setText("0");

        precioEtiqueta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        precioEtiqueta.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(precioEtiqueta)
                    .addComponent(precioBolivaresTexto))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(precioEtiqueta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(precioBolivaresTexto))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("ID:");

        BuscarBoton1.setText("Seleccionar");
        BuscarBoton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BuscarBoton1MouseClicked(evt);
            }
        });
        BuscarBoton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarBoton1ActionPerformed(evt);
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
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cantidadSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(direccionTexto))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                            .addComponent(cedulaTexto)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(BuscarBoton3))
                                        .addComponent(nombreTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 395, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(codigoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BuscarBoton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BuscarBoton1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cedulaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BuscarBoton3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(direccionTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(codigoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BuscarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BuscarBoton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(cantidadSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton3)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        add(jPanel7);
    }// </editor-fold>//GEN-END:initComponents

    private void nombreTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTextoActionPerformed

    private void BuscarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarBotonActionPerformed
        
    }//GEN-LAST:event_BuscarBotonActionPerformed

    private void codigoTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoTextoActionPerformed

    private void tablaVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaVentasMouseClicked
        JTable tabla = (JTable)evt.getComponent();
        String codigo = String.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 0));
        int valor;
        System.out.println(codigo);
        try{
            productoSeleccionado = productoBD.getProducto(codigo);
            cantidadSpinner.setEnabled(true);
            cantidadSpinner.setValue(tabla.getValueAt(tabla.getSelectedRow(), 2));
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_tablaVentasMouseClicked

    private void BuscarBoton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarBoton3ActionPerformed
        try {
            buscarCliente(cedulaTexto.getText());
        } catch (SQLException ex) {
            Logger.getLogger(ventasPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BuscarBoton3ActionPerformed

    private void BuscarBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarBotonMouseClicked
        try {
            cargarProducto(codigoTexto.getText());
            
            codigoTexto.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(ventasPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BuscarBotonMouseClicked

    private void codigoTextoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoTextoKeyPressed
        int key = evt.getKeyCode();
        boolean enter = key == 10;
        
        if ((enter)){
            try {
                cargarProducto(codigoTexto.getText());
                codigoTexto.setText("");
            } catch (SQLException ex) {
                Logger.getLogger(ventasPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_codigoTextoKeyPressed

    private void cantidadSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cantidadSpinnerStateChanged
        int valor = (int)cantidadSpinner.getValue();
        DetallesVenta detalles;
        try{
            if(productoSeleccionado != null && valor > productoSeleccionado.getCantidad()){
                JOptionPane.showMessageDialog(null, "Solo hay "+ productoSeleccionado.getCantidad()+ " unidades de " + productoSeleccionado.getNombre());
                valor = productoSeleccionado.getCantidad();
                cantidadSpinner.setValue(valor);
            }
            else{
                if(tablaVentas != null){
                    tablaVentas.setValueAt(valor, tablaVentas.getSelectedRow(), 2);
                }

                if(valor < 1){
                    valor = 1;

                }
                cantidadSpinner.setValue(valor);
                tablaVentas.setValueAt(valor, tablaVentas.getSelectedRow(), 2);
                detalles = detallesVenta.get(productoSeleccionado.getCodigo());
                detalles.setCantidad(valor);
                detallesVenta.put(productoSeleccionado.getCodigo(),detalles);
                System.out.println(detalles.getCantidad());
                actualizarPrecio();
            }    
        }
        catch(Exception e){
            System.out.println("error en tabla: " + e.getMessage());
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

    private void cedulaTextoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cedulaTextoAncestorAdded
        cedulaTexto.requestFocus();
    }//GEN-LAST:event_cedulaTextoAncestorAdded

    private void cedulaTextoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cedulaTextoFocusLost
        if(!verificarCliente){
            cedulaTexto.requestFocus();
        }
    }//GEN-LAST:event_cedulaTextoFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            eliminarProducto();
            
            actualizarPrecio();
        } catch (SQLException ex) {
            Logger.getLogger(ventasPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cedulaTextoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cedulaTextoKeyPressed
        int key = evt.getKeyCode();
        boolean enter = key == 10;
        
        if ((enter)){
                    try {
            buscarCliente(cedulaTexto.getText());
            
        } catch (SQLException ex) {
            Logger.getLogger(ventasPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_cedulaTextoKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int numeroFactura = parametros.getFactura();
        venta.setIdCliente(cedulaTexto.getText());
        venta.setMonto(Double.parseDouble(redondear(total)));
        guardarVenta();
        guardarDetallesVenta();
        
        try {
            imprimir(numeroFactura, parametros, conexion);
        } catch (SQLException ex) {
            Logger.getLogger(ventasPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Venta registrada con éxito");   

        cedulaTexto.setText("");
        codigoTexto.setText("");
        nombreTexto.setText("");
        direccionTexto.setText("");
        File pdfFile = new File("src/pdf/venta.pdf");
        
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            
            if (pdfFile.exists()) {
                try {
                    desktop.open(pdfFile);
                } catch (IOException e) {
                }
            } else {
                System.out.println("El archivo no existe");
            }
        } else {
            System.out.println("Desktop no está soportado");
        }
        parametros.setFactura(numeroFactura + 1);
        try {
            parametros.guardar();
        } catch (IOException ex) {
            Logger.getLogger(ventasPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        limpiarTablas();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void BuscarBoton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarBoton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarBoton1MouseClicked

    private void BuscarBoton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarBoton1ActionPerformed
       // JOptionPane.showMessageDialog(null, "En construccion");
        abrirBuscador(conexion, parametros, this);
    }//GEN-LAST:event_BuscarBoton1ActionPerformed
    public void guardarDetallesVenta(){
        try{
            DetallesVentaBD detallesBD = new DetallesVentaBD(conexion);
            ProductosBD productoBD = new ProductosBD(conexion);
            Productos producto = new Productos();
            for (DetallesVenta detalles : detallesVenta.values()) {
                detallesBD.setDetalles(detalles);
                producto = productoBD.getProducto(detalles.getIdProducto());
                producto.setCantidad(producto.getCantidad()-detalles.getCantidad());
                System.out.println(producto.getCantidad()-detalles.getCantidad());
                productoBD.actualizarCantidad(producto);
            }
        }
        catch(SQLException e){
            System.out.println("Error al guardar detalles Ventas " + e.getMessage());
        }
    }
    
    public void guardarVenta(){
        VentasBD ventaBD = new VentasBD(conexion);
        ventaBD.agregarVenta(venta);
    }
    
    public void quitarTexto(Component componente){
        JTextField cajaTexto = (JTextField) componente;
        if (cajaTexto.getText().equals("0") || cajaTexto.getText().equals("0.0")){
            cajaTexto.setText(null);
        }
        
    }
    //pone el texto predeterminado en los textbox vacios cuando pierden el foco
    public void ponerTexto(Component componente){
        JTextField cajaTexto = (JTextField) componente;
        if (cajaTexto.getText().equals("")){
            cajaTexto.setText("0");
        }
    }
    
    //solo permite ingresar numeros en los textBox
    private void soloNumeros(java.awt.event.KeyEvent evt){
        JTextField cajaTexto = (JTextField)evt.getComponent();
        int key = evt.getKeyChar();
        boolean numeros = key >= 48 && key <= 57;
        boolean borrar = key == 8;
        boolean enter = key == 10;
        if (!(numeros || borrar))
        {
            evt.consume();
        }
        if (cajaTexto.getText().trim().length() == 20 && !(borrar)) {
            evt.consume();
        }
    }
    
    private void buscarCliente(String idCliente) throws SQLException{
        ClientesBD clienteBD = new ClientesBD(conexion);
        Clientes cliente = clienteBD.getCliente(cedulaTexto.getText());
        System.out.println(cliente.getNombre());
        if (cliente.getNombre() != null){
            nombreTexto.setText(cliente.getNombre());
            direccionTexto.setText(cliente.getDireccion());
            venta.setIdCliente(idCliente);
            verificarCliente = true;
            codigoTexto.requestFocus();
        }
        else{
            if(JOptionPane.showConfirmDialog(null, "¿Desea registrar a un nuevo cliente?", "Cliente no encontrado", JOptionPane.YES_NO_OPTION) == 0){
                verificarCliente = true;
                crearVentanaCliente(conexion, idCliente);
                clienteBD.getCliente(cedulaTexto.getText());
                codigoTexto.requestFocus();
            }
        }
    }
    //solo permite 4 digitos numericos en los textBox
    private void porcentajeNumero(java.awt.event.KeyEvent evt){
        JTextField cajaTexto = (JTextField)evt.getComponent();
        int key = evt.getKeyChar();
        boolean numeros = key >= 48 && key <= 57;
        boolean borrar = key == 8;
        if (!(numeros || borrar))
        {
            evt.consume();
        }
        if (cajaTexto.getText().trim().length() == 4 && !(borrar)) {
            evt.consume();
        }
    }
    //no deja que se cambie el fotoa tro componente
    private void mantenerEnfoque(Component componente){
        
    }
    
    private void pasarEnfoque(Component siguiente, java.awt.event.KeyEvent evt ){
        int key = evt.getKeyCode();
        boolean enter = key == 10;
        boolean flechaAbajo = key == 40;
        boolean flechaArriba = key == 38;
        
        if ((enter || flechaAbajo)){
            siguiente.transferFocus();
        }
        if (flechaArriba){
            siguiente.transferFocusBackward();
        }
    }
    
    private void insertarEnTabla(String producto, String codigo, int cantidad, int cantMin, float precio, String departamento){  
        modeloAgregar.addRow(new Object[]{producto,codigo,cantidad, cantMin, precio, departamento});
    
    }
    
    public void cargarProducto(String codigo) throws SQLException{
        Productos producto = productoBD.getProducto(codigo);
        DetallesVenta detalles = new DetallesVenta();
        precio = producto.getPrecioCosto()+producto.getPrecioCosto()*producto.getGanancia()/100+(producto.getPrecioCosto()+producto.getPrecioCosto()*producto.getGanancia()/100)*producto.getIva()/100;
        if(!(producto.getCantidad() == 0)){
            if((detallesVenta.get(codigo) == null)){
                System.out.println("Pasa");
                modeloProductos.addRow(new Object[]{producto.getCodigo(), producto.getNombre(),1, redondear(precio)});
                detalles.setIdProducto(codigo);
                detalles.setCantidad(1);
                detalles.setPrecioUnidad(Double.valueOf(redondear(precio)));
                detalles.setIdProducto(codigo);
                detalles.setIdVenta(parametros.getFactura());
                detallesVenta.put(detalles.getIdProducto(),detalles);
                actualizarPrecio();
            }
            else{
                System.out.println("ya registrado");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "No hay exixstencia de ese producto");
        }   
    }
    
    private void eliminarProducto() throws SQLException{
        int columna = tablaVentas.getSelectedRow();
        DetallesVenta detalles;
        String codigo = (String) tablaVentas.getValueAt(tablaVentas.getSelectedRow(), 0);
        Productos producto = productoBD.getProducto(codigo);
        detalles = detallesVenta.get(productoSeleccionado.getCodigo());
        detallesVenta.remove(productoSeleccionado.getCodigo(),detalles);
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

    public void actualizarPrecio(){
        double precio = 0;
        double precioBs = 0;
        for (DetallesVenta detalles : detallesVenta.values()) {
            precio = detalles.getPrecioUnidad() * detalles.getCantidad() + precio;
        }
        total = precio;
        precioBs = total * parametros.getTasa();
        precioEtiqueta.setText(redondear(total));
        precioBolivaresTexto.setText(redondear(precioBs));
        System.out.println(detallesVenta.values());
    }
    public void disminuirPrecio(){
    
    } 
    private String redondear(double numero){
        int decimales = 2;
        String resultado;
        BigDecimal bd = new BigDecimal(numero);
        bd = bd.setScale(decimales, RoundingMode.HALF_UP);
        resultado = bd.toString();
        return resultado;
    }
    
    public void setProductoBuscador(String codigoProducto){
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuscarBoton;
    private javax.swing.JButton BuscarBoton1;
    private javax.swing.JButton BuscarBoton3;
    private javax.swing.JSpinner cantidadSpinner;
    private javax.swing.JTextField cedulaTexto;
    private javax.swing.JTextField codigoTexto;
    private javax.swing.JTextField direccionTexto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField nombreTexto;
    private javax.swing.JLabel precioBolivaresTexto;
    private javax.swing.JLabel precioEtiqueta;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tablaVentas;
    // End of variables declaration//GEN-END:variables
}

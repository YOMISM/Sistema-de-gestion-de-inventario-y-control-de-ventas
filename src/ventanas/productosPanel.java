/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ventanas;

import inventario.DepartamentoBD;
import inventario.ObtenerParametros;
import inventario.ProductosBD;
import inventario.ProveedoresBD;
import java.awt.Component;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static VentanasEmergentes.InformacionProducto.crearVentana;
import inventario.Productos;
import inventario.ReporteInventario;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class productosPanel extends javax.swing.JPanel {

    /**
     * Creates new form productosPanel
     */
    public productosPanel() {
        initComponents();
    }

    Connection conexion;
    boolean gananciaUltimo;
    boolean ivaUltimo;
    double gananciaDefecto = 0;
    double ivaDefecto = 0;
    double precioFinalUltimo;
    DefaultTableModel modeloAgregar;
    DefaultTableModel modeloProductos;
    AgregarDatos agregadorDatos;
    ajustes ajustess;
    ObtenerParametros parametros;
    DepartamentoBD departamentosBD;
    ProveedoresBD proveedorBD;
    @SuppressWarnings("unchecked")
    
     public productosPanel(Connection con, ObtenerParametros parametros) {
        conexion = con;
        this.parametros = parametros;
        departamentosBD = new DepartamentoBD(con);
        proveedorBD = new ProveedoresBD(con);
        initComponents();
        modeloProductos = (DefaultTableModel) TablaProductos.getModel();
        cargarDepartamentos(comboDepartamentos);
        cargarDepartamentos(comboBuscarDepartamentos);
        cargarProveedores(comboProveedores);
        modeloAgregar = (DefaultTableModel) TablaAgregarProductos.getModel();
        agregadorDatos= new AgregarDatos();
        cargarProductos();
    }
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        tablaProductos = new javax.swing.JScrollPane();
        TablaProductos = new javax.swing.JTable();
        comboBuscarDepartamentos = new javax.swing.JComboBox<>();
        CodigoTexto = new javax.swing.JTextField();
        BuscarBoton = new javax.swing.JButton();
        BuscarBoton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        productoTexto = new javax.swing.JTextField();
        precioTexto = new javax.swing.JTextField();
        guardarBoton = new javax.swing.JButton();
        cantidadTexto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cantidadMinTexto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaAgregarProductos = new javax.swing.JTable();
        codigoTexto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        precioCostoTexto = new javax.swing.JTextField();
        gananciaTexto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        gananciaPorcentajeTexto = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ivaTexto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        ivaPorcentajeTexto = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        precioBolivarTexto = new javax.swing.JTextField();
        comboDepartamentos = new javax.swing.JComboBox<>();
        comboProveedores = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();

        setName("productosPanel"); // NOI18N
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jTabbedPane1.setBorder(new javax.swing.border.MatteBorder(null));
        jTabbedPane1.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        jTabbedPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTabbedPane1KeyPressed(evt);
            }
        });

        jPanel6.setFocusable(false);

        tablaProductos.setViewportBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tablaProductos.setFocusCycleRoot(true);
        tablaProductos.setFont(new java.awt.Font("Yu Gothic UI", 0, 48)); // NOI18N

        TablaProductos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Cantidad", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
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
        TablaProductos.setRowHeight(40);
        TablaProductos.setShowHorizontalLines(true);
        TablaProductos.setShowVerticalLines(true);
        TablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaProductosMouseClicked(evt);
            }
        });
        tablaProductos.setViewportView(TablaProductos);

        comboBuscarDepartamentos.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        comboBuscarDepartamentos.setName("departamentos2"); // NOI18N
        comboBuscarDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBuscarDepartamentosActionPerformed(evt);
            }
        });

        CodigoTexto.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        CodigoTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodigoTextoActionPerformed(evt);
            }
        });
        CodigoTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CodigoTextoKeyPressed(evt);
            }
        });

        BuscarBoton.setText("Buscar");
        BuscarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarBotonActionPerformed(evt);
            }
        });

        BuscarBoton1.setText("Reporte");
        BuscarBoton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarBoton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tablaProductos)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(comboBuscarDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CodigoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BuscarBoton)
                        .addGap(18, 18, 18)
                        .addComponent(BuscarBoton1)
                        .addGap(0, 477, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(CodigoTexto, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(comboBuscarDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BuscarBoton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BuscarBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tablaProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Productos", jPanel6);

        jPanel2.setMinimumSize(new java.awt.Dimension(1214, 820));
        jPanel2.setOpaque(false);
        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel2KeyPressed(evt);
            }
        });

        productoTexto.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        productoTexto.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        productoTexto.setName("nombreTexto"); // NOI18N
        productoTexto.setNextFocusableComponent(codigoTexto);
        productoTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                productoTextoKeyPressed(evt);
            }
        });

        precioTexto.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        precioTexto.setText("0");
        precioTexto.setName("precioTexto"); // NOI18N
        precioTexto.setNextFocusableComponent(precioBolivarTexto);
        precioTexto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                precioTextoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                precioTextoFocusLost(evt);
            }
        });
        precioTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                precioTextoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                precioTextoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioTextoKeyTyped(evt);
            }
        });

        guardarBoton.setText("Guardar");
        guardarBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarBotonMouseClicked(evt);
            }
        });
        guardarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarBotonActionPerformed(evt);
            }
        });

        cantidadTexto.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        cantidadTexto.setText("0");
        cantidadTexto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cantidadTextoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cantidadTextoFocusLost(evt);
            }
        });
        cantidadTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadTextoActionPerformed(evt);
            }
        });
        cantidadTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cantidadTextoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidadTextoKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel1.setText("Producto:");

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel2.setText("Cantidad:");

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel3.setText("Código:");

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel4.setText("Precio:");

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel5.setText("Departamento:");

        cantidadMinTexto.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        cantidadMinTexto.setText("0");
        cantidadMinTexto.setName("precioTexto"); // NOI18N
        cantidadMinTexto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cantidadMinTextoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cantidadMinTextoFocusLost(evt);
            }
        });
        cantidadMinTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cantidadMinTextoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidadMinTextoKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel6.setText("Cantidad mín:");

        jButton2.setText("Agregar departamento");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        TablaAgregarProductos.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        TablaAgregarProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Código", "Cantidad", "Cantiadad Min.", "Precio", "Departamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Long.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TablaAgregarProductos.setRowHeight(40);
        TablaAgregarProductos.setShowHorizontalLines(true);
        TablaAgregarProductos.setShowVerticalLines(true);
        jScrollPane2.setViewportView(TablaAgregarProductos);

        codigoTexto.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        codigoTexto.setText("0");
        codigoTexto.setName("nombreTexto"); // NOI18N
        codigoTexto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                codigoTextoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                codigoTextoFocusLost(evt);
            }
        });
        codigoTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoTextoActionPerformed(evt);
            }
        });
        codigoTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoTextoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codigoTextoKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel7.setText("Precio costo:");

        precioCostoTexto.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        precioCostoTexto.setText("0");
        precioCostoTexto.setName("precioTexto"); // NOI18N
        precioCostoTexto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                precioCostoTextoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                precioCostoTextoFocusLost(evt);
            }
        });
        precioCostoTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                precioCostoTextoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                precioCostoTextoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioCostoTextoKeyTyped(evt);
            }
        });

        gananciaTexto.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        gananciaTexto.setText("0");
        gananciaTexto.setName("precioTexto"); // NOI18N
        gananciaTexto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                gananciaTextoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                gananciaTextoFocusLost(evt);
            }
        });
        gananciaTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gananciaTextoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gananciaTextoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                gananciaTextoKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel8.setText("Ganancia:");

        gananciaPorcentajeTexto.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        gananciaPorcentajeTexto.setText(String.valueOf(parametros.getGanancia()));
        gananciaPorcentajeTexto.setName("precioTexto"); // NOI18N
        gananciaPorcentajeTexto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                gananciaPorcentajeTextoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                gananciaPorcentajeTextoFocusLost(evt);
            }
        });
        gananciaPorcentajeTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gananciaPorcentajeTextoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gananciaPorcentajeTextoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                gananciaPorcentajeTextoKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel9.setText("IVA:");

        ivaTexto.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        ivaTexto.setText("0");
        ivaTexto.setName("precioTexto"); // NOI18N
        ivaTexto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ivaTextoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ivaTextoFocusLost(evt);
            }
        });
        ivaTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ivaTextoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ivaTextoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ivaTextoKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        jLabel11.setText("%");

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        jLabel12.setText("$");

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        jLabel13.setText("%");

        ivaPorcentajeTexto.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        ivaPorcentajeTexto.setText(String.valueOf(parametros.getIva()));
        ivaPorcentajeTexto.setName("ivaPorcentajeTexto"); // NOI18N
        ivaPorcentajeTexto.setNextFocusableComponent(precioTexto);
        ivaPorcentajeTexto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ivaPorcentajeTextoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ivaPorcentajeTextoFocusLost(evt);
            }
        });
        ivaPorcentajeTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ivaPorcentajeTextoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ivaPorcentajeTextoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ivaPorcentajeTextoKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        jLabel14.setText("$");

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel10.setText("Precio en Bs:");

        precioBolivarTexto.setEditable(false);
        precioBolivarTexto.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        precioBolivarTexto.setText("0");
        precioBolivarTexto.setName("precioBolivaresTexto"); // NOI18N
        precioBolivarTexto.setNextFocusableComponent(comboDepartamentos);
        precioBolivarTexto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                precioBolivarTextoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                precioBolivarTextoFocusLost(evt);
            }
        });
        precioBolivarTexto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                precioBolivarTextoMouseClicked(evt);
            }
        });
        precioBolivarTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                precioBolivarTextoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioBolivarTextoKeyTyped(evt);
            }
        });

        comboDepartamentos.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        comboDepartamentos.setName("departamentos1"); // NOI18N

        comboProveedores.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        comboProveedores.setName("departamentos1"); // NOI18N

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel15.setText("Proveedor:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(productoTexto)
                    .addComponent(precioBolivarTexto)
                    .addComponent(jLabel10)
                    .addComponent(precioTexto)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ivaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(ivaPorcentajeTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13))
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(cantidadTexto)
                    .addComponent(precioCostoTexto)
                    .addComponent(jLabel7)
                    .addComponent(cantidadMinTexto)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(codigoTexto)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(gananciaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(gananciaPorcentajeTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11))
                    .addComponent(comboDepartamentos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15)
                    .addComponent(comboProveedores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(guardarBoton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(codigoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cantidadTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cantidadMinTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(precioCostoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gananciaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(gananciaPorcentajeTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ivaPorcentajeTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel14))
                    .addComponent(ivaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(3, 3, 3)
                .addComponent(precioTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(precioBolivarTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Agregar", jPanel2);

        add(jTabbedPane1);
    }// </editor-fold>//GEN-END:initComponents

    private void TablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaProductosMouseClicked

        if (evt.getClickCount() == 2){
            JTable tabla = (JTable)evt.getComponent();
            System.out.println(tabla.getValueAt(tabla.getSelectedRow(), 0));
            crearVentana(conexion,String.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 0)),parametros);
            
        }
    }//GEN-LAST:event_TablaProductosMouseClicked

    private void comboBuscarDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBuscarDepartamentosActionPerformed

        DepartamentoBD departamento= new DepartamentoBD(conexion);
        int codigo;
        String nombre = (String)comboBuscarDepartamentos.getSelectedItem();
        if (nombre.equals("Sin filtro")){
            cargarProductos();
        }
        else{
            try {
                codigo = departamento.codigoDepartamento(nombre);
                cargarProductosDepartamentos(codigo);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }//GEN-LAST:event_comboBuscarDepartamentosActionPerformed

    private void BuscarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarBotonActionPerformed

    }//GEN-LAST:event_BuscarBotonActionPerformed

    private void jTabbedPane1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTabbedPane1KeyPressed
        pasarEnfoque(jTabbedPane1, evt);
    }//GEN-LAST:event_jTabbedPane1KeyPressed

    private void CodigoTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodigoTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodigoTextoActionPerformed

    private void jPanel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyPressed
        int tecla = evt.getKeyCode();
    }//GEN-LAST:event_jPanel2KeyPressed

    private void precioBolivarTextoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioBolivarTextoKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_precioBolivarTextoKeyTyped

    private void precioBolivarTextoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioBolivarTextoKeyPressed
        pasarEnfoque(precioTexto,evt);
    }//GEN-LAST:event_precioBolivarTextoKeyPressed

    private void precioBolivarTextoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_precioBolivarTextoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_precioBolivarTextoMouseClicked

    private void precioBolivarTextoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_precioBolivarTextoFocusLost
        ponerTexto(evt.getComponent());
    }//GEN-LAST:event_precioBolivarTextoFocusLost

    private void precioBolivarTextoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_precioBolivarTextoFocusGained
        quitarTexto(evt.getComponent());
    }//GEN-LAST:event_precioBolivarTextoFocusGained

    private void ivaPorcentajeTextoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ivaPorcentajeTextoKeyTyped
        porcentajeNumero(evt);
    }//GEN-LAST:event_ivaPorcentajeTextoKeyTyped

    private void ivaPorcentajeTextoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ivaPorcentajeTextoKeyReleased
        calcularIva();
    }//GEN-LAST:event_ivaPorcentajeTextoKeyReleased

    private void ivaPorcentajeTextoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ivaPorcentajeTextoKeyPressed
        pasarEnfoque(ivaPorcentajeTexto, evt);
    }//GEN-LAST:event_ivaPorcentajeTextoKeyPressed

    private void ivaPorcentajeTextoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ivaPorcentajeTextoFocusLost
        ponerTexto(evt.getComponent());
    }//GEN-LAST:event_ivaPorcentajeTextoFocusLost

    private void ivaPorcentajeTextoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ivaPorcentajeTextoFocusGained
        quitarTexto(evt.getComponent());
    }//GEN-LAST:event_ivaPorcentajeTextoFocusGained

    private void ivaTextoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ivaTextoKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_ivaTextoKeyTyped

    private void ivaTextoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ivaTextoKeyReleased
        calcularPorcentajeIva();
    }//GEN-LAST:event_ivaTextoKeyReleased

    private void ivaTextoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ivaTextoKeyPressed
        pasarEnfoque(ivaTexto, evt);
    }//GEN-LAST:event_ivaTextoKeyPressed

    private void ivaTextoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ivaTextoFocusLost
        ponerTexto(evt.getComponent());
    }//GEN-LAST:event_ivaTextoFocusLost

    private void ivaTextoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ivaTextoFocusGained
        quitarTexto(evt.getComponent());
    }//GEN-LAST:event_ivaTextoFocusGained

    private void gananciaPorcentajeTextoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gananciaPorcentajeTextoKeyTyped
        porcentajeNumero(evt);
    }//GEN-LAST:event_gananciaPorcentajeTextoKeyTyped

    private void gananciaPorcentajeTextoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gananciaPorcentajeTextoKeyReleased
        calcularGanancia();
    }//GEN-LAST:event_gananciaPorcentajeTextoKeyReleased

    private void gananciaPorcentajeTextoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gananciaPorcentajeTextoKeyPressed
        pasarEnfoque(gananciaPorcentajeTexto, evt);
    }//GEN-LAST:event_gananciaPorcentajeTextoKeyPressed

    private void gananciaPorcentajeTextoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_gananciaPorcentajeTextoFocusLost
        ponerTexto(evt.getComponent());
    }//GEN-LAST:event_gananciaPorcentajeTextoFocusLost

    private void gananciaPorcentajeTextoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_gananciaPorcentajeTextoFocusGained
        quitarTexto(evt.getComponent());
    }//GEN-LAST:event_gananciaPorcentajeTextoFocusGained

    private void gananciaTextoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gananciaTextoKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_gananciaTextoKeyTyped

    private void gananciaTextoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gananciaTextoKeyReleased
        calcularPorcentajeGanancia();
    }//GEN-LAST:event_gananciaTextoKeyReleased

    private void gananciaTextoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gananciaTextoKeyPressed
        pasarEnfoque(gananciaTexto, evt);
    }//GEN-LAST:event_gananciaTextoKeyPressed

    private void gananciaTextoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_gananciaTextoFocusLost
        ponerTexto(evt.getComponent());
    }//GEN-LAST:event_gananciaTextoFocusLost

    private void gananciaTextoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_gananciaTextoFocusGained
        quitarTexto(evt.getComponent());
    }//GEN-LAST:event_gananciaTextoFocusGained

    private void precioCostoTextoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioCostoTextoKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_precioCostoTextoKeyTyped

    private void precioCostoTextoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioCostoTextoKeyReleased
        precioCostoCalculo();
    }//GEN-LAST:event_precioCostoTextoKeyReleased

    private void precioCostoTextoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioCostoTextoKeyPressed
        pasarEnfoque(precioCostoTexto, evt);
    }//GEN-LAST:event_precioCostoTextoKeyPressed

    private void precioCostoTextoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_precioCostoTextoFocusLost
        ponerTexto(evt.getComponent());
    }//GEN-LAST:event_precioCostoTextoFocusLost

    private void precioCostoTextoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_precioCostoTextoFocusGained
        quitarTexto(evt.getComponent());
    }//GEN-LAST:event_precioCostoTextoFocusGained

    private void codigoTextoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoTextoKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_codigoTextoKeyTyped

    private void codigoTextoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoTextoKeyPressed
        pasarEnfoque(codigoTexto, evt);
    }//GEN-LAST:event_codigoTextoKeyPressed

    private void codigoTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoTextoActionPerformed

    private void codigoTextoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigoTextoFocusLost

        ponerTexto(evt.getComponent());
    }//GEN-LAST:event_codigoTextoFocusLost

    private void codigoTextoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigoTextoFocusGained
        quitarTexto(evt.getComponent());
    }//GEN-LAST:event_codigoTextoFocusGained

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         JOptionPane.showMessageDialog(null, "En construccion");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cantidadMinTextoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadMinTextoKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_cantidadMinTextoKeyTyped

    private void cantidadMinTextoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadMinTextoKeyPressed
        pasarEnfoque(cantidadMinTexto, evt);
    }//GEN-LAST:event_cantidadMinTextoKeyPressed

    private void cantidadMinTextoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cantidadMinTextoFocusLost
        ponerTexto(evt.getComponent());
    }//GEN-LAST:event_cantidadMinTextoFocusLost

    private void cantidadMinTextoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cantidadMinTextoFocusGained
        quitarTexto(evt.getComponent());
    }//GEN-LAST:event_cantidadMinTextoFocusGained

    private void cantidadTextoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadTextoKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_cantidadTextoKeyTyped

    private void cantidadTextoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadTextoKeyPressed
        pasarEnfoque(cantidadTexto, evt);
    }//GEN-LAST:event_cantidadTextoKeyPressed

    private void cantidadTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadTextoActionPerformed

    private void cantidadTextoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cantidadTextoFocusLost
        ponerTexto(evt.getComponent());
    }//GEN-LAST:event_cantidadTextoFocusLost

    private void cantidadTextoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cantidadTextoFocusGained
        quitarTexto(evt.getComponent());
    }//GEN-LAST:event_cantidadTextoFocusGained

    private void guardarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarBotonActionPerformed
        try{
            String codigo = codigoTexto.getText();
            String producto = productoTexto.getText();
            int cantidad = Integer.parseInt(cantidadTexto.getText());
            int cantMin = Integer.parseInt(cantidadMinTexto.getText());
            float precio = Float.parseFloat(precioTexto.getText());
            float ganancia = Float.parseFloat(gananciaPorcentajeTexto.getText());
            float iva = Float.parseFloat(ivaPorcentajeTexto.getText());
            int departamento = departamentosBD.codigoDepartamento(comboDepartamentos.getSelectedItem().toString());
            String proveedor = proveedorBD.rifProveedor(comboProveedores.getSelectedItem().toString());
            float precioCosto = Float.parseFloat(precioCostoTexto.getText());
            System.out.println("pasa 1");
            if (agregadorDatos.insertarProducto(codigo, producto, cantidad, cantMin, precioCosto, ganancia, departamento, iva, proveedor)){
                insertarEnTabla(producto, codigo, cantidad, cantMin, precio, comboDepartamentos.getSelectedItem().toString());
                modeloProductos.addRow(new Object[]{codigo, producto, cantidad, precio});
            }
        }
        catch(NumberFormatException e){
            e.getMessage();
        } catch (SQLException ex) {
            Logger.getLogger(productosPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        productoTexto.setText("");
        codigoTexto.setText("0");
        precioTexto.setText("0");
        cantidadTexto.setText("0");
    }//GEN-LAST:event_guardarBotonActionPerformed

    private void guardarBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarBotonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_guardarBotonMouseClicked

    private void precioTextoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioTextoKeyTyped
        soloNumeros(evt);
    }//GEN-LAST:event_precioTextoKeyTyped

    private void precioTextoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioTextoKeyReleased
        precioTextoModificar();
    }//GEN-LAST:event_precioTextoKeyReleased

    private void precioTextoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioTextoKeyPressed
        pasarEnfoque(precioTexto, evt);
    }//GEN-LAST:event_precioTextoKeyPressed

    private void precioTextoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_precioTextoFocusLost
        ponerTexto(evt.getComponent());
    }//GEN-LAST:event_precioTextoFocusLost

    private void precioTextoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_precioTextoFocusGained
        quitarTexto(evt.getComponent());
    }//GEN-LAST:event_precioTextoFocusGained

    private void productoTextoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productoTextoKeyPressed
        pasarEnfoque(productoTexto, evt);
    }//GEN-LAST:event_productoTextoKeyPressed

    private void CodigoTextoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CodigoTextoKeyPressed
        ProductosBD productoBD = new ProductosBD(conexion);
        Productos producto = productoBD.buscadorProductos(CodigoTexto.getText());
        int key = evt.getKeyCode();
        boolean enter = key == 10;
        if ((enter)){
            if(!(producto.getNombre() == null)){
                limpiarTablas();
                System.out.println(producto.getNombre());
                float precio;
                float precioCosto = producto.getPrecioCosto();
                float ganancia = producto.getGanancia();
                float iva = producto.getIva();

                precio = precioCosto + precioCosto*ganancia/100 + (precioCosto+precioCosto*ganancia/100)*iva/100;
                modeloProductos.addRow(new Object[]{producto.getCodigo(), producto.getNombre(),
                producto.getCantidad(), redondear(precio)});
            }
            else{
                JOptionPane.showMessageDialog(null, "Producto no encontrado");
            }
        }
    }//GEN-LAST:event_CodigoTextoKeyPressed

    private void BuscarBoton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarBoton1ActionPerformed
        new ReporteInventario(conexion);
        
    }//GEN-LAST:event_BuscarBoton1ActionPerformed
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
        boolean punto = key == 46;
        boolean borrar = key == 8;
        boolean enter = key == 10;
        if (!(numeros || punto || borrar))
        {
            evt.consume();
        }
        if (cajaTexto.getText().trim().length() == 20 && !(borrar)) {
            evt.consume();
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
    
    private void cargarProductos(){
        ProductosBD productos;
        ResultSet set;
        productos = new ProductosBD(conexion);
        set = productos.obtenerProductos();
        float precio;
        limpiarTablas();
        
        try{
            while(set.next()){
                float precioCosto = set.getFloat(5);
                float ganancia = set.getFloat(6);
                float iva = set.getFloat(8);

                //precio = precioCosto + precioCosto*ganancia/100 + (precioCosto+precioCosto*ganancia/100)*(iva/100);
                precio = (precioCosto*(1+ganancia/100))*(1+iva/100);
                modeloProductos.addRow(new Object[]{set.getLong(1), set.getString(2),
                set.getInt(3), redondear(precio)});
            }
        }
        catch(Exception e){
            System.out.println("El error est"+e.getMessage());
        }
        
    }
    
    private void cargarProductosDepartamentos(int parametro){
        ProductosBD productos;
        ResultSet set;
        productos = new ProductosBD(conexion);
        set = productos.getProductosDepartamentos(parametro);
        float precio;
        limpiarTablas();
        
        try{
            while(set.next()){
                precio = set.getFloat(5)+(set.getFloat(5)*set.getFloat(6))/100+
                        (set.getFloat(5)*set.getFloat(8))/100;
                modeloProductos.addRow(new Object[]{set.getLong(1), set.getString(2),
                set.getInt(3), precio});
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    private void limpiarTablas(){
        int cantidad =modeloProductos.getRowCount()-1;  
        for(int i=cantidad;i>=0;i--){ 
            modeloProductos.removeRow(i);
        }
    }    
    private void cargarDepartamentos(JComboBox combo){
        ResultSet set = departamentosBD.cargarDepartamentos();
        combo.addItem("Sin filtro");
        System.out.println(combo.getName());
        try{
            while(set.next()){
                System.out.println(set.getString(2));
                combo.addItem(set.getString(2));
            }
        }
        catch(SQLException e){
            System.out.println("Error en cargarDepartamentos "+e.getMessage());
        }
        
    }
    
    private void cargarProveedores(JComboBox combo){
        ResultSet set = proveedorBD.cargarProveedores();
        combo.addItem("Sin filtro");
        System.out.println(combo.getName());
        try{
            while(set.next()){
                System.out.println(set.getString(2));
                combo.addItem(set.getString(2));
            }
        }
        catch(SQLException e){
            System.out.println("Error en cargarProveedores"+e.getMessage());
        }  
    }
    
    private void calcularPorcentajeGanancia()
    {
        try{
            double precioCosto = Double.parseDouble(precioCostoTexto.getText());
            double ganancia = Double.parseDouble(gananciaTexto.getText());
            if(precioCosto > 0){
                DecimalFormat df = new DecimalFormat("#.00");
                String porcentajeGanancia = df.format(ganancia/precioCosto*100);
                gananciaPorcentajeTexto.setText(porcentajeGanancia);
                actualizarPrecioFinal();
                gananciaUltimo = true;
            }    
        }
        catch(Exception e){
            gananciaPorcentajeTexto.setText("0");
        }
        
    }
    
    private void calcularGanancia()
    {  
        
        try{
            double precioCosto = Double.parseDouble(precioCostoTexto.getText());
            double gananciaPorcentaje = Double.parseDouble(gananciaPorcentajeTexto.getText());
            DecimalFormat df = new DecimalFormat("#.00");
            String Ganancia = df.format(precioCosto*gananciaPorcentaje/100);
            gananciaTexto.setText(Ganancia);
            actualizarPrecioFinal();
            gananciaUltimo = false;
        }
        catch(NumberFormatException e){
            gananciaTexto.setText("0");
        }
    }
    
    private void calcularPorcentajeIva()
    {
        try{
            double precioCosto = Double.parseDouble(precioCostoTexto.getText());
            double ganancia = Double.parseDouble(gananciaTexto.getText());
            double iva = Double.parseDouble(ivaTexto.getText());
            if (precioCosto > 0){
                DecimalFormat df = new DecimalFormat("#.00");
                String porcentajeIva = df.format(iva/(precioCosto+ganancia)*100);
                ivaPorcentajeTexto.setText(porcentajeIva);
                actualizarPrecioFinal();
                ivaUltimo = true;
            }
                    
        }
        catch(Exception e){
            ivaPorcentajeTexto.setText("0");
        }
        
    }
    
    private void calcularIva()
    {
        try{
            double precioCosto = Double.parseDouble(precioCostoTexto.getText());
            double ganancia = Double.parseDouble(gananciaTexto.getText());
            double ivaPorcentaje = Double.parseDouble(ivaPorcentajeTexto.getText());
            DecimalFormat df = new DecimalFormat("#.00");
            String iva = df.format((precioCosto+ganancia)*ivaPorcentaje/100);
            ivaTexto.setText(iva);
            actualizarPrecioFinal();
            ivaUltimo = false;
        }
        catch(NumberFormatException e){
            ivaTexto.setText("0");
        }    
    }
    
    private void actualizarPrecioFinal()
    {
        double precioFinal;
        try
        {
            precioFinal = Double.parseDouble(precioCostoTexto.getText()) + 
            Double.parseDouble(gananciaTexto.getText()) + Double.parseDouble(ivaTexto.getText());
            DecimalFormat df = new DecimalFormat("#.00");
            precioTexto.setText(df.format(precioFinal));
            precioFinalUltimo = precioFinal;
            precioBs();
        }
        catch(NumberFormatException e){
            
        }
    }
    
    private void precioBs(){
        double precioFinal = Double.parseDouble(precioTexto.getText());
        DecimalFormat df = new DecimalFormat("#.00");
        precioBolivarTexto.setText(df.format(precioFinal*parametros.getTasa()));   
    }
    
    private void precioCostoCalculo()
    {
        if(gananciaUltimo == true)
        {
            calcularPorcentajeGanancia();
        }
        else
        {
            calcularGanancia();
        }
        if(ivaUltimo == true)
        {
            calcularPorcentajeIva();
        }
        else
        {
            calcularIva();
        }
        actualizarPrecioFinal();
               
    }
    
    //recalcula los valores cuando el textBox de precio es modificado
    private void precioTextoModificar()
    {
        try{
            double precioFinal = Double.parseDouble(precioTexto.getText());
            double diferencia = precioFinal - precioFinalUltimo;
            double ganancia = Double.parseDouble(gananciaTexto.getText());
            String nuevaGanancia = String.valueOf(diferencia + ganancia);
            gananciaTexto.setText(nuevaGanancia);
            calcularPorcentajeGanancia();
        }
        catch(Exception e)
        {}
    }
    
    private String redondear(float numero){
        int decimales = 2;
        String resultado;
        BigDecimal bd = new BigDecimal(numero);
        bd = bd.setScale(decimales, RoundingMode.HALF_UP);
        resultado = bd.toString();
        return resultado;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuscarBoton;
    private javax.swing.JButton BuscarBoton1;
    private javax.swing.JTextField CodigoTexto;
    private javax.swing.JTable TablaAgregarProductos;
    private javax.swing.JTable TablaProductos;
    private javax.swing.JTextField cantidadMinTexto;
    private javax.swing.JTextField cantidadTexto;
    private javax.swing.JTextField codigoTexto;
    private javax.swing.JComboBox<String> comboBuscarDepartamentos;
    private javax.swing.JComboBox<String> comboDepartamentos;
    private javax.swing.JComboBox<String> comboProveedores;
    private javax.swing.JTextField gananciaPorcentajeTexto;
    private javax.swing.JTextField gananciaTexto;
    private javax.swing.JButton guardarBoton;
    private javax.swing.JTextField ivaPorcentajeTexto;
    private javax.swing.JTextField ivaTexto;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField precioBolivarTexto;
    private javax.swing.JTextField precioCostoTexto;
    private javax.swing.JTextField precioTexto;
    private javax.swing.JTextField productoTexto;
    private javax.swing.JScrollPane tablaProductos;
    // End of variables declaration//GEN-END:variables
}

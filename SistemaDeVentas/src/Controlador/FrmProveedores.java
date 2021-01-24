package Controlador;

import static Controlador.FRMPRINCIPAL.MenuProductos;
import Datos.Dproducto;
import Datos.Dproveedor;
import Funciones.Fproducto;
import Funciones.Fproveedor;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public final class FrmProveedores extends javax.swing.JInternalFrame {

    private File file;
    private List<JTable> tabla;
    private List<String> nom_files;

    public FrmProveedores() {
        initComponents();
        inhabilitar();
        mostrar("");

        //width a las columnas del jtable
        jTabla.getColumnModel().getColumn(1).setPreferredWidth(220);

        //   BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        //   bi.setNorthPane(null);
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        jTabla.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                //l.setBorder(new LineBorder(Color.black, 1));
                l.setBackground(new java.awt.Color(36, 33, 33));
                l.setForeground(new java.awt.Color(25, 118, 210));
                l.setFont(new java.awt.Font("Arial", 1, 12));
                return l;
            }
        });
    }

    public FrmProveedores(File file, List<JTable> tabla, List<String> nom_files)
            throws Exception {
        this.file = file;
        this.tabla = tabla;
        this.nom_files = nom_files;
        if (nom_files.size() != tabla.size()) {
            throw new Exception("Error");
        }

    }

    public boolean export() {
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
            WritableWorkbook w = Workbook.createWorkbook(out);
            for (int index = 0; index < tabla.size(); index++) {
                JTable table = tabla.get(index);
                WritableSheet s = w.createSheet(nom_files.get(index), 0);
                for (int i = 0; i < table.getColumnCount(); i++) {
                    String NomCol = table.getColumnName(i);
                    s.addCell(new Label(i, 0, NomCol));

                    for (int j = 0; j < table.getRowCount(); j++) {
                        Object object = table.getValueAt(j, i);
                        s.addCell(new Label(i, j + 1, String.valueOf(object))); //lo pone en la fila 0+1
                    }
                }
            }
            w.write();
            w.close();
            out.close();
            return true;
        } catch (IOException | WriteException e) {
            System.out.println("Error al exportar a Excel:" + e.getMessage());
            return false;
        }
    }

    public void inhabilitar() {

        txtCod_prov.setEditable(false);
        txtNombre_prov.setEditable(false);
        txtDireccion_prov.setEditable(false);
        txtNit_prov.setEditable(false);
        txtTelefono_prov.setEditable(false);

        btnEditar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnNuevo.setEnabled(true);

        txtCod_prov.setText("");
        txtNombre_prov.setText("");
        txtDireccion_prov.setText("");
        txtNit_prov.setText("");
        txtTelefono_prov.setText("");

    }

    public void habilitar() {
        txtCod_prov.setEditable(false);
        txtNombre_prov.setEditable(true);
        txtDireccion_prov.setEditable(true);
        txtNit_prov.setEditable(true);
        txtTelefono_prov.setEditable(true);

        btnEditar.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnNuevo.setEnabled(false);

        txtCod_prov.setText("");
        txtNombre_prov.setText("");
        txtDireccion_prov.setText("");
        txtNit_prov.setText("");
        txtTelefono_prov.setText("");

    }

    public void mostrar(String buscar) {

        try {
            DefaultTableModel modelo = null;
            Fproveedor funcion = new Fproveedor();   
            
            modelo = funcion.mostrar(buscar);
            
        
            jTabla.setModel(modelo);
            // ocultar_columnas();
            //  lblTotalRegistros.setText("Cantidad de Registros : " + Integer.toString(funcion.totalRegistros));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }

    public void mostrarExportar(String buscar) {
        try {
            DefaultTableModel modelo= null;
            Fproducto funcion = new Fproducto();


            jTabla.setModel(modelo);
            // ocultar_columnas();
            //  lblTotalRegistros.setText("Cantidad de Registros : " + Integer.toString(funcion.totalRegistros));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabla = jTabla = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnExportar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTelefono_prov = new javax.swing.JTextField();
        txtNit_prov = new javax.swing.JTextField();
        txtCod_prov = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDireccion_prov = new javax.swing.JTextField();
        txtNombre_prov = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);

        jPanel2.setBackground(new java.awt.Color(36, 33, 33));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBackground(new java.awt.Color(36, 33, 33));
        jPanel1.setPreferredSize(new java.awt.Dimension(822, 479));

        jTabla.setBackground(new java.awt.Color(36, 33, 33));
        jTabla.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTabla.setForeground(new java.awt.Color(207, 207, 207));
        jTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTabla.setRowHeight(20);
        jTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabla);

        jLabel12.setText(" ");

        jPanel3.setBackground(new java.awt.Color(36, 33, 33));

        btnExportar.setBackground(new java.awt.Color(36, 33, 33));
        btnExportar.setForeground(new java.awt.Color(207, 207, 207));
        btnExportar.setText("Exportar");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addComponent(btnExportar)
                .addGap(15, 15, 15))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(36, 33, 33));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(207, 207, 207));
        jLabel4.setText("Codigo");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(207, 207, 207));
        jLabel2.setText("NIT/CC");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(207, 207, 207));
        jLabel3.setText("Telefono");

        txtTelefono_prov.setBackground(new java.awt.Color(36, 33, 33));
        txtTelefono_prov.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtTelefono_prov.setForeground(new java.awt.Color(207, 207, 207));
        txtTelefono_prov.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(207, 207, 207)));
        txtTelefono_prov.setCaretColor(new java.awt.Color(255, 255, 255));
        txtTelefono_prov.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        txtNit_prov.setBackground(new java.awt.Color(36, 33, 33));
        txtNit_prov.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtNit_prov.setForeground(new java.awt.Color(207, 207, 207));
        txtNit_prov.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(207, 207, 207)));
        txtNit_prov.setCaretColor(new java.awt.Color(255, 255, 255));
        txtNit_prov.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        txtCod_prov.setBackground(new java.awt.Color(36, 33, 33));
        txtCod_prov.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtCod_prov.setForeground(new java.awt.Color(207, 207, 207));
        txtCod_prov.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(207, 207, 207)));
        txtCod_prov.setCaretColor(new java.awt.Color(255, 255, 255));
        txtCod_prov.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCod_prov.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCod_provKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(207, 207, 207));
        jLabel5.setText("Direccion");

        txtDireccion_prov.setBackground(new java.awt.Color(36, 33, 33));
        txtDireccion_prov.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtDireccion_prov.setForeground(new java.awt.Color(207, 207, 207));
        txtDireccion_prov.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(207, 207, 207)));
        txtDireccion_prov.setCaretColor(new java.awt.Color(255, 255, 255));
        txtDireccion_prov.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDireccion_prov.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccion_provKeyTyped(evt);
            }
        });

        txtNombre_prov.setBackground(new java.awt.Color(36, 33, 33));
        txtNombre_prov.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtNombre_prov.setForeground(new java.awt.Color(207, 207, 207));
        txtNombre_prov.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(207, 207, 207)));
        txtNombre_prov.setCaretColor(new java.awt.Color(255, 255, 255));
        txtNombre_prov.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNombre_prov.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombre_provKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(207, 207, 207));
        jLabel6.setText("Nombre");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTelefono_prov, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                    .addComponent(txtNit_prov)
                    .addComponent(txtCod_prov)
                    .addComponent(txtDireccion_prov)
                    .addComponent(txtNombre_prov))
                .addContainerGap(291, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCod_prov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre_prov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion_prov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNit_prov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTelefono_prov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );

        jPanel5.setBackground(new java.awt.Color(36, 33, 33));

        btnNuevo.setBackground(new java.awt.Color(36, 33, 33));
        btnNuevo.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(207, 207, 207));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesForm/nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(36, 33, 33));
        btnGuardar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(207, 207, 207));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesForm/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(36, 33, 33));
        btnEditar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(207, 207, 207));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesForm/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnEditar))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(207, 207, 207));
        jLabel10.setText("PANEL PROVEEDORES");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        /* PASAMOS TXT A DATOS*/

        /*PARTE VALIDACION DE CAMPOS*/
        if (txtNombre_prov.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un Nombre.");
            txtNombre_prov.requestFocus();
            return;
        }

        if (txtDireccion_prov.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debes ingresar una Direccion.");
            txtDireccion_prov.requestFocus();
            return;
        }

        if (txtNit_prov.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un Nit/CC.");
            txtNit_prov.requestFocus();
            return;
        }

        if (txtTelefono_prov.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un Telefono.");
            txtTelefono_prov.requestFocus();
            return;
        }

        Dproveedor datos = new Dproveedor();
        Fproveedor funcion = new Fproveedor();
        
        datos.setnombre_prov(txtNombre_prov.getText());
        datos.setdireccion_prov(txtDireccion_prov.getText());
        datos.settelefono_prov(txtTelefono_prov.getText());
        datos.setnit_prov(txtNit_prov.getText());
        datos.setcod_prov(Integer. parseInt(txtCod_prov.getText()));
        
        if (funcion.editar(datos)) {
            JOptionPane.showMessageDialog(null, "Proveedor Editado.");
            mostrar("");
            inhabilitar();
        } else {
            JOptionPane.showMessageDialog(null, "Proveedor no Editado.");
            mostrar("");

        }



        //  datos.setPrecio_producto(Long.valueOf(txtPrecio.getText()));
        // datos.setPrecio_compra(Long.valueOf(txtPrecio_compra.getText()));


    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        habilitar();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        /*PARTE VALIDACION DE CAMPOS*/
        if (txtNombre_prov.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un Nombre.");
            txtNombre_prov.requestFocus();
            return;
        }

        if (txtDireccion_prov.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debes ingresar una Direccion.");
            txtDireccion_prov.requestFocus();
            return;
        }

        if (txtNit_prov.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un Nit/CC.");
            txtNit_prov.requestFocus();
            return;
        }

        if (txtTelefono_prov.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un Telefono.");
            txtTelefono_prov.requestFocus();
            return;
        }

        Dproveedor datos = new Dproveedor();
        Fproveedor funcion = new Fproveedor();

        datos.setnombre_prov(txtNombre_prov.getText());
        datos.setdireccion_prov(txtDireccion_prov.getText());
        datos.settelefono_prov(txtTelefono_prov.getText());
        datos.setnit_prov(txtNit_prov.getText());

        if (funcion.insertar(datos)) {
            JOptionPane.showMessageDialog(null, "Proveedor Ingresado.");
            mostrar("");
            inhabilitar();
        } else {
            JOptionPane.showMessageDialog(null, "Proveedor no Ingresado.");
            mostrar("");
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaMouseClicked

        habilitar();
        btnGuardar.setEnabled(false);
        btnEditar.setEnabled(true);
        btnNuevo.setEnabled(true);        
        
        txtCod_prov.setEditable(false);
        int fila = jTabla.rowAtPoint(evt.getPoint());

        txtCod_prov.setText(jTabla.getValueAt(fila, 0).toString());
        txtNombre_prov.setText(jTabla.getValueAt(fila, 1).toString());
        txtDireccion_prov.setText(jTabla.getValueAt(fila, 2).toString());
        txtNit_prov.setText(jTabla.getValueAt(fila, 3).toString());
        txtTelefono_prov.setText(jTabla.getValueAt(fila, 4).toString());


    }//GEN-LAST:event_jTablaMouseClicked

    private void txtCod_provKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCod_provKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != evt.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCod_provKeyTyped

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed

        if (jTabla.getRowCount() > 0) {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
            chooser.setFileFilter(filter);
            chooser.setDialogTitle("Guardar archivo");
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                List<JTable> tb = new ArrayList<JTable>();

                List<String> nom = new ArrayList<String>();
                tb.add(jTabla);
                nom.add("Productos");
                String file = chooser.getSelectedFile().toString().concat(".xls");
                try {
                    FrmProducto e = new FrmProducto(new File(file), tb, nom);
                    if (e.export()) {
                        JOptionPane.showMessageDialog(null, "Los datos fueron exportados a excel en el directorio seleccionado", "Mensaje de Informacion", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Hubo un error " + e.getMessage(), " Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay datos para exportar", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExportarActionPerformed

    private void txtDireccion_provKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccion_provKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccion_provKeyTyped

    private void txtNombre_provKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre_provKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre_provKeyTyped

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTabla;
    private javax.swing.JTextField txtCod_prov;
    private javax.swing.JTextField txtDireccion_prov;
    private javax.swing.JTextField txtNit_prov;
    private javax.swing.JTextField txtNombre_prov;
    private javax.swing.JTextField txtTelefono_prov;
    // End of variables declaration//GEN-END:variables
}

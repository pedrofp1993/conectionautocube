/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasockets;
import java.io.*;
import javax.swing.table.DefaultTableModel;
import com.google.gson.Gson;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
/**
 *
 * @author psistemas
 */
public final class Main extends javax.swing.JFrame {
    
    /*
     * Variables que se usaran en mas de una funcion
     */
    
    Autocube c = new Autocube();
    
    DefaultTableModel modelo = new DefaultTableModel(){
        
        boolean[] canEdit = new boolean[]{
                    false, false, false, false, false,false,false, false
            };
        
        @Override
        public boolean isCellEditable(int rowIndex,int columnindex){
            return false;
        }
    };
    
    
    /*
     * Variables de nombres de los archivos
     */
    
    String archivonuevo;
    
    String leepeso;
    
    String direccionalmacenamiento = "C:\\apl\\crg\\";
     
    String leer = "solicitud.txt";
    
    int cantidad_bultos = 0;
    int seleccion_Jpane;
    
    /*
     * Variables de estado de los botones
     */
    
    boolean botonselecionado ;
    
    int estadorb = 0;
    
    JFrame frame1= new JFrame();
    
    String peso = "0";
    
    
    Bulto b = new Bulto();
    
    ArrayList<Bulto> bultos = new ArrayList<>();
    
    InactivityListener il;
    
    InactivityListener al;
   
    JFrame frame = new JFrame();
    
    private static final String ERRORPAQUETE = 
                            "{\"response\":\"Place package on the platform.\"}"; 
    
    private static final String COMMAND_REFUSED = 
                            "{\"info\":\"command refused\"}";
    
    Action desconectar;
    
    Action cerrarFrame;
    
    boolean metodofinalizar = false;
    
    DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
    
        
        
    
    /**
     * Creates new form Main
     */
    public Main() {
        
        
        initComponents(); 
        
        UIManager UI = new UIManager();
        
        UI.put("OptionPane.background", new ColorUIResource(Color.white));
        
        UI.put("Panel.background", new ColorUIResource(Color.white));
        
        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
        
        jScrollPane1.getViewport().setBackground(Color.white);
        
        jScrollPane1.setViewportView(TablaDatos);
        
        this.getContentPane().setBackground(Color.white);

        TablaDatos.setBackground(Color.white);
        
        label1.setBackground(Color.white);
        
        jLabel1.setBackground(Color.white);
        
        jScrollPane1.setBackground(Color.white);
        
        TablaDatos.setRowHeight(30);
        
        TablaDatos.setRowMargin(10);
        
        TablaDatos.add(new JScrollPane());
        
        TablaDatos.setShowGrid(true);
        
        TablaDatos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        TablaDatos.doLayout();
        
        boolean validartiempo = true;
        
        
        BufferedImage image = null;
        
        try {
            
            image = ImageIO.read(new File("C:\\apl\\crg\\AutoCube\\Logo AutoCube.png"));
        
        } catch (IOException ex) {
            
            System.out.println(ex);
            
        }
        
        setIconImage(image);
    
        
        
        this.cerrarFrame = new AbstractAction(){
            
            @Override
            
            public void actionPerformed(ActionEvent e){
                
                try {
                    frame1.dispose();
                    
                    Robot robot = new Robot();
                    
                    robot.keyPress(KeyEvent.VK_ESCAPE);
                } catch (HeadlessException ex) {
                    
                    Logger.getLogger(Main.class.getName()).
                            log(Level.SEVERE, null, ex);
                    
                } catch (AWTException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        
        this.desconectar = new AbstractAction() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    
                    JOptionPane.getRootFrame().dispose();
                    
                    finalizarLectura(false);
                    
                } catch (HeadlessException ex) {
                    
                    Logger.getLogger(Main.class.getName()).
                            log(Level.SEVERE, null, ex);
                    
                } 
            }    
        };
        
        this.il = new InactivityListener
                            (this, desconectar, 30, AWTEvent.MOUSE_EVENT_MASK);
        
        this.al = new InactivityListener
                             (this, cerrarFrame, 1, AWTEvent.MOUSE_EVENT_MASK);
        
        agregarColumnas();
        
        
        
        this.setSize(640,370);
        
        setVisiblefalse();   
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDatos = new javax.swing.JTable();
        jRadioButton2 = new javax.swing.JRadioButton();
        rbConectar = new javax.swing.JRadioButton();
        rbInformacion = new javax.swing.JRadioButton();
        NuevoClientebtn = new javax.swing.JButton();
        LeerBultobtn = new javax.swing.JButton();
        Finalizarbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        label1 = new java.awt.Label();
        jSeparator9 = new javax.swing.JSeparator();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cruz del sur cargo - Cliente Autocube");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(240, 240, 240));
        setResizable(false);
        getContentPane().setLayout(null);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TablaDatos.setBackground(new java.awt.Color(240, 240, 240));
        TablaDatos.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        TablaDatos.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        TablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° objeto", "Ancho", "Alto", "Largo", "Volumen", "Peso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaDatos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        TablaDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TablaDatos.setGridColor(new java.awt.Color(0, 0, 0));
        TablaDatos.setName(""); // NOI18N
        TablaDatos.setSelectionBackground(new java.awt.Color(240, 240, 240));
        TablaDatos.setSelectionForeground(new java.awt.Color(0, 0, 0));
        TablaDatos.setSurrendersFocusOnKeystroke(true);
        TablaDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaDatos);
        if (TablaDatos.getColumnModel().getColumnCount() > 0) {
            TablaDatos.getColumnModel().getColumn(0).setResizable(false);
            TablaDatos.getColumnModel().getColumn(1).setResizable(false);
            TablaDatos.getColumnModel().getColumn(2).setResizable(false);
            TablaDatos.getColumnModel().getColumn(3).setResizable(false);
            TablaDatos.getColumnModel().getColumn(4).setResizable(false);
            TablaDatos.getColumnModel().getColumn(5).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 120, 550, 200);
        jScrollPane1.getAccessibleContext().setAccessibleName("");

        jRadioButton2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jRadioButton2.setSelected(true);
        jRadioButton2.setText("Desconectado");
        jRadioButton2.setToolTipText("");
        jRadioButton2.setIcon(new javax.swing.ImageIcon("C:\\apl\\crg\\AutoCube\\desconectar-circle.png"));
        jRadioButton2.setName("rbDesconectar"); // NOI18N
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2);
        jRadioButton2.setBounds(440, 50, 120, 39);

        rbConectar.setBackground(new java.awt.Color(204, 255, 204));
        rbConectar.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        rbConectar.setText("Conectado");
        rbConectar.setIcon(new javax.swing.ImageIcon("C:\\apl\\crg\\AutoCube\\conectar-circle.png"));
        rbConectar.setMaximumSize(new java.awt.Dimension(103, 25));
        rbConectar.setMinimumSize(new java.awt.Dimension(103, 25));
        rbConectar.setName("rbConectado");
        rbConectar.setPreferredSize(new java.awt.Dimension(103, 25));
        getContentPane().add(rbConectar);
        rbConectar.setBounds(440, 50, 110, 42);

        rbInformacion.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        rbInformacion.setText("En espera");
        rbInformacion.setIcon(new javax.swing.ImageIcon("C:\\apl\\crg\\AutoCube\\esperar-circle.png"));
        getContentPane().add(rbInformacion);
        rbInformacion.setBounds(440, 50, 120, 40);

        NuevoClientebtn.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        NuevoClientebtn.setText("Nueva Lectura");
        NuevoClientebtn.setName("nuevocliente"); // NOI18N
        NuevoClientebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoClienteActionPerformed(evt);
            }
        });
        getContentPane().add(NuevoClientebtn);
        NuevoClientebtn.setBounds(50, 60, 109, 25);

        LeerBultobtn.setText("Leer Bulto");
        LeerBultobtn.setEnabled(false);
        LeerBultobtn.setMaximumSize(new java.awt.Dimension(109, 25));
        LeerBultobtn.setMinimumSize(new java.awt.Dimension(109, 25));
        LeerBultobtn.setPreferredSize(new java.awt.Dimension(109, 25));
        LeerBultobtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeerBultoActionPerformed(evt);
            }
        });
        getContentPane().add(LeerBultobtn);
        LeerBultobtn.setBounds(160, 60, 109, 25);

        Finalizarbtn.setText("Finalizar");
        Finalizarbtn.setEnabled(false);
        Finalizarbtn.setMaximumSize(new java.awt.Dimension(109, 25));
        Finalizarbtn.setMinimumSize(new java.awt.Dimension(109, 25));
        Finalizarbtn.setPreferredSize(new java.awt.Dimension(109, 25));
        Finalizarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinalizarActionPerformed(evt);
            }
        });
        getContentPane().add(Finalizarbtn);
        Finalizarbtn.setBounds(270, 60, 109, 25);

        jLabel1.setText("Opciones");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 30, 90, 14);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(40, 20, 10, 80);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(400, 20, 10, 80);
        getContentPane().add(jSeparator4);
        jSeparator4.setBounds(420, 100, 170, 10);
        getContentPane().add(jSeparator5);
        jSeparator5.setBounds(40, 100, 362, 10);

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator6);
        jSeparator6.setBounds(420, 20, 10, 80);

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator7);
        jSeparator7.setBounds(590, 20, 2, 82);
        getContentPane().add(jSeparator8);
        jSeparator8.setBounds(420, 20, 170, 10);

        label1.setText("Estado");
        getContentPane().add(label1);
        label1.setBounds(440, 30, 43, 20);
        getContentPane().add(jSeparator9);
        jSeparator9.setBounds(40, 20, 360, 10);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /*
     * Boton que leera el archivo solicitud y abrira la conexion como servidor y
     * habilita los demas botones y se deshabilita
     */
    private void NuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoClienteActionPerformed

        int contador= 0;
        int numLineas=2;
        String lineas[]= new String[numLineas];
        
        
        il.start();
        
        String  datoconect;
                
        File archivo = null;
        
        File archivo2;
        
        FileReader fr = null;
        
        BufferedReader br;
        String linea;
        
        try {
            
            archivo = new File(direccionalmacenamiento + leer); 
            
            if(archivo.exists()) {
                
                fr = new FileReader(archivo); 
                
                br = new BufferedReader(fr);
                
                linea = br.readLine();
                while(linea != null && contador < numLineas){
                    lineas[contador] = linea;
                    linea = br.readLine();
                    contador++;
                }
                archivonuevo = lineas[0];
                
                cantidad_bultos = Integer.parseInt(lineas[1]);
                
                if(!archivonuevo.isEmpty()) {
                    
                    datoconect = c.conectarAutocube();
                    
                    if(!datoconect.equals
                            ("Error al conectar Connection refused: connect")) {
                            setEnabledbuttons(1);
                    
                        setEnabledrb(1);
                    } else {
                        
                        JOptionPane.showMessageDialog
                                                (this, "Error con la conexion");         
                    }        
                }
            } else {
                
                JOptionPane.showMessageDialog(this, "El archivo no existe");
                
            }
        } catch(NullPointerException e) {
            
            JOptionPane.showMessageDialog(this, "El archivo no tiene Codigo");
            
            System.out.println(e);
            
        } catch(IOException e) {
            
            System.out.println(e.getMessage());
            
        } finally {  
            
            try {
                
                archivo2 = new File(direccionalmacenamiento + archivo+".csv");
                
                if(archivo2.exists()) {
                    
                    archivo2.delete();
                    
                } if(null != fr) {
                    
                    fr.close();
                    
                }
                
            } catch(IOException e2) {
                
            }
        }
        
    }//GEN-LAST:event_NuevoClienteActionPerformed
    
    /*
     * Boton que realizara la conexion con el servidor, recibira los datos y los
     * añadira al jtable
     */
    private void LeerBultoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeerBultoActionPerformed

            // TODO add your handling code here:
            if(cantidad_bultos > 0){
                try {
                    

                    Gson obj = new Gson();

                    setEnabledrb(2);

                    String lectura = c.leerBulto();

                    double pesoregistro= 0;

                        if(lectura == COMMAND_REFUSED) {
                            finalizarLectura(false);
                                JOptionPane.showMessageDialog(this, "No se ejecuto "
                                                            + "la lectura");
                        }
                        if(lectura == ERRORPAQUETE)
                        {
                            finalizarLectura(false);
                            JOptionPane.showMessageDialog(this, "Ponga el paquete "
                                                            + "en la zona "
                                                            + "de lectura");
                        }
                        b = obj.fromJson(lectura,Bulto.class);
                        if(b.getLength() == 0) {
                            JOptionPane.showMessageDialog(this, "Hubo un error "
                                                            + "en la lectura");
                                } else if(b.getWidth() == 0) {
                                    JOptionPane.showMessageDialog(this, "Hubo un "
                                                             + "error en la lectura");
                                } else if(b.getHeight() == 0){
                                    JOptionPane.showMessageDialog(this, "Hubo un "
                                                            + "error en la lectura");
                                } else if(b.getVolume() == 0){
                                    JOptionPane.showMessageDialog(this, "Hubo un"
                                                            + " error en la lectura");
                                } else if(b.getTimestamp().isEmpty()){
                                    JOptionPane.showMessageDialog(this, "Hubo un"
                                                            + " error en la lectura");
                                } else if(b.getSerialNumber().isEmpty()){
                                    JOptionPane.showMessageDialog(this, "Hubo un"
                                                            + " error en la lectura");
                                }
                                else if(!b.getUnit().equals("cm") || b.getUnit().isEmpty()){
                                    JOptionPane.showMessageDialog(this, "La unidad "
                                                            + "ingresada no es valida");
                                }
                                else{
                                    peso = leerPeso();
                                }
                        
                        if(peso != null ) {
                            try {
                                pesoregistro = Double.parseDouble(peso);
                            } catch(NumberFormatException en) {
                                JOptionPane.showMessageDialog(this,"Se ingresaron "
                                                               + "letras en vez de numeros");
                            }
                            if(pesoregistro > 100 || pesoregistro < 0) {
                                JOptionPane.showMessageDialog(this,"El peso no puede "
                                                            + "ser mayor a 100 "
                                                            + "o menor que 0");
                            } else if(pesoregistro <= 100 && pesoregistro > 0) {
                                b.setWeight(pesoregistro);
                                b.setNumBulto(bultos.size() + 1);
                                agregarBulto();
                                añadirDatosjtable(true);
                                cantidad_bultos--;
                                TableColumn columna = TablaDatos.getColumn("N°");
                                columna.setPreferredWidth(25);
                                TableColumn columna2 = TablaDatos.getColumn("Volumen");
                                columna2.setPreferredWidth(100);
                            }
                            
                        }
                } catch(NullPointerException ex) {
                    JOptionPane.showMessageDialog(this, "No se ejecuto la lectura");
                }
                
                
                
            }else{
                JOptionPane.showMessageDialog(this, "La cantidad de bultos es 0");
                setEnabledbuttons(2);
            }
            if(cantidad_bultos == 0){
                
                setEnabledbuttons(2);
            }
            peso = "0";
    }//GEN-LAST:event_LeerBultoActionPerformed
    
    /*
     * Boton que cerrara las conexiones,habilitar el obonr nuevo cliente,
     * el resto y borrara el jtable
     */
    private void FinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinalizarActionPerformed

        finalizarLectura(true);
                
    }//GEN-LAST:event_FinalizarActionPerformed
    
    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        jRadioButton2.setVisible(false);
    }//GEN-LAST:event_jRadioButton2ActionPerformed
    
    private void TablaDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaDatosMouseClicked
        // TODO add your handling code here:
        int seleccion;
        int filaseleccionada,columnaseleccionada;
        columnaseleccionada = TablaDatos.columnAtPoint(evt.getPoint());
        
        
        

        if(columnaseleccionada == 6){
            seleccion = JOptionPane.showConfirmDialog(null, "¿Realmente desea elimnar el registro?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(seleccion == 0) {
                
               filaseleccionada = TablaDatos.getSelectedRow();

                 for(int i = getBultos().size()-1; i>=0;i--){

                     modelo.removeRow(modelo.getRowCount()-1);

                 }
                 bultos.remove(filaseleccionada);

                 if(filaseleccionada < bultos.size()) {

                     for(int i = filaseleccionada;i<bultos.size();i++) {

                         getBultos().get(i).setNumBulto(getBultos()

                                                        .get(i).getNumBulto()-1);
                     }
                 }
                 añadirDatosjtable(false);
                 cantidad_bultos++;
            setEnabledbuttons(1);
            }
        }
    }//GEN-LAST:event_TablaDatosMouseClicked
    
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
    
    /*
     * Funcion que añadira columnas al jtable
     */
    public void agregarColumnas() {
        
        modelo.addColumn("N°");

        modelo.addColumn("Largo");
        
        modelo.addColumn("Ancho");
        
        modelo.addColumn("Alto");   
        
        modelo.addColumn("Volumen");
        
        modelo.addColumn("Peso");
        
        modelo.addColumn("Eliminar");
        
        
        
    }
    /*
     * Setear estado de los botones
    */
    public void setEnabledbuttons(int alternativa) {
        
        switch(alternativa){
            case 0:
                NuevoClientebtn.setEnabled(true);
            
                LeerBultobtn.setEnabled(false);
            
                Finalizarbtn.setEnabled(false);
                
                break;
            case 1:
                NuevoClientebtn.setEnabled(false);
            
                LeerBultobtn.setEnabled(true);
            
                Finalizarbtn.setEnabled(false);
                
                
                break;
            case 2:
                NuevoClientebtn.setEnabled(false);
            
                LeerBultobtn.setEnabled(false);
            
                Finalizarbtn.setEnabled(true);
                
                break;
            default:
                NuevoClientebtn.setEnabled(true);
            
                LeerBultobtn.setEnabled(false);
            
                Finalizarbtn.setEnabled(false);
                
                break;
        }
    }
    
    /*
     * Setear estado de los radio buttons
    */
    public void setEnabledrb(int alternativa) {

        switch(alternativa){
            
            case 1:
                
                rbConectar.setVisible(true);
                
                jRadioButton2.setVisible(false);
                
                rbInformacion.setVisible(false);
                
            break;
            
            case 2:
                
                rbConectar.setVisible(false);
                
                jRadioButton2.setVisible(false);
                
                rbInformacion.setVisible(true);
                
            break;
            
            case 3:
                
                rbConectar.setVisible(false);
                
                jRadioButton2.setVisible(true);
                
                rbInformacion.setVisible(false);
                
            break;
            
            default:
                
                rbConectar.setVisible(false);
                
                jRadioButton2.setVisible(false);
                
                rbInformacion.setVisible(false);
                
        }
    }
    /*
     * Funcion que añadira los datos adquiridos al jtable
     */
    public void añadirDatosjtable(boolean llenar) {  
            try {

                TablaDatos.setModel(modelo);
                
                if(llenar == true) {
                    for(int i = 0; i < getBultos().size();i++)
                    {
                        if(i+1 ==  getBultos().size()) {
                            String[] data = {
                            
                                String.valueOf(getBultos().get(i).getNumBulto()),
                                
                                String.valueOf(getBultos().get(i).getLength())
                                        + " cm",
                                
                                String.valueOf(getBultos().get(i).getWidth())
                                        + " cm",
                                
                                String.valueOf(getBultos().get(i).getHeight())
                                        + " cm",
                                
                                String.valueOf(getBultos().get(i).getVolume())
                                        + " dm3",
                                
                                String.valueOf(getBultos().get(i).getWeight())
                                        + " Kg"
                                
                            };
                           
                            modelo.addRow(data);
                            
                            modelo.setValueAt("Eliminar",i,6);
                            
                            TablaDatos.getColumnModel().getColumn(i).setCellRenderer(tcr);
                            
                        }
                    }
                } else {
                    for(int i = 0; i < getBultos().size();i++) {
                        
                        String[] data = {
                            
                            String.valueOf(getBultos().get(i).getNumBulto())
                                        ,
                            
                            String.valueOf(getBultos().get(i).getLength())
                                        + " cm",
                            
                            String.valueOf(getBultos().get(i).getWidth())
                                        + " cm",
                            
                            String.valueOf(getBultos().get(i).getHeight())
                                        + " cm",
                            
                            String.valueOf(getBultos().get(i).getVolume())
                                        + " dm3",
                            
                            String.valueOf(getBultos().get(i).getWeight())
                                        + " Kg"
                                
                        };
                        
                        modelo.addRow(data);
                        
                        modelo.setValueAt("Eliminar",i,6);
                        
                        
                        
                        
                    }
                }
                for(int i = 0;i<7;i++) {
                    TablaDatos.getColumnModel().getColumn(i).setCellRenderer(tcr);
                }
            } catch(NullPointerException e) {
                System.out.println("Error con los datos"+ e.getMessage());
            }
            TablaDatos.getColumn("Eliminar").setCellRenderer(new DefaultTableCellRenderer(){
                @Override
                public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row,int column){
                    Component comp=super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
                    
                    comp.setBackground(Color.red);
                    comp.setForeground(Color.white);
                    return comp;
                }});
             
            
    }
    
    /*
     * Funcion que creara el archivo csv e introducira los datos adquiridos
     */
    public void registrarBultos() {
        
        try{
            
            File archivo = new File(direccionalmacenamiento + archivonuevo+".csv");
            
            if(archivo.exists()) { 
                
                archivo.delete();
                
            }
            
            try (FileWriter csvoutput = new FileWriter(archivo)) {
                for(int i = 0; i < getBultos().size(); i++){
                    
                    csvoutput.write(String.valueOf(getBultos().
                                                     get(i).getNumBulto())+',');
                    
                    csvoutput.write(String.valueOf(getBultos().
                                                     get(i).getLength())+',');
                    
                    csvoutput.write(String.valueOf(getBultos().
                                                     get(i).getWidth())+',');
                    
                    csvoutput.write(String.valueOf(getBultos().
                                                     get(i).getHeight())+',');
                    
                    csvoutput.write(getBultos().get(i).getUnit()+',');
                    
                    csvoutput.write(String.valueOf(getBultos().
                                                     get(i).getVolume())+',');
                    
                    csvoutput.write(String.valueOf(getBultos().
                                                     get(i).getWeight())+',');
                    
                    csvoutput.write(getBultos().get(i).getSerialNumber()+',');
                    
                    csvoutput.write(getBultos().get(i).getTimestamp() + "\n");
                    
                    
                }}
           
        }catch(NullPointerException e) {
            
                    System.out.println("Error con los datos"+ e.getMessage());
                    
        } catch(IOException e) {
            
        }
    }
    
    /*
     * Funcion para cerrar la conexion
    */
    public void finalizarLectura(boolean metfin) {
        
        System.out.println(archivonuevo);
        
        if(metfin == true && getBultos().size() > 0){
            
            File fichero = new File(direccionalmacenamiento +leer);
            
            fichero.delete();
            
            registrarBultos();
            
        }
        try {
            
            c.desconectarAutocube();
            
        } catch (Exception ex) {
            
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        setEnabledbuttons(0);
        
        setEnabledrb(3);
        
        for(int i = getBultos().size()-1; i>=0;i--) {
            
            bultos.remove(i);
            
            modelo.removeRow(modelo.getRowCount()-1);
            
        }       
    }
    
    /*
     * Funcion para leer peso
     */
    public String leerPeso() {
        al.start();
        leepeso = "0";
        int cantidad_interaccion = 0;
        while(leepeso.equals("0")){
            if(cantidad_interaccion == 0){
                leepeso = JOptionPane.showInputDialog(frame1,"Digite el peso");
            } else {
                JOptionPane.showMessageDialog(this, "El peso no puede ser 0");
                leepeso = JOptionPane.showInputDialog(frame1,"ingrese peso valido");
            }
            cantidad_interaccion++;
        }
        
        return leepeso;
       
    }
    
    /*
     * Añade un objeto al array
    */
    public void agregarBulto() {
        
       bultos.add(b);
       
    }
    
   /*
    * Obtiene el arraylist para el main
    */
    public ArrayList<Bulto> getBultos() {
        
       return bultos;
       
    }
   
   /*
    * Obtiene la clase bulto para el main
    */
    public Bulto getBulto() {
        
       return b;
       
    }
    
    public void setVisiblefalse() {
        
        rbConectar.setVisible(false);
        
        rbInformacion.setVisible(false);
        
    }
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Finalizarbtn;
    private javax.swing.JButton LeerBultobtn;
    private javax.swing.JButton NuevoClientebtn;
    private javax.swing.JTable TablaDatos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField jTextField1;
    private java.awt.Label label1;
    private javax.swing.JRadioButton rbConectar;
    private javax.swing.JRadioButton rbInformacion;
    // End of variables declaration//GEN-END:variables

  
}

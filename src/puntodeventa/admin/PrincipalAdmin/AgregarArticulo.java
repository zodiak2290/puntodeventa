/*     */ package puntodeventa.admin.PrincipalAdmin;
/*     */ 
import BaseDatos.BaseDatos;
import BaseDatos.ConsultaBaseDatos;
import BaseDatos.InsertBaseDatos;
import Consultas.Consultas;
import FabricadeVentanas.Ventanas.Ventana;
/*     */ import java.awt.EventQueue;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.FocusAdapter;
/*     */ import java.awt.event.FocusEvent;
          import java.awt.event.WindowEvent;
          import java.awt.event.WindowListener;
/*     */ import java.io.IOException;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JMenu;
/*     */ import javax.swing.JMenuBar;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import org.netbeans.lib.awtextra.AbsoluteConstraints;
/*     */ import org.netbeans.lib.awtextra.AbsoluteLayout;
/*     */ import puntodeventa.inicio.conexioninicio;
/*     */ 
/*     */ public class AgregarArticulo extends JFrame implements Ventana
/*     */ {
            private static AgregarArticulo instancia = null;
/*  26 */   ArrayList a = new ArrayList();
/*  27 */   ArrayList mar = new ArrayList();
/*     */   private JTextField canti;
/*     */   private JTextField cb;
/*     */   private JComboBox dep;
/*     */   private JTextField desc;
/*     */   private JButton guardar;
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JButton jButton3;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel10;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JLabel jLabel6;
/*     */   private JLabel jLabel7;
/*     */   private JLabel jLabel8;
/*     */   private JLabel jLabel9;
/*     */   private JMenu jMenu1;
/*     */   private JMenu jMenu2;
/*     */   private JMenuBar jMenuBar1;
/*     */   private JMenuItem jMenuItem1;
/*     */   private JPanel jPanel1;
/*     */   private JTextField jTextField2;
/*     */   private JComboBox marca;
/*     */   private JTextField med;
/*     */   private JTextField name;
/*     */   private JTextField nombmarfv;
/*     */   private JTextField precicompra;
/*     */   private JTextField precio;
/*     */ 
/*     */   private AgregarArticulo()
/*     */   {
               this.addWindowListener(new WindowListener(){
            public void windowActivated(WindowEvent e){}
            public void windowClosed(WindowEvent e){
            instancia=null;
            }
            public void windowDeactivated(WindowEvent e){}
            public void windowDeiconified(WindowEvent e){}
            public void windowIconified(WindowEvent e){}
            public void windowOpened(WindowEvent e){}
            public void windowClosing(WindowEvent e){
                System.out.println("Cerrando ventana...");
                e.getWindow().dispose();
            }
        });
/*  30 */     setUndecorated(true);
/*  31 */     initComponents();
/*  32 */     setSize(660, 410);
/*  33 */     setResizable(false);
/*  34 */     setLocationRelativeTo(null);
/*  35 */     getRootPane().setDefaultButton(this.guardar);
/*     */   }
/*     */public static AgregarArticulo getInstancia() {
		if (instancia == null) {
			instancia = new AgregarArticulo();
                         inciarAgregarProd();
			}
                else{
                    instancia.toFront();
                }
		return instancia;
	}
/*     */   private void initComponents()
/*     */   {
/*  47 */     this.jPanel1 = new JPanel();
/*  48 */     this.jLabel1 = new JLabel();
/*  49 */     this.jLabel2 = new JLabel();
/*  50 */     this.jLabel3 = new JLabel();
/*  51 */     this.jLabel4 = new JLabel();
/*  52 */     this.jLabel5 = new JLabel();
/*  53 */     this.marca = new JComboBox();
/*  54 */     this.dep = new JComboBox();
/*  55 */     this.guardar = new JButton();
/*  56 */     this.cb = new JTextField();
/*  57 */     this.name = new JTextField();
/*  58 */     this.med = new JTextField();
/*  59 */     this.precio = new JTextField();
/*  60 */     this.desc = new JTextField();
/*  61 */     this.jLabel6 = new JLabel();
/*  62 */     this.nombmarfv = new JTextField();
/*  63 */     this.jButton1 = new JButton();
/*  64 */     this.jLabel7 = new JLabel();
/*  65 */     this.jTextField2 = new JTextField();
/*  66 */     this.jButton2 = new JButton();
/*  67 */     this.jButton3 = new JButton();
/*  68 */     this.jLabel8 = new JLabel();
/*  69 */     this.precicompra = new JTextField();
/*  70 */     this.jLabel9 = new JLabel();
/*  71 */     this.canti = new JTextField();
/*  72 */     this.jLabel10 = new JLabel();
/*  73 */     this.jMenuBar1 = new JMenuBar();
/*  74 */     this.jMenu1 = new JMenu();
/*  75 */     this.jMenuItem1 = new JMenuItem();
/*  76 */     this.jMenu2 = new JMenu();
/*     */ 
/*  78 */     setDefaultCloseOperation(3);
/*  79 */     getContentPane().setLayout(new AbsoluteLayout());
/*     */ 
/*  81 */     this.jPanel1.setLayout(new AbsoluteLayout());
/*     */ 
/*  83 */     this.jLabel1.setText("Codigo de barras");
/*  84 */     this.jPanel1.add(this.jLabel1, new AbsoluteConstraints(48, 52, -1, -1));
/*     */ 
/*  86 */     this.jLabel2.setText("Nombre");
/*  87 */     this.jPanel1.add(this.jLabel2, new AbsoluteConstraints(316, 52, -1, -1));
/*     */ 
/*  89 */     this.jLabel3.setText("Medida");
/*  90 */     this.jPanel1.add(this.jLabel3, new AbsoluteConstraints(40, 100, -1, -1));
/*     */ 
/*  92 */     this.jLabel4.setText("Precio  Venta (Al cliente) $");
/*  93 */     this.jPanel1.add(this.jLabel4, new AbsoluteConstraints(170, 100, -1, -1));
/*     */ 
/*  95 */     this.jLabel5.setText("Descripcion");
/*  96 */     this.jPanel1.add(this.jLabel5, new AbsoluteConstraints(27, 156, -1, -1));
/*     */ 
/*  98 */     this.marca.addFocusListener(new FocusAdapter() {
/*     */       public void focusGained(FocusEvent evt) {
/* 100 */         AgregarArticulo.this.marcaFocusGained(evt); }
/*     */ 
/*     */     });
/* 106 */     this.jPanel1.add(this.marca, new AbsoluteConstraints(102, 204, -1, -1));
/*     */ 
/* 108 */     this.dep.addFocusListener(new FocusAdapter() {
/*     */       public void focusGained(FocusEvent evt) {
/* 110 */         AgregarArticulo.this.depFocusGained(evt);
/*     */       }
/*     */     });
/* 113 */     this.jPanel1.add(this.dep, new AbsoluteConstraints(390, 210, -1, -1));
/*     */ 
/* 115 */     this.guardar.setText("Guardar Producto");
/* 116 */     this.guardar.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 118 */         AgregarArticulo.this.guardarActionPerformed(evt);
/*     */       }
/*     */     });
/* 121 */     this.jPanel1.add(this.guardar, new AbsoluteConstraints(520, 50, -1, -1));
/* 122 */     this.jPanel1.add(this.cb, new AbsoluteConstraints(140, 49, 166, -1));
/* 123 */     this.jPanel1.add(this.name, new AbsoluteConstraints(371, 49, 92, -1));
/* 124 */     this.jPanel1.add(this.med, new AbsoluteConstraints(80, 100, 74, -1));
/* 125 */     this.jPanel1.add(this.precio, new AbsoluteConstraints(310, 100, 70, -1));
/* 126 */     this.jPanel1.add(this.desc, new AbsoluteConstraints(140, 153, 213, -1));
/*     */ 
/* 128 */     this.jLabel6.setText("Nueva Marca");
/* 129 */     this.jPanel1.add(this.jLabel6, new AbsoluteConstraints(27, 275, -1, -1));
/* 130 */     this.jPanel1.add(this.nombmarfv, new AbsoluteConstraints(140, 272, 127, -1));
/*     */ 
/* 132 */     this.jButton1.setText("Guadar");
/* 133 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 135 */         AgregarArticulo.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */     });
/* 138 */     this.jPanel1.add(this.jButton1, new AbsoluteConstraints(285, 271, -1, -1));
/*     */ 
/* 140 */     this.jLabel7.setText("Nuevo Departamento");
/* 141 */     this.jPanel1.add(this.jLabel7, new AbsoluteConstraints(27, 328, -1, -1));
/* 142 */     this.jPanel1.add(this.jTextField2, new AbsoluteConstraints(140, 325, 127, -1));
/*     */ 
/* 144 */     this.jButton2.setText("Guardar");
/* 145 */     this.jButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 147 */         AgregarArticulo.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */     });
/* 150 */     this.jPanel1.add(this.jButton2, new AbsoluteConstraints(285, 324, -1, -1));
/*     */ 
/* 152 */     this.jButton3.setText("Regresar");
/* 153 */     this.jButton3.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 155 */         AgregarArticulo.this.jButton3ActionPerformed(evt);
/*     */       }
/*     */     });
/* 158 */     this.jPanel1.add(this.jButton3, new AbsoluteConstraints(190, 360, 100, -1));
/*     */ 
/* 160 */     this.jLabel8.setText("Precio de Compra (Del proveedor) $");
/* 161 */     this.jPanel1.add(this.jLabel8, new AbsoluteConstraints(400, 100, -1, -1));
/* 162 */     this.jPanel1.add(this.precicompra, new AbsoluteConstraints(600, 90, 50, -1));
/*     */ 
/* 164 */     this.jLabel9.setText("Cantidad en Almacen  ");
/* 165 */     this.jPanel1.add(this.jLabel9, new AbsoluteConstraints(400, 150, -1, -1));
/* 166 */     this.jPanel1.add(this.canti, new AbsoluteConstraints(530, 140, 60, -1));
/*     */ 
/* 168 */     this.jLabel10.setIcon(new ImageIcon(super.getClass().getResource("/puntodeventa/admin/images/fondo.png")));
/* 169 */     this.jLabel10.setText("jLabel10");
/* 170 */     this.jPanel1.add(this.jLabel10, new AbsoluteConstraints(0, 0, 680, 390));
/*     */ 
/* 172 */     getContentPane().add(this.jPanel1, new AbsoluteConstraints(0, 0, 680, 390));
/*     */ 
/* 174 */     this.jMenu1.setText("Productos");
/*     */ 
/* 176 */     this.jMenuItem1.setText("Lista de productos");
/* 177 */     this.jMenu1.add(this.jMenuItem1);
/*     */ 
/* 179 */     this.jMenuBar1.add(this.jMenu1);
/*     */ 
/* 181 */     this.jMenu2.setText("Edit");
/* 182 */     this.jMenuBar1.add(this.jMenu2);
/*     */ 
/* 184 */     setJMenuBar(this.jMenuBar1);
/*     */ 
/* 186 */     pack();
/*     */   }
/*     */ 
/*     */   private void marcaFocusGained(FocusEvent evt) {
/* 190 */     this.marca.removeAllItems();
/* 191 */     this.mar.clear();
            try {
/* 195 */       BaseDatos realizaCons=new ConsultaBaseDatos(new Consultas().getListaMarcas()); 
                int cantidadColumnas=realizaCons.getResultSetMetaData().getColumnCount();
/* 207 */       while (realizaCons.getResultSet().next()) {
/* 208 */         Object[] fila = new Object[cantidadColumnas];
/* 209 */         for (int i = 1; i < cantidadColumnas; ++i) {
/* 210 */           this.marca.addItem(realizaCons.getResultSet().getObject(i + 1));
/* 211 */           this.mar.add(realizaCons.getResultSet().getString("idmarca"));
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 220 */       JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void depFocusGained(FocusEvent evt)
/*     */   {
/* 226 */     this.dep.removeAllItems();
/* 227 */     this.a.clear();
/*     */     try {
/* 231 */        BaseDatos realizaCons=new ConsultaBaseDatos(new Consultas().getListaDep()); 
                int cantidadColumnas=realizaCons.getResultSetMetaData().getColumnCount();
/* 243 */       while (realizaCons.getResultSet().next()) {
/* 244 */         Object[] fila = new Object[cantidadColumnas];
/* 245 */         this.a.add(realizaCons.getResultSet().getString("iddepartamento"));
/* 246 */         for (int i = 1; i < cantidadColumnas; ++i) {
/* 247 */           this.dep.addItem(realizaCons.getResultSet().getObject(i + 1));
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 258 */       JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jButton1ActionPerformed(ActionEvent evt)
/*     */   {
/*     */     try
/*     */     {
/* 267 */       if (this.nombmarfv.getText().length() > 0)
/*     */       {
/* 270 */         conexioninicio ci = new conexioninicio();
/* 271 */         Connection con = null;
/*     */        BaseDatos bd2=new InsertBaseDatos(new Consultas().getInsertMarca(this.nombmarfv.getText()));
                 JOptionPane.showMessageDialog(null, "Registro exitoso!", "", 0);
                 this.nombmarfv.setText("");
                }
/*     */       else
/*     */       {
/* 291 */         JOptionPane.showMessageDialog(null, "Escriba el nombre de la marca.\n");
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */   }
/*     */ 
/*     */   private void jButton2ActionPerformed(ActionEvent evt)
/*     */   {
/*     */       if (this.jTextField2.getText().length() > 0) {
                    BaseDatos inserta=new InsertBaseDatos(new Consultas().getInsertarDepartamento(this.jTextField2.getText()));    
                 JOptionPane.showMessageDialog(null, "Registro exitoso!", "", 0);
                 this.jTextField2.setText(""); 
                } 
                else {
                 JOptionPane.showMessageDialog(null, "Ingrese el nombre del departamento", "", 0);
                }
   }
/*     */ 
/*     */   private void guardarActionPerformed(ActionEvent evt)
/*     */   {
/*     */     Aceptar();
/*     */   }
/*     */ 
/*     */   private void jButton3ActionPerformed(ActionEvent evt)
/*     */   {
/* 385 */     Cancelar();
/*     */   }
/*     */   boolean verificarProducto(String elUsr, String elPw) throws IOException
/*     */   {
/*     */     try {
/* 395 */       conexioninicio ci = new conexioninicio();
/*     */ 
/* 397 */       Connection con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/*     */ 
/* 399 */       Statement instruccionSQL = con.createStatement();
/* 400 */       ResultSet resultadosConsulta = instruccionSQL.executeQuery("SELECT * FROM marca WHERE nombremar='" + elUsr + "' AND iddepartamento='" + elPw + "'");
/*     */ 
/* 403 */       return (resultadosConsulta.first());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
/*     */ 
/* 409 */     return false;
/*     */   }
/*     */   private  static void  inciarAgregarProd()
/*     */   {
/* 417 */     EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 419 */         new AgregarArticulo().setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ 
           boolean verificarCo(String co) throws IOException
           {;
               boolean codigocorrecto=false;
                try {
                    BaseDatos realizaCons=new ConsultaBaseDatos(new Consultas().getArticuloEspecifico(co));
                    codigocorrecto= (realizaCons.getResultSet().first());
                } catch (SQLException ex) {
                    Logger.getLogger(AgregarArticulo.class.getName()).log(Level.SEVERE, null, ex);
                }
                return codigocorrecto;
            }


    public void Aceptar() {
        try
/*     */     {
/* 332 */       if ((this.cb.getText().length() > 0) && (this.name.getText().length() > 0) && (this.med.getText().length() > 0) && (this.precio.getText().length() > 0) && (this.precicompra.getText().length() > 0) && (this.canti.getText().length() > 0))
/*     */       {
/* 335 */         if (!(verificarCo(this.cb.getText())))
                     { 
                    BaseDatos inserta=new InsertBaseDatos(new Consultas().getInsertarProducto(this.cb.getText(),this.mar.get(this.marca.getSelectedIndex()),this.name.getText(),this.desc.getText(),this.med.getText(),this.a.get(this.dep.getSelectedIndex())));
                    JOptionPane.showMessageDialog(null, "Registro exitoso!", "", 0);
                    new Almacen().recibirCodigoB(this.cb.getText().toUpperCase(), Integer.parseInt(this.canti.getText()));
                    new Almacen().recibirCodigoInv(this.cb.getText().toUpperCase(), Float.parseFloat(this.precio.getText()));
                    new Almacen().recibirCodigoCompra(this.cb.getText().toUpperCase(), Float.parseFloat(this.precicompra.getText()), Integer.parseInt(this.canti.getText()));
                    this.cb.setText("");
                    this.name.setText("");
                    this.canti.setText("");
                    this.med.setText("");
                    this.precio.setText("");
                    this.precicompra.setText("");
                }
/*     */         else
/*     */         {
/* 368 */           JOptionPane.showMessageDialog(null, "El codigo ya se encuentra registrado");
/*     */         }
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 375 */         JOptionPane.showMessageDialog(null, "Ingrese los datos completos de  Producto.\n");
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */     }
    }

    public void Cancelar() {
        dispose();
    }
 }


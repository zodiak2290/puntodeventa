/*    */ package puntodeventa.admin.PrincipalAdmin;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.sql.SQLException;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ import javax.swing.JOptionPane;
/*    */ import org.jfree.chart.ChartFactory;
/*    */ import org.jfree.chart.ChartFrame;
/*    */ import org.jfree.chart.JFreeChart;
/*    */ import org.jfree.chart.plot.PlotOrientation;
/*    */ import org.jfree.data.jdbc.JDBCCategoryDataset;
/*    */ import puntodeventa.inicio.conexioninicio;
/*    */ 
/*    */ public class GeneraGrafica
/*    */ {
/*    */   String query;
/*    */   JDBCCategoryDataset dataset;
/*    */   String nombreven;
/*    */   String etiqhoriz;
/*    */   String etiverti;
/*    */   String namegrafi;
/*    */   int buton;
/*    */ 
/*    */   public void recibirparametros(String cons, String nomven, String ehor, String ever, int buton, String namegra)
/*    */   {
/* 31 */     this.query = cons;
/* 32 */     this.nombreven = nomven;
/* 33 */     this.etiqhoriz = ehor;
/* 34 */     this.etiverti = ever;
/* 35 */     this.namegrafi = namegra;
/* 36 */     this.buton = buton;
/* 37 */     generar();
/*    */   }
/*    */ 
/*    */   public void generar()
/*    */   {
/* 42 */     conexioninicio ci = new conexioninicio();
/* 43 */     Connection con = null;
/*    */     try {
/* 45 */       con = DriverManager.getConnection(ci.getURl(), ci.getLogin(), ci.getPassword());
/*    */     } catch (SQLException ex) {
/* 47 */       Logger.getLogger(GeneraGrafica.class.getName()).log(Level.SEVERE, null, ex);
/*    */     }
/*    */ 
/*    */     try
/*    */     {
/* 52 */       this.dataset = new JDBCCategoryDataset(con, this.query);
/*    */     } catch (Exception e) {
/* 54 */       JOptionPane.showMessageDialog(null, e);
/*    */     }
/*    */     JFreeChart chart;
/*    */     ChartFrame frame;
/* 58 */     if (this.buton == 0)
/*    */     {
/* 62 */       chart = ChartFactory.createLineChart(this.namegrafi, this.etiqhoriz, this.etiverti, this.dataset, PlotOrientation.VERTICAL, true, true, true);
/*    */ 
/* 64 */       frame = new ChartFrame(this.nombreven, chart);
/* 65 */       frame.setVisible(true);
/* 66 */       frame.setSize(600, 600);
/*    */     } else {
/* 68 */       if (this.buton != 1) {
/*    */         return;
/*    */       }
/* 71 */       chart = ChartFactory.createBarChart(this.namegrafi, this.etiqhoriz, this.etiverti, this.dataset, PlotOrientation.VERTICAL, true, true, true);
/*    */ 
/* 73 */       frame = new ChartFrame(this.nombreven, chart);
/* 74 */       frame.setVisible(true);
/* 75 */       frame.setSize(600, 600);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\pc\Desktop\Punto de venta\dist\PuntodeVenta.jar
 * Qualified Name:     puntodeventa.admin.PrincipalAdmin.GeneraGrafica
 * JD-Core Version:    0.5.3
 */
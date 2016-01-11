/*    */ package puntodeventa.admin.PrincipalAdmin;
/*    */ 
/*    */ import java.io.FileWriter;
/*    */ import java.io.PrintStream;
/*    */ import java.io.PrintWriter;
/*    */ 
/*    */ public class Respaldo
/*    */ {
/*    */   private int BUFFER;
/*    */   private StringBuffer temp;
/*    */   private FileWriter fichero;
/*    */   private PrintWriter pw;
/*    */ 
/*    */   public Respaldo()
/*    */   {
/* 16 */     this.BUFFER = 10485760;
/*    */ 
/* 18 */     this.temp = null;
/*    */ 
/* 20 */     this.fichero = null;
/* 21 */     this.pw = null;
/*    */   }
/*    */ 
/*    */   public boolean backupDB(String dbName, String dbUserName, String dbPassword, String path) {
/* 25 */     String executeCmd = "mysqldump -u " + dbUserName + " -p" + dbPassword + " --add-drop-database -B " + dbName + " -r " + path;
/*    */     try
/*    */     {
/* 29 */       Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
/* 30 */       int processComplete = runtimeProcess.waitFor();
/*    */ 
/* 32 */       if (processComplete == 0) {
/* 33 */         System.out.println("Backup created successfully");
/* 34 */         return true;
/*    */       }
/* 36 */       System.out.println("Could not create the backup");
/*    */     }
/*    */     catch (Exception ex) {
/* 39 */       System.out.println(ex.getMessage());
/*    */     }
/*    */ 
/* 42 */     return false;
/*    */   }
/*    */ }

/* Location:           C:\Users\pc\Desktop\Punto de venta\dist\PuntodeVenta.jar
 * Qualified Name:     puntodeventa.admin.PrincipalAdmin.Respaldo
 * JD-Core Version:    0.5.3
 */
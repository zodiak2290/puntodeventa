/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

/**
 *
 * @author mipc
 */
public class Consultas {
    String listaestados="SELECT * FROM tienda.estado WHERE idestado>4;";
    String listamarcas="SELECT * FROM tienda.marca ";
    String listadep="SELECT * FROM tienda.departamento order by nombredep ;";
    public String getInsertMarca(String nombremar){
        return "insert into tienda.marca(idmarca,nombremar) values(NULL,'" + nombremar.toUpperCase() + "')";
    }
    public String getListaEstados(){
        return listaestados;
    }
    public String getListaDep(){
        return listadep;
    }
    public String getInsertPersona(String curp,String nombre,String apPat,String apMat,String calle,String colonia,String num,String municipio,Object idestado,String cp,String email,String telefono){
        return "insert into tienda.persona(curp ,nombre ,apPat,apMat ,calle,"
                + "colonia,numExt,municipio,idestado,cp ,email ,numTel,status,nacimiento,foto,sexo ) "
                + "values('"+curp.toUpperCase()+"','"+ nombre.toUpperCase()+"','"+
                apPat.toUpperCase()+"','"+ apMat.toUpperCase()+"','"+ calle.toUpperCase()+"','"+ colonia.toUpperCase()+"','"+ num.toUpperCase()+"','"+ municipio.toUpperCase()+"','"+ 
                idestado+"','"+ cp+"','"+ email+"','"+ telefono+"','1',CURRENT_DATE,'null','1')";
    }
    public String getInsertAdmin(String idamin,String curp,String pass){
       return "insert into tienda.admin(idadmon ,curp ,contraseña,fechainicio)"
               + " values('"+idamin+"','"+ curp.toUpperCase()+"','"+pass+"',"+ "CURRENT_DATE)";
    }
    public String getListaMarcas(){
        return listamarcas;
    }
    public String getArticuloEspecifico(String codigobarras){
        return "SELECT * FROM articulo WHERE codigobarras='" + codigobarras + "'";
    }
    public String getInsertarDepartamento(String nombredep){
        return "insert into tienda.departamento(iddepartamento,nombredep) values(NULL,'" + nombredep.toUpperCase() + "')";
    }
    public String getInsertarProducto(String cb,Object marca,String nombreArt,String descrip,String medida,Object iddep){
        return "insert into tienda.articulo(codigobarras ,idmarca ,nombreart,descripcion ,medida,iddepartamento)"
                + " values('"+cb.toUpperCase() + "','" + marca + "','"+nombreArt.toUpperCase()+ "','"+descrip.toUpperCase()+"','"+medida+"','"+iddep+ "')";
/* 344 */             
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessModelLayer;

import DataAccessLayer.DataAccess;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FOSTER
 */
public class Producto {

    private DataAccess dataAccess = DataAccess.Instance();
    private int idProducto;
    private int idCategoria;
    private String nombre;
    private double precio;
    private Date caducidad;
    private double descuento;
    private int activo;

    public Producto() {
        activo = 1;
    }

    public Producto(int idProducto, int idCategoria, String nombre, double precio, Date caducidad, double descuento) {
        this.idProducto = idProducto;
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.precio = precio;
        this.caducidad = caducidad;
        this.descuento = descuento;
        activo = 1;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(Date caducidad) {
        this.caducidad = caducidad;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public DefaultTableModel GetAllModel() {
        String query = "SELECT p.idProducto 'ID', p.nombre 'Producto', c.nombre 'Categoria', p.precio 'Precio', p.caducidad 'Caducidad', p.descuento 'Descuento' "
                + "FROM productos p "
                + "INNER JOIN categorias c ON p.idCategoria = c.idCategoria "
                + "WHERE p.activo = 1";
        return dataAccess.Query(query);
    }

    public DefaultTableModel Asc() {
        String query = "SELECT p.idProducto 'ID', p.nombre 'Producto', c.nombre 'Categoria', p.precio 'Precio', p.caducidad 'Caducidad', p.descuento 'Descuento' "
                + "FROM productos p "
                + "INNER JOIN categorias c ON p.idCategoria = c.idCategoria "
                + "WHERE p.activo = 1"
                + "ORDER  BY p.nombre ASC";
        return dataAccess.Query(query);
    }

    public void GetById() {
        String query = "SELECT * FROM productos WHERE idProducto = " + idProducto;
        DefaultTableModel res = dataAccess.Query(query);
        idProducto = (int) res.getValueAt(0, 0);
        idCategoria = (int) res.getValueAt(0, 1);
        nombre = (String) res.getValueAt(0, 2);
        descuento = Double.parseDouble(String.valueOf(res.getValueAt(0, 3)));
        precio = Double.parseDouble(String.valueOf(res.getValueAt(0, 4)));
        caducidad = (Date) res.getValueAt(0, 5);
    }

    public boolean Add() {
        //INSERT INTO TABLA (C1, C2) VALUES (V1, V2);
        String query = "INSERT INTO productos(nombre,idCategoria, precio, caducidad, descuento, activo) "
                + "VALUES('" + nombre + "'," + idCategoria + "," + precio + ",'" + caducidad + "'," + descuento + "," + activo + ");";
        return dataAccess.Execute(query) >= 1;
    }

    public boolean Delete() {
        String query = "DELETE FROM productos WHERE idProducto = " + idProducto;
        return dataAccess.Execute(query) >= 1;
    }

    /*
    public boolean DeleteFK() {
        String query = "DELETE FROM productos WHERE id_Farmacia = " + idFarmacia;
        return dataAccess.Execute(query) >= 1;
    }
     */
    public boolean Update() {
        String query = "UPDATE productos SET "
                + "nombre = '" + nombre + "', "
                + "idCategoria = " + idCategoria + ", "
                + "precio = " + precio + ", "
                + "caducidad = '" + caducidad + "', "
                + "descuento = " + descuento + ", "
                + "activo = " + activo + " "
                + "WHERE idProducto = " + idProducto;
        return dataAccess.Execute(query) >= 1;
    }

    public DefaultTableModel Search(String buscar) {
        String query = "SELECT p.idProducto 'ID', p.nombre 'Producto', c.nombre 'Categoria', p.precio  'Precio', p.caducidad  'Caducidad', p.descuento 'Descuento'  "
                + "FROM productos p "
                + "INNER JOIN categorias c ON p.idCategoria = c.idCategoria "
                + "WHERE p.activo = 1 AND p.nombre LIKE '%" + buscar + "%' ";
        return dataAccess.Query(query);
    }

}

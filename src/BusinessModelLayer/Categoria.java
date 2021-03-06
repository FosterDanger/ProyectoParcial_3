/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessModelLayer;

import DataAccessLayer.DataAccess;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FOSTER
 */
public class Categoria {

    private DataAccess dataAccess = DataAccess.Instance();
    private int idCategoria;
    private String nombre;
    private int activo;

    public Categoria() {
    }

    public Categoria(int idCategoria, String nombre) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        activo = 1;
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

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public String toString() {
        return nombre;
    }

    public DefaultTableModel GetAllModel() {
        String query = "SELECT idCategoria 'ID', nombre 'Categoria' FROM categorias WHERE activo = 1";
        return dataAccess.Query(query);
    }

    public DefaultTableModel Asc() {
        String query = "SELECT idCategoria 'ID', nombre 'Categoria' "
                + "FROM Categorias "
                + "WHERE activo = 1 "
                + "ORDER BY nombre";
        return dataAccess.Query(query);
    }

    public void GetById() {
        String query = "SELECT * FROM categorias WHERE idCategoria = " + idCategoria;
        DefaultTableModel res = dataAccess.Query(query);
        idCategoria = (int) res.getValueAt(0, 0);
        nombre = (String) res.getValueAt(0, 1);
    }

    public boolean Add() {
        //INSERT INTO TABLA (C1, C2) VALUES (V1, V2);
        String query = "INSERT INTO Categorias(nombre, activo) "
                + "VALUES('" + nombre + "'," + activo + ");";
        return dataAccess.Execute(query) >= 1;
    }

//Este metodo borra informacion de la base de datos
    public boolean Delete() {
        String query = "DELETE FROM Categorias WHERE idCategoria = " + idCategoria;
        return dataAccess.Execute(query) >= 1;
    }

    /*
    public boolean DeleteFK() {
        String query = "DELETE FROM productos WHERE id_Farmacia = " + idFarmacia;
        return dataAccess.Execute(query) >= 1;
    }
     */
    public boolean Update() {
        String query = "UPDATE Categorias SET "
                + "nombre = '" + nombre + "', "
                + "activo = " + activo + " "
                + "WHERE idCategoria = " + idCategoria;
        return dataAccess.Execute(query) >= 1;
    }

    public DefaultTableModel Search(String buscar) {
        String query = "SELECT idCategoria  'ID', nombre 'Categoria' "
                + "FROM Categorias "
                + "WHERE activo = 1 AND nombre LIKE '%" + buscar + "%' "
                + "ORDER BY nombre";
        return dataAccess.Query(query);
    }
}

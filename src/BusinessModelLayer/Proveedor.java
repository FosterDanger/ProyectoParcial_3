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
public class Proveedor {

    private DataAccess dataAccess = DataAccess.Instance();
    private int idProveedor;
    private String nombre;
    private int idContacto;
    private int activo;

    public Proveedor() {
        activo = 1;
    }

    public Proveedor(int idProveedor, String nombre, int idContacto) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.idContacto = idContacto;
        activo = 1;
    }

    public DataAccess getDataAccess() {
        return dataAccess;
    }

    public void setDataAccess(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public DefaultTableModel GetAllModel() {
        String query = "SELECT p.idProveedor 'ID', p.nombre 'Nombre', l.localidad 'Localidad', m.municipio 'Municipio', e.entidad 'Entidad', c.telefono 'Telefono' "
                + "FROM proveedores p "
                + "INNER JOIN contactos c ON p.idContacto = c.idContacto "
                + "INNER JOIN entidades e ON c.idEntidad = e.idEntidad "
                + "INNER JOIN municipios m ON c.idMunicipio = m.idMunicipio "
                + "INNER JOIN localidades l ON c.idLocalidad = l.idLocalidad "
                + "WHERE p.activo = 1";
        return dataAccess.Query(query);
    }

    public DefaultTableModel Asc() {
        String query = "SELECT p.idProveedor 'ID', p.nombre 'Nombre', l.localidad 'Localidad', m.municipio 'Municipio', e.entidad 'Entidad', c.telefono 'Telefono' "
                + "FROM proveedores p "
                + "INNER JOIN contactos c ON p.idContacto = c.idContacto "
                + "INNER JOIN entidades e ON c.idEntidad = e.idEntidad "
                + "INNER JOIN municipios m ON c.idMunicipio = m.idMunicipio "
                + "INNER JOIN localidades l ON c.idLocalidad = l.idLocalidad "
                + "WHERE p.activo = 1 "
                + "ORDER BY p.nombre";
        return dataAccess.Query(query);
    }

    public void GetById() {
        String query = "SELECT * FROM proveedores WHERE idProveedor = " + idProveedor;
        DefaultTableModel res = dataAccess.Query(query);
        idProveedor = (int) res.getValueAt(0, 0);
        nombre = String.valueOf(res.getValueAt(0, 1));
        idContacto = (int) res.getValueAt(0, 2);
    }

    public boolean Add() {
        //INSERT INTO TABLA (C1, C2) VALUES (V1, V2);
        String query = "INSERT INTO proveedores(nombre, idContacto, activo) "
                + "VALUES('" + nombre + "'," + idContacto + "," + activo + ");";
        return dataAccess.Execute(query) >= 1;
    }

    public boolean Delete() {
        String query = "DELETE FROM proveedores WHERE idProveedor = " + idProveedor;
        return dataAccess.Execute(query) >= 1;
    }

    public boolean Update() {
        String query = "UPDATE proveedores SET "
                + "nombre = '" + nombre + "', "
                + "idContacto = " + idContacto + ", "
                + "activo = " + activo + " "
                + "WHERE idProveedor = " + idProveedor;
        return dataAccess.Execute(query) >= 1;
    }

    public DefaultTableModel Search(String buscar) {
        String query = "SELECT p.idProveedor 'ID', p.nombre 'Nombre', l.localidad 'Localidad', m.municipio 'Municipio', e.entidad 'Entidad', c.telefono 'Telefono' "
                + "FROM proveedores p "
                + "INNER JOIN contactos c ON p.idContacto = c.idContacto "
                + "INNER JOIN entidades e ON c.idEntidad = e.idEntidad "
                + "INNER JOIN municipios m ON c.idMunicipio = m.idMunicipio "
                + "INNER JOIN localidades l ON c.idLocalidad = l.idLocalidad "
                + "WHERE p.activo = 1 AND p.nombre LIKE '%" + buscar + "%' "
                + "ORDER BY p.nombre";
        return dataAccess.Query(query);
    }

}

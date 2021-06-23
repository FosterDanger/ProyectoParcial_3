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
public class Cliente {

    private DataAccess dataAccess = DataAccess.Instance();
    private int IdCliente;
    private String nombre;
    private int idContacto;
    private int activo;

    public Cliente() {
        activo = 1;
    }

    public Cliente(int IdCliente, String nombre, int idContacto) {
        this.IdCliente = IdCliente;
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

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
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
        String query = "SELECT cl.idCliente 'ID', cl.nombre 'Cliente',cl.IdContacto 'ID Contacto', c.telefono 'Telefono', m.municipio 'Municipio', l.localidad 'Localiad' "
                + "FROM clientes cl "
                + "INNER JOIN contactos c ON cl.idContacto = c.idContacto "
                + "INNER JOIN municipios m ON c.idMunicipio = m.idMunicipio "
                + "INNER JOIN localidades l ON c.idLocalidad = l.idLocalidad "
                + "WHERE cl.activo = 1";
        return dataAccess.Query(query);
    }

    public DefaultTableModel Asc() {
        String query = "SELECT cl.idCliente 'ID', cl.nombre 'Cliente',cl.IdContacto 'ID Contacto', c.telefono 'Telefono', m.municipio 'Municipio', l.localidad 'Localiad' "
                + "FROM clientes cl "
                + "INNER JOIN contactos c ON cl.idContacto = c.idContacto "
                + "INNER JOIN municipios m ON c.idMunicipio = m.idMunicipio "
                + "INNER JOIN localidades l ON c.idLocalidad = l.idLocalidad "
                + "WHERE cl.activo = 1"
                + "ORDER  BY cl.nombre ASC";
        return dataAccess.Query(query);
    }

    public void GetById() {
        String query = "SELECT * FROM clientes WHERE idCliente = " + IdCliente;
        DefaultTableModel res = dataAccess.Query(query);
        IdCliente = (int) res.getValueAt(0, 0);
        nombre = String.valueOf(res.getValueAt(0, 1));
        idContacto = (int) res.getValueAt(0, 2);
    }

    public boolean Add() {
        //INSERT INTO TABLA (C1, C2) VALUES (V1, V2);
        String query = "INSERT INTO Clientes(nombre, idContacto, activo) "
                + "VALUES('" + nombre + "'," + idContacto + "," + activo + ");";
        return dataAccess.Execute(query) >= 1;
    }

    public boolean Delete() {
        String query = "DELETE FROM clientes WHERE idCliente = " + IdCliente;
        return dataAccess.Execute(query) >= 1;
    }

    public boolean Update() {
        String query = "UPDATE Clientes SET "
                + "nombre = '" + nombre + "', "
                + "idContacto = " + idContacto + ", "
                + "activo = " + activo + " "
                + "WHERE idCliente = " + IdCliente;
        return dataAccess.Execute(query) >= 1;
    }

    public DefaultTableModel Search(String buscar) {
        String query = "SELECT cl.idCliente 'ID', cl.nombre 'Cliente',cl.IdContacto 'ID Contacto', c.telefono 'Telefono', m.municipio 'Municipio', l.localidad 'Localiad' "
                + "FROM clientes cl "
                + "INNER JOIN contactos c ON cl.idContacto = c.idContacto "
                + "INNER JOIN municipios m ON c.idMunicipio = m.idMunicipio "
                + "INNER JOIN localidades l ON c.idLocalidad = l.idLocalidad "
                + "WHERE cl.activo = 1 AND cl.nombre LIKE '%" + buscar + "%' ";
        return dataAccess.Query(query);
    }

}

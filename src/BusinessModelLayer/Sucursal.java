/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessModelLayer;

import DataAccessLayer.DataAccess;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FOSTER
 */
public class Sucursal {

    private DataAccess dataAccess = DataAccess.Instance();
    private int idSucursal;
    private String nombre;
    private int idContacto;
    private int activo;

    public Sucursal() {
        activo = 1;
    }

    public Sucursal(int idSucursal, String nombre, int idContacto) {
        this.idSucursal = idSucursal;
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

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
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
         String query = "SELECT s.idSucursal 'ID', s.nombre 'Sucursal',s.idContacto 'ID Contacto', l.localidad 'Localidad', m.municipio 'Municipio', e.entidad 'Entidad' "
                + "FROM Sucursales s "
                + "INNER JOIN contactos c ON s.idContacto = c.idContacto "
                + "INNER JOIN entidades e ON c.idEntidad = e.idEntidad "
                + "INNER JOIN municipios m ON c.idMunicipio = m.idMunicipio "
                + "INNER JOIN localidades l ON c.idLocalidad = l.idLocalidad "
                + "WHERE s.activo = 1";
        return dataAccess.Query(query);
    }

    public DefaultTableModel Asc() {
        String query = "SELECT s.idSucursal 'ID', s.nombre 'Sucursal',s.idContacto 'ID Contacto', l.localidad 'Localidad', m.municipio 'Municipio', e.entidad 'Entidad' "
                + "FROM Sucursales s "
                + "INNER JOIN contactos c ON s.idContacto = c.idContacto "
                + "INNER JOIN entidades e ON c.idEntidad = e.idEntidad "
                + "INNER JOIN municipios m ON c.idMunicipio = m.idMunicipio "
                + "INNER JOIN localidades l ON c.idLocalidad = l.idLocalidad "
                + "WHERE s.activo = 1"
                + "ORDER BY s.nombre";
        return dataAccess.Query(query);
    }

    public void GetById() {
        String query = "SELECT * FROM Sucursales WHERE idSucursal = " + idSucursal;
        DefaultTableModel res = dataAccess.Query(query);
        idSucursal = (int) res.getValueAt(0, 0);
        nombre = String.valueOf(res.getValueAt(0, 1));
        idContacto = (int) res.getValueAt(0, 2);
    }
    
    public ArrayList Row(String buscar) {
        String query = "SELECT  idLocalidad "
                + "FROM localidades "
                + "WHERE localidades.localidad = '" + buscar + "';";
        /*
        String query = "SELECT  e.idEntidad  'idEntidad' "
                + "FROM municipios m "
                + "INNER JOIN entidades e ON m.idEntidad = e.idEntidad "
                + "WHERE e.entidad = '" + buscar + "';";
*/
        return dataAccess.QueryRow(query);
    }

    public boolean Add() {
        //INSERT INTO TABLA (C1, C2) VALUES (V1, V2);
        String query = "INSERT INTO Sucursales(nombre, idContacto, activo) "
                + "VALUES('" + nombre + "'," + idContacto + "," + activo + ");";
        return dataAccess.Execute(query) >= 1;
    }

    public boolean Delete() {
        String query = "DELETE FROM sucursales WHERE idSucursal = " + idSucursal;
        return dataAccess.Execute(query) >= 1;
    }

    public boolean Update() {
        String query = "UPDATE Sucursales SET "
                + "nombre = '" + nombre + "', "
                + "idContacto = " + idContacto + ", "
                + "activo = " + activo + " "
                + "WHERE idSucursal = " + idSucursal;
        return dataAccess.Execute(query) >= 1;
    }

    public DefaultTableModel Search(String buscar) {
         String query = "SELECT s.idSucursal 'ID', s.nombre 'Sucursal',s.idContacto 'ID Contacto', l.localidad 'Localidad', m.municipio 'Municipio', e.entidad 'Entidad' "
                + "FROM Sucursales s "
                + "INNER JOIN contactos c ON s.idContacto = c.idContacto "
                + "INNER JOIN entidades e ON c.idEntidad = e.idEntidad "
                + "INNER JOIN municipios m ON c.idMunicipio = m.idMunicipio "
                + "INNER JOIN localidades l ON c.idLocalidad = l.idLocalidad "
                + "WHERE s.activo = 1 AND s.nombre LIKE '%" + buscar + "%' "
                + "ORDER BY s.nombre";
        return dataAccess.Query(query);
    }

}

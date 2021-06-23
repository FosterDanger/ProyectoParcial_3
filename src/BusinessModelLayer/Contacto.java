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
public class Contacto {

    private DataAccess dataAccess = DataAccess.Instance();
    private int idContacto;
    private int codigoPostal;
    private String calle;
    private String telefono;
    private int idEntidad;
    private int idMunicipio;
    private int idLocalidad;
    private int activo;

    public Contacto() {
        activo = 1;
    }

    public Contacto(int idContacto, int codigoPostal, String calle, String telefono, int idEntidad, int idMunicipio, int idLocalidad) {
        this.idContacto = idContacto;
        this.codigoPostal = codigoPostal;
        this.calle = calle;
        this.telefono = telefono;
        this.idEntidad = idEntidad;
        this.idMunicipio = idMunicipio;
        this.idLocalidad = idLocalidad;
        activo = 1;
    }

    public DataAccess getDataAccess() {
        return dataAccess;
    }

    public void setDataAccess(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(int idEntidad) {
        this.idEntidad = idEntidad;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public int getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(int idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public DefaultTableModel GetAllModel() {
        String query = "SELECT c.idContacto  'ID', c.codigoPostal  'Codigo Postal', c.calle  'Calle', c.telefono  'Telefono', l.localidad  'Localidad', m.municipio  'Municipio', e.entidad  'Entidad' "
                + "FROM contactos c "
                + "INNER JOIN entidades e ON c.idEntidad = e.idEntidad "
                + "INNER JOIN municipios m ON c.idMunicipio = m.idMunicipio "
                + "INNER JOIN localidades l ON c.idLocalidad = l.idLocalidad ";
        return dataAccess.Query(query);
    }

    public boolean Delete() {
        String query = "DELETE FROM contactos WHERE idContacto = " + idContacto;
        return dataAccess.Execute(query) >= 1;
    }

    public DefaultTableModel Asc() {
        String query = "SELECT c.idContacto  'ID', c.codigoPostal  'Codigo Postal', c.calle  'Calle', c.telefono  'Telefono', l.localidad  'Localidad', m.municipio  'Municipio', e.entidad  'Entidad' "
                + "FROM contactos c "
                + "INNER JOIN entidades e ON c.idEntidad = e.idEntidad "
                + "INNER JOIN municipios m ON c.idMunicipio = m.idMunicipio "
                + "INNER JOIN localidades l ON c.idLocalidad = l.idLocalidad "
                + "WHERE c.activo = 1"
                + "ORDER  BY c.idContacto DESC";
        return dataAccess.Query(query);
    }

    public void GetById() {
        String query = "SELECT * FROM contactos WHERE idContacto = " + idContacto;
        DefaultTableModel res = dataAccess.Query(query);
        idContacto = (int) res.getValueAt(0, 0);
        codigoPostal = (int) (long) res.getValueAt(0, 1);
        calle = String.valueOf(res.getValueAt(0, 2));
        telefono = String.valueOf(res.getValueAt(0, 3));
        idEntidad = (int) res.getValueAt(0, 4);
        idMunicipio = (int) res.getValueAt(0, 5);
        idLocalidad = (int) res.getValueAt(0, 6);
    }

    public boolean Add() {
        //INSERT INTO TABLA (C1, C2) VALUES (V1, V2);
        String query = "INSERT INTO contactos(codigoPostal, calle, telefono, idEntidad, idMunicipio, idLocalidad, activo) "
                + "VALUES(" + codigoPostal + ",'" + calle + "','" + telefono + "'," + idEntidad + "," + idMunicipio + "," + idLocalidad + "," + activo + ");";
        return dataAccess.Execute(query) >= 1;
    }

    public boolean Update() {
        String query = "UPDATE Contactos SET "
                + "codigoPostal = " + codigoPostal + ", "
                + "calle = '" + calle + "', "
                + "telefono = '" + telefono + "', "
                + "idEntidad = " + idEntidad + ", "
                + "idMunicipio = " + idMunicipio + ", "
                + "idLocalidad = " + idLocalidad + ", "
                + "activo = " + activo + " "
                + "WHERE idContacto = " + idContacto;
        return dataAccess.Execute(query) >= 1;
    }

    public DefaultTableModel Search(String buscar) {
        String query = "SELECT c.idContacto  'ID', c.codigoPostal  'Codigo Postal', c.calle  'Calle', c.telefono  'Telefono', l.localidad  'Localidad', m.municipio  'Municipio', e.entidad  'Entidad' "
                + "FROM contactos c "
                + "INNER JOIN entidades e ON c.idEntidad = e.idEntidad "
                + "INNER JOIN municipios m ON c.idMunicipio = m.idMunicipio "
                + "INNER JOIN localidades l ON c.idLocalidad = l.idLocalidad "
                + "WHERE c.calle LIKE '%" + buscar + "%' "
                + "ORDER BY c.calle";
        return dataAccess.Query(query);
    }

}

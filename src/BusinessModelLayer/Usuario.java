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
public class Usuario {

    private DataAccess dataAccess = DataAccess.Instance();
    private int idUsuario;
    private int idSucursal;
    private int idContacto;
    private String tipo;
    private String nombre;
    private String usuario;
    private String password;
    private int activo;

    public Usuario() {
        activo = 1;
    }

    public Usuario(int idUsuario, int idSucursal, int idContacto, String tipo, String nombre, String usuario, String password) {
        this.idUsuario = idUsuario;
        this.idSucursal = idSucursal;
        this.idContacto = idContacto;
        this.tipo = tipo;
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
        activo = 1;
    }

    public DataAccess getDataAccess() {
        return dataAccess;
    }

    public void setDataAccess(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public DefaultTableModel GetAllModel() {
        String query = "SELECT u.idUsuario 'ID', u.nombre 'Nombre', u.tipoUsuario 'Tipo Usuario', s.nombre 'Sucursal',  u.usuario 'Usuario', u.password 'Contraseña', c.idContacto 'Contacto' "
                + "FROM usuarios u "
                + "INNER JOIN sucursales s ON u.idSucursal = s.idSucursal "
                + "INNER JOIN contactos c ON u.idContacto = c.idContacto "
                + "INNER JOIN entidades e ON c.idEntidad = e.idEntidad "
                + "INNER JOIN municipios m ON c.idMunicipio = m.idMunicipio "
                + "INNER JOIN localidades l ON c.idLocalidad = l.idLocalidad "
                + "WHERE u.activo = 1 ";
        return dataAccess.Query(query);
    }

    public DefaultTableModel Asc() {
        String query = "SELECT u.idUsuario 'ID', u.nombre 'Nombre', u.tipoUsuario 'Tipo Usuario', s.nombre 'Sucursal',  u.usuario 'Usuario', u.password 'Contraseña', c.idContacto 'Contacto' "
                + "FROM usuarios u "
                + "INNER JOIN sucursales s ON u.idSucursal = s.idSucursal "
                + "INNER JOIN contactos c ON u.idContacto = c.idContacto "
                + "INNER JOIN entidades e ON c.idEntidad = e.idEntidad "
                + "INNER JOIN municipios m ON c.idMunicipio = m.idMunicipio "
                + "INNER JOIN localidades l ON c.idLocalidad = l.idLocalidad "
                + "WHERE u.activo = 1 "
                + "ORDER BY u.nombre";
        return dataAccess.Query(query);
    }

    public void GetById() {
        String query = "SELECT * FROM usuarios WHERE idUsuario = " + idUsuario;
        DefaultTableModel res = dataAccess.Query(query);
        idUsuario = (int) res.getValueAt(0, 0);
        nombre = String.valueOf(res.getValueAt(0, 1));
        idContacto = (int) res.getValueAt(0, 2);
        usuario = String.valueOf(res.getValueAt(0, 3));
        password = String.valueOf(res.getValueAt(0, 4));
        idSucursal = (int) res.getValueAt(0, 6);
        tipo = String.valueOf(res.getValueAt(0, 7));

    }

    public boolean Add() {
        //INSERT INTO TABLA (C1, C2) VALUES (V1, V2);
        String query = "INSERT INTO usuarios(idSucursal, tipoUsuario, nombre, idContacto, usuario, password, activo) "
                + "VALUES(" + idSucursal + ",'" + tipo + "','" + nombre + "'," + idContacto + ",'" + usuario + "','" + password + "'," + activo + ");";
        return dataAccess.Execute(query) >= 1;
    }

    public boolean Delete() {
        String query = "DELETE FROM usuarios WHERE idUsuario = " + idUsuario;
        return dataAccess.Execute(query) >= 1;
    }

    public boolean Update() {
        String query = "UPDATE usuarios SET "
                + "idSucursal = " + idSucursal + ", "
                + "tipoUsuario = '" + tipo + "', "
                + "nombre = '" + nombre + "', "
                + "idContacto = " + idContacto + ", "
                + "usuario = '" + usuario + "', "
                + "password = '" + password + "', "
                + "activo = " + activo + " "
                + "WHERE idUsuario = " + idUsuario;
        return dataAccess.Execute(query) >= 1;
    }

    public DefaultTableModel Search(String buscar) {
        String query = "SELECT u.idUsuario 'ID', u.nombre 'Nombre', u.tipoUsuario 'Tipo Usuario', s.nombre 'Sucursal',  u.usuario 'Usuario', u.password 'Contraseña', c.idContacto 'Contacto' "
                + "FROM usuarios u "
                + "INNER JOIN sucursales s ON u.idSucursal = s.idSucursal "
                + "INNER JOIN contactos c ON u.idContacto = c.idContacto "
                + "INNER JOIN entidades e ON c.idEntidad = e.idEntidad "
                + "INNER JOIN municipios m ON c.idMunicipio = m.idMunicipio "
                + "INNER JOIN localidades l ON c.idLocalidad = l.idLocalidad "
                + "WHERE u.activo = 1 AND u.nombre LIKE '%" + buscar + "%' "
                + "ORDER BY u.nombre";
        return dataAccess.Query(query);
    }

    public ArrayList Row() {
        String query = "SELECT  nombre FROM sucursales ";

        /*
        String query = "SELECT  e.idEntidad  'idEntidad' "
                + "FROM municipios m "
                + "INNER JOIN entidades e ON m.idEntidad = e.idEntidad "
                + "WHERE e.entidad = '" + buscar + "';";
         */
        return dataAccess.QueryRow(query);
    }

    public ArrayList Row3(String nombre) {
        String query = "SELECT  idSucursal FROM sucursales WHERE nombre = '" + nombre + "'; ";

        /*
        String query = "SELECT  e.idEntidad  'idEntidad' "
                + "FROM municipios m "
                + "INNER JOIN entidades e ON m.idEntidad = e.idEntidad "
                + "WHERE e.entidad = '" + buscar + "';";
         */
        return dataAccess.QueryRow(query);
    }

}

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
public class Localidad {

    private DataAccess dataAccess = DataAccess.Instance();
    private int idLocalidad;
    private int idMunicipio;
    private String localidad;

    public Localidad() {
    }

    public Localidad(int idLocalidad, int idMunicipio, String localidad) {
        this.idLocalidad = idLocalidad;
        this.idMunicipio = idMunicipio;
        this.localidad = localidad;
    }

    public DataAccess getDataAccess() {
        return dataAccess;
    }

    public void setDataAccess(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public int getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(int idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public DefaultTableModel GetAllModel() {
        String query = "SELECT l.idLocalidad 'ID', l.localidad 'Localidad', m.municipio  'Municipio' "
                + "FROM localidades l "
                + "INNER JOIN municipios m ON l.idMunicipio = m.idMunicipio";
        return dataAccess.Query(query);
    }

    public ArrayList Row(String buscar) {
        String query = "SELECT  municipios.idMunicipio "
                + "FROM municipios "
                + "WHERE municipios.municipio = '" + buscar + "';";
        /*
        String query = "SELECT  e.idEntidad  'idEntidad' "
                + "FROM municipios m "
                + "INNER JOIN entidades e ON m.idEntidad = e.idEntidad "
                + "WHERE e.entidad = '" + buscar + "';";
         */
        return dataAccess.QueryRow(query);
    }

    public ArrayList Row2(String buscar) {
        /*
        String query = "SELECT  municipios.idMunicipio "
                + "FROM municipios "
                + "WHERE municipios.municipio = '" + buscar + "';";
         */
        String query = "SELECT  m.municipio  'Municipio' "
                + "FROM municipios m "
                + "INNER JOIN entidades e ON m.idEntidad = e.idEntidad "
                + "WHERE e.entidad = '" + buscar + "';";

        return dataAccess.QueryRow(query);
    }

    public ArrayList Row3(String buscar) {
        /*
        String query = "SELECT  municipios.idMunicipio "
                + "FROM municipios "
                + "WHERE municipios.municipio = '" + buscar + "';";
         */
        String query = "SELECT  e.entidad  'Entidad' "
                + "FROM entidades e "
                + "INNER JOIN municipios m ON m.idEntidad = e.idEntidad "
                + "INNER JOIN localidades l ON l.idMunicipio = m.idMunicipio "
                + "WHERE l.localidad = '" + buscar + "';";

        return dataAccess.QueryRow(query);
    }

    public ArrayList Row4(String buscar) {
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

    public DefaultTableModel GetAllModelCob(String buscar) {
        String query = "SELECT l.idLocalidad 'ID', l.localidad 'Localidad', m.municipio  'Municipio' "
                + "FROM localidades l "
                + "INNER JOIN municipios m ON l.idMunicipio = m.idMunicipio "
                + "WHERE m.municipio = '" + buscar + "';";
        return dataAccess.Query(query);
    }

    public DefaultTableModel Asc() {
        String query = "SELECT idLocalidad 'ID', localidad 'Localidad' FROM localidades ORDER BY localidad";
        return dataAccess.Query(query);
    }

//El siguiente medoto pasa la fila seleccionada del jTable por medio del id a variables de la clase.
    public void GetById() {
        String query = "SELECT * FROM localidades WHERE idLocalidad = " + idLocalidad;
        DefaultTableModel res = dataAccess.Query(query);
        idLocalidad = (int) res.getValueAt(0, 0);
        idMunicipio = (int) res.getValueAt(0, 1);
        localidad = String.valueOf(res.getValueAt(0, 2));
    }

//Este metodo añade datos a la base de datos.
    public boolean Add() {
        //INSERT INTO TABLA (C1, C2) VALUES (V1, V2);
        String query = "INSERT INTO localidades(idMunicipio, localidad) "
                + "VALUES(" + idMunicipio + ",'" + localidad + "');";
        return dataAccess.Execute(query) >= 1;
    }

//Este metodo borra informacion de la base de datos
    public boolean Delete() {
        String query = "DELETE FROM localidades WHERE idLocalidad = " + idLocalidad;
        return dataAccess.Execute(query) >= 1;
    }

    /*
    public boolean DeleteFK() {
        String query = "DELETE FROM productos WHERE id_Farmacia = " + idFarmacia;
        return dataAccess.Execute(query) >= 1;
    }
     */
//Este metodo modifica la base de datos.
    public boolean Update() {
        String query = "UPDATE localidades SET "
                + "idMunicipio = " + idMunicipio + ", "
                + "localidad = '" + localidad + "' "
                + "WHERE idLocalidad = " + idLocalidad;
        return dataAccess.Execute(query) >= 1;
    }

    /*
//Este metodo busca algun elemento de la base de datos, basandose en este caso en el nombre y lo muestra en el jTable.
    public DefaultTableModel Search(String nombre) {
        String query = "SELECT * FROM productos where nombre like '%" + nombre + "%'";
        return dataAccess.Query(query);
    }
     */
    public DefaultTableModel Search(String buscar) {
        String query = "SELECT l.idLocalidad 'ID', l.localidad 'Localidad', m.municipio 'Municipio' "
                + "FROM localidades l "
                + "INNER JOIN Municipios m ON l.idMunicipio = m.idMunicipio "
                + "WHERE l.localidad LIKE '%" + buscar + "%' "
                + "ORDER BY l.localidad";
        return dataAccess.Query(query);
    }

}

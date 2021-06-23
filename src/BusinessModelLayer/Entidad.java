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
public class Entidad {

    private DataAccess dataAccess = DataAccess.Instance();
    private int idEntidad;
    private String entidad;

    public Entidad() {
    }

    public Entidad(int idEntidad, String entidad) {
        this.idEntidad = idEntidad;
        this.entidad = entidad;
    }

    public DataAccess getDataAccess() {
        return dataAccess;
    }

    public void setDataAccess(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public int getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(int idEntidad) {
        this.idEntidad = idEntidad;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public DefaultTableModel GetAllModel() {
        String query = "SELECT idEntidad 'ID', entidad 'Entidad' FROM entidades";
        return dataAccess.Query(query);
    }

    public DefaultTableModel Asc() {
        String query = "SELECT idEntidad 'ID', entidad 'Entidad' FROM entidades ORDER BY entidad";
        return dataAccess.Query(query);
    }

    public void GetById() {
        String query = "SELECT * FROM entidades WHERE idEntidad = " + idEntidad;
        DefaultTableModel res = dataAccess.Query(query);
        idEntidad = (int) res.getValueAt(0, 0);
        entidad = String.valueOf(res.getValueAt(0, 1));
    }

    public DefaultTableModel Row2() {
        /*
        String query = "SELECT  municipios.idMunicipio "
                + "FROM municipios "
                + "WHERE municipios.municipio = '" + buscar + "';";
         */
        String query = "SELECT  m.municipio  'Municipio' "
                + "FROM municipios m "
                + "INNER JOIN entidades e ON m.idEntidad = e.idEntidad "
                + "WHERE e.entidad = '" + entidad + "';";

        return dataAccess.Query(query);
    }

    public boolean Add() {
        //INSERT INTO TABLA (C1, C2) VALUES (V1, V2);
        String query = "INSERT INTO entidades(entidad) "
                + "VALUES('" + entidad + "');";
        return dataAccess.Execute(query) >= 1;
    }

    public boolean Delete() {
        String query = "DELETE FROM entidades WHERE idEntidad = " + idEntidad;
        return dataAccess.Execute(query) >= 1;
    }

    /*
    public boolean DeleteFK() {
        String query = "DELETE FROM productos WHERE id_Farmacia = " + idFarmacia;
        return dataAccess.Execute(query) >= 1;
    }
     */
    public boolean Update() {
        String query = "UPDATE entidades SET "
                + "entidad = '" + entidad + "' "
                + "WHERE idEntidad = " + idEntidad;
        return dataAccess.Execute(query) >= 1;
    }

    public DefaultTableModel Search(String buscar) {
        String query = "SELECT idEntidad  'ID', entidad  'Entidad' FROM Entidades WHERE entidad LIKE '%" + buscar + "%' ORDER BY entidad";
        return dataAccess.Query(query);
    }
}

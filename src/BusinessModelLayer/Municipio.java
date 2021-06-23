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
public class Municipio {

    private DataAccess dataAccess = DataAccess.Instance();
    private int idMunicipio;
    private int idEntidad;
    private String municipio;

    public Municipio() {
    }

    public Municipio(int idMunicipio, int idEntidad, String municipio) {
        this.idMunicipio = idMunicipio;
        this.idEntidad = idEntidad;
        this.municipio = municipio;
    }

    public DataAccess getDataAccess() {
        return dataAccess;
    }

    public void setDataAccess(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public int getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(int idEntidad) {
        this.idEntidad = idEntidad;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public DefaultTableModel GetAllModel() {
        String query = "SELECT m.idMunicipio 'ID', m.municipio 'Municipio', e.entidad  'Entidad' "
                + "FROM municipios m "
                + "INNER JOIN entidades e ON m.idEntidad = e.idEntidad";
        return dataAccess.Query(query);
    }

    public DefaultTableModel GetAllModelCob(String buscar) {
        String query = "SELECT m.idMunicipio 'ID', m.municipio 'Municipio', e.idEntidad  'idEntidad' "
                + "FROM municipios m "
                + "INNER JOIN entidades e ON m.idEntidad = e.idEntidad "
                + "WHERE e.entidad = '" + buscar + "';";
        return dataAccess.Query(query);
    }

    public DefaultTableModel Asc() {
        String query = "SELECT m.idMunicipio 'ID', m.municipio 'Municipio', e.entidad  'Entidad' "
                + "FROM municipios m "
                + "INNER JOIN entidades e ON m.idEntidad = e.idEntidad "
                + "ORDER BY e.entidad";
        return dataAccess.Query(query);
    }

    public ArrayList Row(String buscar) {
        String query = "SELECT  entidades.idEntidad "
                + "FROM entidades "
                + "WHERE entidades.entidad = '" + buscar + "';";
        /*
        String query = "SELECT  e.idEntidad  'idEntidad' "
                + "FROM municipios m "
                + "INNER JOIN entidades e ON m.idEntidad = e.idEntidad "
                + "WHERE e.entidad = '" + buscar + "';";
         */
        return dataAccess.QueryRow(query);
    }

    public void GetById() {
        String query = "SELECT * FROM municipios WHERE idMunicipio = " + idMunicipio;
        DefaultTableModel res = dataAccess.Query(query);
        idMunicipio = (int) res.getValueAt(0, 0);
        idEntidad = (int) res.getValueAt(0, 1);
        municipio = String.valueOf(res.getValueAt(0, 2));
    }

    public boolean Add() {
        String query = "INSERT INTO municipios(idEntidad, municipio) "
                + "VALUES(" + idEntidad + ",'" + municipio + "');";
        return dataAccess.Execute(query) >= 1;
    }

    public boolean Delete() {
        String query = "DELETE FROM municipios WHERE idMunicipio = " + idMunicipio;
        return dataAccess.Execute(query) >= 1;
    }

    /*
    public boolean DeleteFK() {
        String query = "DELETE FROM productos WHERE id_Farmacia = " + idFarmacia;
        return dataAccess.Execute(query) >= 1;
    }
     */
    public boolean Update() {
        String query = "UPDATE Municipios SET "
                + "idEntidad = " + idEntidad + ", "
                + "municipio = '" + municipio + "' "
                + "WHERE idMunicipio = " + idMunicipio;
        return dataAccess.Execute(query) >= 1;
    }

    public DefaultTableModel Search(String buscar) {
        String query = "SELECT m.idMunicipio 'ID', m.municipio 'Municipio', e.entidad  'Entidad' "
                + "FROM municipios m "
                + "INNER JOIN entidades e ON m.idEntidad = e.idEntidad "
                + "WHERE m.municipio LIKE '%" + buscar + "%' "
                + "ORDER BY m.municipio";
        return dataAccess.Query(query);
    }

}

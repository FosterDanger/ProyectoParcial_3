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
public class ProductosProveedores {

    private DataAccess dataAccess = DataAccess.Instance();
    private int idProductoProveedor;
    private int idProveedor;
    private int idProducto;

    public ProductosProveedores() {
    }

    public ProductosProveedores(int idProductoProveedor, int idProveedor, int idProducto) {
        this.idProductoProveedor = idProductoProveedor;
        this.idProveedor = idProveedor;
        this.idProducto = idProducto;
    }

    public ProductosProveedores(int idProveedor, int idProducto) {
        this.idProveedor = idProveedor;
        this.idProducto = idProducto;
    }

    public DataAccess getDataAccess() {
        return dataAccess;
    }

    public void setDataAccess(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public int getIdProductoProveedor() {
        return idProductoProveedor;
    }

    public void setIdProductoProveedor(int idProductoProveedor) {
        this.idProductoProveedor = idProductoProveedor;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public DefaultTableModel GetAllModel() {
        String query = "SELECT pr.idProductoProveedor 'ID', pro.nombre 'Proveedor', p.nombre 'Producto' "
                + "FROM productoproveedores pr "
                + "INNER JOIN productos p ON pr.idProducto = p.idProducto "
                + "INNER JOIN proveedores pro ON pr.idProveedor = pro.idProveedor";
        return dataAccess.Query(query);
    }

    public DefaultTableModel Asc() {
        String query = "SELECT pr.idProductoProveedor 'ID', pro.nombre 'Proveedor', p.nombre 'Producto' "
                + "FROM ProductoProveedores pr "
                + "INNER JOIN Productos p ON pr.idProducto = p.idProducto "
                + "INNER JOIN Proveedores pro ON pr.idProveedor = pro.idProveedor "
                + "ORDER BY p.nombre";
        return dataAccess.Query(query);
    }

    public void GetById() {
        String query = "SELECT * FROM productoproveedores WHERE idProductoProveedor = " + idProductoProveedor;
        DefaultTableModel res = dataAccess.Query(query);
        idProductoProveedor = (int) res.getValueAt(0, 0);
        idProveedor = (int) res.getValueAt(0, 1);
        idProducto = (int) res.getValueAt(0, 2);
    }

    public int Add() {
        //INSERT INTO TABLA (C1, C2) VALUES (V1, V2);
        String query = "IF (SELECT COUNT(*) FROM productoproveedores WHERE " + idProveedor + " = idProveedor AND " + idProducto + " = idProducto) > 0 "
                + "RETURN "
                + "INSERT INTO productoproveedores(idProveedor, idProducto) "
                + "VALUES(" + idProveedor + "," + idProducto + ")";
        return dataAccess.Execute(query);
    }

    public boolean Delete() {
        String query = "DELETE FROM productoproveedores WHERE idProductoProveedor = " + idProductoProveedor;
        return dataAccess.Execute(query) >= 1;
    }

    /*
    public boolean DeleteFK() {
        String query = "DELETE FROM productos WHERE id_Farmacia = " + idFarmacia;
        return dataAccess.Execute(query) >= 1;
    }
     */
    public int Update() {
        String query = "IF (SELECT COUNT(*) FROM productoproveedores WHERE " + idProveedor + " = idProveedor AND " + idProducto + " = idProducto) > 0 "
                + "RETURN "
                + "UPDATE productoproveedores SET "
                + "idProveedor = " + idProveedor + ", "
                + "idProducto = " + idProducto + " "
                + "WHERE idProductoProveedor = " + idProductoProveedor;
        return dataAccess.Execute(query);
    }

    public ArrayList Row(String buscar) {
        String query = "SELECT  idProuctoProveedor "
                + "FROM productoproveedores "
                + "WHERE municipios.municipio = '" + buscar + "';";
        /*
        String query = "SELECT  e.idEntidad  'idEntidad' "
                + "FROM municipios m "
                + "INNER JOIN entidades e ON m.idEntidad = e.idEntidad "
                + "WHERE e.entidad = '" + buscar + "';";
         */
        return dataAccess.QueryRow(query);
    }

    public DefaultTableModel Search(String buscar) {
        String query = "SELECT pr.idProductoProveedor 'ID', pro.nombre 'Proveedor', p.nombre 'Producto' "
                + "FROM ProductoProveedores pr "
                + "INNER JOIN Productos p ON pr.idProducto = p.idProducto "
                + "INNER JOIN Proveedores pro ON pr.idProveedor = pro.idProveedor "
                + "WHERE p.nombre LIKE '%" + buscar + "%' "
                + "ORDER BY p.nombre";
        return dataAccess.Query(query);
    }

}

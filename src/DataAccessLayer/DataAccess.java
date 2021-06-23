/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FOSTER
 */
public class DataAccess {

    private static DataAccess instance;
    private Connection con = null;
    private Statement statement;
    private ResultSet resultSet;

    private DataAccess() {
    }

    public static DataAccess Instance() {
        if (instance == null) {
            instance = new DataAccess();
        }
        return instance;
    }

    public void ConectarDB() {
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Simisoft;", "usuario1", "123");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la conexion: " + e.getMessage());
        }
    }

    private void DesconectarDB() {
        try {
            statement.close();
            resultSet.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la conexion: " + e.getMessage());
        }
    }

    public DefaultTableModel Query(String query) {
        try {
            ConectarDB();
            statement = con.createStatement();
            resultSet = statement.executeQuery(query);
            Vector<String> columnNames = new Vector<String>();
            int columnCount = resultSet.getMetaData().getColumnCount();
            for (int colum = 1; colum <= columnCount; colum++) {
                columnNames.add(resultSet.getMetaData().getColumnName(colum));
            }
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (resultSet.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int columIndex = 1; columIndex <= columnCount; columIndex++) {
                    vector.add(resultSet.getObject(columIndex));
                }
                data.add(vector);
            }
            return new DefaultTableModel(data, columnNames) {
            };
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta: " + e.getMessage());
            return null;
        } finally {
            DesconectarDB();
        }
    }

    public int Execute(String query) {
        try {
            ConectarDB();
            statement = con.createStatement();
            return statement.executeUpdate(query);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el comando: " + e.getMessage());
            return 0;
        } finally {
            DesconectarDB();
        }
    }
    
     public ArrayList QueryRow(String query) {

        try {
            ConectarDB();
            statement = con.createStatement();
            resultSet = statement.executeQuery(query);
            int columnCout = resultSet.getMetaData().getColumnCount();

            ArrayList lista = new ArrayList();
            while (resultSet.next()) {
                for (int columnIndex = 1; columnIndex <= columnCout; columnIndex++) {
                    lista.add(resultSet.getObject(columnIndex));
                }
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta: " + e.getMessage());
            return null;
        } finally {
            DesconectarDB();
        }
    }

}

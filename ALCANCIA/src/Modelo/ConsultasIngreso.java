package Modelo;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConsultasIngreso extends Conexion {

    public boolean ingresar(Ingreso ing) {

        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO ingresos (cincuenta, cien, doscientos, quinientos, mil, total) VALUES(?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, ing.getCincuenta());
            ps.setInt(2, ing.getCien());
            ps.setInt(3, ing.getDoscientos());
            ps.setInt(4, ing.getQuinientos());
            ps.setInt(5, ing.getMil());
            ps.setInt(6, ing.getTotal());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }
    }

    public List listarIngresosdet() {
        List<Ingreso> datos = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        // String sql = "SELECT sum (cincuenta), sum (cien), sum (doscientos),sum (quinientos), sum (mil) from ingresos";
        String sql = "SELECT SUM(cincuenta),SUM(cien),SUM(doscientos),SUM(quinientos),SUM(mil) from ingresos";

        try {
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                Ingreso ing = new Ingreso();
                ing.setCincuenta(rs.getInt(1));
                ing.setCien(rs.getInt(2));
                ing.setDoscientos(rs.getInt(3));
                ing.setQuinientos(rs.getInt(4));
                ing.setMil(rs.getInt(5));
                datos.add(ing);
            }

        } catch (SQLException e) {
            System.err.println(e);
            //return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }

        return datos;
    }

    public List listarIngresosdinero() {
        List<Ingreso> datos = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        // String sql = "SELECT sum (cincuenta), sum (cien), sum (doscientos),sum (quinientos), sum (mil) from ingresos";
        String sql = "SELECT SUM(cincuenta)*50,SUM(cien)*100,SUM(doscientos)*200,SUM(quinientos)*500,SUM(mil)*1000 from ingresos";

        try {
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                Ingreso ing = new Ingreso();
                ing.setCincuenta(rs.getInt(1));
                ing.setCien(rs.getInt(2));
                ing.setDoscientos(rs.getInt(3));
                ing.setQuinientos(rs.getInt(4));
                ing.setMil(rs.getInt(5));
                datos.add(ing);
            }

        } catch (SQLException e) {
            System.err.println(e);
            //return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }

        return datos;
    }

    public List listarTotales() {
        List<Totales> datos = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT (SUM(cincuenta)+SUM(cien)+SUM(doscientos)+SUM(quinientos)+SUM(mil))as totalmonedas,( SUM(cincuenta)*50+SUM(cien)*100+SUM(doscientos)*200+SUM(quinientos)*500+SUM(mil)*1000) as totaldinero from ingresos";

        try {
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                Totales total = new Totales();
                total.setMonedas(rs.getInt(1));
                total.setDinero(rs.getInt(2));

                datos.add(total);
            }

        } catch (SQLException e) {
            System.err.println(e);
            //return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }

        return datos;
    }

}

package Controlador;

import Modelo.ConsultasIngreso;
import Modelo.Ingreso;
import Modelo.Totales;
import Vista.frmIngreso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class CtrIngreso implements ActionListener {

    private Ingreso mod;
    private ConsultasIngreso modC;
    private frmIngreso frm;
    DefaultTableModel modelo = new DefaultTableModel();

    public CtrIngreso(Ingreso mod, ConsultasIngreso modC, frmIngreso frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnIngresar.addActionListener(this);

    }

    public void iniciar() {
        frm.setTitle("Ingresos");
        frm.setLocationRelativeTo(null);//ventana centrada

        listarIngdet(frm.tablaIngdet);
        listarIngdinero(frm.tablaIngDinero);
        listarTotales(frm.tablaTotales);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int total = 0;
        if (e.getSource() == frm.btnIngresar) {

            mod.setCincuenta(Integer.parseInt(frm.txtCincuenta.getText()));
            mod.setCien(Integer.parseInt(frm.txtCien.getText()));
            mod.setDoscientos(Integer.parseInt(frm.txtDoscientos.getText()));
            mod.setQuinientos(Integer.parseInt(frm.txtQuinientos.getText()));
            mod.setMil(Integer.parseInt(frm.txtMil.getText()));
            total = ((Integer.parseInt(frm.txtCincuenta.getText()) * 50) + (Integer.parseInt(frm.txtCien.getText()) * 100) + (Integer.parseInt(frm.txtDoscientos.getText()) * 200) + (Integer.parseInt(frm.txtQuinientos.getText()) * 500) + (Integer.parseInt(frm.txtMil.getText()) * 1000));
            mod.setTotal(total);

            if (modC.ingresar(mod)) {

                JOptionPane.showMessageDialog(null, "Ingreso de Moneda Guardado");
                limpiar();
                listarIngdet(frm.tablaIngdet);
                listarIngdinero(frm.tablaIngDinero);
                listarTotales(frm.tablaTotales);
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar Moneda");
                limpiar();
                listarIngdet(frm.tablaIngdet);
                listarIngdinero(frm.tablaIngDinero);
                listarTotales(frm.tablaTotales);
            }

        }

    }

    public void listarIngdet(JTable tabla) {
        DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
        Alinear.setHorizontalAlignment(SwingConstants.CENTER);
        tabla.getColumnModel().getColumn(0).setCellRenderer(Alinear);
        tabla.getColumnModel().getColumn(1).setCellRenderer(Alinear);
        tabla.getColumnModel().getColumn(2).setCellRenderer(Alinear);
        tabla.getColumnModel().getColumn(3).setCellRenderer(Alinear);
        tabla.getColumnModel().getColumn(4).setCellRenderer(Alinear);

        modelo = (DefaultTableModel) tabla.getModel();
        List<Ingreso> lista = modC.listarIngresosdet();
        Object[] object = new Object[5];
        modelo.setRowCount(0);

        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getCincuenta();
            object[1] = lista.get(i).getCien();
            object[2] = lista.get(i).getDoscientos();
            object[3] = lista.get(i).getQuinientos();
            object[4] = lista.get(i).getMil();
            modelo.addRow(object);
            frm.tablaIngdet.setModel(modelo);
        }
    }

    public void listarIngdinero(JTable tabla) {
        DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
        Alinear.setHorizontalAlignment(SwingConstants.CENTER);
        tabla.getColumnModel().getColumn(0).setCellRenderer(Alinear);
        tabla.getColumnModel().getColumn(1).setCellRenderer(Alinear);
        tabla.getColumnModel().getColumn(2).setCellRenderer(Alinear);
        tabla.getColumnModel().getColumn(3).setCellRenderer(Alinear);
        tabla.getColumnModel().getColumn(4).setCellRenderer(Alinear);
        modelo = (DefaultTableModel) tabla.getModel();
        List<Ingreso> lista = modC.listarIngresosdinero();
        Object[] object = new Object[5];
        modelo.setRowCount(0);
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getCincuenta();
            object[1] = lista.get(i).getCien();
            object[2] = lista.get(i).getDoscientos();
            object[3] = lista.get(i).getQuinientos();
            object[4] = lista.get(i).getMil();
            modelo.addRow(object);
            frm.tablaIngDinero.setModel(modelo);
        }
    }

    public void listarTotales(JTable tabla) {
        DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
        Alinear.setHorizontalAlignment(SwingConstants.CENTER);
        tabla.getColumnModel().getColumn(0).setCellRenderer(Alinear);
        tabla.getColumnModel().getColumn(1).setCellRenderer(Alinear);

        modelo = (DefaultTableModel) tabla.getModel();
        List<Totales> lista = modC.listarTotales();
        Object[] object = new Object[2];
        modelo.setRowCount(0);
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getMonedas();
            object[1] = lista.get(i).getDinero();
            modelo.addRow(object);
            frm.tablaTotales.setModel(modelo);
        }
    }

    public void limpiar() {
        frm.txtCincuenta.setText("0");
        frm.txtCien.setText("0");
        frm.txtDoscientos.setText("0");
        frm.txtQuinientos.setText("0");
        frm.txtMil.setText("0");

    }

}

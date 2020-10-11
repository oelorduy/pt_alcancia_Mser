package alcancia;

import Controlador.CtrIngreso;
import Modelo.ConsultasIngreso;
import Modelo.Ingreso;
import Vista.frmIngreso;

public class ALCANCIA {

    public static void main(String[] args) {
        Ingreso mod = new Ingreso();
        ConsultasIngreso modC = new ConsultasIngreso();
        frmIngreso frm = new frmIngreso();

        CtrIngreso ctrl = new CtrIngreso(mod, modC, frm);
        ctrl.iniciar();
        frm.setVisible(true);
    }

}

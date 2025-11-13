package com.josue.c1.registrocuentas;

import javax.swing.JOptionPane;

public class CerrarCuentas {

    public static void cerrarCuenta(Registrocuentas[] cuentas) {
        String numero = JOptionPane.showInputDialog("Ingrese el número de cuenta a cerrar:");

        boolean encontrada = false;

        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i] != null) {
                if (cuentas[i].getNumeroCuenta().equals(numero)) {
                    encontrada = true;
                    if (cuentas[i].getSaldo() == 0) {
                        cuentas[i] = null;
                        JOptionPane.showMessageDialog(null, "Cuenta cerrada con éxito.");
                    } else {
                        JOptionPane.showMessageDialog(null, "La cuenta debe tener saldo 0 para poder cerrarla.");
                    }
                    break;
                }
            }
        }

        if (!encontrada) {
            JOptionPane.showMessageDialog(null, "Cuenta no encontrada.");
        }
    }
}

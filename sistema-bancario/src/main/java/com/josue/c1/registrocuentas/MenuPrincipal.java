package com.josue.c1.registrocuentas;

import javax.swing.JOptionPane;

public class MenuPrincipal {

    public static void main(String[] args) {
        Registrocuentas[] cuentas = new Registrocuentas[10];
        int totalCuentas = 0;
        int opcion;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                "MENÚ PRINCIPAL\n" +
                "1. Registrar nueva cuenta\n" +
                "2. Realizar transacciones (Depósito, Retiro, Transferencia)\n" +
                "3. Registrar préstamo\n" +
                "4. Cerrar cuenta\n" +
                "5. Salir\n" +
                "Seleccione una opción:"
            ));

            switch (opcion) {
                case 1:
                    if (totalCuentas < cuentas.length) {
                        Registrocuentas nueva = Registrocuentas.registrarNuevaCuenta();
                        cuentas[totalCuentas] = nueva;
                        totalCuentas++;
                    } else {
                        JOptionPane.showMessageDialog(null, "Límite máximo de cuentas alcanzado.");
                    }
                    break;

                case 2:
                    if (totalCuentas > 0) {
                        Transferencia transacciones = new Transferencia(cuentas);
                        transacciones.mostrarMenuTransacciones();
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe registrar al menos una cuenta.");
                    }
                    break;

                case 3:
                    RegistroPrestamos.registrarPrestamo();
                    break;

                case 4:
                    if (totalCuentas > 0) {
                        CerrarCuentas.cerrarCuenta(cuentas);
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay cuentas para cerrar.");
                    }
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema. ¡Hasta luego!");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
            }

        } while (opcion != 5);
    }
}

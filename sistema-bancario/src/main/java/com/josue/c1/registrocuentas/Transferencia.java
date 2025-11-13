package com.josue.c1.registrocuentas;

import javax.swing.JOptionPane;

public class Transferencia {

    private Registrocuentas[] cuentas;

    public Transferencia(Registrocuentas[] cuentas) {
        this.cuentas = cuentas;
    }

    public void mostrarMenuTransacciones() {
        String opcion = JOptionPane.showInputDialog(
            "MENÚ TRANSACCIONES\n" +
            "1. Depósito\n" +
            "2. Retiro\n" +
            "3. Transferencia\n" +
            "4. Cancelar\n" +
            "Seleccione una opción:"
        );

        switch (opcion) {
            case "1":
                realizarDeposito();
                break;
            case "2":
                realizarRetiro();
                break;
            case "3":
                realizarTransferencia();
                break;
            case "4":
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida.");
                break;
        }
    }

    public void realizarDeposito() {
        Registrocuentas cuenta = buscarCuenta("Ingrese el número de cuenta para depósito:");
        if (cuenta != null) {
            double monto = solicitarMonto("Ingrese el monto a depositar:");
            cuenta.depositar(monto);
        }
    }

    public void realizarRetiro() {
        Registrocuentas cuenta = buscarCuenta("Ingrese el número de cuenta para retiro:");
        if (cuenta != null) {
            double monto = solicitarMonto("Ingrese el monto a retirar:");
            cuenta.retirar(monto);
        }
    }

    public void realizarTransferencia() {
        Registrocuentas origen = buscarCuenta("Ingrese el número de cuenta de origen:");
        if (origen != null) {
            Registrocuentas destino = buscarCuenta("Ingrese el número de cuenta de destino:");
            if (destino != null && !origen.getNumeroCuenta().equals(destino.getNumeroCuenta())) {
                double monto = solicitarMonto("Ingrese el monto a transferir:");
                origen.transferir(destino, monto);
            } else {
                JOptionPane.showMessageDialog(null, "Cuenta de destino inválida o igual a la de origen.");
            }
        }
    }

    private Registrocuentas buscarCuenta(String mensaje) {
        String numero = JOptionPane.showInputDialog(mensaje);

        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i] != null) {
                if (cuentas[i].getNumeroCuenta().equals(numero)) {
                    return cuentas[i];
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Cuenta no encontrada.");
        return null;
    }

    private double solicitarMonto(String mensaje) {
        double monto = -1;

        while (monto <= 0) {
            try {
                monto = Double.parseDouble(JOptionPane.showInputDialog(mensaje));
                if (monto <= 0) {
                    JOptionPane.showMessageDialog(null, "El monto debe ser mayor a 0.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
            }
        }

        return monto;
    }
}

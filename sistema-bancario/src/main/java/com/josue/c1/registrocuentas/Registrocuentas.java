package com.josue.c1.registrocuentas;

import javax.swing.JOptionPane;

public class Registrocuentas {

    private String nombreCliente;
    private String identificacion;
    private String tipoCuenta;
    private String numeroCuenta;
    private double saldo;
    private String fechaApertura;

    public Registrocuentas(String nombreCliente, String identificacion, String tipoCuenta, double saldo, String fechaApertura) {
        this.nombreCliente = nombreCliente;
        this.identificacion = identificacion;
        this.tipoCuenta = tipoCuenta;
        this.numeroCuenta = generarNumeroCuenta();
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
    }

    private String generarNumeroCuenta() {
        int parte1 = (int) (Math.random() * 900) + 100;
        int parte2 = (int) (Math.random() * 90000) + 10000;
        return parte1 + "-" + parte2;
    }

    public static Registrocuentas registrarNuevaCuenta() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
        String id = JOptionPane.showInputDialog("Ingrese la identificación:");
        String tipo = "";
        while (true) {
            tipo = JOptionPane.showInputDialog("Ingrese el tipo de cuenta (Ahorros/Corriente/Empresarial):");
            if (tipo != null) {
                tipo = tipo.toUpperCase();
                if (tipo.equals("AHORROS") || tipo.equals("CORRIENTE") || tipo.equals("EMPRESARIAL")) {
                    break;
                }
            }
            JOptionPane.showMessageDialog(null, "Tipo inválido.");
        }

        double saldo = -1;
        while (saldo < 0) {
            try {
                saldo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el saldo inicial:"));
                if (saldo < 0) {
                    JOptionPane.showMessageDialog(null, "El saldo no puede ser negativo.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
            }
        }

        String fecha = JOptionPane.showInputDialog("Ingrese la fecha de apertura (dd-mm-aaaa):");

        Registrocuentas nueva = new Registrocuentas(nombre, id, tipo, saldo, fecha);

        JOptionPane.showMessageDialog(null,
            "Cuenta registrada con éxito\n" +
            "Número de cuenta: " + nueva.getNumeroCuenta() + "\n" +
            "Tipo: " + nueva.getTipoCuenta() + "\n" +
            "Saldo: " + nueva.getSaldo());

        return nueva;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            JOptionPane.showMessageDialog(null, "Depósito exitoso. Nuevo saldo: " + saldo);
        } else {
            JOptionPane.showMessageDialog(null, "El monto debe ser mayor a 0.");
        }
    }

    public void retirar(double monto) {
        if (monto > 0 && saldo >= monto) {
            saldo -= monto;
            JOptionPane.showMessageDialog(null, "Retiro exitoso. Nuevo saldo: " + saldo);
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente o monto inválido.");
        }
    }

    public void transferir(Registrocuentas destino, double monto) {
        if (!this.tipoCuenta.equals(destino.tipoCuenta)) {
            JOptionPane.showMessageDialog(null, "No se puede transferir entre cuentas de diferentes tipos.");
            return;
        }

        if (monto > 0 && saldo >= monto) {
            saldo -= monto;
            destino.depositar(monto);
            JOptionPane.showMessageDialog(null, "Transferencia realizada. Nuevo saldo: " + saldo);
        } else {
            JOptionPane.showMessageDialog(null, "Monto inválido o saldo insuficiente.");
        }
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }
}

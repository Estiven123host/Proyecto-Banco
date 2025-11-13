package com.josue.c1.registrocuentas;

import javax.swing.JOptionPane;

public class RegistroPrestamos {

    public static void registrarPrestamo() {
        int prestamosActivos = 0;
        final int MAX_PRESTAMOS = 2;

        while (prestamosActivos < MAX_PRESTAMOS) {
            try {
                String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
                String idCliente = JOptionPane.showInputDialog("Ingrese la identificación del cliente:");

                double montoCredito = solicitarMonto("Ingrese el monto del crédito:");
                double tasaInteres = solicitarMonto("Ingrese la tasa de interés (por ejemplo: 5 para 5%):") / 100;
                int plazoMeses = (int) solicitarMonto("Ingrese el plazo en meses:");

                String fechaInicio = JOptionPane.showInputDialog("Ingrese la fecha de inicio (dd/mm/aaaa):");

                String numeroOperacion = generarNumeroOperacion();

                double cuotaMensual;
                if (tasaInteres == 0) {
                    cuotaMensual = montoCredito / plazoMeses;
                } else {
                    cuotaMensual = (montoCredito * tasaInteres) / (1 - Math.pow(1 + tasaInteres, -plazoMeses));
                }

                String resultado = "Nombre del cliente: " + nombreCliente +
                        "\nIdentificación: " + idCliente +
                        "\nNúmero de operación: " + numeroOperacion +
                        "\nMonto del crédito: $" + String.format("%.2f", montoCredito) +
                        "\nTasa de interés: " + String.format("%.2f%%", tasaInteres * 100) +
                        "\nPlazo: " + plazoMeses + " meses" +
                        "\nFecha de inicio: " + fechaInicio +
                        "\nCuota mensual: $" + String.format("%.2f", cuotaMensual);

                JOptionPane.showMessageDialog(null, resultado);
                prestamosActivos++;

                if (prestamosActivos < MAX_PRESTAMOS) {
                    int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea registrar otro préstamo?", "Continuar", JOptionPane.YES_NO_OPTION);
                    if (respuesta != JOptionPane.YES_OPTION) {
                        break;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ha alcanzado el número máximo de préstamos permitidos.");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error. Intente nuevamente.");
            }
        }
    }

    private static String generarNumeroOperacion() {
        int parte1 = (int) (Math.random() * 10000);
        int parte2 = (int) (Math.random() * 10000);
        int anio = java.time.LocalDate.now().getYear();
        return String.format("%04d-%04d-%d", parte1, parte2, anio);
    }

    private static double solicitarMonto(String mensaje) {
        double monto = -1;
        while (monto <= 0) {
            try {
                monto = Double.parseDouble(JOptionPane.showInputDialog(mensaje));
                if (monto <= 0) {
                    JOptionPane.showMessageDialog(null, "El valor debe ser mayor a 0.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
            }
        }
        return monto;
    }
}

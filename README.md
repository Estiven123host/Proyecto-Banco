# 🏦 Proyecto Banco – Sistema Bancario en Java

Este proyecto es un **sistema bancario** desarrollado en Java como parte de un trabajo universitario.  
Incluye funcionalidades completas para gestionar cuentas bancarias, transacciones y procesos internos del banco.

El objetivo del proyecto es aplicar **POO**, manejo de clases, estructuras de control, validaciones y archivos siguiendo los requerimientos del curso.

---

##  Funcionalidades Principales

###  Registro de cuentas
- Registra clientes con una única cuenta.
- Número de cuenta generado automáticamente en formato `###-#####`.
- Máximo de 50 cuentas registradas.
- Tipos de cuenta:
  - Ahorros
  - Corriente
  - Plazo fijo

---

###  Procesos de transacciones (Depósito, Retiro y Transferencia)
- Depósitos con validación de tipo de cuenta.
- Retiros con verificación de saldo suficiente.
- Transferencias entre cuentas válidas.
- Registro detallado de cada transacción:
  - Tipo (Depósito, Retiro, Transferencia)
  - Cliente
  - Monto
  - Fecha
  - Cuenta destino (si aplica)
- Máximo de 100 transacciones almacenadas.

---

##  Arquitectura del Proyecto

El sistema está organizado en las siguientes clases:

###  **CuentaBancaria**
- Representa una cuenta individual.
- Manejo de saldo, número de cuenta y tipo de cuenta.
- Métodos clave: depositar, retirar, transferir.

###  **Banco**
- Controla el registro de cuentas.
- Maneja las transacciones realizadas.
- Realiza validaciones globales.

###  **TipoCuenta (Enum)**
- Enumera los tipos de cuenta válidos del sistema.

###  **BancoApp**
- Contiene el menú principal e interacción con el usuario.
- Muestra opciones, captura datos e invoca métodos del banco.

---

##  Tecnologías Utilizadas

- **Java 8+**
- Programación Orientada a Objetos (POO)
- Estructuras básicas:
  - `if / else`
  - `switch`
  - `while`
  - `for`
- Arreglos unidimensionales
- `Scanner`, `String` y `JOptionPane`

---

##  Cómo ejecutar el proyecto

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/Estiven123host/Proyecto-Banco.git

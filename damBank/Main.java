package damBank;

import java.util.Scanner;

import dawbank.CuentaBancaria;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Ingrese el IBAN de la cuenta: ");
		String iban = scanner.nextLine();

		System.out.println("Ingrese el titular de la cuenta: ");
		String titular = scanner.nextLine();

		CuentaBancaria cuenta = new CuentaBancaria(iban, titular);
		int opcion;
		do {
			mostrarMenu();

			opcion = scanner.nextInt();
			scanner.nextLine();

			switch (opcion) {
			case 1:
				cuenta.mostrarInformacion();
				break;
			case 2:
				System.out.println("IBAN: " + cuenta.getIban());
				break;
			case 3:
				System.out.println("Titular: " + cuenta.getTitular());
				break;
			case 4:
				System.out.println("Saldo: " + cuenta.getSaldo() + " euros");
				break;
			case 5:
				System.out.print("Ingrese la cantidad a ingresar: ");
				double cantidadIngreso = scanner.nextDouble();
				cuenta.realizarIngreso(cantidadIngreso);
				if (cantidadIngreso > 3000) {
					System.out.println("AVISO: Notificar a hacienda.");

				}
				break;
			case 6:
				System.out.print("Ingrese la cantidad a retirar: ");
				double cantidadRetirada = scanner.nextDouble();
				cuenta.realizarRetirada(cantidadRetirada);
				break;
			case 7:
				System.out.println("Movimientos:");
				cuenta.mostrarMovimientos();
				break;
			case 8:
				System.out.println("Saliendo del programa. Vuelve pronto!");
				break;
			default:
				System.out.println("Opcion no valida. Intentelo de nuevo.");
			}
		} while (opcion != 8);

		scanner.close();
	}

	public static void mostrarMenu() {
		System.out.println("\n=== Menu Principal ===");
		System.out.println("1. Datos de la cuenta");
		System.out.println("2. Mostrar IBAN");
		System.out.println("3. Mostrar Titular");
		System.out.println("4. Mostrar Saldo");
		System.out.println("5. Realizar Ingreso");
		System.out.println("6. Realizar Retirada");
		System.out.println("7. Mostrar Movimientos");
		System.out.println("8. Salir");
		System.out.print("Seleccione una opcion: ");
	}
}

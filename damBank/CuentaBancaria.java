package damBank;

import java.util.ArrayList;
import java.util.List;
/**
 * @author pablo
 * @since asdfasd
 * @version assdad
 */
public class CuentaBancaria {
	
	
	private String iban;
	private String titular;
	private double saldo;
	private final List<String> movimientos;

	private static final int MAX_MOVIMIENTOS = 10;
	private static final double SALDO_MINIMO = -50;
	
	/**
	 * 
	 * @param iban  sadasdadsasdasdasdsadasdas
	 * @param titular asdasdadasdadadadsad
	 */
	public CuentaBancaria(String iban, String titular) {
		this.iban = iban;
		this.titular = titular;
		this.saldo = 0;
		this.movimientos = new ArrayList<>();
	}
	/**
	 * 
	 * @return devuelve un iban
	 */
	public String getIban() {
		return iban;
	}

	public String getTitular() {
		return titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public void realizarIngreso(double cantidad) {
		if (cantidad > 0) {
			saldo += cantidad;
			registrarMovimiento("Ingreso: +" + cantidad + " euros");
			verificarAvisos();
		} else {
			System.out.println("Error: La cantidad de ingreso debe ser mayor a cero.");
		}
	}

	public void realizarRetirada(double cantidad) {
		if (cantidad > 0) {
			if (saldo - cantidad >= SALDO_MINIMO) {
				saldo -= cantidad;
				registrarMovimiento("Retirada: -" + cantidad + " euros");
				verificarAvisos();
			} else {
				System.out.println("AVISO: Saldo negativo. La retirada no es posible.");
			}
		} else {
			System.out.println("Error: La cantidad de retirada debe ser mayor a cero.");
		}
	}

	private void registrarMovimiento(String movimiento) {
		movimientos.add(movimiento);
		if (movimientos.size() > MAX_MOVIMIENTOS) {
			movimientos.remove(0);
		}
	}

	private void verificarAvisos() {
		if (saldo < SALDO_MINIMO) {
			System.out.println("AVISO: Saldo negativo.");
		}

	}

	public void mostrarInformacion() {
		System.out.println("IBAN: " + iban);
		System.out.println("Titular: " + titular);
		System.out.println("Saldo: " + saldo + " euros");
		System.out.println("Movimientos:");
		for (String movimiento : movimientos) {
			System.out.println("- " + movimiento);
		}
	}

	public void mostrarMovimientos() {
		System.out.println("Movimientos:");
		for (String movimiento : movimientos) {
			System.out.println("- " + movimiento);
		}
	}

}

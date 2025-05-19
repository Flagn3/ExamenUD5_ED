package test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import examen.ProductoImportado;
import examen.ServicioAranceles;

public class ServicioArancelesTest {

	@Test
	public void calcularArancelProductoNull() {
		ProductoImportado p = null;

		assertThrows(IllegalArgumentException.class, () -> {
			ServicioAranceles.calcularArancel(p);
		});
	}

	@Test
	public void calcularArancelChinaElectronica() {
		ProductoImportado p = new ProductoImportado("Xiaomi", "China", 200, "electrónica");

		double total = ServicioAranceles.calcularArancel(p);

		assertEquals(78.0, total);

	}
	
	@Test
	public void calcularArancelChinatextil() {
		ProductoImportado p = new ProductoImportado("camiseta", "China", 20, "textil");

		double total = ServicioAranceles.calcularArancel(p);

		assertEquals(8.8, total);

	}
	
	@Test
	public void calcularArancelUEelectronica() {
		ProductoImportado p = new ProductoImportado("movil", "Unión Europea", 300, "electrónica");

		double total = ServicioAranceles.calcularArancel(p);

		assertEquals(75, total);

	}
	
	@Test
	public void calcularArancelUEtextil() {
		ProductoImportado p = new ProductoImportado("camiseta", "Unión Europea", 10, "textil");

		double total = ServicioAranceles.calcularArancel(p);

		assertEquals(3, total);

	}
	
	@Test
	public void calcularArancelBaseNoCategoria() {
		ProductoImportado p = new ProductoImportado("burrito", "México", 3, "alimentacion");

		double total = ServicioAranceles.calcularArancel(p);

		assertEquals(0.3, total);

	}
	
	

	@Test
	public void agregarArancelPaisNoValidoSuperior() {

		assertThrows(IllegalArgumentException.class, () -> {
			ServicioAranceles.agregarArancelPais("España", 3.5);
		});

	}

	@Test
	public void agregarArancelPaisNoValidoInferior() {

		assertThrows(IllegalArgumentException.class, () -> {
			ServicioAranceles.agregarArancelPais("España", -1);
		});

	}

	@Test
	public void agregarArancelPaisValido() {

		ServicioAranceles.agregarArancelPais("España", 0.5);

	}

}

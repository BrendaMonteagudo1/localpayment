package ar.com.localpayment.api.localpayment;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.com.localpayment.api.localpayment.entities.Tarjeta;
import ar.com.localpayment.api.localpayment.services.TarjetaService;

@SpringBootTest
class LocalpaymentApplicationTests {
	@Autowired
	TarjetaService tarjetaService;


	@Test
	void tarjetaTestPrecioOk() {

		Tarjeta consumoOK = new Tarjeta();
		consumoOK.setConsumo(new BigDecimal(100));

		// Assert: afirmar
		// afirmar quie sea verdadero: assertTrue
		assertTrue(tarjetaService.validarPrecio(consumoOK));
	}

	
	@Test
	void tarjetaValidarMarca() {
	
		String tarjeta = "SCO";
		String tarjeta2 = "SQUA";
		String tarjeta3 = "PERE";

		String tarjeta4 = "MALA";



		Tarjeta marcaTarjetaId = new Tarjeta();
		marcaTarjetaId.setMarca(tarjeta);

		Tarjeta marcaTarjetaId2 = new Tarjeta();
		marcaTarjetaId2.setMarca(tarjeta2);

		Tarjeta marcaTarjetaId3 = new Tarjeta();
		marcaTarjetaId3.setMarca(tarjeta3);

		
	

		//assertTrue(tarjetaService.ValidarMarca(tarjeta));
		//assertTrue(tarjetaService.ValidarMarca(tarjeta2));
		//assertTrue(tarjetaService.ValidarMarca(tarjeta3));


		//assertFalse(tarjetaService.ValidarMarca(tarjeta4);
	}


	 


}

		

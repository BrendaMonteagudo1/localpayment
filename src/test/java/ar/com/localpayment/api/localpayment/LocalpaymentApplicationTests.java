package ar.com.localpayment.api.localpayment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.yaml.snakeyaml.util.EnumUtils;

import ar.com.localpayment.api.localpayment.entities.Tarjeta;
import ar.com.localpayment.api.localpayment.entities.Tarjeta.MarcaTarjetaEnum;
import ar.com.localpayment.api.localpayment.services.TarjetaService;

@SpringBootTest
class LocalpaymentApplicationTests {
	@Autowired
	TarjetaService tarjetaService;


	@Test
	void tarjetaTestPrecioOk() {

		Tarjeta consumoOK = new Tarjeta();
		consumoOK.setConsumo(new BigDecimal(99));

		// Assert: afirmar
		// afirmar quie sea verdadero: assertTrue
		assertTrue(tarjetaService.validarPrecio(consumoOK));
	}

	
	@Test
	void tarjetaValidarMarca() {
	
		String tarjeta = "SCO";
		String tarjeta2 = "SQUA";
		String tarjeta3 = "PERE";

		//String tarjeta4 = "MALA";



		Tarjeta marcaTarjetaId = new Tarjeta();
		marcaTarjetaId.setMarca(tarjeta);

		Tarjeta marcaTarjetaId2 = new Tarjeta();
		marcaTarjetaId2.setMarca(tarjeta2);

		Tarjeta marcaTarjetaId3 = new Tarjeta();
		marcaTarjetaId3.setMarca(tarjeta3);

	

		
	    assertEquals(MarcaTarjetaEnum.SCO,tarjetaService.validarMarca(tarjeta)); 
		assertEquals(MarcaTarjetaEnum.SQUA,tarjetaService.validarMarca(tarjeta2));
	    assertEquals(MarcaTarjetaEnum.PERE,tarjetaService.validarMarca(tarjeta3));

	

		//assertFalse(tarjetaService.validarMarca(tarjeta4));
		
	}
	



	 


}

		

package testesClasses;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import calculaPesos.CalcularPesoIdeal;

public class CalcularPesoIdealTeste {
	
	CalcularPesoIdeal CalPeso;
	
	@Before
	public void setUp() throws Exception {
		CalPeso = new CalcularPesoIdeal();
	}

	@Test
	public void testCalcularClassificacaoPeso() {
		assertEquals("Peso Normal", CalPeso.calcularClassificacaoPeso(60, 1.7));
	}
	
	@Test
	public void testCalcularPesoIdealCrianca() {
		assertEquals(17.0, CalPeso.calcularPesoIdealCrianca(4), 0);
	}

	@Test
	public void testCalcularPesoIdealAdulto() {
		assertEquals("Homem", 68.1472, CalPeso.calcularPesoIdealAdulto(1.76, false), 0.001);
		assertEquals("Mulher", 65.0496, CalPeso.calcularPesoIdealAdulto(1.76, true), 0.001);
	}

	@Test
	public void testCalcularPesoIdealIdoso() {
		double altura = 1.7;
        int idade65a69 = 66;
        int idade70a74 = 72;
        int idade75a79 = 78;
        int idade80a84 = 82;
        int idade85mais = 90;

        boolean isMulher = true;

        try {
            double pesoIdeal65a69 = CalPeso.calcularPesoIdealIdoso(altura, idade65a69, isMulher);
            assertEquals(76.585, pesoIdeal65a69, 0.001);

            double pesoIdeal70a74 = CalPeso.calcularPesoIdealIdoso(altura, idade70a74, isMulher);
            assertEquals(76.00699999999999, pesoIdeal70a74, 0.001);

            double pesoIdeal75a79 = CalPeso.calcularPesoIdealIdoso(altura, idade75a79, isMulher);
            assertEquals(75.429, pesoIdeal75a79, 0.001);

            double pesoIdeal80a84 = CalPeso.calcularPesoIdealIdoso(altura, idade80a84, isMulher);
            assertEquals(73.695, pesoIdeal80a84, 0.001);

            double pesoIdeal85mais = CalPeso.calcularPesoIdealIdoso(altura, idade85mais, isMulher);
            assertEquals(68.204, pesoIdeal85mais, 0.001);
        } catch (Exception e) {
            fail("Exceção lançada: " + e.getMessage());
        }
	}
	 

}

package testesClasses;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import calculaPesos.CalcularCalorias;

public class CalcularCaloriasTeste {
	
	CalcularCalorias CalCalorias;

	@Before
	public void setUp() throws Exception {
		CalCalorias = new CalcularCalorias();
	}

	@Test
	public void testCalcularNecessidadeDiariaEnergia() {
		
		// Mulher de 31 anos, 1.68m e 69kg, trabalha sentada e não pratica atividade física regularmente
        double necessidadeEnergia = CalCalorias.calcularNecessidadeDiariaEnergia("feminino", 31, 69, 1.68, 1.2);
        assertEquals(1715.16, necessidadeEnergia, 0.01); // Valor esperado: 1715.16 calorias

        // Homem de 25 anos, 1.75m e 80kg, dia-a-dia movimentado sem atividades físicas programadas
        necessidadeEnergia = CalCalorias.calcularNecessidadeDiariaEnergia("masculino", 25, 80, 1.75, 1.3);
        assertEquals(2473.9, necessidadeEnergia, 0.01); // Valor esperado: 2473.9 calorias

        // Mulher de 60 anos, 1.60m e 55kg, atividade física diária por mais de três horas
        necessidadeEnergia = CalCalorias.calcularNecessidadeDiariaEnergia("feminino", 60, 55, 1.60, 1.7);
        assertEquals(2222.75, necessidadeEnergia, 0.01); // Valor esperado: 2222.75 calorias
	}
}

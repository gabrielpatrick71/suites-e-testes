package calculaPesos;

public class CalcularCalorias {
    private static final double[] TMB_MUL_FEMININO = {12.2, 14.7, 8.7, 10.5};
    private static final double[] TMB_ADD_FEMININO = {746, 496, 829, 596};
    private static final double[] TMB_MUL_MASCULINO = {17.5, 15.3, 8.7, 13.5};
    private static final double[] TMB_ADD_MASCULINO = {651, 679, 879, 487};

    public double calcularNecessidadeDiariaEnergia(String genero, int idade, double peso, double altura, double fatorAtividade) {       
    	double[] tmbMul;
        double[] tmbAdd;
        double tmb;

        if (genero.equalsIgnoreCase("feminino")) {
            tmbMul = TMB_MUL_FEMININO;
            tmbAdd = TMB_ADD_FEMININO;
        } else {
            tmbMul = TMB_MUL_MASCULINO;
            tmbAdd = TMB_ADD_MASCULINO;
        }

        if (idade >= 10 && idade <= 18) {
            tmb = tmbMul[0] * peso + tmbAdd[0];
        } else if (idade > 18 && idade <= 30) {
            tmb = tmbMul[1] * peso + tmbAdd[1];
        } else if (idade > 30 && idade <= 60) {
            tmb = tmbMul[2] * peso + tmbAdd[2];
        } else {
            tmb = tmbMul[3] * peso + tmbAdd[3];
        }
    	
        return tmb * fatorAtividade;
    }
}


package calculaPesos;

public class CalcularPesoIdeal {
    private static final double IMC_DESEJADO_HOMENS = 22.0; // IMC desejado para homens adultos
    private static final double IMC_DESEJADO_MULHERES = 21.0; // IMC desejado para mulheres adultas
    private static final double[] IMC_PERCENTIL_HOMENS = {24.3, 25.1, 23.9, 23.7, 23.1}; // IMC percentil para homens idosos
    private static final double[] IMC_PERCENTIL_MULHERES = {26.5, 26.3, 26.1, 25.5, 23.6}; // IMC percentil para mulheres idosas

    public String calcularClassificacaoPeso(double peso, double altura) {
        double imc = peso / (altura * altura);

        if (imc < 20) {
            return "Abaixo do peso";
        } else if (imc < 25) {
            return "Peso Normal";
        } else if (imc < 30) {
            return "Sobre Peso";
        } else if (imc < 40) {
            return "Obeso";
        } else {
            return "Obeso Mórbido";
        }
    }

    public double calcularPesoIdealCrianca(int idade) {
        return (idade * 2) + 9;
    }

    public  double calcularPesoIdealAdulto(double altura, boolean isMulher) {
        double imcDesejado = isMulher ? IMC_DESEJADO_MULHERES : IMC_DESEJADO_HOMENS;
        return imcDesejado * (altura * altura);
    }

    public double calcularPesoIdealIdoso(double altura, int idade, boolean isMulher) throws Exception {
        double imcPercentil;

        if (idade >= 65 && idade <= 69) {
            imcPercentil = isMulher ? IMC_PERCENTIL_MULHERES[0] : IMC_PERCENTIL_HOMENS[0];
        } else if (idade >= 70 && idade <= 74) {
            imcPercentil = isMulher ? IMC_PERCENTIL_MULHERES[1] : IMC_PERCENTIL_HOMENS[1];
        } else if (idade >= 75 && idade <= 79) {
            imcPercentil = isMulher ? IMC_PERCENTIL_MULHERES[2] : IMC_PERCENTIL_HOMENS[2];
        } else if (idade >= 80 && idade <= 84) {
            imcPercentil = isMulher ? IMC_PERCENTIL_MULHERES[3] : IMC_PERCENTIL_HOMENS[3];
        } else if (idade >= 85) {
            imcPercentil = isMulher ? IMC_PERCENTIL_MULHERES[4] : IMC_PERCENTIL_HOMENS[4];
        } else {
            throw new Exception("A idade não se enquadra nos critérios informados.");
        }

        return imcPercentil * (altura * altura);
    }
}

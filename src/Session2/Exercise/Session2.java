package Session2.Exercise;

//Link --> https://www.mathsisfun.com/data/correlation.html
public class Session2 {
    public static void main(String[] args) {
        double[] variableX = {14.2, 16.4, 11.9, 15.2, 18.5, 22.1, 19.4, 25.1, 23.4, 18.1, 22.6, 17.2};
        double[] variableY = {215, 325, 185, 332, 406, 522, 412, 614, 544, 421, 445, 408};

        System.out.println(calculateCorrelation(variableX, variableY));
    }

    private static double calculateCorrelation(double[] variableX, double[] variableY) {
        double meanX = sumElements(variableX) / variableX.length;
        double meanY = sumElements(variableY) / variableY.length;
        double numerator = calculateNumerator(variableX, meanX, variableY, meanY);
        double denominator = calculateDenominator(variableX, meanX, variableY, meanY);
        return numerator / denominator;
    }


    private static double sumElements(double[] variable) {
        double sum = 0;
        for (double element : variable)
            sum += element;
        return sum;
    }

    private static double calculateNumerator(double[] variableX, double meanX, double[] variableY, double meanY) {
        double numerator = 0;
        for (int i = 0; i < variableX.length; i++)
            numerator += (variableX[i] - meanX) * (variableY[i] - meanY);
        return numerator;
    }

    private static double calculateDenominator(double[] variableX, double meanX, double[] variableY, double meanY) {
        double firstSum = 0;
        double secondSum = 0;
        for (int i = 0; i < variableX.length; i++){
            firstSum += Math.pow(variableX[i] - meanX, 2);
            secondSum += Math.pow(variableY[i] - meanY, 2);
        }
        return Math.sqrt(firstSum * secondSum);
    }

}

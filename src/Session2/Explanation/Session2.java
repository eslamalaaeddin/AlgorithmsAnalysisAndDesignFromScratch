package Session2.Explanation;

@SuppressWarnings("ALL")
public class Session2 {
    public static void main(String[] args) {
        double[] sample = {1, 2, 3};
        System.out.println("Standard Deviation: " + calculateSTD(sample));
    }

    static double calculateSTD(double[] sample) {
        double numberOfElements = sample.length;
        double mew = sumElements(sample) / numberOfElements;
        double standardDeviation = Math.sqrt(getNumerator(sample, mew) / numberOfElements);
        return standardDeviation;
    }

    private static double sumElements(double[] sample) {
        double sum = 0;
        for (double element : sample)
            sum += element;
        return sum;
    }

    private static double getNumerator(double[] sample, double mew) {
        double sum = 0;
        for (double element : sample)
            sum += Math.pow((element - mew), 2);
        return sum;
    }
}

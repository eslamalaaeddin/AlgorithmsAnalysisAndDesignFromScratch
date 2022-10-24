package Session1;

public class Session1 {
    public static void main(String[] args) {
        System.out.println("ParallelogramArea: " + getParallelogramArea(10f, 6f));
        System.out.println("TrapezoidArea: " + getTrapezoidArea(10f, 6f, 2f));
    }

    private static float getParallelogramArea(float base, float height) {
        float area = base * height;
        return area;
    }

    private static float getTrapezoidArea(float upperBase, float lowerBase, float height) {
        float area = ((upperBase + lowerBase) / 2) * height;
        return area;
    }
}



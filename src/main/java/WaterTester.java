public class WaterTester {
    public static void main(String[] args) {
        Water water = new Water();

        Runnable releaseHydrogen = ()-> System.out.print("H");
        Runnable releaseOxygen = ()-> System.out.print("O");

        for (int i = 0; i < 4; i++) {
            new Thread(() -> water.hydrogen(releaseHydrogen)).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(() -> water.oxygen(releaseOxygen)).start();
        }
    }
}
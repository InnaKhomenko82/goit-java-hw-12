public class RepeatTester {
    public static void main(String[] args) {
        MyThreadPoolExecutor poolExecutor = new MyThreadPoolExecutor(3);
        poolExecutor.execute(new MyRunnable());
        poolExecutor.shutdown();
    }
}

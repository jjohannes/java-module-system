package app;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello from module " + App.class.getModule().getName());
    }
}

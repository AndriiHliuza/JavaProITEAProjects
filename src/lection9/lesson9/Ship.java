package lection9.lesson9;

public class Ship {
    private Engine engine;
    public int g = 6;

    protected class Engine {
        public int a = 5;
        public void launch() {
            System.out.println("Запуск двигуна");
        }
    }

    public final void init() {
        engine = new Engine();
        engine.launch();
    }
}

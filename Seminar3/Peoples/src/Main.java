import Model.Saver;
import View.ConsoleView;

public class Main {
    public static void main(String[] args) {
        InputController inputController = new InputController(new ConsoleView(), new Saver());
        inputController.run();
    }
}
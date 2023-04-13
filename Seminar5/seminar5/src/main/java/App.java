import controller.BankController;

public class App {
    public static void main(String[] args) {
        BankController bankController = new BankController();
        bankController.fillBankTestClient();
        bankController.mainMenu();
    }
}

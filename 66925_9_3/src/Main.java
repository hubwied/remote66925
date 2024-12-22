public class Main {
    public static void main(String[] args) {
        Account account = new Account("Jan Kowalski", 50, "12345");

        try {
            account.transfer(20);
        } catch (NotEnoughMoneyException e) {
            System.out.println(e);
            e.printStackTrace();
        } catch (Exception e) {
        } finally {
            System.out.println("Finally" + account.getBalance());
        }
    }
}
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws LimitedException {
        BankAccount bankAccount = new BankAccount(20000);
        while(true){
            try{
                bankAccount.withDraw(6000);
                System.out.println("На вашем счету: " + bankAccount.getAmount());
            } catch (LimitedException e) {
                System.out.println(e.getMessage());
                System.out.println("Желаете снять оставшиеся " + e.getRemainingAmount() + "сом ?");
                Scanner input = new Scanner(System.in);

                String answer = input.next();
                if(answer.equals("Да")){
                    bankAccount.withDraw(((int)e.getRemainingAmount()));
                    System.out.println("На вашем счету не осталось денег");
                    break;
                } else if (answer.equals("Нет")) {
                    System.out.println("На вашем счету также остаются: " + bankAccount.getAmount());
                    break;
                }else {
                    System.out.println("Да или Нет");
                }
            }
        }
    }
}
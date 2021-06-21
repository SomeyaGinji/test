package lecture04;

public class Exercise4_2 {
    public static void main(String[] args) {

        ATM atm = new ATM();

        String str1 = "染谷銀志";
        String str2 = "12345";

        atm.existsAccount(str1,str2);
        atm.registerAccount(str1,str2);

        if(atm.existsAccount(str1,str2)) {

            atm.deposit(str2, 1000);
            atm.withdraw(str2, 2000);
            atm.withdraw(str2, 500);

        }

    }
}

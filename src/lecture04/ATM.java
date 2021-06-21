package lecture04;

import java.util.ArrayList;
import java.util.List;

public class ATM {

    private List<Account> accountList;

    public ATM(){
        this.accountList = new ArrayList<>();
    }

    public void registerAccount(String name,String number){
        this.accountList.add(new Account(name,number));
        System.out.println(name+" さんのアカウントを口座番号:"+number+" で登録しました。");
    }

    public boolean existsAccount(String name, String number){
            if (name == accountList.get(0).getName() && number == accountList.get(0).getNumber()) {
                System.out.println("名前:" + name + " 口座番号:" + number + " は存在します。");
                return true;
            } else {
                System.out.println("名前:" + name + " 口座番号:" + number + " は存在しません。");
                return false;
            }
    }

    public void deposit(String number,long money){
        if(number == accountList.get(0).getNumber()){
            accountList.get(0).setBalance(money);
            System.out.println("口座番号:"+number+" に "+money+" 円入金しました。");
        } else {

        }
    }

    public long withdraw(String number,long money){

        if(number == accountList.get(0).getNumber()){
            long balance = accountList.get(0).getBalance(); //置き換えて簡略化
            if(money <= balance){
                accountList.get(0).setBalance(balance-money);
                System.out.println("口座番号:"+number+" から "+money+" 円引き出しました。残高:"+(balance-money)+"円です。");
            } else {
                System.out.println("口座番号:"+number+" から "+money+" 円引き出せませんでした。残高:"+balance+"円です。");
            }
        }
        return 0;
    }

}

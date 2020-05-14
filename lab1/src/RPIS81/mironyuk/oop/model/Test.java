package RPIS81.mironyuk.oop.model;


import RPIS81.mironyuk.oop.model.Account;
import RPIS81.mironyuk.oop.model.AccountManager;
import RPIS81.mironyuk.oop.model.Individual;

public class Test {
    public static void main (String[] args) {
        System.out.println("did it");
        lab1tests();
    }

    public static void lab1tests(){
        Account[] accounts=new Account[3];
        accounts[0]=new Account();
        accounts[1]=new Account("464568",5266.01);
        accounts[2]=new Account("554589",165489.68);
        System.out.println("Вывод до изменений");
        for (Account account:  accounts) {
            System.out.format("Номер счета: %s \nТекущий баланс: %s\n\n",account.getNumber(),account.getBalance());
        }

        accounts[0].setNumber("558956");
        accounts[1].setBalance(55635.12);
        accounts[2].setBalance(accounts[2].getBalance()-100000);

        System.out.println("Вывод после изменений");
        for (Account account:  accounts) {
            System.out.format("Номер счета: %s \nТекущий баланс: %s\n\n",account.getNumber(),account.getBalance());

        }
        Individual[] individuals=new Individual[3];
        individuals[0]=new Individual();
        individuals[1]=new Individual(3);
        individuals[2]=new Individual(accounts);

        for (Account account:  individuals[2].getAccounts()) {
            System.out.format("Номер счета: %s \nТекущий баланс: %s\n\n",account.getNumber(),account.getBalance());

        }
        individuals[2].add(new Account("565659",56.0));
        individuals[2].add(9,new Account("565656",56.0));
        individuals[2].add(10,new Account("565656",56.0));
        individuals[2].add(new Account("565658",56.0));
        individuals[2].remove(10);
        individuals[2].remove("565658");
        for (Account account:  individuals[2].sortedAccountsByBalance()) {
            System.out.format("Номер счета: %s \nТекущий баланс: %s\n\n",account.getNumber(),account.getBalance());

        }
        System.out.format("Суммарный счет: %s\n",individuals[2].totalBalance());

        AccountManager[] accountManagers=new AccountManager[2];
        accountManagers[0]=new AccountManager(13);
        accountManagers[1]=new AccountManager(individuals);

        for (Account account:  accountManagers[1].get(2).getAccounts()) {
            System.out.format("Номер счета: %s \nТекущий баланс: %s\n\n",account.getNumber(),account.getBalance());}}}


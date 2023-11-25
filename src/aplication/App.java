package aplication;

import model.entities.Account;
import model.exceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("entre com os dados da conta: ");
        System.out.print("entre com o número: ");
        int number = sc.nextInt();
        System.out.print("entre com o nome de usuario: ");
        String holder = sc.next();
        System.out.println("entre com o seu saldo inicial: ");
        double balance = sc.nextDouble();
        System.out.println("entre com seu limite de saque:");
        double whithdrawLimite = sc.nextDouble();

        Account acc = new Account(number,holder,balance,whithdrawLimite);
        double amount;

        System.out.println("deseja realizar um sque ou deposito? (s/d)");
        char x = sc.next().charAt(0);
        if (x == 'd'){
            System.out.println("entre com a quantioa de deposito: ");
            amount = sc.nextDouble();
            acc.deposit(amount);
        }else if (x == 's'){
            System.out.println("quanto deseja sacar? ");
            amount = sc.nextDouble();
            try {
            acc.withdraw(amount);
            }catch (DomainException e){
                System.out.println(e.getMessage());
            }
        }else {
            System.out.println("entrada invalida: ");
        }
        System.out.println(acc);
        System.out.println("fim do programa!");
        sc.close();

    }
}

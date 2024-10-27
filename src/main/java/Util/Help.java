package Util;

import java.math.BigDecimal;
import java.util.Scanner;

public class Help {
    private static String baseCode;
    private static String targetCode;
    private static final Scanner sc = new Scanner(System.in);
    private static BigDecimal amount;

    public static void readValues() {
        System.out.print("Enter the base code: ");
        baseCode = sc.next();
        System.out.print("Enter the target code: ");
        targetCode = sc.next();

    }

    public static int options() {

        System.out.println("Welcome to currencies converse");
        System.out.println("Choose from the following options:");
        System.out.println("1. COP - USD");
        System.out.println("2. COP - EUR");
        System.out.println("3. USD - COP");
        System.out.println("4. USD - EUR");
        System.out.println("5. EUR - COP");
        System.out.println("6. USD - EUR");
        System.out.println("7. Choose your base code and target code");
        System.out.println("8. Exit");
        System.out.print("Enter your option: ");
        return sc.nextInt();
    }

    public static String process(int option) {
        String url = "";
        switch (option) {
            case 1:
                amount = readAmount();
                return "https://v6.exchangerate-api.com/v6/2248b62ee494b59f4e0f7aa6/pair/COP/USD/" + amount;

            case 2:
                amount = readAmount();
                return "https://v6.exchangerate-api.com/v6/2248b62ee494b59f4e0f7aa6/pair/COP/EUR/" + amount;

            case 3:
                amount = readAmount();
                return "https://v6.exchangerate-api.com/v6/2248b62ee494b59f4e0f7aa6/pair/USD/COP/" + amount;

            case 4:
                amount = readAmount();
                return "https://v6.exchangerate-api.com/v6/2248b62ee494b59f4e0f7aa6/pair/USD/EUR/" + amount;

            case 5:
                amount = readAmount();
                return "https://v6.exchangerate-api.com/v6/2248b62ee494b59f4e0f7aa6/pair/EUR/COP/" + amount;

            case 6:
                amount = readAmount();
                return "https://v6.exchangerate-api.com/v6/2248b62ee494b59f4e0f7aa6/pair/EUR/USD/" + amount;


            case 7:
                readValues();
                amount = readAmount();
                return "https://v6.exchangerate-api.com/v6/2248b62ee494b59f4e0f7aa6/pair/)" + baseCode + "/" + targetCode + "/" + amount;

            case 8:
                System.exit(0);

        }
        return url;
    }


    public static BigDecimal readAmount() {
        BigDecimal amount = new BigDecimal(0);
        try {
            System.out.print("Enter the amount: ");
            amount = new BigDecimal(sc.next());
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount");
            System.out.println(e.getMessage());
        }
        return amount;

    }
}

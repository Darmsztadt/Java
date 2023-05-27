package edu.lab02;

import java.util.Scanner;
/**
 * Program oblicza pole powierzchni kątownika
 * @author Stanisław
 * @version 1.0
 * @see CProfile
 * @see java.lang.Math
 * @see java.lang.String#format(java.lang.String, java.lang.Object[])
 */
public class Main {

    public static void main(String[] args) {
        CProfile K50 = new CProfile("K50x50x5", 50., 50., 5., 7., 3.5);
        CProfile K120 = new CProfile("K120x120x12", 120., 120., 12., 13., 6.5);
        CProfile K90x60 = new CProfile("K90x60x8", 90., 60., 8., 9., 4.);
        System.out.println(K50.getResult());
        System.out.println(K50.getResult(1));
        System.out.println(K50.getResult(2));
        System.out.println(K50.getResult(3));
        String decision = "n";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Jeśli chcesz kontynuwać wciśnij t,  jeżeli chcesz zakończyć program wciśnij dowolny inny klawisz: ");
        decision = scanner.nextLine();
        while (decision.equalsIgnoreCase("t")) {
            System.out.println("Podaj nazwę kątownika: ");
            String name = scanner.nextLine();
            System.out.println("Podaj wartosc A: ");
            Double a = Double.valueOf(scanner.nextLine());
            System.out.println("Podaj wartosc B: ");
            Double b = Double.valueOf(scanner.nextLine());
            System.out.println("Podaj wartosc G: ");
            Double g = Double.valueOf(scanner.nextLine());
            System.out.println("Podaj wartosc r: ");
            Double r = Double.valueOf(scanner.nextLine());
            System.out.println("Podaj wartosc r1: ");
            Double r1 = Double.valueOf(scanner.nextLine());
            CProfile katownik = new CProfile(name, a, b, g, r, r1);
            System.out.println(katownik.getResult());
            System.out.println("Jeśli chcesz kontynuwać wciśnij t,  jeżeli chcesz zakończyć program wciśnij dowolny inny klawisz: ");
            decision = scanner.nextLine();
        }
    }
}

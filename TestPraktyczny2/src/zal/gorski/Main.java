package zal.gorski;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    //zad2
        CFigure[] figures = new CFigure[7];

        figures[0] = new CRectangle();
        figures[1] = new CRectangle(10.5,4.4);
        figures[2] = new CCircle();
        figures[3] = new CCircle(4.0/Math.pow(Math.PI,0.25));
        figures[4] = new CRectPipe();
        figures[5] = new CRectPipe(6.5,5.5,5.5,4.5);
        figures[6] = new CGenericCircle<Integer>(4);

        //zad3
        for (CFigure f : figures) {
            System.out.println(f.toString());
            System.out.println(f.info());;
            System.out.println("\n");
        }

        //zad4
        System.out.println(((CRectangle)figures[1]).info());
        System.out.println(((CCircle)figures[3]).info());

        //Ponieważ metoda info jest, statyczna nie podlega ona mechanizmowi polimorfizmu. W klasach dziedziczących
        //jest, ona tylko przysłaniana powoduje to, że wywoływana metoda zależna jest od referencji ustawionej na obiekt.

        //Interfejsy
        DimensionInformation figures2[] = new DimensionInformation[3];
        figures2 [0] = new CRectangle(12.3,5.8);
        figures2 [1] = new CCircle(8.0);
        figures2 [2] = new CRectPipe(12,9,3,4);

        System.out.println("Pole oraz obwody z wykorzystaniem interfejsów:");
        for (DimensionInformation d :figures2) {
            System.out.println("Pole: " + d.getArea());
            System.out.println("Obwód: " + d.getCircumference());
        }

        //zad5
        List<CFigure> list = new ArrayList<CFigure>();

        boolean doContinue=false;

        do{
            System.out.println("Podaj jaką Figurę dodać:\n 1.Kwadrat 2.Koło 3.Rura");
            int choice = 9;
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

            switch (choice){
                case 1:
                {
                    double A;
                    double B;
                    System.out.println("Podaj A:");
                    A = sc.nextDouble();
                    System.out.println("Podaj B:");
                    B = sc.nextDouble();
                    CFigure f = new CRectangle(A,B);
                    f.toString();
                    list.add(f);
                    break;
                }
                case 2:
                {
                    double D;
                    System.out.println("Podaj D:");
                    D = sc.nextDouble();
                    CFigure f = new CCircle(D);
                    f.toString();
                    list.add(f);
                    break;
                }
                case 3:
                {
                    double A;
                    double B;
                    double A1;
                    double B1;
                    System.out.println("Podaj A:");
                    A = sc.nextDouble();
                    System.out.println("Podaj B:");
                    B = sc.nextDouble();
                    System.out.println("Podaj A1:");
                    A1= sc.nextDouble();
                    System.out.println("Podaj B1:");
                    B1= sc.nextDouble();
                    CFigure f = new CRectPipe(A,B,A1,B1);
                    f.toString();
                    list.add(f);
                    break;
                }
            }

            System.out.println("Czy kontynuować? 1.Tak 2.Nie");
            int val = sc.nextInt();
            if(val==1){
                doContinue =true;
            }else{
                doContinue = false;
            }


        }while (doContinue);

        for (CFigure f : list) {
            System.out.println(f.toString());
            System.out.println(f.info());;
            System.out.println("\n");
        }

    }
}

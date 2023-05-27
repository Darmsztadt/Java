package edu.lab02;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CProfile {
    /**
     * Długość poziomego ramienia kątownika.
     * Dodatkowe informacje: musi być większe niż G i R.
     * Informacje od drugiej linii nie będą wyświetlane
     * w podsumowaniu, tylko w opisie szczegółowym danego pola.
     */
    protected Double A;
    /**
     * Długość pionowego ramienia kątownika
     */
    protected Double B;
    /**
     * Grubość ramion kątownika.
     */
    protected Double G;
    /**
     * Promień
     */
    protected Double R;
    /**
     * Promień 1
     */
    protected Double R1;
    /**
     * Standard
     */
    private static final String Standard = "PN-EN 10056-1:2000";
    /**
     * Imię kątownika.
     */
    private String Name;

    /**
     * Getter pola Standard
     *
     * @return standard
     */
    public static String getStandard() {
        return Standard;
    }

    /**
     * Zwraca pole kątownika
     *
     * @return pole
     */
    private Double area() {
        return A * (G) + (G) * (B - (G)) + (1 - (Math.PI / (4))) * (R * R - (2 * (R1 * R1)));
    }

    /**
     * Przypisuje wartości argumentów do pól instancji.
     *
     * @param name nazwa
     * @param a
     * @param b
     * @param g
     * @param r
     * @param r1
     * @return zwraca wartość boolean informującą o wykonaniu przypisania
     */
    final Boolean assignData(String name, Double a, Double b, Double g, Double r, Double r1) {

        if (A > 0 || B > 0 || G > 0 || R > 0 || R1 > 0) {
            this.Name = name;
            this.A = a;
            this.B = b;
            this.G = g;
            this.R = r;
            this.R1 = r1;

            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * Konstruktor z argumantami, wywołuje metodę assignData, która sprawdza czy dane są z poprawnego zakresu.
     *
     * @param name nazwa
     * @param a    podstawa
     * @param b    ramię
     * @param g    grubość
     * @param r    promień 1
     * @param r1   promień 2
     */
    public CProfile(String name, Double a, Double b, Double g, Double r, Double r1) {
        Name = name;
        A = a;
        B = b;
        G = g;
        R = r;
        R1 = r1;
        assignData(name, a, b, g, r, r1);
    }

    /**
     * Konstruktor przypisujący wartości domyślne.
     */
    public CProfile() {
        assignData("none", 50., 50., 5., 7., 3.5);
    }

    /**
     * Wywołuje metodę area która liczy pole
     *
     * @return pole
     */
    Double getResult() {
        return area();
    }

    /**
     * Zwraca wartości parametrów i pole przekroju w postaci tekstu
     *
     * @param prec liczba cyfr po przecinku
     * @return zwraca pole przekroju w postaci obiektu klasy String
     */
    String getResult(Integer prec) {

        Double area = BigDecimal.valueOf(this.area())
                .setScale(prec, RoundingMode.HALF_UP)
                .doubleValue();

        StringBuilder sb = new StringBuilder(100).append(this.Name)
                .append(" parameters: ")
                .append("A value: ").append(this.A).append(" ")
                .append("B value: ").append(this.B).append(" ")
                .append("G value: ").append(this.G).append(" ")
                .append("R value: ").append(this.R).append(" ")
                .append("R1 value: ").append(this.R1).append(" ")
                .append("area: ").append(area);
        return sb.toString();

    }
}

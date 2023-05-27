package zal.gorski;

public class CRectangle extends CFigure{

    protected double A;
    protected double B;

    public double getA() {
        return A;
    }

    public void setA(double a) {
        A = a;
    }

    public double getB() {
        return B;
    }

    public void setB(double b) {
        B = b;
    }

    public CRectangle(double a, double b) {
        A = a;
        B = b;
    }

    public CRectangle() {
        this.A = 10;
        this.B = 8;
    }

    @Override
    protected double calculate() {
        return (A * Math.pow(B,3))/12.0;
    }

    @Override
    public String toString() {
        return "Nazwa: " + this.name + " A: " + this.A + " B: " + this.B + " Moment bezwładności: " + calculate();
    }

    public static String info(){
        return "Obiekt klasy: CRectangle";
    }

    @Override
    public double getArea() {
        return A*B;
    }

    @Override
    public double getCircumference() {
        return 2*A + 2*B;
    }

}

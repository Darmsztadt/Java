package zal.gorski;

public class CRectPipe extends CRectangle{

    protected double A1;
    protected double B1;

    public double getA1() {
        return A1;
    }

    public void setA1(double a1) {
        A1 = a1;
    }

    public double getB1() {
        return B1;
    }

    public void setB1(double b1) {
        B1 = b1;
    }

    public CRectPipe(double a, double b, double a1, double b1) {
        super(a, b);
        A1 = a1;
        B1 = b1;
    }

    public CRectPipe(){
        super(10,8);
        this.A1 = 8;
        this.B1 = 6;
    }

    @Override
    protected double calculate() {
        return super.calculate() - (A1*Math.pow(B1,3)/12.0);
    }

    @Override
    public String toString() {
        return "Nazwa: " + this.name + " A: " + this.A + " B: " + this.B + " A1: " + this.A1 + " B1: " + this.B1 + " Moment bezwładności: " + calculate();
    }

    public static String info(){
        return "Obiekt klasy: CRectPipe";
    }

    @Override
    public double getArea() {
        return super.getArea() - A1*B1;
    }

    @Override
    public double getCircumference() {
        return super.getCircumference() + 2*A1 + 2*B1;
    }

}

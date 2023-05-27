package zal.gorski;

public class CCircle extends CFigure{

    protected double D;

    public double getD() {
        return D;
    }

    public void setD(double d) {
        D = d;
    }

    public CCircle(double d) {
        D = d;
    }

    public CCircle() {
        this.D = 6.28;
    }

    @Override
    protected double calculate() {
        return (Math.PI * Math.pow(D,4))/64.0;
    }

    @Override
    public String toString() {
         return "Nazwa: " + this.name + " D: " + this.D + " Moment bezwładności: " + calculate();
    }

    public static String info(){
        return "Obiekt klasy: CCircle";
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(D,2)/4;
    }

    @Override
    public double getCircumference() {
        return Math.PI * D;
    }
}

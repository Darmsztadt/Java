package zal.gorski;

public class CGenericCircle<T extends Number> extends CFigure{

    protected T D;

    public T getD() {
        return D;
    }

    public void setD(T d) {
        D = d;
    }

    public CGenericCircle(T d) {
        D = d;
    }


    @Override
    protected double calculate() {
        return (Math.PI * Math.pow(D.doubleValue(),4))/64.0;
    }

    @Override
    public String toString() {
        return "Nazwa: " + this.name + " D: " + this.D.doubleValue() + " Moment bezwładności: " + calculate();
    }

    public static String info(){
        return "Obiekt klasy: CGenericCircle";
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(D.doubleValue(),2)/4;
    }

    @Override
    public double getCircumference() {
        return Math.PI * D.doubleValue();
    }

}

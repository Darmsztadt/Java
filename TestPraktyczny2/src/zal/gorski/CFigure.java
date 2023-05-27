package zal.gorski;

abstract public class CFigure implements DimensionInformation{

    protected String name = "Mirek";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected abstract double calculate();

    static public String info(){
        return "Obiekt klasy: CFigure";
    }

}

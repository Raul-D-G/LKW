package Contabilitate;

import javafx.beans.property.*;

public class Contabilitate {

    private final IntegerProperty id;
    private final StringProperty cursa;
    private final StringProperty camion;
    private final StringProperty sofer;
    private final DoubleProperty profit;


    public Contabilitate(int id, String cursa, String camion, String sofer, Double profit) {
        this.id = new SimpleIntegerProperty(id);
        this.cursa = new SimpleStringProperty(cursa);
        this.camion = new SimpleStringProperty(camion);
        this.sofer = new SimpleStringProperty(sofer);
        this.profit = new SimpleDoubleProperty(profit);
    }


    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getCursa() {
        return cursa.get();
    }

    public StringProperty cursaProperty() {
        return cursa;
    }

    public void setCursa(String cursa) {
        this.cursa.set(cursa);
    }

    public String getCamion() {
        return camion.get();
    }

    public StringProperty camionProperty() {
        return camion;
    }

    public void setCamion(String camion) {
        this.camion.set(camion);
    }

    public String getSofer() {
        return sofer.get();
    }

    public StringProperty soferProperty() {
        return sofer;
    }

    public void setSofer(String sofer) {
        this.sofer.set(sofer);
    }

    public double getProfit() {
        return profit.get();
    }

    public DoubleProperty profitProperty() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit.set(profit);
    }
}

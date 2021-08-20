package ChatServiceGUI;

public class TotalAmount {
    private int productValue, weightValue, taxPercentaje;
    private float amount;
    private TotalAmount instance;

    /**
     *
     * @param productValue
     * @param weightValue
     * @param taxPercentaje
     */
    private TotalAmount(int productValue, int weightValue, int taxPercentaje) {
        this.productValue = productValue;
        this.weightValue = weightValue;
        this.taxPercentaje = taxPercentaje;
        this.amount = (float) ((productValue*taxPercentaje/100)+(weightValue*0.15));
    }
    public TotalAmount getInstance(int productValue, int weightValue, int taxPercentaje) {
        if (instance == null){
            instance = new TotalAmount(productValue,weightValue,taxPercentaje);
        }
        return instance;
    }
    public void updateValues(int productValue, int weightValue, int taxPercentaje) {
        this.productValue = productValue;
    }
}

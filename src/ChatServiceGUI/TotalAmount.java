package ChatServiceGUI;

public class TotalAmount {
    private int productValue, weightValue, taxPercentaje;
    private float amount;
    private static TotalAmount instance;

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
    public static TotalAmount getInstance() {
        if (instance == null){
            instance = new TotalAmount(0,0,0);
        }
        return instance;
    }


    public static float updateValues(int productValue, int weightValue, int taxPercentaje) {
        instance.productValue = productValue;
        instance.weightValue = weightValue;
        instance.taxPercentaje = taxPercentaje;
        instance.amount = (float) ((productValue*taxPercentaje/100)+(weightValue*0.15));
        return instance.amount;
    }
}

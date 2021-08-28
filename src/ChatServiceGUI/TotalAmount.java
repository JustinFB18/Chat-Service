package ChatServiceGUI;


/**
 * Uses singleton OOD pattern to use only one instance for all clients to calculate the operation.
 *
 * @author Justin Fern&aacute;ndez
 * @version 1
 */

public class TotalAmount {
    private int productValue, weightValue, taxPercentaje;
    private float amount;
    private static TotalAmount instance;

    /**
     * Assing the values of each param and calculates the amount to pay.
     *
     * @param productValue the cost of the product.
     * @param weightValue the weight of the product.
     * @param taxPercentaje the tax to pay for the product.
     */
    private TotalAmount(int productValue, int weightValue, int taxPercentaje) {
        this.productValue = productValue;
        this.weightValue = weightValue;
        this.taxPercentaje = taxPercentaje;
        this.amount = (float) ((productValue*taxPercentaje/100)+(weightValue*0.15));
    }

    /**
     * This method verificates if exists any instance of the class, and return the existing one if there is
     * or create one to return it.
     * @return instance the object to get access to the method to calculate the amount.
     */
    public static TotalAmount getInstance() {
        if (instance == null){
            instance = new TotalAmount(0,0,0);
        }
        return instance;
    }

    /**
     * Update the values of the instance and return the amount to pay.
     * @param productValue the cost of the product.
     * @param weightValue the weight of the product.
     * @param taxPercentaje the tax to pay for the product.
     * @return instance.amount
     */
    public static float updateValues(int productValue, int weightValue, int taxPercentaje) {
        instance.productValue = productValue;
        instance.weightValue = weightValue;
        instance.taxPercentaje = taxPercentaje;
        instance.amount = (float) ((productValue*taxPercentaje/100)+(weightValue*0.15));
        return instance.amount;
    }
}

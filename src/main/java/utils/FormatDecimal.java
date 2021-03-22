package utils;

import java.text.DecimalFormat;

public class FormatDecimal {
    private static DecimalFormat formatter = new DecimalFormat("###,###,###");;
    public FormatDecimal() {
    }
    public String formatCurrency(double f){
        return  formatter.format(f);
    }

}

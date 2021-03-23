package utils;

import java.text.DecimalFormat;

public class FormatDecimal {
    private static DecimalFormat currecyFormatter = new DecimalFormat("###,###,###");;
    public static DecimalFormat rateFormatter = new DecimalFormat("");
    public FormatDecimal() {
    }
    public String formatCurrency(double f){
        return  currecyFormatter.format(f);
    }
//    public double formatRate(double f) {
//        return Float.parseFloat(rateFormatter.format(f));
//    }
}

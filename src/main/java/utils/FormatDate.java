package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDate {
    private static String dateFormat = "dd/MM/yyyy";
    private static SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
    public FormatDate() {
    }
    public static String format(Date date){
        return sdf.format(date);
    }
}

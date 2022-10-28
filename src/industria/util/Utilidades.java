package industria.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utilidades {
    public static String setFormatterDate(LocalDate data) {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy").format(data);
    }

    public static String setFormatterNumber(BigDecimal number) {
        return new DecimalFormat("#,###.00").format(number);
    }

    public static String setFormatterNumber(Double number) {
        return new DecimalFormat("#,###.00").format(number);
    }
}

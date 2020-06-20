package com.philipramkeerat.travel.util;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class CoinUtil {

    public static final String PORTUGUESE_LANGUAGE = "pt";
    public static final String BRAZILIAN_COUNTRY = "br";
    public static final String DEFAULT_COIN_FORMAT = "R$";
    public static final String FORMAT_COIN_WITH_SPACE = "R$ ";

    public static String formatForBrazilian(BigDecimal value) {
        NumberFormat brazilianFormat = DecimalFormat.getCurrencyInstance(
                new Locale(PORTUGUESE_LANGUAGE, BRAZILIAN_COUNTRY));
        return brazilianFormat
                .format(value)
                .replace(DEFAULT_COIN_FORMAT, FORMAT_COIN_WITH_SPACE);
    }
}

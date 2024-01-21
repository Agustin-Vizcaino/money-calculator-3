package software.ulpgc.moneycalculator.fixerws;

public class MoneyConverterAPI implements API {
    public static final String url = "https://cdn.moneyconvert.net/api/latest.json";
    public static final String key = "";
    public static final String keyAdapter = "";
    @Override
    public String getURL() {
        return url;
    }

    @Override
    public String getKey() {
        return "";
    }

    @Override
    public String getURLWithKey() {
        return url;
    }
}

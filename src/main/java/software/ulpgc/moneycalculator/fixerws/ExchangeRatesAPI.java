package software.ulpgc.moneycalculator.fixerws;

public class ExchangeRatesAPI implements API {
    public static final String url = "http://data.fixer.io/api/symbols";
    public static final String key = "31547d8fcf138f06d26b4f66076050d1";
    public static final String keyAdapter = "?access_key=";

    @Override
    public String getURL() {
        return url;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getURLWithKey() {
        return url + keyAdapter + key;
    }
}

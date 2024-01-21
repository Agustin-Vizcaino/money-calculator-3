package software.ulpgc.moneycalculator.fixerws;

import software.ulpgc.moneycalculator.CurrencyRecord;
import software.ulpgc.moneycalculator.ExchangeRate;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface JSONInterpreter {
    Map<String, Float> getRates(String json);
    Map<String, String> getCurrencies(String json);

    interface APILoader {
        String loadJson(String url, String key) throws IOException;
    }
    interface CurrencyLoader {
        List<CurrencyRecord> load();
        List<CurrencyRecord> toList(String json);
        CurrencyRecord getCurrency(String code);
    }

    interface RateLoader {
        ExchangeRate getRate(String first, String second);
        //List<ExchangeRate> load();
        //List<ExchangeRate> toList(String json);
    }
}

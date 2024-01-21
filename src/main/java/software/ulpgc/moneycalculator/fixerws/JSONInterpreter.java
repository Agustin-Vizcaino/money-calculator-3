package software.ulpgc.moneycalculator.fixerws;

import software.ulpgc.moneycalculator.CurrencyRecord;
import software.ulpgc.moneycalculator.ExchangeRate;

import java.io.IOException;
import java.util.List;

//This interface (I hope) promotes high cohesion, solid internal structure, and could be implemented
//As a module instead of a single class
public interface JSONInterpreter {
    List<CurrencyRecord> getCurrencies();
    ExchangeRate getExchangeRate(String first, String second);
    ExchangeRate getExchangeRate(CurrencyRecord first, CurrencyRecord second);
    interface APILoader {
        String loadJson(API api) throws IOException;
    }
    interface CurrencyLoader {
        List<CurrencyRecord> load();
        List<CurrencyRecord> toList(String json);
        CurrencyRecord getCurrency(String code);
    }

    interface RateLoader {
        ExchangeRate getRate(String first, String second);
    }
}

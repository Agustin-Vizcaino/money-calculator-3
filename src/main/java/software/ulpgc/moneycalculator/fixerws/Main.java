package software.ulpgc.moneycalculator.fixerws;

import software.ulpgc.moneycalculator.CurrencyLoader;
import software.ulpgc.moneycalculator.CurrencyRecord;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        JSONInterpreter manager = new MoneyConvertInterpreter(new MoneyConverterAPI());
        //CurrencyLoader currencyLoader = new FixerCurrencyLoader();
        List<CurrencyRecord> currencies = manager.getCurrencies();
    }
}

package software.ulpgc.moneycalculator.fixerws;

import software.ulpgc.moneycalculator.CurrencyLoader;
import software.ulpgc.moneycalculator.CurrencyRecord;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CurrencyLoader currencyLoader = new FixerCurrencyLoader();
        List<CurrencyRecord> currencies = currencyLoader.load();
        for (CurrencyRecord currency : currencies) {
            System.out.println(currency);
        }
    }
}

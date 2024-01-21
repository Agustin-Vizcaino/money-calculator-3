package software.ulpgc.moneycalculator;

public interface ExchangeRateLoader {
    ExchangeRate load(CurrencyRecord from, CurrencyRecord to);
}

package software.ulpgc.moneycalculator.mocks;

import software.ulpgc.moneycalculator.CurrencyRecord;
import software.ulpgc.moneycalculator.ExchangeRate;
import software.ulpgc.moneycalculator.ExchangeRateLoader;

import java.time.LocalDate;

public class MockExchangeRateLoader implements ExchangeRateLoader {
    @Override
    public ExchangeRate load(CurrencyRecord from, CurrencyRecord to) {
        return new ExchangeRate(from, to, LocalDate.now(), 1.218);
    }
}

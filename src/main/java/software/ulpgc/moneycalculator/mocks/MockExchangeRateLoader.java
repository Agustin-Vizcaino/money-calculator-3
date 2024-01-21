package software.ulpgc.moneycalculator.mocks;

import software.ulpgc.moneycalculator.CurrencyRecord;
import software.ulpgc.moneycalculator.ExchangeRate;
import software.ulpgc.moneycalculator.ExchangeRateLoader;

import java.time.LocalDateTime;

public class MockExchangeRateLoader implements ExchangeRateLoader {
    @Override
    public ExchangeRate load(CurrencyRecord from, CurrencyRecord to) {
        return new ExchangeRate(from, to, LocalDateTime.now(), 1.218);
    }
}

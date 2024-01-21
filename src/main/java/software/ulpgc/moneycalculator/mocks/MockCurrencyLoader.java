package software.ulpgc.moneycalculator.mocks;

import software.ulpgc.moneycalculator.CurrencyLoader;
import software.ulpgc.moneycalculator.CurrencyRecord;

import java.util.List;

public class MockCurrencyLoader implements CurrencyLoader {
    @Override
    public List<CurrencyRecord> load() {
        return List.of(
                new CurrencyRecord("EUR", "Euro"),
                new CurrencyRecord("USD", "Dolar"),
                new CurrencyRecord("GBP", "Libra")
        );
    }
}

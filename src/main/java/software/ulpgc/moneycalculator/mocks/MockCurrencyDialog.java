package software.ulpgc.moneycalculator.mocks;

import software.ulpgc.moneycalculator.CurrencyDialog;
import software.ulpgc.moneycalculator.CurrencyRecord;

import java.util.List;

public class MockCurrencyDialog implements CurrencyDialog {
    private List<CurrencyRecord> currencies;

    @Override
    public CurrencyDialog define(List<CurrencyRecord> currencies) {
        this.currencies = currencies;
        return this;
    }

    @Override
    public CurrencyRecord get() {
        return currencies.get(1);
    }
}

package software.ulpgc.moneycalculator.mocks;

import software.ulpgc.moneycalculator.CurrencyRecord;
import software.ulpgc.moneycalculator.Money;
import software.ulpgc.moneycalculator.MoneyDialog;

import java.util.List;


public class MockMoneyDialog implements MoneyDialog {
    private List<CurrencyRecord> currencies;

    @Override
    public MoneyDialog define(List<CurrencyRecord> currencies) {
        this.currencies = currencies;
        return this;
    }

    @Override
    public Money get() {
        return new Money(200, currencies.get(0));
    }
}

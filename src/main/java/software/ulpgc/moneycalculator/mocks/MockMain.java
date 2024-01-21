package software.ulpgc.moneycalculator.mocks;

import software.ulpgc.moneycalculator.*;

import java.util.List;

public class MockMain {
    public static void main(String[] args) {
        List<CurrencyRecord> currencies = new MockCurrencyLoader().load();
        MoneyDialog moneyDialog = new MockMoneyDialog().define(currencies);
        CurrencyDialog currencyDialog = new MockCurrencyDialog().define(currencies);
        MoneyDisplay moneyDisplay = new MockMoneyDisplay();
        ExchangeRateLoader exchangeRateLoader = new MockExchangeRateLoader();
        Command command = new ExchangeMoneyCommand(moneyDialog, currencyDialog, null, moneyDisplay);
        command.execute();
    }
}

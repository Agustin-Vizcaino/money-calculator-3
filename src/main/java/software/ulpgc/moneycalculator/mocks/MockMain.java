package software.ulpgc.moneycalculator.mocks;

import software.ulpgc.moneycalculator.*;

import java.util.List;

public class MockMain {
    public static void main(String[] args) {
        /*List<CurrencyRecord> currencies = new MockCurrencyLoader().load();
        MoneyDialog moneyDialog = new MockMoneyDialog().define(currencies);
        CurrencyDialog currencyDialog = new MockCurrencyDialog().define(currencies);
        MoneyDisplay moneyDisplay = new MockMoneyDisplay();
        Command command = new ExchangeMoneyCommand(moneyDialog, currencyDialog, null, moneyDisplay);
        command.execute();*/
        System.out.println("Please use 'SwingMain', this is kept for legacy purposes");
    }
}

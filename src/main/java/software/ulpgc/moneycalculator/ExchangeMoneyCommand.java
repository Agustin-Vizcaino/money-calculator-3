package software.ulpgc.moneycalculator;

import software.ulpgc.moneycalculator.fixerws.JSONInterpreter;

public class ExchangeMoneyCommand implements Command{
    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final JSONInterpreter manager;
    private final MoneyDisplay moneyDisplay;

    public ExchangeMoneyCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, JSONInterpreter manager, MoneyDisplay moneyDisplay) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.manager = manager;
        this.moneyDisplay = moneyDisplay;
    }

    @Override
    public void execute() {
        Money money = moneyDialog.get();
        CurrencyRecord currency = currencyDialog.get();

        ExchangeRate exchangeRate = manager.getExchangeRate(money.currency(), currency);
        Money result = new Money((long) (money.amount()*exchangeRate.rate()), currency);

        moneyDisplay.show(result);
    }
}

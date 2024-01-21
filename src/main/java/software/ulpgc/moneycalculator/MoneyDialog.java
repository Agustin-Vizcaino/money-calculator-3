package software.ulpgc.moneycalculator;

import java.util.List;

public interface MoneyDialog {
    MoneyDialog define(List<CurrencyRecord> currencies);
    Money get();
}

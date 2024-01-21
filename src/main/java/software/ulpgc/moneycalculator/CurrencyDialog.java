package software.ulpgc.moneycalculator;

import java.util.List;

public interface CurrencyDialog {
    CurrencyDialog define(List<CurrencyRecord> currencies);
    CurrencyRecord get();
}

package software.ulpgc.moneycalculator;

import java.util.List;

public interface CurrencyLoader {
    List<CurrencyRecord> load();
}

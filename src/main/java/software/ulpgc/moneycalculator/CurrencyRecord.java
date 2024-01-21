package software.ulpgc.moneycalculator;

import java.util.Comparator;

public record CurrencyRecord(String code, String name) {
    @Override
    public String toString() {
        return code + "-" + name;
    }
}

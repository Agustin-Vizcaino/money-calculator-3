package software.ulpgc.moneycalculator;

public record CurrencyRecord(String code, String name) {
    @Override
    public String toString() {
        return code + "-" + name;
    }
}

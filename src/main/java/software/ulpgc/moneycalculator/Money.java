package software.ulpgc.moneycalculator;

public record Money(long amount, CurrencyRecord currency) {
    @Override
    public String toString() {
        return amount + " " + currency;
    }
}

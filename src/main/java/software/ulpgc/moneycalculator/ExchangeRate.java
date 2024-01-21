package software.ulpgc.moneycalculator;

import java.time.LocalDate;

public record ExchangeRate(CurrencyRecord from, CurrencyRecord to, LocalDate date, double rate) {
}

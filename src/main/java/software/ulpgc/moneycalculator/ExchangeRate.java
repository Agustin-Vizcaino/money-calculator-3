package software.ulpgc.moneycalculator;

import java.time.LocalDateTime;

public record ExchangeRate(CurrencyRecord from, CurrencyRecord to, LocalDateTime date, double rate) {
}

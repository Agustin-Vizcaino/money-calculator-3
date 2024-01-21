package software.ulpgc.moneycalculator.fixerws;

import java.util.Map;

public interface JSONInterpreter {
    Map<String, Float> getRates(String json);
    Map<String, String> getCurrencies(String json);
}

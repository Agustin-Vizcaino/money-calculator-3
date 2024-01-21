package software.ulpgc.moneycalculator.fixerws;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Map;

public class MoneyConvertInterpreter implements JSONInterpreter {
    @Override
    public Map<String, Float> getRates(String json) {

    }

    @Override
    public Map<String, String> getCurrencies(String json) {
        Map<String, String> currenciesMap = new HashMap<>();
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        JsonObject names = JsonParser.parseString(String.valueOf(jsonObject.asMap().get("rates"))).getAsJsonObject();
        for (String i : names.keySet()) {
            //This new API does not return currency names
            currenciesMap.put(i, i);
        }
        return currenciesMap;
    }
}

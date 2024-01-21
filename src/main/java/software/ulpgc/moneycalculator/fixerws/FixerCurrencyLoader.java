package software.ulpgc.moneycalculator.fixerws;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import software.ulpgc.moneycalculator.CurrencyLoader;
import software.ulpgc.moneycalculator.CurrencyRecord;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;

public class FixerCurrencyLoader implements CurrencyLoader {
    @Override
    public List<CurrencyRecord> load() {
        try {
            return toList(loadJson());
        } catch (IOException e) {
            return emptyList();
        }
    }

    private List<CurrencyRecord> toList(String json) {
        List<CurrencyRecord> list = new ArrayList<>();
        Map<String, String> currencies = new MoneyConvertInterpreter().getCurrencies(json);
        //Map<String, JsonElement> symbols = new Gson().fromJson(json, JsonObject.class).get("symbols").getAsJsonObject().asMap();
        for (String symbol : currencies.keySet())
            list.add(new CurrencyRecord(symbol, currencies.get(symbol)));
        return list;
    }

    private String loadJson() throws IOException {
        //URL url = new URL("http://data.fixer.io/api/symbols?access_key=" + FixerAPI.key);
        URL url = new URL("https://cdn.moneyconvert.net/api/latest.json");
        try (InputStream is = url.openStream()) {
            return new String(is.readAllBytes());
        }
    }
}

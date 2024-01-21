package software.ulpgc.moneycalculator.fixerws;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import software.ulpgc.moneycalculator.CurrencyLoader;
import software.ulpgc.moneycalculator.CurrencyRecord;
import software.ulpgc.moneycalculator.ExchangeRate;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

import static java.util.Collections.emptyList;

public class MoneyConvertInterpreter implements JSONInterpreter {
    API api;
    String url = "";
    String json = "";
    private APILoader al;
    private CurrencyLoader cl;
    private RateLoader rl;


    public MoneyConvertInterpreter(API api) {
        this.api = api;
        this.url = api.getURLWithKey();
        startAL();
        try {
            this.json = al.loadJson(this.api);
        } catch (Exception e) {
            System.out.println("Error loading API: " + e.getMessage());
        }
        //Necessary because otherwise they would be initialized before the constructor
        startCL();
        startRL();
    }

    private void startAL() {
        al = new APILoader() {
            @Override
            public String loadJson(API input_api) throws IOException {
                URL url = new URL(input_api.getURLWithKey());
                try (InputStream is = url.openStream()) {
                    return new String(is.readAllBytes());
                }
            }
        };
    }

    private void startCL() {
        cl = new CurrencyLoader() {

            List<CurrencyRecord> returner;
            Map<String,String> currenciesMap;
            {
                currenciesMap = getCurrencies(json);
            }
            @Override
            public List<CurrencyRecord> load() {
                if (returner == null) returner = toList(json);
                return returner;
            }

            //This method should likely not be public, but oh well...
            @Override
            public List<CurrencyRecord> toList(String json) {
                List<CurrencyRecord> list = new ArrayList<>();
                for (String symbol : currenciesMap.keySet())
                    list.add(new CurrencyRecord(symbol, currenciesMap.get(symbol)));
                return list;
            }

            @Override
            public CurrencyRecord getCurrency(String code) {
                if (currenciesMap.containsKey(code)) return new CurrencyRecord(code, currenciesMap.get(code));
                return new CurrencyRecord("Error", "Error");
            }

            private Map<String, String> getCurrencies(String json) {
                Map<String, String> returnerMap = new HashMap<>();
                JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
                JsonObject names = JsonParser.parseString(String.valueOf(jsonObject.asMap().get("rates"))).getAsJsonObject();
                for (String i : names.keySet()) {
                    //This new API does not return currency names
                    returnerMap.put(i, i);
                }
                return returnerMap;
            }
        };
    }

    private void startRL() {
        rl = new RateLoader() {
            Map<String,Float> ratesMap = new HashMap<>();
            {
                ratesMap = getRates(json);
                getDate(json);
            }
            @Override
            public ExchangeRate getRate(String first, String second) {
                return new ExchangeRate(cl.getCurrency(first), cl.getCurrency(second), null, ratesMap.get(first) / ratesMap.get(second));
            }

            private Map<String, Float> getRates(String json) {
                Map<String,Float> returnerMap = new HashMap<>();
                JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
                JsonObject rates = JsonParser.parseString(String.valueOf(jsonObject.asMap().get("rates"))).getAsJsonObject();
                for (String i : rates.keySet()) {
                    returnerMap.put(i, rates.get(i).getAsFloat());
                }
                return returnerMap;
            }

            private Date getDate(String json) {
                System.out.println(JsonParser.parseString(json).getAsJsonObject().get("lastupdate"));
                return null;
                //JsonObject date = JsonParser.parseString(String.valueOf(jsonObject.asMap().get("lastupdate")))
            }
        };
    }

    @Override
    public List<CurrencyRecord> getCurrencies() {
        return cl.load();
    }

    @Override
    public ExchangeRate getExchangeRate(String first, String second) {
        return rl.getRate(first, second);
    }
}

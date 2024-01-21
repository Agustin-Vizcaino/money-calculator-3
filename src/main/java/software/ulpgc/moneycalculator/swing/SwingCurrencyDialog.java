package software.ulpgc.moneycalculator.swing;

import software.ulpgc.moneycalculator.CurrencyDialog;
import software.ulpgc.moneycalculator.CurrencyRecord;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingCurrencyDialog extends JPanel implements CurrencyDialog {

    private JComboBox<CurrencyRecord> currencySelector;

    public SwingCurrencyDialog() {
    }

    @Override
    public CurrencyDialog define(List<CurrencyRecord> currencies) {
        add(createCurrencySelector(currencies));
        return this;
    }

    private Component createCurrencySelector(List<CurrencyRecord> currencies) {
        JComboBox<CurrencyRecord> selector = new JComboBox<>();
        for (CurrencyRecord currency : currencies) selector.addItem(currency);
        this.currencySelector = selector;
        return selector;
    }

    @Override
    public CurrencyRecord get() {
        return currencySelector.getItemAt(currencySelector.getSelectedIndex());
    }
}

package software.ulpgc.moneycalculator.swing;

import software.ulpgc.moneycalculator.*;
import software.ulpgc.moneycalculator.fixerws.JSONInterpreter;
import software.ulpgc.moneycalculator.fixerws.MoneyConvertInterpreter;
import software.ulpgc.moneycalculator.fixerws.MoneyConverterAPI;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class SwingMain extends JFrame {
    private final Map<String,Command> commands = new HashMap<>();
    private MoneyDisplay moneyDisplay;
    private MoneyDialog moneyDialog;
    private CurrencyDialog currencyDialog;

    private static JSONInterpreter manager;
    public static void main(String[] args) {
        SwingMain main = new SwingMain();
        manager = new MoneyConvertInterpreter(new MoneyConverterAPI());
        List<CurrencyRecord> currencies = manager.getCurrencies();
        currencies.sort(Comparator.comparing(CurrencyRecord::toString));
        Command command = new ExchangeMoneyCommand(
                main.moneyDialog().define(currencies),
                main.currencyDialog().define(currencies),
                manager,
                main.moneyDisplay());
        main.add("exchange money", command);
        main.setVisible(true);
    }

    public SwingMain() throws HeadlessException {
        this.setTitle("Money calculator");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.add(createMoneyDialog());
        this.add(createCurrencyDialog());
        this.add(createMoneyDisplay());
        this.add(toolbar());
    }

    private Component toolbar() {
        JButton button = new JButton("Calculate");
        button.addActionListener(e -> commands.get("exchange money").execute());
        return button;
    }

    private Component createMoneyDisplay() {
        SwingMoneyDisplay display = new SwingMoneyDisplay();
        this.moneyDisplay = display;
        return display;
    }

    private Component createCurrencyDialog() {
        SwingCurrencyDialog dialog = new SwingCurrencyDialog();
        this.currencyDialog = dialog;
        return dialog;
    }

    private Component createMoneyDialog() {
        SwingMoneyDialog dialog = new SwingMoneyDialog();
        this.moneyDialog = dialog;
        return dialog;
    }

    private void add(String name, Command command) {
        commands.put(name, command);
    }

    private MoneyDisplay moneyDisplay() {
        return moneyDisplay;
    }

    private CurrencyDialog currencyDialog() {
        return currencyDialog;
    }

    private MoneyDialog moneyDialog() {
        return moneyDialog;
    }
}

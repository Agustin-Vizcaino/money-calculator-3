package software.ulpgc.moneycalculator.swing;

import software.ulpgc.moneycalculator.Money;
import software.ulpgc.moneycalculator.MoneyDisplay;

import javax.swing.*;

public class SwingMoneyDisplay extends JLabel implements MoneyDisplay {
    @Override
    public void show(Money money) {
        if (money.amount() >= 0) this.setText(money.toString()); else this.setText("Error (negative amount)");
    }
}

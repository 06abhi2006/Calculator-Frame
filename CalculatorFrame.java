import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class CalculatorApplet extends Applet implements ActionListener {
    TextField num1, num2, result;
    Button add, sub, mul, div;
    Label lbl;

    public void init() {
        setLayout(new GridLayout(5, 2, 5, 5));

        add(new Label("Number 1:"));
        num1 = new TextField(10);
        add(num1);

        add(new Label("Number 2:"));
        num2 = new TextField(10);
        add(num2);

        add = new Button("+");
        sub = new Button("-");
        mul = new Button("*");
        div = new Button("/");

        add(add);
        add(sub);
        add(mul);
        add(div);

        lbl = new Label("Result:");
        add(lbl);

        result = new TextField(15);
        result.setEditable(false);
        add(result);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double n1 = Double.parseDouble(num1.getText());
            double n2 = Double.parseDouble(num2.getText());
            double res = 0;

            if (e.getSource() == add) {
                res = n1 + n2;
            } else if (e.getSource() == sub) {
                res = n1 - n2;
            } else if (e.getSource() == mul) {
                res = n1 * n2;
            } else if (e.getSource() == div) {
                if (n2 == 0) {
                    result.setText("Cannot divide by zero");
                    return;
                }
                res = n1 / n2;
            }
            result.setText(String.valueOf(res));
        } catch (NumberFormatException ex) {
            result.setText("Invalid input");
        }
    }
}

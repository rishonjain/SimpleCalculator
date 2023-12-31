import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];

    JButton[] functionButtons = new JButton[10];
    JButton addButton, subButton, multiplyButton, divideButton;
    JButton equalstoButton, decimalButton, delButton, clearButton, percentageButton, negativeButton;
    JPanel panel;

    Font font1 = new Font("Times New Roman", Font.BOLD,30);
    Font font2 = new Font("Times New Roman", Font.BOLD,20);

    double num1=0,num2=0,result=0;
    char operator;

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 600);
        frame.setResizable(false);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(font1);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        equalstoButton = new JButton("=");
        decimalButton = new JButton(".");
        delButton = new JButton("Delete");
        clearButton = new JButton("Clear");
        percentageButton = new JButton("%");
        negativeButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = multiplyButton;
        functionButtons[3] = divideButton;
        functionButtons[4] = equalstoButton;
        functionButtons[5] = decimalButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clearButton;
        functionButtons[8] = percentageButton;
        functionButtons[9] = negativeButton;

        for (int i = 0; i < 6 ; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(font1);
            functionButtons[i].setFocusable(false);
        }
        for (int i = 6; i < 8 ; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(font2);
            functionButtons[i].setFocusable(false);

        }
        for (int i = 8; i < 10 ; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(font1);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(font1);
            numberButtons[i].setFocusable(false);

        }

        negativeButton.setBounds(50,430,100,50);
        delButton.setBounds(155,430,100,50);
        clearButton.setBounds(260,430,90,50);
        equalstoButton.setBounds(130, 490,145,50);



        panel = new JPanel();
        panel.setBounds (50, 100, 300, 300);
        panel.setLayout(new GridLayout (4,4,10,10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(functionButtons[0]);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(functionButtons[1]);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(functionButtons[2]);

        panel.add(functionButtons[5]);
        panel.add(numberButtons[0]);
        panel.add(functionButtons[8]);
        panel.add(functionButtons[3]);

        frame.add(textField);
        frame.add(negativeButton);
        frame.add(delButton);
        frame.add(clearButton);
        frame.add(equalstoButton);
        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();


    }
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decimalButton) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == multiplyButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divideButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == percentageButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '%';
            textField.setText("");
        }
        if (e.getSource() == equalstoButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                case '%':
                    result = (num1 / 100) * num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clearButton) {
            textField.setText("");
        }
        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));

            }
        }
        if (e.getSource() == negativeButton) {
            double temp = Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));
        }
    }
}
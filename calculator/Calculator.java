package calculator;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.Math;

/**
 * Constructs a Calculator app with Java Swing
 * 
 * @author Amber Ott
 */
public class Calculator extends JFrame {

    /**
     * Creates Calculator object
     */
    public Calculator() {
        initComponents();
    }

    public enum Calc {
        TYPE, EXPONENT, DIVIDE, MULTIPLY, SUBTRACT, ADD
    }

    /**
     * Initializes various GUI components, such as
     * JTextFields and JButtons, and displays them
     * with a Layout Manager
     */
    private void initComponents() {
        calculation = Calc.TYPE;
        prevNum = (float) 0;
        numTextField = new JTextField();

        allClearButton = new JButton("AC");
        exponentButton = new JButton("xʸ");
        squareRootButton = new JButton("√x");
        divideButton = new JButton("÷");
        multiplyButton = new JButton("×");
        subtractButton = new JButton("-");
        addButton = new JButton("+");
        plusMinusButton = new JButton("±");
        decimalButton = new JButton(".");
        equalsButton = new JButton("=");

        zeroButton = new JButton("0");
        oneButton = new JButton("1");
        twoButton = new JButton("2");
        threeButton = new JButton("3");
        fourButton = new JButton("4");
        fiveButton = new JButton("5");
        sixButton = new JButton("6");
        sevenButton = new JButton("7");
        eightButton = new JButton("8");
        nineButton = new JButton("9");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Classic Calculator");

        numTextField.setHorizontalAlignment(JTextField.RIGHT);
        numTextField.setAlignmentY(JTextField.TOP_ALIGNMENT);
        numTextField.setFont(new Font("Arial", Font.PLAIN, 35));
        numTextField.setText("0");
        numTextField.setBackground(new Color(200, 200, 200));

        JButton[] buttons = new JButton[] { allClearButton, exponentButton, squareRootButton, divideButton,
                multiplyButton, subtractButton, addButton, plusMinusButton, decimalButton, equalsButton, zeroButton,
                oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton, eightButton,
                nineButton };

        for (JButton button : buttons) {
            button.setOpaque(true);
            button.setBorderPainted(false);
            button.setFocusPainted(false);
            button.setFont(new Font("Arial", Font.PLAIN, 20));

            button.setActionCommand(button.getText());
            button.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    convertButtonActionPerformed(evt);
                }
            });
        }

        for (JButton button : new JButton[] { zeroButton, oneButton, twoButton, threeButton, fourButton, fiveButton,
                sixButton, sevenButton, eightButton, nineButton }) {
            button.setBackground(Color.GRAY);
        }

        for (JButton button : new JButton[] { exponentButton, squareRootButton, divideButton, multiplyButton, addButton,
                subtractButton, decimalButton, plusMinusButton }) {
            button.setBackground(new Color(100, 100, 200));
        }

        equalsButton.setBackground(new Color(100, 150, 100));
        allClearButton.setBackground(new Color(200, 100, 100));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(numTextField)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(allClearButton, 0,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(exponentButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(squareRootButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(divideButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(sevenButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(eightButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(nineButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(multiplyButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(fourButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(fiveButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(sixButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(subtractButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(oneButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(twoButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(threeButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(addButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(plusMinusButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(zeroButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(decimalButton)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(equalsButton)))
                                .addContainerGap()));

        layout.linkSize(SwingConstants.HORIZONTAL,
                new java.awt.Component[] { allClearButton, exponentButton, squareRootButton, divideButton,
                        multiplyButton, subtractButton, addButton, plusMinusButton, decimalButton, equalsButton,
                        zeroButton, oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton,
                        eightButton, nineButton });

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(numTextField, 50, 100, Short.MAX_VALUE)
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(allClearButton, 0,
                                                60,
                                                Short.MAX_VALUE)
                                        .addComponent(exponentButton)
                                        .addComponent(squareRootButton)
                                        .addComponent(divideButton))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(sevenButton)
                                        .addComponent(eightButton)
                                        .addComponent(nineButton)
                                        .addComponent(multiplyButton))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(fourButton)
                                        .addComponent(fiveButton)
                                        .addComponent(sixButton)
                                        .addComponent(subtractButton))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(oneButton)
                                        .addComponent(twoButton)
                                        .addComponent(threeButton)
                                        .addComponent(addButton))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(plusMinusButton)
                                        .addComponent(zeroButton)
                                        .addComponent(decimalButton)
                                        .addComponent(equalsButton))
                                .addContainerGap()));

        layout.linkSize(SwingConstants.VERTICAL,
                new java.awt.Component[] { allClearButton, exponentButton, squareRootButton, divideButton,
                        multiplyButton, subtractButton, addButton, plusMinusButton, decimalButton, equalsButton,
                        zeroButton, oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton,
                        eightButton, nineButton });

        pack();
    }

    /**
     * Converts the action command from a button being
     * clicked into the appropriate calculation or text
     * edit
     * 
     * @param evt   event to retrieve action command from
     */
    private void convertButtonActionPerformed(ActionEvent evt) {
        String actionCommand = evt.getActionCommand();
        switch (calculation) {
            case TYPE:
                switch (actionCommand) {
                    case "0":
                        if (Float.parseFloat(numTextField.getText()) != 0 && numTextField.getText().length() < 15) {
                            numTextField.setText((numTextField.getText() + "0").replaceFirst("^0+(?!$)", ""));
                        }
                        break;
                    case "1", "2", "3", "4", "5", "6", "7", "8", "9":
                        if (numTextField.getText().length() < 15) {
                            numTextField.setText((numTextField.getText() + actionCommand).replaceFirst("^0+(?!$)", ""));
                        }
                        break;
                    case "AC":
                        numTextField.setText("0");
                        break;
                    case "xʸ":
                        calculation = Calc.EXPONENT;
                        prevNum = Float.parseFloat(numTextField.getText());
                        numTextField.setText("0");
                        break;
                    case "√x":
                        numTextField.setText(Float.toString(
                                ((float) Math.rint(Math.sqrt(Float.parseFloat(numTextField.getText())) * 1000))
                                        / 1000));
                        break;
                    case "÷":
                        calculation = Calc.DIVIDE;
                        prevNum = Float.parseFloat(numTextField.getText());
                        numTextField.setText("0");
                        break;
                    case "×":
                        calculation = Calc.MULTIPLY;
                        prevNum = Float.parseFloat(numTextField.getText());
                        numTextField.setText("0");
                        break;
                    case "-":
                        calculation = Calc.SUBTRACT;
                        prevNum = Float.parseFloat(numTextField.getText());
                        numTextField.setText("0");
                        break;
                    case "+":
                        calculation = Calc.ADD;
                        prevNum = Float.parseFloat(numTextField.getText());
                        numTextField.setText("0");
                        break;
                    case "±":
                        numTextField.setText(Float.toString(-Float.parseFloat(numTextField.getText())));
                        break;
                    case ".":
                        if (!numTextField.getText().contains(".") && numTextField.getText().length() < 15) {
                            numTextField.setText(numTextField.getText() + ".");
                        }
                        break;
                    case "=":
                        numTextField.setText(
                                Float.toString(
                                        ((float) Math.rint(Float.parseFloat(numTextField.getText()) * 1000)) / 1000));
                        break;
                }
                break;
            case EXPONENT, DIVIDE, MULTIPLY, SUBTRACT, ADD:
                switch (actionCommand) {
                    case "0":
                        if (Float.parseFloat(numTextField.getText()) != 0 && numTextField.getText().length() < 15) {
                            numTextField.setText((numTextField.getText() + "0").replaceFirst("^0+(?!$)", ""));
                        }
                        break;
                    case "1", "2", "3", "4", "5", "6", "7", "8", "9":
                        if (numTextField.getText().length() < 15) {
                            numTextField.setText((numTextField.getText() + actionCommand).replaceFirst("^0+(?!$)", ""));
                        }
                        break;
                    case "AC":
                        numTextField.setText("0");
                        calculation = Calc.TYPE;
                        break;
                    case "xʸ":
                        numTextField.setText(Float.toString(
                                ((float) Math.rint(calculate(prevNum, Float.parseFloat(numTextField.getText())) * 1000))
                                        / 1000));
                        prevNum = Float.parseFloat(numTextField.getText());
                        calculation = Calc.EXPONENT;
                        break;
                    case "√x":
                        numTextField.setText(Float.toString(((float) Math
                                .rint(Math.sqrt(calculate(prevNum, Float.parseFloat(numTextField.getText()))) * 1000))
                                / 1000));
                        prevNum = Float.parseFloat(numTextField.getText());
                        calculation = Calc.TYPE;
                        break;
                    case "÷":
                        numTextField.setText(Float.toString(
                                ((float) Math.rint(calculate(prevNum, Float.parseFloat(numTextField.getText())) * 1000))
                                        / 1000));
                        prevNum = Float.parseFloat(numTextField.getText());
                        calculation = Calc.DIVIDE;
                        break;
                    case "×":
                        numTextField.setText(Float.toString(
                                ((float) Math.rint(calculate(prevNum, Float.parseFloat(numTextField.getText())) * 1000))
                                        / 1000));
                        prevNum = Float.parseFloat(numTextField.getText());
                        calculation = Calc.MULTIPLY;
                        break;
                    case "-":
                        numTextField.setText(Float.toString(
                                ((float) Math.rint(calculate(prevNum, Float.parseFloat(numTextField.getText())) * 1000))
                                        / 1000));
                        prevNum = Float.parseFloat(numTextField.getText());
                        calculation = Calc.SUBTRACT;
                        break;
                    case "+":
                        numTextField.setText(Float.toString(
                                ((float) Math.rint(calculate(prevNum, Float.parseFloat(numTextField.getText())) * 1000))
                                        / 1000));
                        prevNum = Float.parseFloat(numTextField.getText());
                        calculation = Calc.ADD;
                        break;
                    case "±":
                        numTextField.setText(Float.toString(-Float.parseFloat(numTextField.getText())));
                        break;
                    case ".":
                        if (!numTextField.getText().contains(".") && numTextField.getText().length() < 15) {
                            numTextField.setText(numTextField.getText() + ".");
                        }
                        break;
                    case "=":
                        numTextField.setText(Float.toString(
                                ((float) Math.rint(calculate(prevNum, Float.parseFloat(numTextField.getText())) * 1000))
                                        / 1000));
                        prevNum = Float.parseFloat(numTextField.getText());
                        calculation = Calc.TYPE;
                        break;
                }
                break;
        }
    }

    /**
     * Completes calculation on two floats
     * 
     * @param a     the first float in the equation
     * @param b     the second float in the equation
     * @return      the resulting float from the equation
     */
    public Float calculate(float a, float b) {
        switch (calculation) {
            case ADD:
                return (float) a + b;
            case SUBTRACT:
                return (float) a - b;
            case MULTIPLY:
                return (float) a * b;
            case DIVIDE:
                return (float) a / b;
            case EXPONENT:
                return (float) Math.pow(a, b);
            default:
                return (float) 0;
        }
    }

    /**
     * Creates new instance of Calculator object
     * 
     * @param args
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calculator().setVisible(true);
            }
        });
    }

    private Calc calculation;
    private Float prevNum;
    private JTextField numTextField;
    private JButton allClearButton;
    private JButton exponentButton;
    private JButton squareRootButton;
    private JButton divideButton;
    private JButton multiplyButton;
    private JButton subtractButton;
    private JButton addButton;
    private JButton plusMinusButton;
    private JButton decimalButton;
    private JButton equalsButton;
    private JButton zeroButton;
    private JButton oneButton;
    private JButton twoButton;
    private JButton threeButton;
    private JButton fourButton;
    private JButton fiveButton;
    private JButton sixButton;
    private JButton sevenButton;
    private JButton eightButton;
    private JButton nineButton;
}

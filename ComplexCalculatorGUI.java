package CalculatorApp;

import javax.swing.*;
import javax.swing.DefaultListModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ComplexCalculatorGUI extends JFrame implements ActionListener{
    DefaultListModel<Complex> numbers = new DefaultListModel<>();
    private JList<Complex> list1;
    private JButton ACButton;
    private JButton dropButton;
    private JButton pushButton;
    private JButton swapButton;
    private JButton overButton;
    private JButton dupButton;
    private JButton clearButton;
    private JButton subtractButton;
    private JButton divideButton;
    private JButton invertSignButton;
    private JButton sqrtButton;
    private JButton multiplyButton;
    private JButton addButton;
    private JTextField firstNumber;
    private JTextField secondNumber;
    private JTextField solutionField;
    private JPanel mainPanel;
    private final Stack stack;


    public ComplexCalculatorGUI(Stack stack){
        this.stack = stack;
        list1.setModel(numbers);
        setContentPane(mainPanel);
        setTitle("ComplexCalculatorGUI");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 450);
        setVisible(true);

        solutionField.setEditable(false);





        pushButton.addActionListener(this);

        ACButton.addActionListener(this);

        divideButton.addActionListener(this);

        sqrtButton.addActionListener(this);

        multiplyButton.addActionListener(this);

        subtractButton.addActionListener(this);

        addButton.addActionListener(this);

        invertSignButton.addActionListener(this);

        clearButton.addActionListener(this);

        dropButton.addActionListener(this);

        swapButton.addActionListener(this);

        overButton.addActionListener(this);

        dupButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ACButton){
            solutionField.setText("");
            firstNumber.setText("");
            secondNumber.setText("");
            /*Complex j = stack.peek();
            System.out.println(list1.getSelectedValue().getReal());
            System.out.println(list1.getSelectedValue().getImaginary());*/
        } else if(e.getSource() == pushButton){
            Complex j = new Complex(Double.parseDouble(firstNumber.getText()),Double.parseDouble(secondNumber.getText()));
            stack.push(j);
            numbers.addElement(j);
        } else if(e.getSource() == divideButton){
            solutionField.setText(list1.getSelectedValue().divide(new Complex(Double.parseDouble(firstNumber.getText()),Double.parseDouble(secondNumber.getText()))).toString());
            numbers.add(numbers.getSize(),list1.getSelectedValue().divide(new Complex(Double.parseDouble(firstNumber.getText()),Double.parseDouble(secondNumber.getText()))));
        } else if(e.getSource() == sqrtButton){
            Complex a = list1.getSelectedValue().sqrt(new Complex(list1.getSelectedValue().getReal(), list1.getSelectedValue().getImaginary()));
            solutionField.setText(list1.getSelectedValue().sqrt(new Complex(list1.getSelectedValue().getReal(), list1.getSelectedValue().getImaginary())).toString());
            numbers.add(numbers.getSize(),a);
        } else if(e.getSource() == multiplyButton){
            solutionField.setText(list1.getSelectedValue().multiply(new Complex(Double.parseDouble(firstNumber.getText()),Double.parseDouble(secondNumber.getText()))).toString());
            numbers.add(numbers.getSize(),list1.getSelectedValue().multiply(new Complex(Double.parseDouble(firstNumber.getText()),Double.parseDouble(secondNumber.getText()))));
        } else if(e.getSource() == subtractButton){
            solutionField.setText(list1.getSelectedValue().subtract(new Complex(Double.parseDouble(firstNumber.getText()),Double.parseDouble(secondNumber.getText()))).toString());
            numbers.add(numbers.getSize(),list1.getSelectedValue().subtract(new Complex(Double.parseDouble(firstNumber.getText()),Double.parseDouble(secondNumber.getText()))));
        } else if(e.getSource() == addButton){
            solutionField.setText(list1.getSelectedValue().add(new Complex(Double.parseDouble(firstNumber.getText()),Double.parseDouble(secondNumber.getText()))).toString());
            numbers.add(numbers.getSize(),list1.getSelectedValue().add(new Complex(Double.parseDouble(firstNumber.getText()),Double.parseDouble(secondNumber.getText()))));
        } else if(e.getSource() == invertSignButton){
            solutionField.setText(list1.getSelectedValue().invertSign(new Complex(list1.getSelectedValue().getReal(),list1.getSelectedValue().getImaginary())).toString());
            numbers.add(numbers.getSize(),list1.getSelectedValue().invertSign(new Complex(list1.getSelectedValue().getReal(),list1.getSelectedValue().getImaginary())));
        } else if(e.getSource() == clearButton){
            stack.clear();
            numbers.clear();
        } else if(e.getSource() == dropButton){
            stack.drop();
            numbers.remove(numbers.getSize()-1);
        } else if(e.getSource() == swapButton){
            Complex a = numbers.lastElement();
            numbers.set(numbers.getSize()-1,numbers.get(numbers.getSize()-2));
            numbers.set(numbers.getSize()-2,a);
            stack.swap();
        } else if(e.getSource() == dupButton){
            Complex j = stack.dup();
            numbers.addElement(j);
        } else if(e.getSource() == overButton){
            Complex j = stack.over();
            numbers.addElement(j);
        }
    }
}



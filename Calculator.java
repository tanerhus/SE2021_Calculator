package CalculatorApp;

import java.io.*;
import java.util.ArrayList;

public class Calculator {

    public static void main(String[] args) {
        Stack myStack = new Stack(1000);
        String fileName = "UserDefinedOperations.txt";
        ComplexCalculatorGUI myFrame = new ComplexCalculatorGUI(myStack);
        myFrame.setVisible(true);


    }

    public static Complex operation(Stack myStack, String operation, Complex variable) {
        switch (operation) {
            case ">":
                return myStack.drop();
            case "<":
                myStack.push(variable);
                return variable;
            case "+": {
                Complex topComplex = myStack.drop();
                myStack.push(variable.add(topComplex));
                return variable;
            }
            case "-": {
                Complex topComplex = myStack.drop();
                myStack.push(variable.subtract(topComplex));
                return variable;
            }
        }
        return null;
    }

    // Writing File Format is: operationName || operation
    public static void WriteToFile(String fileName, String operationName, String operation) {
        try {

            FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            String line = operationName + " || " + operation;
            bw.write(line);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<UserDefinedOperation> ReadFromFile(String fileName) {
        ArrayList<UserDefinedOperation> userDefinedOperations = new ArrayList<UserDefinedOperation>();
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] lineText = line.split(" || ");
                String operationName = lineText[0];
                String operation = lineText[1];
                userDefinedOperations.add(new UserDefinedOperation(operationName, operation));
            }
            br.close();
            return userDefinedOperations;
        } catch (IOException e) {
            e.printStackTrace();
            return userDefinedOperations;
        }
    }
}
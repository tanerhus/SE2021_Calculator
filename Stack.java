package CalculatorApp;

public class Stack {

    private final Complex[] stack;
    private int top;
    private final int maxSize;

    public Stack(int s) {
        maxSize = s;
        stack = new Complex[maxSize];
        top = 0;
    }

    public void push(Complex j) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }

        stack[top++] = j;
    }

    public Complex dup() {
        if (isFull()) {
            System.out.println("Stack is full");
            return null;
        }
        Complex topVar2 = stack[top-1];
        stack[++top] = topVar2;
        return topVar2;

    }

    public void swap() {
        Complex topVar = stack[top - 1];
        Complex topVar2 = stack[top - 2];
        stack[top - 1] = topVar2;
        stack[top - 2] = topVar;
    }

    public Complex over() {
        if (isFull()) {
            System.out.println("Stack is full");
            return null;
        }

        Complex topVar = stack[top-2];
        stack[top++] = topVar;
        return topVar;
    }

    public void clear() {
        for (int i = 0; i < stack.length; i++) {
            stack[i] = null;
        }
    }

    public Complex drop() {
        Complex lastElement = stack[top];
        stack[top] = null;
        top--;
        return lastElement;
    }

    public Complex peek() {
        return stack[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }
}

package CalculatorApp;

public class  Complex {

    private double real;
    private double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public Complex add(Complex c) {
        return new Complex(real + c.real, imaginary + c.imaginary);
    }

    public Complex subtract(Complex c) {
        return new Complex(real - c.real, imaginary - c.imaginary);
    }

    public Complex multiply(Complex c) {
        return new Complex(real * c.real - imaginary * c.imaginary, real * c.imaginary + imaginary * c.real);
    }

    public Complex divide(Complex c) {
        return new Complex((real * c.real + imaginary * c.imaginary) / (c.real * c.real + c.imaginary * c.imaginary),
                (imaginary * c.real - real * c.imaginary) / (c.real * c.real + c.imaginary * c.imaginary));
    }

    public Complex sqrt(Complex c) {
        return new Complex(Math.sqrt(c.real), Math.sqrt(c.imaginary));
    }

    public Complex invertSign(Complex c) {
        return new Complex(-c.real, -c.imaginary);
    }

    public String toString() {
        if(Double.toString(getImaginary()).startsWith("-")){
            return real + " " + imaginary + "i";
        }
        return real + " + " + imaginary + "i";
    }
}

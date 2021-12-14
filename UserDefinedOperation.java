package CalculatorApp;

public class UserDefinedOperation {

    public String operationName;
    public String operation;

    public UserDefinedOperation(String operationName, String operation) {
        this.operationName = operationName;
        this.operation = operation;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}

package src.project01am.day08;

public class Calculator {
    protected int lastResult;
    protected final String[] COMMAND = { "+", "-", "*", "/" };

    public Calculator() {
        this.lastResult = 0;
    }

    public int calculate(String input) {
        int result = 0;
        String[] inputs = input.split(" ");
        for (int idx = 0; idx < inputs.length; idx++) {
            if (checkCMD(inputs[idx])) {
                int num1;
                int num2;
                if (inputs[idx - 1].equalsIgnoreCase("last")) {
                    num1 = this.lastResult;
                }else{
                    num1 = Integer.parseInt(inputs[idx - 1]);
                }
                if (inputs[idx + 1].equalsIgnoreCase("last")) {
                    num2 = this.lastResult;
                }else{
                    num2 = Integer.parseInt(inputs[idx + 1]);
                }
                switch (inputs[idx]) {
                    case "*":
                        result = num1 * num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "+":
                        result = num1 + num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;

                    default:
                        break;
                }
            }
        }
        this.lastResult = result;
        return result;
    }

    public int getLastResult() {
        return this.lastResult;
    }

    private boolean checkCMD(String item) {
        for (String cmd : COMMAND) {
            if (item.equals(cmd)) {
                return true;
            }
        }
        return false;
    }
}

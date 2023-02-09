package Models;

public class Verification {
    private boolean result;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Verification(boolean result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Verification{" +
                "result=" + result +
                '}';
    }
}

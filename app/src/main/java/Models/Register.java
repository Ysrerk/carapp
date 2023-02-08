package Models;

public class Register {

    private boolean result;
    private String explanation;
    private String varifacitioncode;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Register(boolean result, String explanation, String varifacitioncode) {
        this.result = result;
        this.explanation = explanation;
        this.varifacitioncode = varifacitioncode;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getVarifacitioncode() {
        return varifacitioncode;
    }

    public void setVarifacitioncode(String varifacitioncode) {
        this.varifacitioncode = varifacitioncode;
    }

    @Override
    public String toString() {
        return "Register{" +
                "result=" + result +
                ", explanation='" + explanation + '\'' +
                ", varifacitioncode='" + varifacitioncode + '\'' +
                '}';
    }
}

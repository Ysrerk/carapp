package Models;

public class UserUpdate {

    private  Boolean result;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "UserUpdate{" +
                "result=" + result +
                '}';
    }
}

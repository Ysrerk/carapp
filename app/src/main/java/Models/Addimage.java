package Models;

public class Addimage {
    private String resultmessage;
    private Boolean tf;

    public String getResultmessage() {
        return resultmessage;
    }

    public void setResultmessage(String resultmessage) {
        this.resultmessage = resultmessage;
    }

    public Boolean getTf() {
        return tf;
    }

    public void setTf(Boolean tf) {
        this.tf = tf;
    }

    @Override
    public String toString() {
        return "Addimage{" +
                "resultmessage='" + resultmessage + '\'' +
                ", tf=" + tf +
                '}';
    }
}

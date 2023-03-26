package Models;

public class AddFavorite {

    private Boolean tf;
    private String text;

    public Boolean getTf() {
        return tf;
    }

    public void setTf(Boolean tf) {
        this.tf = tf;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "AddFavorite{" +
                "tf=" + tf +
                ", text='" + text + '\'' +
                '}';
    }
}

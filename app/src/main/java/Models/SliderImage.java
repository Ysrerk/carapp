package Models;

public class SliderImage {
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "SliderImage{" +
                "image='" + image + '\'' +
                '}';
    }
}

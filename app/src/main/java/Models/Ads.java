package Models;

public class Ads {

    private String advid;
    private String memberid;
    private String province;
    private String title;
    private String year;
    private String make;
    private String model;
    private String price;
    private Boolean tf;

    private String image;

    public String getAdvid() {
        return advid;
    }

    public void setAdvid(String advid) {
        this.advid = advid;
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Boolean getTf() {
        return tf;
    }

    public void setTf(Boolean tf) {
        this.tf = tf;
    }

    public String getSayi() {
        return sayi;
    }

    public void setSayi(String sayi) {
        this.sayi = sayi;
    }

    private String sayi;

    @Override
    public String toString() {
        return "Ads{" +
                "advid='" + advid + '\'' +
                ", memberid='" + memberid + '\'' +
                ", province='" + province + '\'' +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", price='" + price + '\'' +
                ", tf=" + tf +
                ", sayi='" + sayi + '\'' +
                '}';
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

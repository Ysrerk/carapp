package Models;

public class Advresult {

    private String memberid;
    private Boolean result;
    private String advid;

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getAdvid() {
        return advid;
    }

    public void setAdvid(String advid) {
        this.advid = advid;
    }

    @Override
    public String toString() {
        return "Advresult{" +
                "memberid='" + memberid + '\'' +
                ", result=" + result +
                ", advid='" + advid + '\'' +
                '}';
    }
}

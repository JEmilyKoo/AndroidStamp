package kosmo.com.stampgo.service;

public class MemberDTO {

    private String id;
    private String pwd;
    private String name;
    private int followCheck;
    private String nickName;
    private String mail;
    private String trvprpns;
    private String gender;
    private String birth;
    private String phone;
    private String prfImage;

    public int getFollowCheck() {
        return followCheck;
    }

    public void setFollowCheck(int followCheck) {
        this.followCheck = followCheck;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTrvprpns() {
        return trvprpns;
    }

    public void setTrvprpns(String trvprpns) {
        this.trvprpns = trvprpns;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPrfImage() {
        return prfImage;
    }

    public void setPrfImage(String prfImage) {
        this.prfImage = prfImage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

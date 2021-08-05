package kosmo.com.stampgo.service;

import java.util.Date;

public class ReviewDTO {

    private String rvNo;
    private String nickName;
    private String rvTitle;
    private String rvCtt;
    private int rvLikeCnt;
    private Date rvDate;
    private String rvCategory1;
    private String rvCategory2;
    private String rvLat;
    private String rvLng;
    private String rvVisitCnt;
    private String rvFile;
    private int rvLikeCheck;


    //rvLike 추가
    private Date rvlDate;
    public ReviewDTO() {

    }


    //rvCmnt 추가
    private String rvcNo;
    //+rvNo
    private String rvCmnt;
    //+nickName
    private Date rvcDate;

    //file객체들
    private String fullName;
    private String rvfdate;

    //섬네일 날조용
    private String image;

    public String getRvNo() {
        return rvNo;
    }

    public void setRvNo(String rvNo) {
        this.rvNo = rvNo;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRvTitle() {
        return rvTitle;
    }

    public void setRvTitle(String rvTitle) {
        this.rvTitle = rvTitle;
    }

    public String getRvCtt() {
        return rvCtt;
    }

    public void setRvCtt(String rvCtt) {
        this.rvCtt = rvCtt;
    }

    public int getRvLikeCnt() {
        return rvLikeCnt;
    }

    public void setRvLikeCnt(int rvLikeCnt) {
        this.rvLikeCnt = rvLikeCnt;
    }

    public Date getRvDate() {
        return rvDate;
    }

    public void setRvDate(Date rvDate) {
        this.rvDate = rvDate;
    }

    public String getRvCategory1() {
        return rvCategory1;
    }

    public void setRvCategory1(String rvCategory1) {
        this.rvCategory1 = rvCategory1;
    }

    public String getRvCategory2() {
        return rvCategory2;
    }

    public void setRvCategory2(String rvCategory2) {
        this.rvCategory2 = rvCategory2;
    }

    public String getRvLat() {
        return rvLat;
    }

    public void setRvLat(String rvLat) {
        this.rvLat = rvLat;
    }

    public String getRvLng() {
        return rvLng;
    }

    public void setRvLng(String rvLng) {
        this.rvLng = rvLng;
    }

    public String getRvVisitCnt() {
        return rvVisitCnt;
    }

    public void setRvVisitCnt(String rvVisitCnt) {
        this.rvVisitCnt = rvVisitCnt;
    }

    public String getRvFile() {
        return rvFile;
    }

    public void setRvFile(String rvFile) {
        this.rvFile = rvFile;
    }

    public int getRvLikeCheck() {
        return rvLikeCheck;
    }

    public void setRvLikeCheck(int rvLikeCheck) {
        this.rvLikeCheck = rvLikeCheck;
    }

    public Date getRvlDate() {
        return rvlDate;
    }

    public void setRvlDate(Date rvlDate) {
        this.rvlDate = rvlDate;
    }

    public String getRvcNo() {
        return rvcNo;
    }

    public void setRvcNo(String rvcNo) {
        this.rvcNo = rvcNo;
    }

    public String getRvCmnt() {
        return rvCmnt;
    }

    public void setRvCmnt(String rvCmnt) {
        this.rvCmnt = rvCmnt;
    }

    public Date getRvcDate() {
        return rvcDate;
    }

    public void setRvcDate(Date rvcDate) {
        this.rvcDate = rvcDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRvfdate() {
        return rvfdate;
    }

    public void setRvfdate(String rvfdate) {
        this.rvfdate = rvfdate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ReviewDTO(String rvNo, String nickName, String rvTitle, String rvCtt, int rvLikeCnt, Date rvDate, String rvCategory1, String rvCategory2, String rvLat, String rvLng, String rvVisitCnt, String rvFile, int rvLikeCheck, Date rvlDate, String rvcNo, String rvCmnt, Date rvcDate, String fullName, String rvfdate, String image) {
        this.rvNo = rvNo;
        this.nickName = nickName;
        this.rvTitle = rvTitle;
        this.rvCtt = rvCtt;
        this.rvLikeCnt = rvLikeCnt;
        this.rvDate = rvDate;
        this.rvCategory1 = rvCategory1;
        this.rvCategory2 = rvCategory2;
        this.rvLat = rvLat;
        this.rvLng = rvLng;
        this.rvVisitCnt = rvVisitCnt;
        this.rvFile = rvFile;
        this.rvLikeCheck = rvLikeCheck;
        this.rvlDate = rvlDate;
        this.rvcNo = rvcNo;
        this.rvCmnt = rvCmnt;
        this.rvcDate = rvcDate;
        this.fullName = fullName;
        this.rvfdate = rvfdate;
        this.image = image;
    }
}

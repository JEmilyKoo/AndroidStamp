package kosmo.com.stampgo.service;

import java.util.Date;

public class StampDTO {

    String rvNo;
    String rvLat;
    String rvLng;
    String stNo;
    Date stDate;
    Date stExpiredDate;
    String rvTitle;
    String stIsExpired;

    public String getRvNo() {
        return rvNo;
    }

    public void setRvNo(String rvNo) {
        this.rvNo = rvNo;
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

    public String getStNo() {
        return stNo;
    }

    public void setStNo(String stNo) {
        this.stNo = stNo;
    }

    public Date getStDate() {
        return stDate;
    }

    public void setStDate(Date stDate) {
        this.stDate = stDate;
    }

    public Date getStExpiredDate() {
        return stExpiredDate;
    }

    public void setStExpiredDate(Date stExpiredDate) {
        this.stExpiredDate = stExpiredDate;
    }

    public String getRvTitle() {
        return rvTitle;
    }

    public void setRvTitle(String rvTitle) {
        this.rvTitle = rvTitle;
    }

    public String getStIsExpired() {
        return stIsExpired;
    }

    public void setStIsExpired(String stIsExpired) {
        this.stIsExpired = stIsExpired;
    }
}

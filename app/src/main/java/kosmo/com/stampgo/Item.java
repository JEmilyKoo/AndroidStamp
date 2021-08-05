package kosmo.com.stampgo;

import android.graphics.Bitmap;

import com.makeramen.roundedimageview.RoundedImageView;

public class Item {
    private String itemTitle;
    private String image;
    private String rvNo;


    public Item(String itemTitle, String image, String rvNo) {
        this.itemTitle = itemTitle;
        this.image = image;
        this.rvNo= rvNo;
    }
    public String getImage(){return image;}
    public String getRvNo() {return rvNo;}
    public String getItemTitle() {
        return itemTitle;
    }

}

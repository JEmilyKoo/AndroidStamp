package kosmo.com.stampgo;

public class Item {
    private String itemTitle;
    private int itemImageResId;
    private String rvNo;


    public Item(String itemTitle, int itemImageResId, String rvNo) {
        this.itemTitle = itemTitle;
        this.itemImageResId = itemImageResId;
        this.rvNo= rvNo;
    }
    public String getRvNo() {return rvNo;}
    public String getItemTitle() {
        return itemTitle;
    }
    public int getItemImageResId() {
        return itemImageResId;
    }

}

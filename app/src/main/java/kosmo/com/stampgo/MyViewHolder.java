package kosmo.com.stampgo;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;

//어댑터의 내부 클래스로 정의하지않고 별도의 외부 클래스로 뷰홀더 정의
public class MyViewHolder extends RecyclerView.ViewHolder {
    RoundedImageView itemImage;
    TextView itemTitle;
    CardView cardView;
    TextView itemRv1;
    TextView itemRv2;
    TextView itemNickName;
    ImageView recommend;
    //이벤트 처리용
    //인자로 전개된 아이템뷰를 받는다
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        itemImage = itemView.findViewById(R.id.itemImage);
        itemTitle = itemView.findViewById(R.id.itemTitle);
        cardView  = itemView.findViewById(R.id.cardview);
        itemRv1 =itemView.findViewById(R.id.itemRV1);
        itemRv2 =itemView.findViewById(R.id.itemRV2);
        recommend = itemView.findViewById(R.id.recommend);
        itemNickName =itemView.findViewById(R.id.itemNickName);

    }
}

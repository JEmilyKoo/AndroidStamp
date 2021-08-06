package kosmo.com.stampgo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Field;
import java.util.List;

import kosmo.com.stampgo.service.MemberDTO;
import kosmo.com.stampgo.service.ReviewDTO;
import kosmo.com.stampgo.service.ReviewService;
import kosmo.com.stampgo.service.StampService;

public class MyRecyclerAdapter extends RecyclerView.Adapter {

    private final Context context;
    private final List<ReviewDTO> items;
    public MyRecyclerAdapter(Context context, List<ReviewDTO> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        //아이템뷰 전개
        View itemView=LayoutInflater.from(context).inflate(R.layout.item_layout,null);
        //뷰홀더 객체 생성후 반환
        return new MyViewHolder(itemView);
    }





    //데이터 바인딩
    @Override
    public void onBindViewHolder(@NonNull  RecyclerView.ViewHolder holder, int position) {
        //position 인덱스의 데이타
        ReviewDTO item = items.get(position);


        //위의 데이터로 바인딩
        if (item.getImage()!=null){
            System.out.println("값은 있다니까");
            String encodedDataString =item.getImage();
            encodedDataString = encodedDataString.substring(encodedDataString.indexOf(",")  + 1);
            byte[] imageAsBytes = Base64.decode(encodedDataString, Base64.DEFAULT);
            Bitmap decodedBitmap = BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length);
            ((MyViewHolder)holder).itemImage.setImageBitmap(decodedBitmap);

        }
     int rvNo =Integer.parseInt(item.getRvNo());
    if(item.getRvLikeCnt()>=2){
        ((MyViewHolder)holder).recommend.setAlpha(1f);
    }
        if(510>rvNo && rvNo>500){
            rvNo=rvNo-500;
            String photo = "photo"+Integer.toString(rvNo);
            Class<R.drawable> drawable = R.drawable.class;
            try { Field field;
            field = drawable.getField(photo);
            int r; r = field.getInt(null);
System.out.println(item.getRvNo());

                ((MyViewHolder)holder).itemImage.setImageResource(r);}
            catch (Exception e) {}
           // int lid = this.getResources().getIdentifier(photo, "drawable", this.getPackageName());
            //((MyViewHolder)holder).itemImage.setImageResource(lid);
            //   ((MyViewHolder)holder).itemImage.setImageResource(photo);
        }
if(item.getRvCategory1()!=null) {
    ((MyViewHolder) holder).itemRv1.setText("#"+item.getRvCategory1());
}
if(item.getRvCategory2()!=null) {
    ((MyViewHolder) holder).itemRv2.setText("#"+item.getRvCategory2());
}
((MyViewHolder)holder).itemNickName.setText(item.getNickName());
        ((MyViewHolder)holder).rvLikeCnt.setText(Integer.toString(item.setRvLikeCnt()));
        ((MyViewHolder)holder).itemTitle.setText(item.getRvTitle());
        ((MyViewHolder)holder).itemTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, item.getRvNo(), Toast.LENGTH_SHORT).show();


                //    activity.onFragmentChanged(1);
            }
        });
        final boolean[] flag = {true};

        ((MyViewHolder)holder).itemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag[0]) {
                    Toast.makeText(context, item.getRvTitle(), Toast.LENGTH_SHORT).show();
                    ((MyViewHolder) holder).itemImage.setAlpha(0.2f);

                    flag[0] =false;
                }
                else{

                    ((MyViewHolder) holder).itemImage.setAlpha(1f);
                    flag[0] =true;
                }

            }


        });


    }
    @Override
    public int getItemCount() {
        return items.size();
    }
}

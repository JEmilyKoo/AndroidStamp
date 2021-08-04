package kosmo.com.stampgo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<Item> items;

    public MyRecyclerAdapter(Context context, List<Item> items) {
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
        //position인덱스의 데이타
        Item item = items.get(position);

        //위의 데이터로 바인딩
        ((MyViewHolder)holder).itemImage.setImageResource(item.getItemImageResId());
        ((MyViewHolder)holder).itemTitle.setText(item.getItemTitle());
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
                if(flag[0] ==true) {
                    Toast.makeText(context, item.getItemTitle(), Toast.LENGTH_SHORT).show();
                    ((MyViewHolder) holder).itemImage.setAlpha(0.2f);
                    flag[0] =false;
                }
                else{

                    ((MyViewHolder) holder).itemImage.setAlpha(1f);
                    flag[0] =true;
                }

            }


        });

        /*
        ((MyViewHolder)holder).cardView.setOnTouchListener(new View.OnTouchListener(){

            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();

                float curX = motionEvent.getX();
                float curY = motionEvent.getY();

                if (action == MotionEvent.ACTION_DOWN){
                    System.out.println("손가락 눌림 : "+curX+", "+curY);
                }
                else if (action == MotionEvent.ACTION_MOVE){
                    System.out.println("손가락 움직임 : "+curX+", "+curY);
                }
                else if (action == MotionEvent.ACTION_UP){
                    System.out.println("손가락 뗌 : "+curX+", "+curY);
                }
                return true;
            }
        });


         */
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
}

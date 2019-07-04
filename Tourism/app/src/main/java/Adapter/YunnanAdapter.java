package Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.tourism.R;

import java.util.List;

//import java.util.List;
//
public class YunnanAdapter extends RecyclerView.Adapter<YunnanAdapter.ViewHolder> {
//    private int resourceId;
    private List<Yunnan> mYunnanList;
    static class  ViewHolder extends  RecyclerView.ViewHolder{
        ImageView yunnanimage;
        TextView beijingname;
        public  ViewHolder(View view){
            super(view);
            yunnanimage=(ImageView)view.findViewById(R.id.yunnan_item_image);
          // beijingname=(TextView)view.findViewById(R.id.beijing_item_name);
        }
    }
    public YunnanAdapter(List<Yunnan> mHainanList1)
    {
        mYunnanList=mHainanList1;
    }

    @NonNull
    @Override
    public YunnanAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.yunnan_item,viewGroup,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull YunnanAdapter.ViewHolder viewHolder,final int position) {
       Yunnan yunnan=mYunnanList.get(position);
       viewHolder.yunnanimage.setImageResource(yunnan.getImageId());
        viewHolder.yunnanimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 1){

                }
            }
        });
   //viewHolder.beijingname.setText(beijing.getName());
    }

    @Override
    public int getItemCount() {
        return mYunnanList.size();
    }


    /**
     * ListView的代码
     *
     * */

//    @Override
//    public View getView(int  position, View convertView, ViewGroup parent)
//    {
//        //获取当前实例
//        Beijing beijing=getItem(position);
//        View view=LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
//        ImageView BeijingImage=(ImageView)view.findViewById(R.id.beijing_item_image);
//        TextView BeijingName=(TextView)view.findViewById(R.id.beijing_item_name);
//        BeijingImage.setImageResource(beijing.getImageId());
//        BeijingName.setText(beijing.getName());
//        return view;
//    }
}

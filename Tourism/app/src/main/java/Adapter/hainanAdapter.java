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
public class hainanAdapter extends RecyclerView.Adapter<hainanAdapter.ViewHolder> {
//    private int resourceId;
    private List<Hainan> mHainanList;
    static class  ViewHolder extends  RecyclerView.ViewHolder{
        ImageView hainanimage;
       // TextView beijingname;
        public  ViewHolder(View view){
            super(view);
            hainanimage=(ImageView)view.findViewById(R.id.hainan_item_image);
          // beijingname=(TextView)view.findViewById(R.id.beijing_item_name);
        }
    }
    public hainanAdapter(List<Hainan>mHainanList1)
    {
        mHainanList=mHainanList1;
    }

    @NonNull
    @Override
    public hainanAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hainan_item,viewGroup,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull hainanAdapter.ViewHolder viewHolder, int position) {
       Hainan hainan=mHainanList.get(position);
       viewHolder.hainanimage.setImageResource(hainan.getImageId());
   //viewHolder.beijingname.setText(beijing.getName());
    }

    @Override
    public int getItemCount() {
        return mHainanList.size();
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

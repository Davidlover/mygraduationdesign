package Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

;

import com.example.lenovo.tourism.R;

import java.util.List;

//import java.util.List;
//
public class Home_icon_Adapter extends RecyclerView.Adapter<Home_icon_Adapter.ViewHolder> {
//    private int resourceId;
    private List<home_icon> mBeijingList;
    static class  ViewHolder extends  RecyclerView.ViewHolder{
        ImageView beijingimage;
        TextView beijingname;
        public  ViewHolder(View view){
            super(view);
//            beijingimage=(ImageView)view.findViewById(R.id.imageaaa);
//            beijingname=(TextView)view.findViewById(R.id.tvaaaa);
        }
    }
    public Home_icon_Adapter(List<home_icon>beijingList)
    {
        mBeijingList=beijingList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout,viewGroup,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Home_icon_Adapter.ViewHolder viewHolder, int position) {
       home_icon icon=mBeijingList.get(position);
       viewHolder.beijingimage.setImageResource(icon.getImageId());
       viewHolder.beijingname.setText(icon.getName());
    }

    @Override
    public int getItemCount() {
        return mBeijingList.size();
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

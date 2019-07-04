package com.example.lenovo.tourism.activity.newmodel;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.tourism.R;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;

import utils.BitMap;


/**
 *
 * 原生的RecycleView 不支持 addHeaderView，addFooterView 方法，
 *
 * 所以通过如下自定义Adapter 的方式来实现对于 addHeaderView，addFooterView 方法 的支持。
 *
 * 参考：http://www.jianshu.com/p/991062d964cf
 *
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_HEADER = 0;  //带有Header的
    public static final int TYPE_FOOTER = 1;  //带有Footer的
    public static final int TYPE_NORMAL_ONE = 2;  //不带有header和footer的viewtype1
    public static final int TYPE_NORMAL_TWO = 3;
private MomentActivity momentActivity;
    private ItemData[] itemsData;

    private View mHeaderView;
    private View mFooterView;

    public MyAdapter(ItemData[]itemsData,MomentActivity momentActivity) {
        this.itemsData = itemsData;
        this.momentActivity =momentActivity;
    }

    // HeaderView和FooterView的get和set函数
    public View getHeaderView() {
        return mHeaderView;
    }
    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }
    public View getFooterView() {
        return mFooterView;
    }
    public void setFooterView(View footerView) {
        mFooterView = footerView;
        notifyItemInserted(getItemCount()-1);
    }

    // 通过判断item的类型，从而绑定不同的view
    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            // 第一个位置加载 Header
            return TYPE_HEADER;
        } else if (itemsData[position-1].getPic() != null){
            return TYPE_NORMAL_ONE;
        }
        /*
        if (position == getItemCount()-1){
            // 最后一个位置加载 Footer
            return TYPE_FOOTER;
        }*/
        return TYPE_NORMAL_TWO;

    }

    // 创建View，如果是HeaderView或者是FooterView，直接在Holder中返回
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mHeaderView != null && viewType == TYPE_HEADER) {
            return new ListHolder(mHeaderView);
        }
        if (viewType == TYPE_NORMAL_ONE) {
            View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_second, parent, false);
            return new ListHolder(layout);
        } else{
            View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
            return new ListHolder(layout);
    }

    }

    // 绑定View，这里是根据返回的这个position的类型，从而进行绑定的，HeaderView和FooterView, 就不同绑定了
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == TYPE_NORMAL_TWO){
            if(holder instanceof ListHolder) {
                // 从position-1开始，因为position==0已经被header占用了
//                ((ListHolder) holder).tv.setText(itemsData.get(position-1));

                ((ListHolder) holder).mNameView.setText(itemsData[position - 1].getName());
                ((ListHolder) holder).mAvatarView.setImageResource(itemsData[position - 1].getAvatar());
                ((ListHolder) holder).mContentView.setText(itemsData[position - 1].getContent());
                ((ListHolder) holder).mTimeView.setText(itemsData[position - 1].getTimet());

//
//                if(itemsData[position - 1].getPic() != 0) {
//                    ((ListHolder) holder).mPicView.setVisibility(View.VISIBLE);
//                ((ListHolder) holder).mPicView.setImageResource(itemsData[position - 1].getPic());
//
//                }

            }
        }else if(getItemViewType(position) == TYPE_NORMAL_ONE){
            if(holder instanceof ListHolder) {
                ((ListHolder) holder).mNameView.setText(itemsData[position - 1].getName());
                ((ListHolder) holder).mAvatarView.setImageResource(itemsData[position - 1].getAvatar());
                ((ListHolder) holder).mContentView.setText(itemsData[position - 1].getContent());
                ((ListHolder) holder).mTimeView.setText(itemsData[position - 1].getTimet());
                ((ListHolder) holder).mPicView.setImageBitmap(itemsData[position-1].getPic());//setImageResource(itemsData[position - 1].getPic());
            }

        }else if(getItemViewType(position) == TYPE_HEADER){
        }else{
        }
    }

    // 在这里面加载ListView中的每个item的布局
    class ListHolder extends RecyclerView.ViewHolder{

        public TextView mNameView;
        public ImageView mAvatarView;
        public TextView mContentView;
        public TextView mTimeView;
        public ImageView mPicView;

        public ListHolder(View itemLayoutView) {
            super(itemLayoutView);
            // 如果是headerview或者是footerview,直接返回
            if (itemView == mHeaderView){
                return;
            }
            mNameView = (TextView) itemLayoutView.findViewById(R.id.item_name);
            mAvatarView = (ImageView) itemLayoutView.findViewById(R.id.item_avatar);
            mContentView = (TextView) itemLayoutView.findViewById(R.id.item_content);
            mTimeView = (TextView) itemLayoutView.findViewById(R.id.item_time_1);
            mPicView = (ImageView) itemLayoutView.findViewById(R.id.item_pic);
        }
    }


    // 返回View中Item的个数，这个时候，总的个数应该是ListView中Item的个数加上HeaderView和FooterView
    @Override
    public int getItemCount() {
        if(mHeaderView == null){
            return itemsData.length;
        }else {
            return itemsData.length + 1;
        }
    }

}
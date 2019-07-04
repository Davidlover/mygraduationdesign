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

public class MeAdapter extends RecyclerView.Adapter<MeAdapter.ViewHolder> {
    private List<Me> mMelist;
    static class ViewHolder extends  RecyclerView.ViewHolder {
        ImageView meimage;
        TextView metext;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            meimage=itemView.findViewById(R.id.me_item_image);
            metext=itemView.findViewById(R.id.me_item_text);
        }
    }

    public MeAdapter(List<Me> mMelistpara) {
        mMelist = mMelistpara;
    }

    @NonNull
    @Override
    public MeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.me_item, viewGroup, false);
         ViewHolder holder = new ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull MeAdapter.ViewHolder viewHolder, int i) {
        Me me = mMelist.get(i);
        viewHolder.meimage.setImageResource(me.getImageId());
        viewHolder.metext.setText(me.getName());
    }

    @Override
    public int getItemCount() {
        return mMelist.size();
    }


}

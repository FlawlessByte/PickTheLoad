package co.realinventor.picktheload.Admin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import co.realinventor.picktheload.Common.LoadPost;
import co.realinventor.picktheload.R;

public class PostLoadAdapter extends RecyclerView.Adapter<PostLoadAdapter.MyViewHolder> {
    private List<LoadPost> loadPostList;

    public PostLoadAdapter(List<LoadPost> loadPostList){
        this.loadPostList = loadPostList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView, locationTo, locationFrom, capacity, goodsType, truckType, expPrice, phone, date;
        public Button approveButton, removeButton;

        public MyViewHolder(View view) {
            super(view);
            nameTextView = (TextView) view.findViewById(R.id.nameTextView);
            locationTo = (TextView) view.findViewById(R.id.locationTo);
            locationFrom = (TextView) view.findViewById(R.id.locationFrom);
            capacity = (TextView) view.findViewById(R.id.capacity);
            goodsType = (TextView) view.findViewById(R.id.goodsType);
            truckType = (TextView) view.findViewById(R.id.truckType);
            expPrice = (TextView) view.findViewById(R.id.expPrice);
            phone = (TextView) view.findViewById(R.id.phone);
            date = (TextView) view.findViewById(R.id.date);
            approveButton = (Button) view.findViewById(R.id.approveButton);
            removeButton = (Button) view.findViewById(R.id.removeButton);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_load_row_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        LoadPost loadPost = loadPostList.get(position);
        holder.nameTextView.setText(loadPost.getName());
        holder.locationTo.setText(loadPost.getLocation_to());
        holder.locationFrom.setText(loadPost.getLocation_from());
        holder.date.setText(loadPost.getDate());
        holder.phone.setText(loadPost.getPhone());
        holder.expPrice.setText(loadPost.getExpected_price());
        holder.truckType.setText(loadPost.getTruck_type());
        holder.goodsType.setText(loadPost.getGoods_type());
        holder.capacity.setText(loadPost.getCapacity());
        holder.approveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

        holder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return loadPostList.size();
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

}

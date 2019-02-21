package co.realinventor.picktheload.Admin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.List;
import androidx.recyclerview.widget.RecyclerView;
import co.realinventor.picktheload.Common.Constants;
import co.realinventor.picktheload.Common.LorryPost;
import co.realinventor.picktheload.R;

public class PostLorryAdapter extends RecyclerView.Adapter<PostLorryAdapter.MyViewHolder> {
    private List<LorryPost> LorryPostList;
    private DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

    public PostLorryAdapter(List<LorryPost> LorryPostList){
        this.LorryPostList = LorryPostList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView, locationTo, locationFrom, capacity, truckNo, phone, date;
        public Button approveButton, removeButton;

        public MyViewHolder(View view) {
            super(view);
            nameTextView = (TextView) view.findViewById(R.id.nameTextView);
            locationTo = (TextView) view.findViewById(R.id.locationTo);
            locationFrom = (TextView) view.findViewById(R.id.locationFrom);
            capacity = (TextView) view.findViewById(R.id.capacity);
            truckNo = (TextView) view.findViewById(R.id.truckNo);
            phone = (TextView) view.findViewById(R.id.phone);
            date = (TextView) view.findViewById(R.id.date);
            approveButton = (Button) view.findViewById(R.id.approveButton);
            removeButton = (Button) view.findViewById(R.id.removeButton);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_lorry_row_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final LorryPost LorryPost = LorryPostList.get(position);
        holder.nameTextView.setText("Name : "+LorryPost.getName());
        holder.locationTo.setText("To : "+LorryPost.getLocation_to());
        holder.locationFrom.setText("From : "+LorryPost.getLocation_from());
        holder.date.setText("Date : "+LorryPost.getDate());
        holder.phone.setText("Phone No. : "+LorryPost.getPhone());
        holder.truckNo.setText("Truck No : "+LorryPost.gettruck_no());
        holder.capacity.setText("Capacity : "+LorryPost.getCapacity());

        if(Constants.CURRENT_USER.equals(Constants.ADMIN)) {
            holder.approveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //approve the request
                    Log.d("Approve button", "position " + position);
                    ref.child("Post_Lorry").child(LorryPost.unique_id).child("approved").setValue("yes");
                    LorryPostList.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, LorryPostList.size());

                }
            });

            holder.removeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Remove the request from database
                    ref.child("Post_Lorry").child(LorryPost.unique_id).removeValue();
                    LorryPostList.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, LorryPostList.size());

                }
            });
        }
        else if(Constants.CURRENT_USER.equals(Constants.MERCHANT)){
            holder.approveButton.setVisibility(View.GONE);
            holder.removeButton.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return LorryPostList.size();
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

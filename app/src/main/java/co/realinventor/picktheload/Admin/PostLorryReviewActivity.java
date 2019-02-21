package co.realinventor.picktheload.Admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import co.realinventor.picktheload.Common.Constants;
import co.realinventor.picktheload.Common.LorryPost;
import co.realinventor.picktheload.R;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PostLorryReviewActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private List<LorryPost> lorryPostList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PostLorryAdapter mAdapter;
    private TextView textViewMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_lorry_review);

        textViewMsg = findViewById(R.id.textViewMsgFeedback);

        //RecyclerView things
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_lorry_review);

        mAdapter = new PostLorryAdapter(lorryPostList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        Query myFeedbackQuery = mDatabase.child("Post_Lorry");
        myFeedbackQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    // TODO: handle the post

                    Log.d("FirebaseDatabase", "Got Post Lorrys");
                    LorryPost lorryPost = postSnapshot.getValue(LorryPost.class);
                    if (Constants.CURRENT_USER.equals(Constants.ADMIN) && lorryPost.getApproved().equals("no")){
                        lorryPostList.add(lorryPost);
                    }
                    if (Constants.CURRENT_USER.equals(Constants.MERCHANT) && lorryPost.getApproved().equals("yes")){
                        lorryPostList.add(lorryPost);
                    }

                }

                if(lorryPostList.size() == 0)
                    textViewMsg.setVisibility(View.VISIBLE);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("get lorry", databaseError.getMessage());
                Toast.makeText(getApplicationContext(), "Sorry, some error occured!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

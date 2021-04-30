package id.ac.umn.mobile_jobfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//import com.firebase.ui.database.FirebaseRecyclerAdapter;

import id.ac.umn.mobile_jobfinder.Model.Data;

public class PostJobActivity extends AppCompatActivity {
    private FloatingActionButton faBtn;
    private RecyclerView recyclerView;

    private FirebaseAuth mAuth;
    private DatabaseReference JobPostDataBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_job);
        faBtn = findViewById(R.id.fab_add);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser mUser = mAuth.getCurrentUser();
        String uId = mUser.getUid();

        JobPostDataBase = FirebaseDatabase.getInstance().getReference().child("Job Post").child(uId);

        recyclerView = findViewById(R.id.recycler_job_post_id);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setStackFromEnd(true);
        layoutManager.setReverseLayout(true);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);


        faBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), InsertJobPostActivity.class));
            }
        });
 }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Data, MyViewHolder> adapter=new FirebaseRecyclerAdapter<Data, MyViewHolder>
                (
                        Data.class,
                        R.layout.job_post_item,
                        MyViewHolder.class,
                        JobPostDataBase
                ) {

            @Override
            protected void populateViewHolder(MyViewHolder viewHolder, Data model, int position) {
                viewHolder.setJobTitle(model.getTitle());
                viewHolder.setJobDate(model.getDate());
                viewHolder.setJobDesc(model.getDescription());
                viewHolder.setJobDate(model.getDate());
                viewHolder.setJobSkills(model.getSkills());
                viewHolder.setJobSalary(model.getSalary());
            }
            };
        recyclerView.setAdapter(adapter);
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder {

            View myview;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                myview = itemView;
            }

            public void setJobTitle(String title) {
                TextView mTitle = myview.findViewById(R.id.edtJobTitle);
                mTitle.setText(title);
            }

            public void setJobDate(String date) {
                TextView mDate = myview.findViewById(R.id.job_date);
                mDate.setText(date);
            }

            public void setJobDesc(String desc) {
                TextView mDesc = myview.findViewById(R.id.edtJobDesc);
                mDesc.setText(desc);
            }

            public void setJobSkills(String skills) {
                TextView mSkills = myview.findViewById(R.id.edtSkill);
                mSkills.setText(skills);
            }

            public void setJobSalary(String salary) {
                TextView mSalary = myview.findViewById(R.id.edtSalary);
                mSalary.setText(salary);
            }


        }
    }

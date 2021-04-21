package id.ac.umn.mobile_jobfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostJobActivity extends AppCompatActivity {

    //recycler view

    private RecyclerView recyclerView;

    //Firebase

    private FirebaseAuth mAuth;
    private DatabaseReference JobPostDataBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_job);

        //database
        mAuth=FirebaseAuth.getInstance();
        FirebaseUser mUser = mAuth.getCurrentUser();
        String uId = mUser.getUid();

        JobPostDataBase = FirebaseDatabase.getInstance().getReference().child("Job Post").child(uId);

        //ini buat recycler viewnya
        recyclerView=findViewById(R.id.recycler_job_post_id);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setStackFromEnd(true);
        layoutManager.setReverseLayout(true);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        View myView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myView = itemView;
        }

        public void setJobTitle(String title) {
            TextView mTitle = myView.findViewById(R.id.edtJobTitle);
            mTitle.setText(title);
        }

        public void setJobDate(String date) {
            TextView mDate = myView.findViewById(R.id.job_date);
            mDate.setText(date);
        }

        public void setJobDesc(String desc) {
            TextView mDesc = myView.findViewById(R.id.edtJobDesc);
            mDesc.setText(desc);
        }

        public void setJobSkills(String skills) {
            TextView mSkills = myView.findViewById(R.id.edtSkill);
            mSkills.setText(skills);
        }

        public void setJobSalary(String salary) {
            TextView mSalary = myView.findViewById(R.id.edtSalary);
            mSalary.setText(salary);
        }
    }
}
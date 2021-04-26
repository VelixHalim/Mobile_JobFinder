package id.ac.umn.mobile_jobfinder;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AllJobActivity extends AppCompatActivity {
private Toolbar toolbar;
private RecyclerView recyclerView;
private DatabaseReference mAllJobPost;

@Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_all_job);

    toolbar = findViewById(R.id.all_job_post);
    setSupportActionBar(toolbar);
    getSupportActionBar().setTitle("All Job Post");

    mAllJobPost = FirebaseDatabase.getInstance().getReference().child("Job Post");
    mAllJobPost.keepSynced(true);
    recyclerView = findViewById(R.id.recycler_all_job);

    LinearLayoutManager layoutManager= new LinearLayoutManager(this);
    layoutManager.setReverseLayout(true);
    layoutManager.setStackFromEnd(true);
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(layoutManager);
}

    private void setSupportActionBar(Toolbar toolbar) {
    }

    public static class AllJobPostViewHolder extends RecyclerView.ViewHolder{
View myview;
     public AllJobPostViewHolder(@NonNull View itemView) {
         super(itemView);
         myview=itemView;
     }
     public void setJobTitle(String title) {
         TextView mTitle = myview.findViewById(R.id.all_job_post_title);
         mTitle.setText(title);
     }
     public void setJobDate(String date){
         TextView mDate = myview.findViewById(R.id.all_job_post_date);
         mDate.setText(date);

     }

     public void setJobDescription(String description){
         TextView mDescription = myview.findViewById(R.id.all_job_post_description);
         mDescription.setText(description);

     }

     public void setJobSkills(String skills){
         TextView mSkills=myview.findViewById(R.id.all_job_post_skills);
         mSkills.setText(skills);
     }

     public void setJobSalary(String salary){
         TextView mSalary= myview.findViewById(R.id.all_job_post_sallary);
         mSalary.setText(salary);
     }

 }

}

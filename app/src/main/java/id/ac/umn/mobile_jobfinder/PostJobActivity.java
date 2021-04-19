package id.ac.umn.mobile_jobfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

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


    /*
    //database
        mAuth=FirebaseAuth.getInstance();
        FirebaseUser mUser=mAuth.getCurrentUser();
        String uId=mUser.getUid();




*/
        //ini buat recycler viewnya
        recyclerView=findViewById(R.id.recycler_job_post_id);
        LinearLayoutManager



    }
}
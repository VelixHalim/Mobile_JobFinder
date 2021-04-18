package id.ac.umn.mobile_jobfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class InsertJobPostActivity extends AppCompatActivity {
    //variable toolbar
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    //end variabel toolbar

    //variabel post job
    EditText edtJobTitle, edtJobDesc, edtSkill, edtSalary;
    Button btnPost;
    //end variable post job
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_job_post);

        //toolbar
        //untuk menu start
        drawerLayout = findViewById(R.id.insert_job_Drawlayout);
        navigationView = findViewById(R.id.insert_nav_view);
        toolbar = (Toolbar) findViewById(R.id.insert_job_toolbar);

        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home :
                        Toast.makeText(getApplicationContext(),"Balik ke home",Toast.LENGTH_LONG).show();
                        Intent InsertJob_ke_Home = new Intent(InsertJobPostActivity.this, MainActivity.class);
                        startActivityForResult(InsertJob_ke_Home, 7);
                        finish();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.btnProfile :
                        Toast.makeText(getApplicationContext(),"Buat profile",Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.btnLogout :
                        Toast.makeText(getApplicationContext(),"Logout",Toast.LENGTH_LONG).show();
                        Intent InsertJob_ke_Logout = new Intent(InsertJobPostActivity.this, LoginActivity.class);
                        startActivityForResult(InsertJob_ke_Logout, 9);
                        finish();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }

                return true;
            }
        });
        //navigationView.setNavigationItemSelectedListener(this);
        // end
        //end toolbar


        //post job
        btnPost = findViewById(R.id.btnPost_Job);
        edtJobTitle = findViewById(R.id.edtJobTitle);
        edtJobDesc = findViewById(R.id.edtJobDesc);
        edtSkill = findViewById(R.id.edtSkill);
        edtSalary = findViewById(R.id.edtSalary);

    //error Message
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title=edtJobTitle.getText().toString().trim();
                String description=edtJobDesc.getText().toString().trim();
                String skills=edtSkill.getText().toString().trim();
                String salary=edtSalary.getText().toString().trim();

                if(TextUtils.isEmpty(title)){
                    edtJobTitle.setError("This Field is Required");
                    return;
                }

                if(TextUtils.isEmpty(description)){
                    edtJobDesc.setError("This Field is Required");
                    return;
                }
                if(TextUtils.isEmpty(skills)){
                    edtSkill.setError("This Field is Required");
                    return;
                }
                if(TextUtils.isEmpty(salary)){
                    edtSalary.setError("This Field is Required");
                    return;
                }



            }
        });
        //end post job
    }

   /* private void InsertJob(){

        edtJobTitle=findViewById(R.id.edtJobTitle);
        edtJobDesc=findViewById(R.id.edtJobDesc);
        edtSkill=findViewById(R.id.edtSkill);
        edtSalary=findViewById(R.id.edtSalary);

        btnPost=findViewById(R.id.btnPost_Job);

    }

 */



    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
}
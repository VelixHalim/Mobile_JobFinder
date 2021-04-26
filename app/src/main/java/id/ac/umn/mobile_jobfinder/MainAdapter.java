//package id.ac.umn.mobile_jobfinder;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.google.firebase.FirebaseOptions;
//
//import id.ac.umn.mobile_jobfinder.Model.Data;
//
//public class MainAdapter extends FirebaseOptions<Data> {
//    public MainAdapter(
//            @NonNull FirebaseOptions<Data> options)
//    {
//        super(options);
//    }
//
//    @Override
//    protected void
//    onBindViewHolder(@NonNull PostJobActivity.MyViewHolder holder, int position, @NonNull Data model)
//    {
//        holder.setJobTitle(model.getTitle());
//        holder.setJobDate(model.getDate());
//        holder.setJobDesc(model.getDescription());
//        holder.setJobDate(model.getDate());
//        holder.setJobSkills(model.getSkills());
//        holder.setJobSalary(model.getSalary());
//    }
//    @NonNull
//    public Builder
//    onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
//    {
//
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_post_job, parent, false);
//        return new FirebaseOptions.MyViewHolder(view);
//    }
//
//
//}
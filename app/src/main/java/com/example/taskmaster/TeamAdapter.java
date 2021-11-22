package com.example.taskmaster;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amplifyframework.datastore.generated.model.Taskmaster;
import com.amplifyframework.datastore.generated.model.Team;
import com.example.taskmaster.Entity.TaskEntity;

import java.util.ArrayList;
import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamHolder> {
    List<Team> allTasksData2 = new ArrayList<>();
    Context c;

    public  TeamAdapter (List<Team> allTasksData2) {
        this.allTasksData2 = allTasksData2;
    }
    public class TeamHolder extends RecyclerView.ViewHolder {

        public Team task;
        View itemView;
        public TeamHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("my Adapter", "Element " + allTasksData2.get(getAdapterPosition()).getName()+ " clicked");
                    Intent goToDetailsPage = new Intent(view.getContext(), Teams.class);
                    goToDetailsPage.putExtra("body",allTasksData2.get(getAdapterPosition()).getName());


                    view.getContext().startActivity(goToDetailsPage);
                }
            });

        }
    }

    @NonNull
    @Override
    public TeamAdapter.TeamHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_team, parent , false);
        return  new TeamHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamHolder holder, int position) {
        holder.task=allTasksData2.get(position);
        TextView name = holder.itemView.findViewById(R.id.teamName);
        name.setText(holder.task.getName());
    }

    @Override
    public int getItemCount() {
        return allTasksData2.size();    }

    public void setTaskOGList(List<Team> allTasksData2) {
        this.allTasksData2 = allTasksData2;
    }
}
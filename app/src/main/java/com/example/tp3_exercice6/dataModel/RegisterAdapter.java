package com.example.tp3_exercice6.dataModel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp3_exercice6.R;

import java.util.ArrayList;
import java.util.List;

public class RegisterAdapter extends RecyclerView.Adapter<RegisterAdapter.NoteHolder> {
    private List<Registration> notes = new ArrayList<>();
    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.profil_activity, parent, false);
        return new NoteHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Registration registration = notes.get(position);
        holder.nom.setText(registration.getNom());
        holder.prenom.setText(registration.getPrenom());
        holder.age.setText(String.valueOf(registration.getAge()));
    }
    @Override
    public int getItemCount() {
        return notes.size();
    }
    public void setNotes(List<Registration> registrations) {
        this.notes = registrations;
        notifyDataSetChanged();
    }
    class NoteHolder extends RecyclerView.ViewHolder {
        private TextView nom;
        private TextView prenom;
        private TextView age;
        public NoteHolder(View itemView) {
            super(itemView);
            nom = itemView.findViewById(R.id.text_view_title);
            prenom = itemView.findViewById(R.id.text_view_description);
            age = itemView.findViewById(R.id.text_view_priority);
        }
    }
}
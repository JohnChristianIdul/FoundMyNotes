package com.example.foundmynotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RemindersAdapter extends RecyclerView.Adapter<RemindersAdapter.ReminderViewHolder> {

    private Context context;
    private List<Reminder> reminderList;

    public RemindersAdapter(Context context, List<Reminder> reminderList) {
        this.context = context;
        this.reminderList = reminderList;
    }

    @NonNull
    @Override
    public ReminderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.reminder_item, parent, false);
        return new ReminderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReminderViewHolder holder, int position) {
        Reminder reminder = reminderList.get(position);

        holder.textViewTitle.setText(reminder.getTitle());
        holder.textViewDescription.setText(reminder.getDescription());
        holder.textViewDate.setText(reminder.getDate());
        holder.textViewTime.setText(reminder.getTime());
    }

    @Override
    public int getItemCount() {
        return reminderList.size();
    }

    public static class ReminderViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;
        TextView textViewDescription;
        TextView textViewDate;
        TextView textViewTime;

        public ReminderViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.reminder_title_bar);
            textViewDescription = itemView.findViewById(R.id.description);
            textViewDate = itemView.findViewById(R.id.mtrl_picker_text_input_date);
            textViewTime = itemView.findViewById(R.id.time);
        }
    }
}

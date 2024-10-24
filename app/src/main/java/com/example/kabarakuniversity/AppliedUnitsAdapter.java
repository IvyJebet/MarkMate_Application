package com.example.kabarakuniversity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kabarakuniversity.model.MissingMarks;

import java.util.ArrayList;

public class AppliedUnitsAdapter extends RecyclerView.Adapter<AppliedUnitsAdapter.ViewHolder> {

    private final ArrayList<MissingMarks> marks;
    Context context;
    static OnUnitClicked onUnitClicked;

    public AppliedUnitsAdapter(ArrayList<MissingMarks> marks, Context context, OnUnitClicked onMessageClicked) {
        this.marks = marks;
        this.context = context;
        AppliedUnitsAdapter.onUnitClicked = onMessageClicked;
    }

    interface OnUnitClicked {
        void onUnitClicked(int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.applied_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textView1.setText(marks.get(position).getUnitName());
        holder.textView2.setText(marks.get(position).getUnitCode());
        holder.textView3.setText(marks.get(position).getLecturerName());
        holder.textView4.setText(marks.get(position).getStage());
        holder.textView5.setText(marks.get(position).getStudentName());
        holder.textView6.setText(marks.get(position).getRegNo());

        holder.itemView.setOnClickListener(view -> {
            onUnitClicked.onUnitClicked(position);
        });


    }
    @Override
    public int getItemCount() {
        return marks.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1, textView2, textView3, textView4, textView5, textView6;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onUnitClicked.onUnitClicked(getAdapterPosition());

                }
            });
            textView1 = itemView.findViewById(R.id.line_a);
            textView2 = itemView.findViewById(R.id.line_b);
            textView3 = itemView.findViewById(R.id.line_c);
            textView4 = itemView.findViewById(R.id.line_d);
            textView5 = itemView.findViewById(R.id.line_e);
            textView6 = itemView.findViewById(R.id.line_f);
        }
    }

}



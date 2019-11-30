package com.abylay.hackathonproject.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.abylay.hackathonproject.R;
import com.abylay.hackathonproject.models.MainModel;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private List<MainModel> list;
    private MainListener listener;

    public MainAdapter(List<MainModel> list, MainListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        MainModel model = list.get(position);
        holder.itemName.setText(model.getName());
        holder.img.setImageResource(model.getResource());
        listener.setItemSize(holder.itemView);
        holder.itemView.setOnClickListener(v -> {listener.onItemClicked(position);});
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView itemName;

        MainViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.itemImg);
            itemName = itemView.findViewById(R.id.itemName);
        }
    }

    public interface MainListener {
        void onItemClicked(int position);
        void setItemSize(View itemView);
    }
}

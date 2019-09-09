package com.example.infinitybike;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<ListStatus> mData;
    Button btnStatus;

    public RecyclerViewAdapter(Context mContext, List<ListStatus> mData){
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        LayoutInflater mInflate = LayoutInflater.from(mContext);
        view = mInflate.inflate(R.layout.card_view_status,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.ordem.setText(mData.get(position).getOs());
        holder.data.setText(mData.get(position).getData());

//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(mContext,Status_Activity.class);
//
//                intent.putExtra("ordem",mData.get(position).getOs());
//                intent.putExtra("data",mData.get(position).getData());
//                intent.putExtra("rating",mData.get(position).getRatingbar());
//                mContext.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
//            }
//        });

        holder.btnStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,Status_Activity.class);
                mContext.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView ordem,data;
        CardView cardView;
        RatingBar ratingBar;
        Button btnStatus;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ordem = (TextView)itemView.findViewById(R.id.lblCardRecNumPed);
            data = (TextView)itemView.findViewById(R.id.lblCardRecDataPed);
            cardView = (CardView)itemView.findViewById(R.id.idCardViewStatus);
            ratingBar = (RatingBar)itemView.findViewById(R.id.idRatingbar);
            btnStatus = (Button)itemView.findViewById(R.id.btnStatus);

        }
    }
}

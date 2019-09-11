package com.example.infinitybike;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyviewHolder> {

    private Context mContext;
    private List<ListMenu> mData;

    public MenuAdapter(Context mContext,List<ListMenu> mData){
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;

        LayoutInflater mInflate = LayoutInflater.from(mContext);
        view = mInflate.inflate(R.layout.card_view_menu,parent,false);

        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        holder.titulo.setText(mData.get(position).getTitulo());
        holder.noticia.setText(mData.get(position).getNoticia());
        holder.data.setText(mData.get(position).getData());
        holder.imagem.setImageResource(mData.get(position).getImagem());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder{

        TextView titulo,noticia,data;
        ImageView imagem;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = (TextView)itemView.findViewById(R.id.txtTituloCard);
            noticia = (TextView)itemView.findViewById(R.id.txtNoticiaCard);
            data = (TextView)itemView.findViewById(R.id.txtRecDataCard);
            imagem = (ImageView) itemView.findViewById(R.id.imgCardMenu);
        }
    }
}

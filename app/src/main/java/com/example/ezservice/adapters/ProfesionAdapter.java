package com.example.ezservice.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.request.RequestOptions;
import com.example.ezservice.R;
import com.example.ezservice.TarjetasProfesiones;
import com.example.ezservice.models.Categoria;
import com.example.ezservice.models.Profesion;


import java.text.DecimalFormat;
import java.util.List;

public class ProfesionAdapter extends RecyclerView.Adapter<ProfesionAdapter.MyViewHolder>{
    private List<Profesion> models;
    private LayoutInflater layoutInflater;
    private Context context;
    private RequestOptions option;
    DecimalFormat format1 = new DecimalFormat("#.##");

    public ProfesionAdapter(List<Profesion> models, Context context){
        this.models = models;
        this.context = context;

        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }

    @Override
    public ProfesionAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {

        View view;
        view = View.inflate(context, R.layout.activity_tarjetas_profesiones, null);


        final ProfesionAdapter.MyViewHolder viewHolder = new ProfesionAdapter.MyViewHolder(view);
        viewHolder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, TarjetasProfesiones.class);
                i.putExtra("profesion", models.get(viewHolder.getAdapterPosition()).getNombre());
                context.startActivity(i);

            }
        });


        return viewHolder;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout container;
        TextView nombre;

        public MyViewHolder(View itemView) {
            super(itemView);

            container=itemView.findViewById(R.id.Prof_container);
            nombre=itemView.findViewById(R.id.Prof_Nombre);

        }

    }

    @Override
    public void onBindViewHolder(@NonNull ProfesionAdapter.MyViewHolder holder, int position) {
        holder.nombre.setText(models.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

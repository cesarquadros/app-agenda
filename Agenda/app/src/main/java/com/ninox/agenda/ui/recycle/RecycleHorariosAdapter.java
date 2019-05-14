package com.ninox.agenda.ui.recycle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ninox.agenda.R;
import com.ninox.agenda.model.Horario;

import java.util.List;

public class RecycleHorariosAdapter extends RecyclerView.Adapter<RecycleHorariosAdapter.HorarioViewHolder> {

    private final List<Horario> horarios;
    private final Context context;

    public RecycleHorariosAdapter(List<Horario> horarios, Context context) {
        this.horarios = horarios;
        this.context = context;
    }


    @Override
    public HorarioViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View viewCriada = LayoutInflater.from(this.context).inflate(R.layout.item_horario, viewGroup, false);
        HorarioViewHolder hvh = new HorarioViewHolder(viewCriada);
        return hvh;
    }

    @Override
    public void onBindViewHolder(HorarioViewHolder horarioViewholder, int position) {
        Horario h = horarios.get(position);
        horarioViewholder.vincula(h);
    }

    @Override
    public int getItemCount() {
        return horarios.size();
    }

    class HorarioViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewHorario;
        private Horario horario;

        public HorarioViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textViewHorario = itemView.findViewById(R.id.horario_hora);
        }

        public void vincula(Horario horario){
            this.horario = horario;
            preencheCampo(horario);
        }

        public void preencheCampo(Horario horario){
            this.textViewHorario.setText(horario.getHora());
        }
    }
}

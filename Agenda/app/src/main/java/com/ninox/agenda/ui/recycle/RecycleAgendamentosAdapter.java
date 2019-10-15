package com.ninox.agenda.ui.recycle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ninox.agenda.R;
import com.ninox.agenda.model.Agendamento;
import com.ninox.agenda.ui.onclicklistner.OnItemAgendamentoClickListner;

import java.util.List;

public class RecycleAgendamentosAdapter extends RecyclerView.Adapter<RecycleAgendamentosAdapter.AgendamentoViewHolder>{

    private final List<Agendamento> agendamentos;
    private final Context context;
    OnItemAgendamentoClickListner onItemAgendamentoClickListner;

    public RecycleAgendamentosAdapter(List<Agendamento> agendamentos, Context context) {
        this.agendamentos = agendamentos;
        this.context = context;
    }

    public void setOnItemAgendamentoClickListener(OnItemAgendamentoClickListner onItemAgendamentoClickListner){
        this.onItemAgendamentoClickListner = onItemAgendamentoClickListner;
    }

    @Override
    public int getItemCount() {
        return agendamentos.size();
    }

    @Override
    public AgendamentoViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View viewCriada = LayoutInflater.from(this.context).inflate(R.layout.item_agendamento, viewGroup, false);
        AgendamentoViewHolder avh = new AgendamentoViewHolder(viewCriada);
        return avh;
    }

    @Override
    public void onBindViewHolder( AgendamentoViewHolder holder, int position) {
        Agendamento a = agendamentos.get(position);
        holder.vincula(a);
    }

    class AgendamentoViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        private TextView salaAgendamento;
        private TextView dataAgendamento;
        private Agendamento agendamento;

        public AgendamentoViewHolder( View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cardView);
            this.dataAgendamento = itemView.findViewById(R.id.data_agendamento);
            this.salaAgendamento  = itemView.findViewById(R.id.sala_agendamento);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemAgendamentoClickListner.onItemClick(agendamento, getAdapterPosition());
                }
            });
        }

        public void vincula(Agendamento agendamento){
            this.agendamento = agendamento;
            preencheCampo(agendamento);
        }

        private void preencheCampo(Agendamento agendamento){
            this.salaAgendamento.setText(agendamento.getSala().getNome());
            this.dataAgendamento.setText(agendamento.getDataAgendamento().toString());
        }
    }

}

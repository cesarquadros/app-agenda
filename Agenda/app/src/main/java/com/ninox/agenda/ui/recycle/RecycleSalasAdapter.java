package com.ninox.agenda.ui.recycle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ninox.agenda.R;
import com.ninox.agenda.model.Sala;
import com.ninox.agenda.ui.onclicklistner.OnItemSalaClickListener;

import java.util.List;

public class RecycleSalasAdapter extends RecyclerView.Adapter<RecycleSalasAdapter.SalaViewHolder> {

    private final List<Sala> salas;
    private final Context context;
    OnItemSalaClickListener onItemSalaClickListener;

    public RecycleSalasAdapter(List<Sala> salas, Context context){
        this.salas = salas;
        this.context = context;
    }

    public void setOnItemSalaClickListener(OnItemSalaClickListener onItemSalaClickListener){
        this.onItemSalaClickListener = onItemSalaClickListener;
    }

    @Override
    public int getItemCount() {
        return salas.size();
    }

    @Override
    public SalaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View viewCriada = LayoutInflater.from(this.context).inflate(R.layout.item_sala, viewGroup, false);
        SalaViewHolder svh = new SalaViewHolder(viewCriada);
        return svh;
    }

    @Override
    public void onBindViewHolder(RecycleSalasAdapter.SalaViewHolder salaViewHolder, int i) {
        Sala s = salas.get(i);
        salaViewHolder.vincula(s);
    }

/*    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }*/

    class SalaViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        private TextView salaNome;
        private TextView descricao;
        private Sala sala;

        public SalaViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cardView);
            this.salaNome = itemView.findViewById(R.id.sala_nome);
            this.descricao = itemView.findViewById(R.id.sala_descricao);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemSalaClickListener.onItemClick(sala, getAdapterPosition());
                }
            });
        }

        public void vincula(Sala sala){
            this.sala = sala;
            preencheCampo(sala);
        }

        private void preencheCampo(Sala sala){
            this.salaNome.setText(sala.getNome());
            this.descricao.setText(sala.getDescricao());
        }
    }
}

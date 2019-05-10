package model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ninox.agenda.R;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.SalaViewHolder> {

    private List<Sala> salas;
    private Context context;

    public RVAdapter(List<Sala> salas, Context context){
        this.salas = salas;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return salas.size();
    }

    @Override
    public SalaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ricycle_view_salas, viewGroup, false);
        SalaViewHolder pvh = new SalaViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(SalaViewHolder salaViewHolder, int i) {
        salaViewHolder.salaNome.setText(salas.get(i).getNome());
        salaViewHolder.descricao.setText(salas.get(i).getDescricao());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class SalaViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView salaNome;
        TextView descricao;

        SalaViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            this.salaNome = itemView.findViewById(R.id.sala_nome);
            this.descricao = itemView.findViewById(R.id.sala_descricao);
        }
    }
}

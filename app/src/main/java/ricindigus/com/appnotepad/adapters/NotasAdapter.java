package ricindigus.com.appnotepad.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ricindigus.com.appnotepad.R;
import ricindigus.com.appnotepad.pojos.Nota;


public class NotasAdapter extends RecyclerView.Adapter<NotasAdapter.ViewHolder>{
    private Context contexto;
    private ArrayList<Nota> notas;

    public NotasAdapter(Context contexto, ArrayList<Nota> notas) {
        this.contexto = contexto;
        this.notas = notas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nota_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.id.setText(String.valueOf(notas.get(position).getId()));
        holder.titulo.setText(notas.get(position).getTitulo());
        holder.cuerpo.setText(notas.get(position).getCuerpo());
        holder.imgBasura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notas.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return notas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView id, titulo, cuerpo;
        ImageView imgBasura;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.cardview_nota);
            id = (TextView)itemView.findViewById(R.id.id);
            titulo = (TextView)itemView.findViewById(R.id.titulo);
            cuerpo = (TextView)itemView.findViewById(R.id.cuerpo);
            imgBasura = (ImageView)itemView.findViewById(R.id.img_trash);
        }
    }
}

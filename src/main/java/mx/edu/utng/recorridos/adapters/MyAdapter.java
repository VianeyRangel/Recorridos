package mx.edu.utng.recorridos.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import mx.edu.utng.recorridos.R;
import mx.edu.utng.recorridos.models.Museum;

/**
 * Created by Toshiba on 15/02/2018.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Museum> museums;
    private int layout;
    private OnItemClickListener itemClickListener;

    private Context context;


    public MyAdapter(List<Museum> movies, int layout, OnItemClickListener listener) {
        this.museums = museums;
        this.layout = layout;
        this.itemClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflamos el layout y se lo pasamos al constructor del ViewHolder, donde manejaremos
        // toda la lógica como extraer los datos, referencias...
        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        context = parent.getContext();
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Llamamos al método Bind del ViewHolder pasándole objeto y listener
        holder.bind(museums.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return museums.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Elementos UI a rellenar
        public TextView textViewName;
        public ImageView imageViewPaint;

        public ViewHolder(View itemView) {
         
            super(itemView);
            textViewName = (TextView) itemView.findViewById(R.id.textViewTitle);
            imageViewPaint = (ImageView) itemView.findViewById(R.id.imageViewPoster);
        }

        public void bind(final Museum museum, final OnItemClickListener listener) {
            // Procesamos los datos a renderizar
            textViewName.setText(museum.getName());
            Picasso.with(context).load(museum.getImage()).fit().into(imageViewPaint);
            
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(museum, getAdapterPosition());
                }
            });
        }
    }

    // Declaramos nuestra interfaz con el/los método/s a implementar
    public interface OnItemClickListener {
        void onItemClick(Museum museum, int position);
    }
}

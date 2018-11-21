package pe.edu.upc.pc1asandoval.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.edu.upc.pc1asandoval.BioActivity;
import pe.edu.upc.pc1asandoval.R;
import pe.edu.upc.pc1asandoval.model.Customer;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerHolder> {

    private List<Customer> items;

    public CustomerAdapter(List<Customer> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CustomerAdapter.CustomerHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.customer_card, viewGroup, false);
        return new CustomerHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerAdapter.CustomerHolder customerHolder, final int i) {
        customerHolder.imgFoto.setImageResource(items.get(i).getIdphoto());
        customerHolder.lblNombre.setText(items.get(i).getNombre());
        customerHolder.lblTproducto.setText("Producto: " + items.get(i).getIdProducto());


        customerHolder.personCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("pId", items.get(i).getId());
                bundle.putInt("pImgFoto", items.get(i).getIdphoto());
                bundle.putString("pProducto", items.get(i).getIdProducto());
                bundle.putString("pNombre", items.get(i).getNombre());
                bundle.putString("pDni", items.get(i).getDni());
                bundle.putString("pFecha", items.get(i).getDate());
                bundle.putString("pBioigrafia", items.get(i).getBiografia());
                Intent bio = new Intent(v.getContext(), BioActivity.class);
                bio.putExtras(bundle);
                v.getContext().startActivity(bio);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class CustomerHolder extends RecyclerView.ViewHolder {

        public CardView personCardView;
        public ImageView imgFoto;
        public TextView lblNombre;
        public TextView lblTproducto;

        public CustomerHolder(@NonNull View itemView) {
            super(itemView);
            personCardView = (CardView)itemView.findViewById(R.id.customerCardView);
            imgFoto = (ImageView)itemView.findViewById(R.id.imgFoto);
            lblNombre = (TextView)itemView.findViewById(R.id.lblNombre);
            lblTproducto = (TextView)itemView.findViewById(R.id.lblTproducto);
        }
    }
}

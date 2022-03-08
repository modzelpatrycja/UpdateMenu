package com.example.updatemenu;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListaAdapter extends RecyclerView.Adapter<ListaAdapter.ListaViewHolder> {
    ArrayList<MPozycjaMenu> ListaDan;
    private Context context;

    public ListaAdapter(ArrayList<MPozycjaMenu>  ListaDan) {
        this.ListaDan = ListaDan;
    }

    public ListaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View dayView = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu, parent, false);
        ListaViewHolder viewH = new ListaViewHolder(dayView);
        context = parent.getContext();
        return viewH;
    }

    @Override
    public void onBindViewHolder(ListaViewHolder holder, final int position) {
        holder.MPozycjaMenuName.setText(ListaDan.get(position).getNazwa());


        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setTitle("Potwierdzenie usunięcia dania");
                alertDialogBuilder.setMessage("Czy na pewno chcesz usunąć danie?");
                alertDialogBuilder.setCancelable(false);
                alertDialogBuilder.setPositiveButton("Tak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        CListaDan cLista = new CListaDan();
                        ListaDan =  cLista.wybierzPozycjeDoZmiany(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, getItemCount() - position);
                        VKomunikatPowodzenia vkomP = new VKomunikatPowodzenia();
                        vkomP.wyswietlKomunikatPowodzenia(context);
                    }
                });
                alertDialogBuilder.setNegativeButton("Nie", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        VKomunikatNiepowodzenia vkomP = new VKomunikatNiepowodzenia();
                        vkomP.wyswietlKomunikatNiepowodzenia(context);
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return ListaDan.size();
    }

    public class ListaViewHolder extends RecyclerView.ViewHolder {
        TextView MPozycjaMenuName;
        Button deleteButton;

        public ListaViewHolder(View view) {
            super(view);
            MPozycjaMenuName = view.findViewById(R.id.nazwa_dania);
            deleteButton = itemView.findViewById(R.id.usun_danie);
            }
        }
    }

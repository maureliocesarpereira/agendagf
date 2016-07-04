package com.senac.maurelio.agendagf.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.senac.maurelio.agendagf.model.Agenda;

import java.util.List;

/**
 * Created by home on 01/07/2016.
 */

public class AdapterListaPrincipal extends BaseAdapter{

    private LayoutInflater inflater;
    private List<Agenda> agendas;

    public AdapterListaPrincipal(Context context, List<Agenda> agendas){

        //Itens para a lista
        this.agendas = agendas;
        //Pegar o layout da agenda
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return agendas.size();
    }

    @Override
    public Object getItem(int position) {
        return agendas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        //Resgatar agenda do listView pelo position
        Agenda agenda = agendas.get(position);

        //Resgatar o layout a ser preenchido
        view = inflater.inflate(R.layout.agenda, null);

        //Resgatar elementos para inserção de conteúdo
        TextView textViewTextoAgenda = (TextView) view.findViewById(R.id.textoAgenda);
        textViewTextoAgenda.setText(agenda.getAgenda_titulo());

        ImageView imageViewAgenda = (ImageView) view.findViewById(R.id.imagemAgenda);
        imageViewAgenda.setImageResource(agenda.getImageResId());
        /*ImageView imageViewAgenda = (ImageView) view.findViewById(R.id.imagemAgenda);
        imageViewAgenda.setImageDrawable(agenda.getDrawable());*/

        return view;
    }
}

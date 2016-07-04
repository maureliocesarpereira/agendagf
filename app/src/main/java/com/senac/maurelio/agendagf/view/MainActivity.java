package com.senac.maurelio.agendagf.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.senac.maurelio.agendagf.controller.ListaDeAgendas;
import com.senac.maurelio.agendagf.model.Agenda;
import com.senac.maurelio.agendagf.model.Categoria;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    //Data
    private DatePicker datePickerDataAgenda;

    //Categorias
    private Spinner spinnerCategorias;
    private Categoria categoria;
    private ArrayAdapter<Categoria> adapterCategorias;

    //Lista de Agendas
    private ListView listViewAgendas;
    private AdapterListaPrincipal adapterListaPrincipal;
    private Agenda agenda;

    private ListaDeAgendas lista;
    private ArrayList<Agenda> arrayListAgenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DATAPIKER
        datePickerDataAgenda = (DatePicker) findViewById(R.id.datePicker);

        //SPINNER
        spinnerCategorias = (Spinner) findViewById(R.id.spinnerCategorias);
        categoria = new Categoria();
        this.adapterCategorias = new ArrayAdapter<Categoria>(this, android.R.layout.simple_spinner_dropdown_item, categoria.pegarArrayCategorias());
        spinnerCategorias.setAdapter(adapterCategorias);

        //criar objeto com json

/*        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://localhost/index2.php", new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                JSONArray jsonArray = new JSONArray(response);
                ArrayList<Agenda> agendas = new ArrayList<Agenda>(response);
                Gson gson = new Gson();
                listaDeAgendas = gson.fromJson(s, ListaDeAgendas.class);
                Toast.makeText(MainActivity.this, listaDeAgendas.toString(), Toast.LENGTH_SHORT).show();
            }
        });*/
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://api.myjson.com/bins/1cs3x", new  AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                //Converte responseBody to string
                String s = new String(responseBody);

                Gson gson = new Gson();
                ListaDeAgendas lista = gson.fromJson(s, ListaDeAgendas.class);

                //LISTVIEW
                listViewAgendas = (ListView) findViewById(R.id.listViewCustomizado);
                adapterListaPrincipal = new AdapterListaPrincipal(MainActivity.this, lista.getAgendas());
                //adapterListaPrincipal = new AdapterListaPrincipal(this, arrayListAgenda);
                //adapterListaPrincipal = new AdapterListaPrincipal(this, this.pegarArrayAgenda());
                listViewAgendas.setAdapter(adapterListaPrincipal);



                //List<Agenda> agendas = new ArrayList<Agenda>();
                //arrayListAgenda = new ArrayList<Agenda>();
                //ListaDeAgendas listaDeAgendas = new ListaDeAgendas();

                //Converte string em Json Array

                /*try {
                    JSONArray jsonArray = new JSONArray(s);
                    JSONObject agendaJson;

                    //itera para pegar objetos do Json Array
                    for (int i = 0; i < jsonArray.length(); i++){
                        agendaJson = new JSONObject(jsonArray.getString(i));
                        Agenda agenda = new Agenda(agendaJson.getString("id_agenda"), agendaJson.getString("agenda_titulo"));
                        arrayListAgenda.add(agenda);
                    }

                } catch (JSONException e) {
                    Log.e("Erro", "Erro ao pegar o JSON", e);
                }
                listaDeAgendas.setAgendas(arrayListAgenda);*/
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            }
        });


    }

    public ArrayList<Agenda> pegarArrayAgenda(){
        arrayListAgenda = new ArrayList<>();
        categoria = new Categoria("FESTA");
        Agenda agenda1 = new Agenda("Festa da Pipoca", categoria.getNome(), R.drawable.foto);
        Agenda agenda2 = new Agenda("Show do Camarão", categoria.getNome(), R.drawable.foto);
        arrayListAgenda.add(agenda1);
        arrayListAgenda.add(agenda2);
        return arrayListAgenda;
    }




}

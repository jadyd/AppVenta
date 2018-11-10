package com.example.jose.juan.evaluacion2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Registrar_Venta extends AppCompatActivity {

    ArrayList<Producto> listaProductos= new ArrayList<>();
    ArrayList<Cliente> listaClientes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar__venta);

        EditText idVenta = (EditText) findViewById(R.id.txtIdVenta);
        final Spinner sprProducto = (Spinner) findViewById(R.id.sprProducto);
        final Spinner sprCliente = (Spinner) findViewById(R.id.sprCliente);
        Button btnAgregarProducto = (Button) findViewById(R.id.btnAgregarProducto);
        Button btnGuardarVenta =(Button) findViewById(R.id.btnGuardarVenta);


        final TextView txvIdProducto = (TextView) findViewById(R.id.txvIdProducto);
        final TextView txvNombreProducto = (TextView) findViewById(R.id.txvNombreProducto);
        final TextView txvPrecioProducto = (TextView) findViewById(R.id.txvPrecioProducto);

        final TextView txvRutCliente = (TextView) findViewById(R.id.txvRutCliente);
        final TextView txvNombreCliente = (TextView) findViewById(R.id.txvNombreCliente);
        final TextView txvApellidoCliente = (TextView) findViewById(R.id.txvApellidoCliente);


        ArrayList<String> nombreProductos = new ArrayList<>();
        ArrayList<String> nombreClientes = new ArrayList<>();



        if(getIntent().getSerializableExtra("lp")!=null){
            listaProductos = (ArrayList<Producto>)getIntent().getSerializableExtra("lp");

            for (int i = 0; i < listaProductos.size(); i++){
                nombreProductos.add(listaProductos.get(i).getNombre());
            }

        }else if(getIntent().getSerializableExtra("lp")==null){
            nombreProductos.add("Registro Vacio");
        }




        if(getIntent().getSerializableExtra("lc")!=null){
            listaClientes = (ArrayList<Cliente>)getIntent().getSerializableExtra("lc");

            for (int i = 0; i < listaClientes.size(); i++){
                nombreClientes.add(listaClientes.get(i).getRutCliente());
            }

        }else if(getIntent().getSerializableExtra("lc")==null){
            nombreClientes.add("Registro Vacio");
        }



        ArrayAdapter<CharSequence> adapterProducto = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, nombreProductos);

        ArrayAdapter<CharSequence> adapterCliente = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, nombreClientes);


        sprProducto.setAdapter(adapterProducto);
        sprCliente.setAdapter(adapterCliente);



        sprProducto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(listaProductos.size()>0){
                    String nombreRevisarProducto = sprProducto.getItemAtPosition(position).toString();

                    for(int i = 0;i < listaProductos.size();i++ ){
                        if(nombreRevisarProducto.equals(listaProductos.get(i).getNombre())){
                            txvIdProducto.setText(""+listaProductos.get(i).getId());
                            txvNombreProducto.setText(listaProductos.get(i).getNombre());
                            txvPrecioProducto.setText(""+listaProductos.get(i).getPrecio());
                        }
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sprCliente.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (listaClientes.size()>0) {
                    String nombreRevisarCliente = sprCliente.getItemAtPosition(position).toString();

                    for(int i = 0;i < listaClientes.size();i++ ){

                        if(nombreRevisarCliente.equals(listaClientes.get(i).getRutCliente())){

                            txvRutCliente.setText(listaClientes.get(i).getRutCliente());
                            txvNombreCliente.setText(listaClientes.get(i).getNombreCliente());
                            txvApellidoCliente.setText(listaClientes.get(i).getApellidoCliente());

                        }
                    }

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}

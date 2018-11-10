package com.example.jose.juan.evaluacion2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Producto> listaProductosMain = new ArrayList<>();
    ArrayList<Cliente> listaClientesMain = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnR_producto = (Button) findViewById(R.id.btnR_producto);
        Button btnR_cliente = (Button) findViewById(R.id.btnR_cliente);
        Button btnR_venta = (Button) findViewById(R.id.btnR_venta);

        if(getIntent().getSerializableExtra("lp")!=null) {
            listaProductosMain = (ArrayList<Producto>) getIntent().getSerializableExtra("lp");
        }

        if(getIntent().getSerializableExtra("lc")!=null){
            listaClientesMain = (ArrayList<Cliente>)getIntent().getSerializableExtra("lc");
        }

        btnR_producto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Registrar_Producto.class);

                if (getIntent().getSerializableExtra("lp")!=null) {
                    i.putExtra("lp",listaProductosMain);
                }

                startActivity(i);
            }
        });

        btnR_cliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Registrar_Cliente.class);
                if (getIntent().getSerializableExtra("lc")!=null) {
                    i.putExtra("lc",listaClientesMain);
                }
                startActivity(i);
            }
        });

        btnR_venta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Registrar_Venta.class);

                if (getIntent().getSerializableExtra("lp")!=null) {
                    i.putExtra("lp",listaProductosMain);
                }

                if (getIntent().getSerializableExtra("lc")!=null) {
                    i.putExtra("lc",listaClientesMain);
                }

                startActivity(i);
            }
        });
    }
}

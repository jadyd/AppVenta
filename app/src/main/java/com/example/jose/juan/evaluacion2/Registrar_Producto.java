package com.example.jose.juan.evaluacion2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Registrar_Producto extends AppCompatActivity {

    ArrayList <Producto> listaProductos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar__producto);

        final EditText txtIdProducto = (EditText) findViewById(R.id.txtIdProducto);
        final EditText txtNombreProducto = (EditText) findViewById(R.id.txtNombreProducto);
        final EditText txtPrecioProducto = (EditText) findViewById(R.id.txtPrecioProducto);
        Button btnRegistrarp = (Button) findViewById(R.id.btnRegistarP);
        Button btnCancelarP = (Button) findViewById(R.id.btnCancelarP);

        if(getIntent().getSerializableExtra("lp")!=null){
            listaProductos = (ArrayList<Producto>)getIntent().getSerializableExtra("lp");
        }else{
            listaProductos=new ArrayList<>();
        }

        btnRegistrarp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtIdProducto.getText().toString().equals("")){
                    Toast.makeText(Registrar_Producto.this,"Complete el id", Toast.LENGTH_SHORT).show();
                } else{
                    if(txtNombreProducto.getText().toString().equals("")){
                        Toast.makeText(Registrar_Producto.this,"Complete el nombre", Toast.LENGTH_SHORT).show();
                    }else{
                        if(txtPrecioProducto.getText().toString().equals("")){
                            Toast.makeText(Registrar_Producto.this,"Complete el precio", Toast.LENGTH_SHORT).show();
                        }else{

                            Producto p = new Producto();
                            p.setId(Integer.parseInt(txtIdProducto.getText().toString()));
                            p.setNombre(txtNombreProducto.getText().toString());
                            p.setPrecio(Integer.parseInt(txtPrecioProducto.getText().toString()));
                            listaProductos.add(p);

                            Toast.makeText(Registrar_Producto.this,"Producto Regitrado", Toast.LENGTH_SHORT).show();

                            Intent i = new Intent(getApplicationContext(), MainActivity.class);
                            i.putExtra("lp", listaProductos);
                            startActivity(i);
                        }
                    }
                }
            }
        });

        btnCancelarP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}

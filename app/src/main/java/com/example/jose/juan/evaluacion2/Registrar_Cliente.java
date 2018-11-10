package com.example.jose.juan.evaluacion2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Registrar_Cliente extends AppCompatActivity {

    ArrayList<Cliente> listaClientes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar__cliente);

        final EditText txtRut = (EditText) findViewById(R.id.txtRutClienteR);
        final EditText txtNombreCliente = (EditText) findViewById(R.id.txtNombreClienteR);
        final EditText txtApellido = (EditText) findViewById(R.id.txtApellidoClienteR);

        Button btnRegistrarCliente = (Button) findViewById(R.id.btnRegistrarCliente);
        Button btnCancelarCliente = (Button) findViewById(R.id.btnCancelarCliente);

        if(getIntent().getSerializableExtra("lc")!=null){
            listaClientes = (ArrayList<Cliente>)getIntent().getSerializableExtra("lc");
        }else{
            listaClientes = new ArrayList<>();
        }

        btnRegistrarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtRut.getText().toString().equals("")) {
                    Toast.makeText(Registrar_Cliente.this,"Complete el rut", Toast.LENGTH_SHORT).show();
                }else{
                    if(txtNombreCliente.getText().toString().equals("")){
                        Toast.makeText(Registrar_Cliente.this,"Complete el nombre", Toast.LENGTH_SHORT).show();
                    }else{
                        if(txtApellido.getText().toString().equals("")){
                            Toast.makeText(Registrar_Cliente.this,"Complete el apellido", Toast.LENGTH_SHORT).show();
                        }else{
                            Cliente c = new Cliente();
                            c.setRutCliente(txtRut.getText().toString());
                            c.setNombreCliente(txtNombreCliente.getText().toString());
                            c.setApellidoCliente(txtApellido.getText().toString());
                            listaClientes.add(c);

                            Toast.makeText(Registrar_Cliente.this,"Cliente Regitrado", Toast.LENGTH_SHORT).show();

                            Intent i = new Intent(getApplicationContext(), MainActivity.class);
                            i.putExtra("lc", listaClientes);
                            startActivity(i);
                        }
                    }
                }
            }
        });

        btnCancelarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}

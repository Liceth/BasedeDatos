package com.example.vanessa.basededatos;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Editar extends AppCompatActivity {

    public static final String ARG_ID_ESTUDIANTE = "ARG_ID_ESTUDIANTE";
    public static final String ARG_NOMBRE_ESTUDIANTE = "ARG_NOMBRE_ESTUDIANTE";
    public static final String ARG_APELLIDO_ESTUDIANTE = "ARG_APELLIDO_ESTUDIANTE";

    public TextView idEstudiante;
    public EditText nombreEstudiante;
    public EditText apellidoEstudiante;

    public Button aceptar;
    public Button cancelar;

    public String id;
    public String nombre;
    public String apellido;

    public TextView valNombre;
    public TextView valApellido;

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        id = getIntent().getStringExtra(ARG_ID_ESTUDIANTE);
        nombre = getIntent().getStringExtra(ARG_NOMBRE_ESTUDIANTE);
        apellido = getIntent().getStringExtra(ARG_APELLIDO_ESTUDIANTE);

        idEstudiante = (TextView)findViewById(R.id.id1);
        nombreEstudiante = (EditText)findViewById(R.id.nombre1);
        apellidoEstudiante = (EditText)findViewById(R.id.apellido1);

        valNombre = (TextView)findViewById(R.id.valNombre1);
        valApellido = (TextView)findViewById(R.id.valApellido1);

        idEstudiante.setText(id);
        nombreEstudiante.setText(nombre);
        apellidoEstudiante.setText(apellido);

        aceptar = (Button)findViewById(R.id.aceptar);
        cancelar = (Button)findViewById(R.id.cancelar);


        aceptar.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    aceptar.setBackgroundColor(Color.rgb(255, 0, 102));

                    valNombre.setText("");
                    valApellido.setText("");

                    boolean confirmar = true;

                    nombre = nombreEstudiante.getText().toString();
                    apellido = apellidoEstudiante.getText().toString();

                    if(nombre.equals("")){
                        valNombre.setText("Esta informacion es obligatoria");
                        confirmar = false;
                    }

                    if(apellido.equals("")){
                        valApellido.setText("Esta informacion es obligatoria");
                        confirmar = false;
                    }

                    if(confirmar){
                        Funciones fun = new Funciones();
                        fun.Editar(context, id, nombre, apellido);
                        Toast.makeText(context, "Estudiante editado correctamente", Toast.LENGTH_SHORT).show();
                        finish();

                        Intent intent = new Intent(context, Listado.class);
                        startActivity(intent);
                    }

                    return true;
                } else {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        aceptar.setBackgroundColor(Color.rgb(248, 146, 209));
                        return false;
                    } else {
                        return false;
                    }
                }
            }

        });

        cancelar.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    cancelar.setBackgroundColor(Color.rgb(255, 0, 102));
                    finish();
                    return true;
                } else {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        cancelar.setBackgroundColor(Color.rgb(248, 146, 209));
                        return false;
                    } else {
                        return false;
                    }
                }
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_editar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

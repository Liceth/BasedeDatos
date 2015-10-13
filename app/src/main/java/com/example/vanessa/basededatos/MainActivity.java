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

public class MainActivity extends AppCompatActivity {

    public EditText idEstudiante;
    public EditText nombreEstudiante;
    public EditText apellidoEstudiante;
    public Button guardar;
    public Button listar;

    public String id;
    public String nombre;
    public String apellido;

    public TextView valId;
    public TextView valNombre;
    public TextView valApellido;

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Funciones fun = new Funciones();
        
        idEstudiante = (EditText)findViewById(R.id.idEstudiante);
        nombreEstudiante = (EditText)findViewById(R.id.nombreEstudiante);
        apellidoEstudiante = (EditText)findViewById(R.id.apellidoEstudiante);
        guardar = (Button)findViewById(R.id.guardar);
        listar = (Button)findViewById(R.id.listar);

        valId = (TextView)findViewById(R.id.valIdEstudiante);
        valNombre = (TextView)findViewById(R.id.valNombreEstudiante);
        valApellido = (TextView)findViewById(R.id.valApellidoEstudiante);


        guardar.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    guardar.setBackgroundColor(Color.rgb(255, 0, 102));

                    valId.setText("");
                    valNombre.setText("");
                    valApellido.setText("");

                    id = idEstudiante.getText().toString();
                    nombre = nombreEstudiante.getText().toString();
                    apellido = apellidoEstudiante.getText().toString();

                    boolean confirmar = true;

                    if(id.equals("")){
                        valId.setText("Esta informacion es obligatoria");
                        confirmar = false;
                    }

                    if(nombre.equals("")){
                        valNombre.setText("Esta informacion es obligatoria");
                        confirmar = false;
                    }

                    if(apellido.equals("")){
                        valApellido.setText("Esta informacion es obligatoria");
                        confirmar = false;
                    }

                    if(confirmar) {
                        fun.Crear(context, id, nombre, apellido);
                        Toast.makeText(context, "Estudiante creado", Toast.LENGTH_SHORT).show();
                    }

                    return true;
                } else {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        guardar.setBackgroundColor(Color.rgb(248, 146, 209));
                        return false;
                    } else {
                        return false;
                    }
                }
            }

        });

        listar.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    listar.setBackgroundColor(Color.rgb(255, 0, 102));
                    valId.setText("");
                    valNombre.setText("");
                    valApellido.setText("");
                    Intent intent = new Intent(MainActivity.this, Listado.class);
                    startActivity(intent);
                    return true;
                } else {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        listar.setBackgroundColor(Color.rgb(248, 146, 209));
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
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

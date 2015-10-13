package com.example.vanessa.basededatos;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Listado extends AppCompatActivity {

    LinearLayout listado;
    LinearLayout linear;
    Cursor c;


    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        final Funciones fun = new Funciones();

        listado = (LinearLayout)findViewById(R.id.linear);
        listado.removeAllViews();

        c = fun.Mostrar(context);

        if(c.moveToFirst()){
            do{
                LinearLayout linear = new LinearLayout(this);
                linear.setOrientation(LinearLayout.HORIZONTAL);

                TextView Descripcion = new TextView(this);
                Descripcion.setTextSize(18);
                Descripcion.setWidth(500);

                final String id = new String(c.getString(0));
                final String nombre = new String(c.getString(1));
                final String apellido = new String(c.getString(2));

                Descripcion.append("ID: " + id + "\n");
                Descripcion.append("Nombre: " + nombre + "\n");
                Descripcion.append("Apellido: " + apellido + "\n" + "\n");

                final ImageButton editar = new ImageButton(this);
                editar.setBackgroundResource(R.drawable.edit_icon);

                ImageButton Eliminar = new ImageButton(this);
                Eliminar.setBackgroundResource(R.drawable.delete_icon);

                editar.setOnTouchListener(new View.OnTouchListener() {

                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_UP) {

                            Intent intent = new Intent(context, Editar.class);
                            intent.putExtra(Editar.ARG_ID_ESTUDIANTE, id);
                            intent.putExtra(Editar.ARG_NOMBRE_ESTUDIANTE, nombre);
                            intent.putExtra(Editar.ARG_APELLIDO_ESTUDIANTE, apellido);

                            startActivity(intent);

                            return true;
                        } else {
                            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                                return false;
                            } else {
                                return false;
                            }
                        }
                    }

                });


                Eliminar.setOnTouchListener(new View.OnTouchListener() {

                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_UP) {
                            fun.Eliminar(context, id);
                            Toast.makeText(context, "Estudiante Eliminado", Toast.LENGTH_LONG).show();

                            Intent intent = getIntent();
                            finish();
                            startActivity(intent);

                            return true;
                        } else {
                            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                                return false;
                            } else {
                                return false;
                            }
                        }
                    }

                });

                linear.addView(Descripcion);
                linear.addView(editar);
                linear.addView(Eliminar);
                listado.addView(linear);

            }while (c.moveToNext());
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_listado, menu);
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

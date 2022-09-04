package com.nagv.crud_sqlite;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Modal {
    Dialog myDialog;
    AlertDialog.Builder dialogo;
    boolean validaInput = false;
    String codigo;
    String descripcion;
    String precio;

    SQLiteDatabase bd = null;
    Dto datos = new Dto();

    public void Search(final Context context){
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.ventana1);
        myDialog.setTitle("Search");
        myDialog.setCancelable(false);
        final ConexionSQLite conexion = new ConexionSQLite(context);
        final EditText et_cod = (EditText) myDialog.findViewById(R.id.et_cod);
        Button btn_buscar=(Button) myDialog.findViewById(R.id.btn_buscar);
        TextView tv_close=(TextView) myDialog.findViewById(R.id.tv_close);
        tv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });

        btn_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_cod.getText().toString().length()==0){
                    validaInput=false;
                    et_cod.setError("Campo Obligatorio");
                }else{
                    validaInput=true;
                }
                if (validaInput){
                    String cod = et_cod.getText().toString();
                    datos.setCodigo(Integer.parseInt(cod));
                    if (conexion.consultaCodigo(datos));
                }
            }
        });
    }
}

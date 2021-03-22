package com.sh1.sqliteappmorefields;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    db admin;
    TextView[] textViews;
    String[] name;
    TextView txtId, txtNombre, txtApellido, txtCodigoEmpleado, txtCedula, txtDepartamento, txtDireccion, txtSueldo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        admin = new db(this,"persona.db",null,1);
        txtId = findViewById(R.id.txtId);
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtCodigoEmpleado = findViewById(R.id.txtCodigoEmpleado);
        txtCedula = findViewById(R.id.txtCedula);
        txtDepartamento = findViewById(R.id.txtDepartamento);
        txtDireccion = findViewById(R.id.txtDireccion);
        txtSueldo = findViewById(R.id.txtSueldo);
        name = new String[]{"id","nombre", "apellido","codigo_empleado" ,"cedula","departamento","direccion" ,"sueldo"};
        textViews = new TextView[]{txtId,txtNombre,txtApellido,txtCodigoEmpleado,txtCedula,txtDepartamento,txtDireccion,txtSueldo};
    }

    public void Limpiar(View v){
        for (TextView t:textViews) {
            t.setText("");
        }
    }
    public boolean Insertar(View v){
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("id",txtId.getText().toString());
        values.put("nombre",txtNombre.getText().toString());
        values.put("apellido",txtApellido.getText().toString());
        values.put("codigo_empleado",txtCodigoEmpleado.getText().toString());
        values.put("cedula",txtCedula.getText().toString());
        values.put("departamento",txtDepartamento.getText().toString());
        values.put("direccion",txtDireccion.getText().toString());
        values.put("sueldo",txtSueldo.getText().toString());

        long result = db.insert("personas",null,values);
        if(result == -1){
            Toast.makeText(this,"No se guardaron los datos ",Toast.LENGTH_SHORT).show();
            return false;
        }
        else {
            Toast.makeText(this,"Se guardaron los datos correctamente",Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    public boolean Actualizar(View v){
        SQLiteDatabase db = admin.getWritableDatabase();
        String id = txtId.getText().toString();
        ContentValues values = new ContentValues();
        values.put("id",txtId.getText().toString());
        values.put("nombre",txtNombre.getText().toString());
        values.put("apellido",txtApellido.getText().toString());
        values.put("codigo_empleado",txtCodigoEmpleado.getText().toString());
        values.put("cedula",txtCedula.getText().toString());
        values.put("departamento",txtDepartamento.getText().toString());
        values.put("direccion",txtDireccion.getText().toString());
        values.put("sueldo",txtSueldo.getText().toString());
        values.
        long result = db.update("personas",values,"id ='"+id+"'",null);
        if(result == -1){
            Toast.makeText(this,"No se Actualizaron los datos ",Toast.LENGTH_SHORT).show();
            return false ;
        }
        else{
            Toast.makeText(this,"Se modificaron los datos correctamente",Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    public boolean Eliminar(View v){
        SQLiteDatabase db = admin.getWritableDatabase();
        String id = txtId.getText().toString();
        long result = db.delete("personas","id=" + id,null);
        if (result == -1) {
            Toast.makeText(this, "No se eliminaron los datos", Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            Toast.makeText(this, "Se eliminaron los datos correctamente", Toast.LENGTH_SHORT).show();
            return true;
        }
   }

    public void Consultar(View v){
        SQLiteDatabase db = admin.getWritableDatabase();
        String id = txtId.getText().toString();
        Cursor row = db.rawQuery("SELECT * FROM personas WHERE id = " + id,null);
        if(row.getCount() == 0){
            Toast.makeText(this,"No se encuentra los datos " ,Toast.LENGTH_SHORT).show();
            return;
        }
        while(row.moveToNext()){
            id = row.getString(0);
            txtNombre.setText(row.getString(1));
            txtApellido.setText(row.getString(2));
            txtCodigoEmpleado.setText(row.getString(3));
            txtCedula.setText(row.getString(4));
            txtDepartamento.setText(row.getString(5));
            txtDireccion.setText(row.getString(6));
            txtSueldo.setText(row.getString(7));
            Toast.makeText(this,"Se cargaron los datos correctamente",Toast.LENGTH_SHORT).show();
        }
    }
}
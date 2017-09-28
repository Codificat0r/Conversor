package com.example.conversor;

import android.content.DialogInterface;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Creamos objetos para guardar la direccion de memoria de los ya creados y poder trabajar con
    //ellos
    Button btnConvertir;
    RadioButton rbtnDolarEuro;
    RadioButton rbtnEuroDolar;
    EditText edtxtDolar;
    EditText edtxtEuro;
    Conversion miConversor = new Conversion();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        edtxtEuro = (EditText)findViewById(R.id.edtxtEuro);
        edtxtDolar = (EditText)findViewById(R.id.edtxtDolar);
        rbtnDolarEuro = (RadioButton)findViewById(R.id.rbtnDolarEuro);
        rbtnEuroDolar = (RadioButton)findViewById(R.id.rbtnEuroDolar);
        btnConvertir = (Button)findViewById(R.id.btnConvertir);

        btnConvertir.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == btnConvertir)
        {
            try {
                if (rbtnDolarEuro.isChecked()) {
                    edtxtEuro.setText(miConversor.convertirAEuros(edtxtDolar.getText().toString()));
                }
                if (rbtnEuroDolar.isChecked()) {
                    edtxtDolar.setText(miConversor.convertirADolares(edtxtEuro.getText().toString()));
                }
            }
            catch (Exception e) {
                Toast.makeText(this, "Error en el formato de los números introducidos", Toast.LENGTH_SHORT).show();
                Snackbar.make(view, "Error en el formato de los numeros introducidos", Snackbar.LENGTH_SHORT).show();
            }
        }
    }
}

package com.example.conversor;

import android.content.DialogInterface;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Creamos objetos para guardar la direccion de memoria de los ya creados y poder trabajar con
    //ellos
    Button btnConvertir;
    RadioButton rbtnDolarEuro;
    RadioButton rbtnEuroDolar;
    EditText edtxtDolar;
    EditText edtxtEuro;
    double conversionEuroDolar = 1.18;

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
                    edtxtEuro.setText((String.format("%.2f", Double.parseDouble(edtxtDolar.getText().toString()) / conversionEuroDolar)).replace(',','.'));
                }
                if (rbtnEuroDolar.isChecked()) {
                    edtxtDolar.setText((String.format("%.2f", Double.parseDouble(edtxtEuro.getText().toString()) * conversionEuroDolar)).replace(',','.'));
                }
            }
            catch (Exception e) {
            }
        }
    }
}

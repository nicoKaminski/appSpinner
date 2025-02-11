package com.murek.spinnerapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.murek.spinnerapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String[] opciones = {"Sumar", "Restar", "Multiplicar", "Dividir"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, opciones);
        binding.spinner.setAdapter(adapter);
        binding.spinner.setSelection(0); // Establece la primera opción como seleccionada por defecto

    }

    public void calular(View view) {
        String selec = binding.spinner.getSelectedItem().toString();
        String num1 = binding.et1.getText().toString();
        String num2 = binding.et2.getText().toString();

        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);
        String resultado = "";

        if (selec.equals("Sumar")) {
            resultado += "La suma es: " + (n1 + n2) + "\n";
        }
        if (selec.equals("Restar")) {
            resultado += "La resta es: " + (n1 - n2) + "\n";
        }
        if (selec.equals("Multiplicar")) {
            resultado += "La multiplicación es: " + (n1 * n2) + "\n";
        }
        if (selec.equals("Dividir")) {
            if (n2 != 0) {
                resultado += "La división es: " + (n1 / n2) + "\n";
            } else {
                resultado += "Error: División por cero\n";
            }
        }
        binding.tvResult.setText(resultado);
    }
}
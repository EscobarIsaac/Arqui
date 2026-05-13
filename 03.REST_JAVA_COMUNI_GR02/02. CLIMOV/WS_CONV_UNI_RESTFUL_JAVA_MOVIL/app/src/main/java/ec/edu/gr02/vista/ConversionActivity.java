package ec.edu.gr02.vista;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import ec.edu.gr02.R;
import ec.edu.gr02.controlador.ConversionControlador;

public class ConversionActivity extends AppCompatActivity {

    EditText etValor;
    RadioButton rbPulgadasACm, rbCmAPulgadas;
    Button btnConvertir, btnCerrarSesion;
    TextView txtResultado;

    ConversionControlador controlador = new ConversionControlador();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);

        etValor = findViewById(R.id.etValor);
        rbPulgadasACm = findViewById(R.id.rbPulgadasACm);
        rbCmAPulgadas = findViewById(R.id.rbCmAPulgadas);
        btnConvertir = findViewById(R.id.btnConvertir);
        btnCerrarSesion = findViewById(R.id.btnCerrarSesion);

        // Crear resultado dinámico (porque no tienes TextView en XML)
        txtResultado = new TextView(this);
        txtResultado.setTextSize(18);
        LinearLayout mainLayout = findViewById(R.id.mainLinearLayout);
        mainLayout.addView(txtResultado);

        btnConvertir.setOnClickListener(v -> {

            String valorTxt = etValor.getText().toString();

            if (valorTxt.isEmpty()) {
                txtResultado.setText("Ingrese un valor");
                return;
            }

            double valor = Double.parseDouble(valorTxt);

            String origen, destino;

            if (rbPulgadasACm.isChecked()) {
                origen = "in";
                destino = "cm";
            } else {
                origen = "cm";
                destino = "in";
            }

            new Thread(() -> {
                String resultado = controlador.convertir(valor, origen, destino);

                runOnUiThread(() -> txtResultado.setText("Resultado: " + resultado));
            }).start();
        });

        btnCerrarSesion.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });
    }
}
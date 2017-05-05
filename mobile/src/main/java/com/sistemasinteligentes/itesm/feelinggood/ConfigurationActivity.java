package com.sistemasinteligentes.itesm.feelinggood;

import android.app.ActionBar;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Context;
import android.widget.TimePicker;

import java.sql.Time;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.RecursiveTask;

public class ConfigurationActivity extends AppCompatActivity {

    private LinearLayout mLayout;
    private EditText edit_text;
    private Button add_button;
    private final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        Button btn = null;

        List<Comida> comidas = new ArrayList<Comida>();

        btn = (Button)findViewById(R.id.agregar_comida_button);
        btn.setOnClickListener(onClick());

        // Initialization
        mLayout = (LinearLayout) findViewById(R.id.configuration_form);
        TextInputLayout hora_inicio = new TextInputLayout(this);
        EditText hora_inicio_input = new EditText(this);
        hora_inicio.addView(hora_inicio_input);
        hora_inicio_input.setText("Hora de inicio");
    }

    private OnClickListener onClick() {
        return new OnClickListener() {
            @Override
            public void onClick(View v) {
                mLayout.addView(createTextInputLayout());
            }
        };
    }

    private TextInputLayout createTextInputLayout() {
        final LayoutParams mTextInputLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        final TextInputLayout inputLayout = new TextInputLayout(context);
        inputLayout.setLayoutParams(mTextInputLayoutParams);
        inputLayout.addView(createTextInputEditText("Nombre de la comida"));
        inputLayout.addView(createTextInputEditText("Horario de inicio"));
        //inputLayout.addView();
        return inputLayout;
    }

    private EditText createTextInputEditText(String text) {
        final TextInputEditText editText = new TextInputEditText(context);
        final LayoutParams mEditTextParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        editText.setLayoutParams(mEditTextParams);
        editText.setHint(text);
        return editText;
    }

    /*
    private TimePicker createTimePicker() {
        final TimePicker tp = new TimePicker(context);
        //final LayoutParams mLayoutParams =
    }*/
}

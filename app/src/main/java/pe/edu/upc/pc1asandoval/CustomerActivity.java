package pe.edu.upc.pc1asandoval;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.pc1asandoval.database.CustomersDBHelper;
import pe.edu.upc.pc1asandoval.model.Customer;

public class CustomerActivity extends AppCompatActivity {

    private EditText txtNombre;
    private EditText txtDNI;
    private EditText txtFecha;
    private EditText txtBiografia;
    private Spinner cmbProducto;
    private Button btnGuardar;

    private List<String> arrAvatarTexto = new ArrayList<>();
    private List<Integer> arrAvatarResource = new ArrayList<>();

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);


        txtNombre = (EditText)findViewById(R.id.txtNombre);
        txtDNI = (EditText)findViewById(R.id.txtDNI);
        txtFecha = (EditText)findViewById(R.id.txtFecha);
        txtBiografia = (EditText)findViewById(R.id.txtBiografia);
        cmbProducto = (Spinner) findViewById(R.id.cmbProducto);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCustomer();
            }
        });

        arrAvatarTexto.add("Llanta 1");
        arrAvatarTexto.add("Llanta 2");
        arrAvatarTexto.add("Llanta 3");
        arrAvatarTexto.add("Llanta 4");

        arrAvatarResource.add(R.drawable.llanta12);
        arrAvatarResource.add(R.drawable.llanta14);
        arrAvatarResource.add(R.drawable.llanta16);
        arrAvatarResource.add(R.drawable.llanta18);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, arrAvatarTexto);
        cmbProducto.setAdapter(dataAdapter);

    }


    private void addCustomer() {
        if(txtNombre.getText().toString().isEmpty()){
            Toast.makeText(this, "Ingrese su nombre!", Toast.LENGTH_SHORT).show();
            txtNombre.requestFocus();
            return;
        }
        if(txtDNI.getText().toString().isEmpty()){
            Toast.makeText(this, "Ingrese su DNI!", Toast.LENGTH_SHORT).show();
            txtDNI.requestFocus();
            return;
        }
        if(txtFecha.getText().toString().isEmpty()){
            Toast.makeText(this, "Ingrese su edad!", Toast.LENGTH_SHORT).show();
            txtFecha.requestFocus();
            return;
        }
        if(txtBiografia.getText().toString().isEmpty()){
            Toast.makeText(this, "Ingrese su biografia!", Toast.LENGTH_SHORT).show();
            txtBiografia.requestFocus();
            return;
        }

        String vNombre = txtNombre.getText().toString();
        String vDNI = txtDNI.getText().toString();
        String vFecha = txtFecha.getText().toString();
        String vBiografia = txtBiografia.getText().toString();

        int selectedItem = cmbProducto.getSelectedItemPosition();
        int vAvatar = arrAvatarResource.get(selectedItem);

        //Creando objeto Persona
        Customer p = new Customer();
        p.setNombre(vNombre);
        p.setDni(vDNI);
        p.setDate(vFecha);
        p.setBiografia(vBiografia);
        p.setIdProducto(arrAvatarTexto.get(selectedItem));
        p.setIdphoto(vAvatar);

        //Realizando el registro
        CustomersDBHelper db = CustomersDBHelper.getInstance(this);
        long cmd = db.saveCustomer(p);

        if(cmd>0){
            Toast.makeText(this,
                    "Registro creado satisfactoriamente!",
                    Toast.LENGTH_SHORT).show();
            LimpiarFormulario();

            Intent toMain = new Intent(this, MainActivity.class);
            startActivity(toMain);
        }else{
            Toast.makeText(this,
                    "Hubo un error al crear el registro!",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void LimpiarFormulario() {
        txtNombre.setText("");
        txtDNI.setText("");
        txtFecha.setText("");
        txtBiografia.setText("");
        cmbProducto.setSelection(0);
    }
}

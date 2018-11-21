package pe.edu.upc.pc1asandoval;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BioActivity extends AppCompatActivity {

    private ImageView imgFoto;
    private TextView txtNombre;
    private TextView txtDNI;
    private TextView txtFecha;
    private TextView txtBiografia;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio);

        imgFoto = (ImageView) findViewById(R.id.imgFoto);
        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtDNI = (TextView) findViewById(R.id.txtDNI);
        txtBiografia = (TextView) findViewById(R.id.txtBiografia);
        txtFecha = (TextView) findViewById(R.id.txtFecha);

        id = getIntent().getExtras().getInt("pId");
        imgFoto.setImageResource(getIntent().getExtras().getInt("pImgFoto"));
        txtNombre.setText(getIntent().getExtras().getString("pNombre"));
        txtDNI.setText(getIntent().getExtras().getString("pDni"));
        txtBiografia.setText(getIntent().getExtras().getString("pBioigrafia"));
        txtFecha.setText(getIntent().getExtras().getString("pFecha"));

    }
}

package pe.edu.upc.pc1asandoval;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.pc1asandoval.adapter.CustomerAdapter;
import pe.edu.upc.pc1asandoval.database.CustomersDBHelper;
import pe.edu.upc.pc1asandoval.model.Customer;

public class MainActivity extends AppCompatActivity {

    private List<Customer> items = new ArrayList();
    private RecyclerView reciclador;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private FloatingActionButton btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reciclador = (RecyclerView) findViewById(R.id.reciclador);
        reciclador.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this);
        reciclador.setLayoutManager(lManager);

        customers();
        adapter = new CustomerAdapter(items);
        reciclador.setAdapter(adapter);


        btnAgregar = (FloatingActionButton)findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCustomer();
            }
        });

    }

    private void addCustomer() {
        Intent act = new Intent(this, CustomerActivity.class);
        startActivity(act);
    }

    private void customers() {
        CustomersDBHelper db = CustomersDBHelper.getInstance(this);
        items = db.customers();
    }

    @Override
    protected void onResume() {
        super.onResume();
        customers();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


}

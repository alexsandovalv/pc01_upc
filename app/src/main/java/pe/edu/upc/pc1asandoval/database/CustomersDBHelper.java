package pe.edu.upc.pc1asandoval.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.pc1asandoval.R;
import pe.edu.upc.pc1asandoval.model.Customer;

public class CustomersDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Sales.db";
    public static final int DATABASE_VERSION = 1;
    private List<Customer> people = new ArrayList<Customer>();

    private static CustomersDBHelper instance;

    public CustomersDBHelper(@Nullable Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    public static synchronized CustomersDBHelper getInstance(Context context) {
        if (instance == null) {
            instance = new CustomersDBHelper(context);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS "+CustomerTable.TABLE_NAME+";");
        db.execSQL(CustomerTable.CREATE_TABLE);
        loadData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private void loadData(SQLiteDatabase db) {
        people.add(new Customer("Juan Perez", "40893322",
                "Ingeniero de sistemas", "Llanta 1","12/01/2008", R.drawable.llanta12));
        people.add(new Customer("Carla Gonzales", "45887766",
                        "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old.",
                "Llanta 2","01/01/2008", R.drawable.llanta14));
        people.add(new Customer("Marco Perales", "40893322",
                        "To find and compare the position ", "Llanta 3","24/06/2018", R.drawable.llanta16));
        people.add(new Customer("JRosa Gomez", "40893322",
                        "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem",
                "Llanta 4","08/10/2012", R.drawable.llanta18));


        for(Customer p:people){
            db.insert(CustomerTable.TABLE_NAME,null, p.toContentValues());
        }
    }

    public long saveCustomer(Customer customer){
        SQLiteDatabase db = getWritableDatabase();
        long cmd = db.insert(CustomerTable.TABLE_NAME,null,customer.toContentValues());
        return cmd;
    }

    public List<Customer> customers(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(CustomerTable.TABLE_NAME,
                null,       //Columnas a listar
                null,       //Sentencia WHERE
                null,   //Parametros de WHERE
                null,       //Agruapamiento
                null,        //Condición de agrupamiento
                CustomerTable.NOMBRE);  //Ordenamiento
        List<Customer> lista = new ArrayList<>();
        while(cursor.moveToNext()){
            lista.add(new Customer(
                    cursor.getInt(cursor.getColumnIndex(CustomerTable.ID)),  //id
                    cursor.getString(cursor.getColumnIndex(CustomerTable.NOMBRE)),  //Nombre
                    cursor.getString(cursor.getColumnIndex(CustomerTable.DNI)),    //dni
                    cursor.getString(cursor.getColumnIndex(CustomerTable.BIOGRAFIA)),//biografia
                    cursor.getString(cursor.getColumnIndex(CustomerTable.PRODUCTO)), //idProducto
                    cursor.getString(cursor.getColumnIndex(CustomerTable.FECHA)),//Fecha
                    cursor.getInt(cursor.getColumnIndex(CustomerTable.PHOTO)) //idProducto

            ));
        }
        return lista;
    }
}

package pe.edu.upc.pc1asandoval.database;

public class CustomerTable {

    public static final String TABLE_NAME = "CLIENTE";
    public static final String ID = "id";
    public static final String NOMBRE = "nombre";
    public static final String DNI = "dni";
    public static final String BIOGRAFIA = "biografia";
    public static final String FECHA = "fecha";
    public static final String PRODUCTO = "producto";
    public static final String PHOTO = "idPhoto";

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
            + "( "
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NOMBRE + " TEXT, "
            + DNI + " TEXT, "
            + BIOGRAFIA + " TEXT, "
            + FECHA + " TEXT, "
            + PRODUCTO + " TEXT, "
            + PHOTO + " INTEGER "
            + " )";



}

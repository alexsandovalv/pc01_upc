package pe.edu.upc.pc1asandoval.model;

import android.content.ContentValues;

import pe.edu.upc.pc1asandoval.database.CustomerTable;

public class Customer {

    private int id;
    private String nombre;
    private String dni;
    private String biografia;
    private int idphoto;
    private String idProducto;
    private String date;

    public Customer(String nombre, String dni, String biografia, String idProducto, String date, int idphoto ) {
        this.nombre = nombre;
        this.dni = dni;
        this.biografia = biografia;
        this.idProducto = idProducto;
        this.date = date;
        this.idphoto = idphoto;
    }

    public Customer(){}

    public Customer(int id, String nombre, String dni, String biografia, String idProducto, String date, int idphoto) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.biografia = biografia;
        this.idProducto = idProducto;
        this.date = date;
        this.idphoto = idphoto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getIdphoto() {
        return idphoto;
    }

    public void setIdphoto(int idphoto) {
        this.idphoto = idphoto;
    }


    public ContentValues toContentValues(){
        ContentValues values = new ContentValues();
        values.put(CustomerTable.NOMBRE, this.nombre);
        values.put(CustomerTable.DNI, this.dni);
        values.put(CustomerTable.FECHA, this.date);
        values.put(CustomerTable.BIOGRAFIA, this.biografia);
        values.put(CustomerTable.PRODUCTO, this.idProducto);
        values.put(CustomerTable.PHOTO, this.idphoto);
        return  values;
    }
}

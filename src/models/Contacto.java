package models;

public class Contacto  {
    private String nombre;
    private String telefono;



    public Contacto() {
    }

    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    
    public Contacto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public String getTelefono() {
        return telefono;
    }
    @Override
    public String toString() {
        return "Contacto [toString()=" + super.toString() + "]";
    }


    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if (this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        // aqui obj y this son clase contacto
        Contacto c = (Contacto) obj;
        return nombre != null && nombre.equals(c.getNombre());

    }

    

    

    
    
}

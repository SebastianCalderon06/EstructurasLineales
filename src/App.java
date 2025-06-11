import models.*;
public class App {
    public static void main(String[] args) throws Exception {

        Contacto c1 =  new Contacto("Juan", "123");
        Contacto c4 =  new Contacto("Juan");
        Contacto c2 =  new Contacto("Juan", "null");
        Contacto c3 =  new Contacto("Juana", "456");
        Contacto c5 =  new Contacto("Juan", "123");
        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(c3));
        System.out.println(c1.equals(c4));
        System.out.println(c1.equals(c5));
    }
}

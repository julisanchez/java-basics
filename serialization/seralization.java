package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

// Serializar consiste en convertir un objeto en una sucesion de bytes para poder ser almacenado
public class seralization {
    public static void main(final String[] args) {
        final Administrador jefe = new Administrador("Juan", 80000, 2005, 12, 15);

        jefe.setIncentivo(5000);

        final Empleado[] personal = new Empleado[3];

        personal[0] = jefe;
        personal[1] = new Empleado("Ana", 25000, 2008, 10, 1);
        personal[2] = new Empleado("Luis", 18000, 2012, 9, 15);

        try {
            // ObjectOutputStream: escribe objetos en un fichero
            FileOutputStream file = new FileOutputStream("empleado.j");
            final ObjectOutputStream escribiendoFichero = new ObjectOutputStream(file);

            escribiendoFichero.writeObject(personal);

            escribiendoFichero.close();

            // ObjectInputStream: lee objetos de un fichero
            FileInputStream input = new FileInputStream("empleado.j");
            final ObjectInputStream recuperandoFichero = new ObjectInputStream(input);

            final Empleado[] personalRecuperado = (Empleado[]) recuperandoFichero.readObject();

            recuperandoFichero.close();

            for(final Empleado e : personalRecuperado) {
                System.out.println(e);
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

}

class Empleado implements Serializable {

    // Este id representa a la clase. Si a la clase se le hace alguna modificacion hay que cambiar el id
    private static final long serialVersionUID = 224434453403286234L;

    // Los campos estáticos o transient en una clase no pueden ser serializados.
    static String noSerializable = "No soy serializable";
    transient String tampoco = "Tampoco soy serializable";


    private final String nombre;
    private double sueldo;
    private final Date fechaContrato;
    // Si una clase tiene una referencia de otra clase, todas las referencias deben ser serializables,
    // de lo contrario no se realizará el proceso de serialización.
    private Proyecto proyecto;

    public Empleado(final String n, final double s, final int anio, final int mes, final int dia) {
        nombre = n;
        sueldo = s;

        final GregorianCalendar calendar = new GregorianCalendar(anio, mes - 1, dia);
        fechaContrato = calendar.getTime();
    }

    public String getNombre() {
        return nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public Date getFechaContrato() {
        return fechaContrato;
    }

    public void subirSueldo(final double porcentaje) {
        final double aumento = sueldo * porcentaje / 100;

        sueldo += aumento;
    }

    public void setProyecto(final Proyecto p) {
        proyecto = p;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public String toString() {
        return "Nombre: " + nombre + " Sueldo: " + sueldo + " Fecha de Contrato: " + fechaContrato;
    }
}

class Administrador extends Empleado {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private double incentivo;

    public Administrador(final String n, final double s, final int anio, final int mes, final int dia) {
        super(n, s, anio, mes, dia);

        incentivo = 0;
    }

    public double getSueldo() {
        final double sueldoBase = super.getSueldo();

        return sueldoBase + incentivo;
    }

    public void setIncentivo(final double b) {
        incentivo = b;
    }

    public String toString() {
        return super.toString() + "Incentivo: " + incentivo;
    }
}

class Proyecto implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String titulo;

    Proyecto(final String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }
}
package hipermercado;

import java.util.Calendar;
import java.util.GregorianCalendar;

class Caja {

    private static int id = 0;
    public Cola cola;
    private Contabilidad contabilidad;
    private boolean cerrada = false;
    private float tiempo;
    private float suma;
    private Calendar calendario = new GregorianCalendar();

    public Caja(Cola cola, Contabilidad contabilidad) {
        this.cola = cola;
        this.contabilidad = contabilidad;
        Caja.id++;
        this.suma = 0;
    }

    public void run() {
        while (!cerrada) {
            Cliente cliente = this.cola.sacar();
            if (cliente != null) {
                suma += cliente.damePrecioCarro();
                tiempo = (float) (cliente.damePrecioCarro() / 10);
            } else {
                cerrada = true;
            }
            System.out.println("Se ha atendido un cliente: " + calendario.get(Calendar.HOUR_OF_DAY)
                    + ":" + calendario.get(Calendar.MINUTE) + ":"
                    + calendario.get(Calendar.SECOND));
        }
        contabilidad.añadeSaldo(suma);
        System.out.println("Se actualiza la contabilidad: " + calendario.get(Calendar.HOUR_OF_DAY)
                + ":" + calendario.get(Calendar.MINUTE) + ":"
                + calendario.get(Calendar.SECOND));
    }

    public void interrupt(Cliente cliente) {
        cerrada = true;
        cola.añadirPrincipio(cliente);
    }

    public String dimeEstado() {
        if (!cerrada) {
            return "La caja está abierta";
        } else {
            return "La caja está cerrada";
        }
    }

    public int dimeId() {
        return id;
    }
}

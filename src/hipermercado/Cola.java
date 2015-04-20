package hipermercado;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

class Cola {

    private ArrayList<Cliente> colaClientes;
    
    private boolean cerrada = false;
    private int tamMax = 0;

    public Cola() {
        this.colaClientes = new ArrayList<>();
    }

    public boolean añadirFinal(Cliente cliente) {
        if (!cerrada) {
            colaClientes.add(cliente);
            Calendar calendario = new GregorianCalendar();
            System.out.println("Se añade un cliente: " + calendario.get(Calendar.HOUR_OF_DAY)
                    + ":" + calendario.get(Calendar.MINUTE) + ":"
                    + calendario.get(Calendar.SECOND));
            if (colaClientes.size() > tamMax) {
                tamMax = colaClientes.size();
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean añadirPrincipio(Cliente cliente) {
        colaClientes.add(0, cliente);
        Calendar calendario = new GregorianCalendar();
        System.out.println("Se añade un cliente al principio: " + calendario.get(Calendar.HOUR_OF_DAY)
                + ":" + calendario.get(Calendar.MINUTE) + ":"
                + calendario.get(Calendar.SECOND));
        if (colaClientes.size() > tamMax) {
            tamMax = colaClientes.size();
        }
        return true;
    }

    public Cliente sacar() {
        if (colaClientes.size() > 0) {
            Calendar calendario = new GregorianCalendar();
            System.out.println("Se saca un cliente: " + calendario.get(Calendar.HOUR_OF_DAY)
                    + ":" + calendario.get(Calendar.MINUTE) + ":"
                    + calendario.get(Calendar.SECOND));
            return colaClientes.remove(0);
        }
        return null;
    }

    public boolean cerrar() {
        this.cerrada = true;
        return this.cerrada;
    }

    public int tamañoMáximo() {
        return tamMax;
    }

}

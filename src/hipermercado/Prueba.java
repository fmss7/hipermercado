package hipermercado;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Prueba {

    public Prueba() {
    }

    public void ponAPrueba() throws InterruptedException {
        while (true) {
            java.util.Random random = new java.util.Random();
            Calendar prueba = new GregorianCalendar();
            System.out.println(prueba.get(Calendar.HOUR_OF_DAY) + ":" + prueba.get(Calendar.MINUTE) + ":" + prueba.get(Calendar.SECOND));
            Thread.sleep(random.nextInt(1000));
        }
    }
}

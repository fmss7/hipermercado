package hipermercado;

public class Main{
    public static void main(String[] args) throws InterruptedException{
        java.util.Random random = new java.util.Random();
        Cola cola = new Cola();
        long antes = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            Cliente cliente = new Cliente();
            cola.añadirFinal(cliente);
            if(System.currentTimeMillis()- antes >= 60000){
                break;
            }
            Thread.sleep(random.nextInt(50));
        }
        Contabilidad contabilidad = new Contabilidad();
        Caja caja = new Caja(cola, contabilidad);
        caja.run();
    }
}
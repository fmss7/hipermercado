package hipermercado;

class Contabilidad{
    private int saldo;
    public Contabilidad() {
        this.saldo = 0;
    }
    
    public void añadeSaldo(float saldo){
        this.saldo += saldo;
    }
    
    public int dameSaldo(){
        return this.saldo;
    }
    
}
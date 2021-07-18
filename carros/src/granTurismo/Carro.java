package granTurismo;

public class Carro {
    private Carril carril;
    public Carro(Integer numerodeconductor, Pista pista){
        this.carril=pista.getCarriles(numerodeconductor);
    }
    
}

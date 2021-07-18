package granTurismo;

public class Conductor {
    private String nombre;
    private Integer victorias;
    private Carro carro;


    public Conductor(String nombre, Integer numerodeconductor, Pista pista){

        this.nombre=nombre;
        this.carro=new Carro(numerodeconductor, pista);
        this.victorias=0;
    }
    
    public void setVictorias(Integer Victorias){
        this.victorias=victorias;
    }

    
    
    public String getNombre(){
        return this.nombre;
    }
    public Integer getVictorias(){
        return this.victorias;
    }

}

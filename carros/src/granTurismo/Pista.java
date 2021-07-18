package granTurismo;

public class Pista {
    private Integer[] rutas ={1, 8570, 9780};
    private Carril[] carriles;

    public void crearCarriles(Integer carriles){
        this.carriles=new Carril[carriles];
        for(int i=0; i<carriles; i++){
            this.carriles[i]=new Carril();
        }
    }

    public  Integer getRutas(Integer seleccion){
        return this.rutas[seleccion];
    }

    public  Carril getCarriles(Integer seleccion){
        return this.carriles[seleccion];
    }
}

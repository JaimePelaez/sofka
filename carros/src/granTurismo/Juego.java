package granTurismo;

import java.util.Scanner;

import paquetesDAO.PodioDAO;

public class Juego {
    
    private Conductor[] jugadores;
    private Pista pistasDeljuego= new Pista();   
    private Integer dado;
    private Integer numJugadores;
    private Integer pistaSeleccionada; 
    private int [] podio;
    

    public void agregarJugadores(){
        this.jugadores=new Conductor[this.numJugadores];
        this.pistasDeljuego.crearCarriles(this.numJugadores);
        for(int i=0; i<this.numJugadores; i++){
            System.out.println("Ingrese el nombre del Conductor #"+(i+1));
            Scanner sc = new Scanner(System.in);
            this.jugadores[i]=new Conductor(sc.nextLine(),i, pistasDeljuego);            
        }

    }
    public void seleccionarPista(){
        System.out.println("Selecciona el numero de la pista que desea jugar entre las siguientes opciones\n 0. Vuelta a España\n 1. vuelta a Francia\n 2. vuelta a New York");
        Scanner sc = new Scanner(System.in);
        this.pistaSeleccionada=sc.nextInt();
    }

    public void iniciarJuego(){
        System.out.println("La pista seleccionada tiene un recorrido de "+ (pistasDeljuego.getRutas(pistaSeleccionada)*1000)+"metros."+"\nEl orden de salida de los conductores es: ");
        for(int i = 0 ; i<numJugadores;i++){
            System.out.println("Conductor #"+(i+1)+" -> "+ jugadores[i].getNombre());
        }
        System.out.println("Para hacer mover el carro se lanzara un dado que indicara el numero de metros recorridos ");
        
        carrera();
    }

    public int lanzarDado(){
        return (int) (Math.random()*6 +1);
    }


    public void setNumJugadores(Integer numJugadores){
        this.numJugadores=numJugadores;
    }

    public Integer carrera (){
        Scanner sc = new Scanner(System.in);
        int [] distancia=new int[numJugadores];
        podio= new int[numJugadores];
        int jugador=0;
        int auxpodio =0;
        int dado;
        Integer a =(pistasDeljuego.getRutas(pistaSeleccionada)*1000);


        for(int j=0; j<numJugadores;j++){
            distancia[j]=0;
            podio[j]=0;
        }
        
        while(podio[podio.length-1]==0){
            System.out.println("***********aqui voy**************");
            System.out.println(podio[podio.length-1]);
            while(jugador<numJugadores){
                if(distancia[jugador]<a){
                    System.out.println(" Presione la tecla L para lazar dados corredor #"+(jugador+1));  
                    sc.next();
                    dado=lanzarDado();
                    distancia[jugador]+=dado*100;
                    
                    System.out.println(" su dado arrojo el numero "+dado+ " corredor#"+(jugador+1)+" avanza "+dado*100+"metros"+" y te queda faltando"+(a-distancia[jugador]));
                    
        
                    if(distancia[jugador]>=a){
                        podio[auxpodio]=jugador+1;
                        System.out.println(podio[auxpodio]);
                        auxpodio++;
                    }
                }
                jugador++;
            }
            jugador=0;
        }
        return null;
    }

    public void asignarPodio(){
        
        String a= jugadores[podio[0]-1].getNombre();
        String b= jugadores[podio[1]-1].getNombre();
        String c= jugadores[podio[2]-1].getNombre();

        System.out.println("El primer lugar para el conductor "+a+" El segundo lugar es para el conductor "+b+" El tercer lugar es para el conductor "+c);

        Podio final1  =new Podio(a,b ,c );
        PodioDAO final1_1 = new PodioDAO();
        final1_1.PodioDAO(final1);
        
    }

}

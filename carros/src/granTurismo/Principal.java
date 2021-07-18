package granTurismo;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Juego juego = new Juego();
        
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; 
        
        while(!salir){
            System.out.println("1. Instrucciones");
            System.out.println("2. Agregar jugadores");
            System.out.println("3. Seleccionar pista");
            System.out.println("4. Iniciar juego");
            System.out.println("5. Salir");
            System.out.println("Escribe una de las opciones");
            opcion = sn.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("Has seleccionado la opcion 1");
                    break;
                case 2:
                    System.out.println("Has seleccionado la opcion 2");
                    System.out.println("Ingresa el numero de jugadores mayor o igual a 3");
                    juego.setNumJugadores(sn.nextInt());
                    juego.agregarJugadores();
                    break;
                case 3:
                    System.out.println("Has seleccionado la opcion 3");
                    juego.seleccionarPista();
                    break;
                case 4: 
                    System.out.println("Has seleccionado la opcion 3");
                    juego.iniciarJuego();
                    juego.asignarPodio();
                case 5:
                    salir=true;
                    break;
                default:
                    System.out.println("Solo números entre 1 y 5");
            }
        }
    }
}

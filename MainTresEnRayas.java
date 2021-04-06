import java.util.Scanner;

public class MainTresEnRayas {
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);

        int opcion = 0;//Saber que opción elije el usuario
        int posX = -1;//Saber la posición de la fila donde quiere colocar la marca el jugador
        int posY = -1;//Saber la posición de la columna donde quiere colocar la marca el jugador
        int posXm = -1;//Saber la posición de la fila donde quiere colocar la marca la máquina
        int posYm = -1;//Saber la posición de la columna donde quiere colocar la marca la máquina
        String mostrar;//Para guardar los datos que devuelve el metodo mostrar de la clase
        boolean insertado = false;//Para comprobar si se puede introducir una marca en la posición que indica
        boolean ganar = false;

        //Creamos el tablero por defecto, ya viene inicializado
        TresEnRayas tablero = new TresEnRayas();
    

       do {
            //Creamos el menú del juego
            System.out.println("----------------------");
            System.out.println("¡Juego de 3 en rayas!");
            System.out.println("----------------------");
            System.out.println("¿Qué deseas hacer?:\n (1) Jugar.\n (2) Reiniciar Tablero.\n (3) Salir.");
            System.out.print("Opción: ");
            opcion = entrada.nextInt();
            System.out.print("");

            if (opcion == 1) {
                
                //Creamos el contador de las jugadas
                int jugadaUsuario = 0;
                int jugadaMaquina = 0;

                do {

                    if (!ganar) {
                        
                        do {

                            posXm = (int)(Math.random()*3+1);
                            posYm = (int)(Math.random()*3+1);

                            insertado = tablero.comprobarHueco((posXm-1), (posYm-1));

                        } while (!insertado);

                        System.out.print("");
                        System.out.println("La máquina ya ha colocado su marca.");
                        System.out.print("");

                        jugadaMaquina++;
        
                        tablero.rellenarHueco(posXm-1, posYm-1, "O");

                        mostrar = tablero.mostrarTabla();
                        System.out.println(mostrar);

                        //Buscamos a partir de la tercera jugada si se ha conseguido hacer tres en rayas
                        if (jugadaMaquina > 2) {
                            
                            boolean estado = tablero.comprobarTablero("O");

                            if (estado) {
                                opcion = 3;
                                System.out.println("");
                                System.out.println("--------------------------");
                                System.out.println("    GANA LA MÁQUINA");
                                System.out.println("--------------------------");
                                System.out.println("");
                                ganar = true;
                            }
                            else if (!estado && (jugadaMaquina == 5 && jugadaUsuario == 4)) {
                                
                                opcion = 3;
                                System.out.println("");
                                System.out.println("---------------");
                                System.out.println("    EMPATE");
                                System.out.println("---------------");
                                System.out.println("");
                                ganar = true;
                            }
                        }
                    }


                    if(!ganar){

                        do {

                            System.out.println("Donde quieres poner la X?");
                            System.out.print("Fila: ");
                            posX = entrada.nextInt();
                            System.out.print("Columna: ");
                            posY = entrada.nextInt();

                            insertado = tablero.comprobarHueco((posX-1), (posY-1));

                        } while (!insertado);

                        jugadaUsuario++;
    
                        tablero.rellenarHueco((posX-1), (posY-1), "X");

                        mostrar = tablero.mostrarTabla();
                        System.out.println(mostrar);

                        //Buscamos a partir de la tercera jugada si se ha conseguido hacer tres en rayas
                        if (jugadaUsuario > 2) {
                            
                            boolean estado = tablero.comprobarTablero("X");

                            if (estado) {
                                opcion = 3;
                                System.out.println("");
                                System.out.println("--------------------------");
                                System.out.println("    GANA EL USUARIO");
                                System.out.println("--------------------------");
                                System.out.println("");
                                ganar = true;
                            }
                            else if (!estado && (jugadaMaquina == 5 && jugadaUsuario == 4)) {
                                
                                opcion = 3;
                                System.out.println("");
                                System.out.println("---------------");
                                System.out.println("    EMPATE");
                                System.out.println("---------------");
                                System.out.println("");
                                ganar = true;
                            }
                        }
                    }

            
                } while (!ganar);

                
            }
            else if(opcion == 2){
        
                System.out.println("");
                System.out.println("Tablero reiniciado.");
                tablero.inicializarTabla();
                System.out.println("");
            }
            else if(opcion == 3){
        
                System.out.println("");
                System.out.println("----------------------------------");
                System.out.println("Saliendo del juego, hasta pronto!");
                System.out.println("----------------------------------");
                System.out.println("");

            }
            else{
        
                System.out.println("");
                System.out.println("Eliga una opción correcta.");
                System.out.println("");
            }
               

       } while (opcion != 3);

       entrada.close();
       
       
    }
}

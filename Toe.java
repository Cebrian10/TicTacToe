import java.util.Scanner;

public class Toe {
    Scanner sc = new Scanner(System.in);
    private boolean[] posicionesOcupadas = new boolean[9];

    private String jug_1, jug_2;

    public void setJug_1(String jug_1) {
        this.jug_1 = jug_1;
    }

    public String getJug_1() {
        return jug_1;
    }

    public void setJug_2(String jug_2) {
        this.jug_2 = jug_2;
    }

    public String getJug_2() {
        return jug_2;
    }

    void inicio() {
        System.out.print("""
                -------------------------------
                ESTE DE EL JUEGO DE TIC TAC TOE
                   Tambien conocido como X 0
                -------------------------------

                En cada turno deberas escribir un
                numero ese numero representa una
                posicion del cuadro de juego

                1 | 2 | 3
                - + - + -
                4 | 5 | 6
                - + - + -
                7 | 8 | 9
                \n""");
        System.out.print("Nombre del jugador 1 (X) : ");
        jug_1 = sc.nextLine();
        System.out.print("\nNombre del jugador 2 (0) : ");
        jug_2 = sc.nextLine();
    }

    void agregarTablero(char[][] tablero, int posicion, int z, String jug) {
        char caracter = (z % 2 == 0) ? 'X' : '0';

        while (posicion < 1 || posicion > 9 || posicionesOcupadas[posicion - 1] == true) {
            System.out.print("\nEsta posición ya está ocupada. Por favor, elija otra.\nTurno de " + jug + ": ");
            String entrada = sc.nextLine();
            try {
                posicion = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("\nERROR: Por favor ingrese un número entero válido.");
            }
        }
        int fila = (posicion - 1) / 3;
        int columna = (posicion - 1) % 3;
        tablero[fila * 2][columna * 2] = caracter;
        posicionesOcupadas[posicion - 1] = true;
    }

    boolean verificarGanador(char[][] tablero, int z, String jug) {
        char caracter = (z % 2 == 0) ? 'X' : '0';

        for (int i = 0; i < 5; i += 2) {
            if (tablero[i][0] == caracter && tablero[i][2] == caracter && tablero[i][4] == caracter) {
                if (caracter == 'X') 
                    System.out.println("\nGANO HORIZONTALMENTE X\n" + jug);
                else 
                    System.out.println("\nGANO HORIZONTALMENTE 0\n" + jug);
                return false;
                }
            }
            if (z == 9) {
                System.out.println("\nFUE EMPATE\n");
                return false;
            }                    
        return true;
    }

    /*
     * else if(tablero[0][i] == caracter && tablero[2][i] == caracter && tablero[4][i] == caracter){
        * System.out.print("GANO VERTICALMENTE");
        * return false;
     * }
     * else if(tablero[i][0] == caracter && tablero[i][2] == caracter && tablero[i][4] == caracter){
        * System.out.print("GANO DIAGONALMENTE");
        * return false;
     * }
     * else if(tablero[i][4] == caracter && tablero[i][2] == caracter && tablero[i][0] == caracter){
        * System.out.print("GANO DIAGONALMENTE INVERTIDO");
        * return false;
     * }
     */

    /*
     * boolean verificarGanador(char[][] tablero, int z) {
        * char caracter = (z % 2 == 0) ? 'X' : '0';
        * for (int i = 0; i < 5; i += 2) {
            * if (tablero[i][0] == caracter && tablero[i][2] == caracter && tablero[i][4] == caracter) {
                * return true;
                * }
            * if (tablero[0][i] == caracter && tablero[2][i] == caracter && tablero[4][i] == caracter) {
                * return true;
            * }
        * }
            * if (tablero[0][0] == caracter && tablero[2][2] == caracter && tablero[4][4] == caracter) {
                * return true;
            * }
            * if (tablero[0][4] == caracter && tablero[2][2] == caracter && tablero[4][0] == caracter) {
                * return true;
            * }
        * return false;
     * }
     */

}
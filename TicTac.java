import java.lang.System;
import java.util.Scanner;

class TicTac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int z = 0, num = 0;
        String jug = " ";
        char tablero[][] = { { ' ', '|', ' ', '|', ' ' }, { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' },
                { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' } };
        Toe obj = new Toe();
        obj.inicio();
        
        while(obj.verificarGanador(tablero, z, jug)){
            jug = (z % 2 == 0) ? obj.getJug_1() : obj.getJug_2();
            System.out.print("\nTurno de " + jug + ": ");
            try {
                String entrada = sc.nextLine();
                num = Integer.parseInt(entrada);
                obj.agregarTablero(tablero, num, z, jug);

                for (char[] fila : tablero) {
                    for (char celda : fila) {
                        System.out.print(celda + " ");
                    }
                    System.out.println();
                }
                z++;
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Por favor ingrese un número entero válido.");
            }            
        }
        sc.close();
    }
}
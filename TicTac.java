import java.lang.System;
import java.util.Scanner;

class TicTac{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int z = 0;
        char tablero[][] = { { ' ', '|', ' ', '|', ' ' }, { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' },{ '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' } };  
        do{
            System.out.print("leer un numero: ");
            int num = sc.nextInt();
            agregarAlTablero(tablero, num, z);
            for (char[] fila : tablero){
                for (char celda : fila){
                    System.out.print(celda + " ");
                }
                System.out.println();
            }
            System.out.println();
            z++;            
        }while(z < 9);                                     
        sc.close();                
    }
     static void agregarAlTablero(char[][] tablero, int posicion, int z) {
        char caracter = ' ';
        if(z % 2 == 0)
            caracter = 'X';         
        else
            caracter = 'O';  
        int fila = (posicion - 1) / 3;
        int columna = (posicion - 1) % 3;
        tablero[fila * 2][columna * 2] = caracter;
    }
}  
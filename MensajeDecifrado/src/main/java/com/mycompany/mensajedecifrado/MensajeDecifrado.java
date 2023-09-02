/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mensajedecifrado;

import java.util.Scanner;

/**
 *
 * @author sebastiancaicedo
 */
public class MensajeDecifrado {

    public static void main(String[] args) {
       Scanner lector = new Scanner(System.in);
        System.out.println("Ingresa el mensaje cifrado");
        String mensajeCifrado = lector.next();
        System.out.println("Ingresa el número de posiciones hacia atrás utilizado para cifrar");
        int veces = lector.nextInt();

        String mensajeDescifrado = "";

        for(int i = 0; i < mensajeCifrado.length(); i++) {
            char letra = mensajeCifrado.charAt(i);
            boolean minuscula = (letra >= 'a' && letra <='z');
            boolean mayuscula = (letra >= 'A' && letra <='Z');
            if(!(minuscula || mayuscula))
                mensajeDescifrado += letra;
            else {
                int ascii = (int)letra;
                int baseAscii = (int)'a';
                if(mayuscula)
                    baseAscii = (int)'A';
                int nuevoAscii = (ascii - baseAscii - veces + 26) % 26 + baseAscii;
                char nuevaLetra = (char)nuevoAscii;
                mensajeDescifrado += nuevaLetra;
            }
        }
        System.out.println("Mensaje descifrado: " + mensajeDescifrado);
    }
}

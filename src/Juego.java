
import java.util.Scanner;

/**
 *
 * @author Guerra AH2-RA2-nombre-apellido
 */
public class Juego {

    public static void main(String[] args) {

        int[][] numeros = new int[8][8];
        int cont = 64;
        char[][] arroba = new char[8][8];
        char[][] tranpa = new char[8][8];
        String opcionesMenu;
        int numeroTranpas;
        int numeroDado;
        int sumaPosiciones = 1;
        int salir = 3;

        Scanner in = new Scanner(System.in);

        // *********** MATRIZ CON NUMEROS    ------------------
        for (int c = 0; c < numeros.length; c++) {
            if (c % 2 == 0) {
                for (int f = numeros[c].length - 1; f >= 0; f--) {
                    numeros[c][f] = cont--;
                }
            } else if (c % 2 != 0) {
                for (int f = 0; f < numeros[c].length; f++) {
                    numeros[c][f] = cont--;
                }
            }
            // ********** MATRIZ CON TRAMPAS      ----------------
            for (int t = 0; t < tranpa[c].length; t++) {
                tranpa[c][t] = ' ';
            }
        }

        // ********** COLOCAMOS LAS TRAMPAS     --------------------   
        for (int c = 0; c < tranpa.length; c++) {
            numeroTranpas = (int) (Math.random() * 3) + 1;
            for (int t = 1; t <= numeroTranpas; t++) {
                int numeroColumna = (int) (Math.random() * 7) + 0;
                if (tranpa[c][numeroColumna] == ' ') {
                    tranpa[c][numeroColumna] = '#';
                } else {
                    t--;
                }
            }
        }

        arroba[7][7] = '@';
        while (true) {
            System.out.println("""
                           =============  MENU PRINCIPAL  ===================
                           1. Iniciar Juego
                           2. Retornar Juego
                           3. Salir
                           """);
            opcionesMenu = in.nextLine();
            switch (opcionesMenu) {
                case "1":
                    while (sumaPosiciones <= 64) {
                        //********** MOSTRAMOS LA MATRIZ CON NUMEROS     ------------------
                        for (int i = 0; i < numeros.length; i++) {
                            for (int j = 0; j < numeros[i].length; j++) {
                                if (numeros[i][j] <= 9) {
                                    System.out.print("|     " + numeros[i][j]);
                                    System.out.print("");
                                } else {
                                    System.out.print("|    " + numeros[i][j]);
                                }
                            }
                            System.out.println("|        ");

                            //**********MOSTRAMOS SEGUNDA MATRIZ CON TRAMPAS
                            for (int k = 0; k < tranpa.length; k++) {
                                if (arroba[i][k] == '@' || arroba[i][k] == ' ') {
                                    System.out.print("|" + arroba[i][k] + "    " + tranpa[i][k]);
                                } else {
                                    System.out.print("|" + arroba[i][k] + "     " + tranpa[i][k]);
                                }
                            }
                            System.out.println("|");
                            System.out.println("-----------------------------------------------------------");
                        }
                        for (int c = 0; c < arroba.length; c++) {
                            for (int f = 0; f < arroba[c].length; f++) {
                                if (arroba[c][f] == '@' && tranpa[c][f] == '#') {
                                    System.out.println("******************************************************");
                                    System.out.println("*            Has caido en una tranpa!    :-)         * ");
                                    System.out.println("******************************************************");
                                }
                            }
                        }

                        System.out.println("ingresa el numeros 'D' para tirar el dado, o 'P' para regresar al menu principal: ");
                        String opcion2 = in.nextLine();
                        // **************** BORRAMOS EL ARROBA ANTERIOR *******************
                        for (int f = 0; f < arroba.length; f++) {
                            for (int c = 0; c < arroba[f].length; c++) {
                                if (arroba[f][c] == '@') {
                                    arroba[f][c] = ' ';
                                }
                            }
                        }

                        // ****** SUMAMOS LAS POCIONES DEL ARROBA   ************
                        if (opcion2.equalsIgnoreCase("d")) {
                            numeroDado = (int) (Math.random() * 5) + 2;
                            System.out.println("Resultado del dato = " + numeroDado);
                            sumaPosiciones += numeroDado;

                            //******** MOVEMOS EL ARROBA CON EL NUMERO DE DADO ***************
                            for (int c = 0; c < numeros.length; c++) {
                                for (int f = 0; f < numeros[c].length; f++) {
                                    if (numeros[c][f] == sumaPosiciones) {
                                        arroba[c][f] = '@';
                                    }
                                }
                            }
                            if (sumaPosiciones >= 64) {
                                System.out.println("******************************************************");
                                System.out.println("*            Felicidades has Ganado!    :-)          * ");
                                System.out.println("******************************************************");
                            }
                        }
                    } // FIN DEL WUILE
                    break;
                case "2":
                    System.out.println("");
                    break;
                case "3":
                    System.out.println("");
                    break;
                default:
                    System.out.println("Solo opciones del 1 al 3");
                    
            }
        }
    }
}

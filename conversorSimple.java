import java.io.IOException;
import java.util.Scanner;

public class conversorSimple {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        tiposMonedas tipos;

        try {
            tipos = new tiposMonedas(); // obtiene tasas desde la API

            while (true) {
                System.out.println("\nBienvenido al conversor de monedas de johan");
                System.out.println("1 - pasamos de : Dólar a ARS");
                System.out.println("2 - pasamos de : ARS a Dólar");
                System.out.println("3 - pasamos de : Dólar a BRL");
                System.out.println("4 - pasamos de : BRL a Dólar");
                System.out.println("Escriba 'salir' para terminar.");
                System.out.print("Ingrese una opción que sea valida: ");
                String opcion = scanner.nextLine();

                if (opcion.equalsIgnoreCase("salir")) {
                    System.out.println("¡Gracias por usar el conversor!");
                    break;
                }

                System.out.print("Ingrese el monto: ");
                double monto = Double.parseDouble(scanner.nextLine());

                double resultado = 0;
                switch (opcion) {
                    case "1":
                        resultado = monto * tipos.obtenerTasa("ARS");
                        System.out.println(monto + " USD = " + resultado + " ARS");
                        break;
                    case "2":
                        resultado = monto / tipos.obtenerTasa("ARS");
                        System.out.println(monto + " ARS = " + resultado + " USD");
                        break;
                    case "3":
                        resultado = monto * tipos.obtenerTasa("BRL");
                        System.out.println(monto + " USD = " + resultado + " BRL");
                        break;
                    case "4":
                        resultado = monto / tipos.obtenerTasa("BRL");
                        System.out.println(monto + " BRL = " + resultado + " USD");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Error al obtener los datos: " + e.getMessage());
        }
    }
}


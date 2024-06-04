package LanzarAplicacion;

import Conexion.ConectarAPI;
import CreadorDeArchivos.CrearArchivos;
import GuardarDatosAplicacion.GuardarDatos;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        //Variables
        Scanner keyboard = new Scanner(System.in);
        DecimalFormat formatador = new DecimalFormat("#.##");
        boolean trueFalse = true;
        double conversion;
        double guardarCalculo;
        GuardarDatos guardar;
        List<GuardarDatos> guardarDatos = new ArrayList<>();
        Map<String, Double> monedas;
        CrearArchivos archivo;
        

        //Instanciar a la API.
        ConectarAPI conectarApi = new ConectarAPI();

        //Iniciar el programa
        while(trueFalse){
            System.out.println("""
                    Bienvenido al conversor de monedas\n
                    **********************************
                    1) Peso Dominicano a Dolar Estadounidense
                    2) Dolar Estadounidense a Peso Dominicano
                    3) Peso Dominicano a Euros
                    4) Euro a Peso Dominicano
                    5) Salir
                    **********************************
                    """);
            System.out.println("Cual opcion elige?");
            int opcion = keyboard.nextInt();
            switch (opcion){
                case 1:
                    System.out.print("Que valor desea convertir: ");
                    conversion = keyboard.nextDouble();
                    monedas =  conectarApi.obtenerApi("DOP").conversion_rates();
                    guardarCalculo = Double.parseDouble(formatador.format(conversion * monedas.get("USD")));
                    System.out.println("El equivalente en dolares es: " + guardarCalculo+" USD");
                    guardar = new GuardarDatos("Peso Dominicano a Dolar", "USD", "DOP",conversion, guardarCalculo);
                    guardarDatos.add(guardar);
                    break;
                case 2:
                    System.out.print("Que valor desea convertir:  ");
                    conversion = keyboard.nextDouble();
                    monedas =  conectarApi.obtenerApi("USD").conversion_rates();
                    guardarCalculo = Double.parseDouble(formatador.format(conversion * monedas.get("DOP")));
                    System.out.println("El equivalente en pesos dominicanos es: " +guardarCalculo+" DOP");
                    guardar = new GuardarDatos("Dolar a Peso Dominicano", "DOP", "USD",conversion, guardarCalculo);
                    guardarDatos.add(guardar);
                    break;
                case 3:
                    System.out.print("Que valor desea convertir:  ");
                    conversion = keyboard.nextDouble();
                    monedas =  conectarApi.obtenerApi("DOP").conversion_rates();
                    guardarCalculo = Double.parseDouble(formatador.format(conversion * monedas.get("EUR")));
                    System.out.println("El equivalente en Euros es: " + guardarCalculo+" EUR");
                    guardar = new GuardarDatos("Peso Dominicano a Euro", "EUR", "DOP",conversion, guardarCalculo);
                    guardarDatos.add(guardar);
                    break;
                case 4:
                    System.out.print("Que valor desea convertir:  ");
                    conversion = keyboard.nextDouble();
                    monedas =  conectarApi.obtenerApi("EUR").conversion_rates();
                    guardarCalculo = Double.parseDouble(formatador.format(conversion * monedas.get("DOP")));
                    System.out.println("El equivalente en pesos dominicanos es: " + guardarCalculo+" DOP");
                    guardar = new GuardarDatos("Euro a Peso Dominicano", "DOP", "EUR",conversion, guardarCalculo);
                    guardarDatos.add(guardar);
                    break;
                default:
                    trueFalse = false;
            }
        }
        System.out.println(guardarDatos);
        archivo = new CrearArchivos(guardarDatos);
    }
}

package LanzarAplicacion;

import Conexion.ConectarAPI;
import CreadorDeArchivos.CrearArchivos;
import GuardarDatosAplicacion.GuardarDatos;

import java.text.DecimalFormat;
import java.time.LocalTime;
import java.util.*;

public class dependencia {
    //Lo se, esto es una mala practica
    //Aqui agrupe todas las variables
    //Esta clase dependencia hara casi toda la parte logica de la aplicacion
    private String lanzador;
    Scanner teclado = new Scanner(System.in);
    DecimalFormat formatador = new DecimalFormat("#.##");
    double conversion;
    GuardarDatos guardar;
    List<GuardarDatos> guardarDatos = new ArrayList<>();
    Map<String, Double> monedas;
    CrearArchivos archivar;
    ConectarAPI conectarApi = new ConectarAPI();
    double guardarCalculo;



    //Aqui se selecciona una opcion y se hacen los calculos correspondientes.
    public String lanzar(int opcion) {
            System.out.print("Que valor desea convertir: ");
            //Este while es por si el usuario no ingresa un numero.
            //De esa manera me evito usar un exepcion y tener que agregar mas complejidad.
            while(!teclado.hasNextDouble()){
                System.out.print("Que valor desea convertir: ");
                teclado.next();
            }
            conversion = teclado.nextDouble();

            //Variable para guardar el tiempo
            LocalTime localTime = LocalTime.now();
            String tiempo = String.valueOf(localTime);
            switch (opcion) {
                case 1:
                    monedas = conectarApi.obtenerApi("DOP").conversion_rates();
                    guardarCalculo = Double.parseDouble(formatador.format(conversion * monedas.get("USD")));
                    guardar = new GuardarDatos("Peso Dominicano a Dolar", "USD", "DOP", conversion, guardarCalculo, tiempo);
                    guardarDatos.add(guardar);
                    lanzador = "\nEl equivalente en dolares es: " + guardarCalculo + " USD\n";
                    break;
                case 2:
                    monedas = conectarApi.obtenerApi("USD").conversion_rates();
                    guardarCalculo = Double.parseDouble(formatador.format(conversion * monedas.get("DOP")));
                    guardar = new GuardarDatos("Dolar a Peso Dominicano", "DOP", "USD", conversion, guardarCalculo, tiempo);
                    guardarDatos.add(guardar);
                    lanzador = "\nEl equivalente en pesos dominicanos es: " + guardarCalculo + " DOP\n";
                    break;
                case 3:
                    monedas = conectarApi.obtenerApi("DOP").conversion_rates();
                    guardarCalculo = Double.parseDouble(formatador.format(conversion * monedas.get("EUR")));
                    guardar = new GuardarDatos("Peso Dominicano a Euro", "EUR", "DOP", conversion, guardarCalculo, tiempo);
                    guardarDatos.add(guardar);
                    lanzador = "\nEl equivalente en Euros es: " + guardarCalculo + " EUR\n";
                    break;
                case 4:
                    monedas = conectarApi.obtenerApi("EUR").conversion_rates();
                    guardarCalculo = Double.parseDouble(formatador.format(conversion * monedas.get("DOP")));
                    guardar = new GuardarDatos("Euro a Peso Dominicano", "DOP", "EUR", conversion, guardarCalculo, tiempo);
                    guardarDatos.add(guardar);
                    lanzador = "\nEl equivalente en pesos dominicanos es: " + guardarCalculo + " DOP\n";
                    break;
                default:
                    lanzador = "El programa procedera a cerrarse\n";
            }
            //LLamar a la clase GuardarDatos para crear el archivo.
                archivar = new CrearArchivos(guardarDatos);
                return lanzador;
        }
}
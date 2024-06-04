package CreadorDeArchivos;
import GuardarDatosAplicacion.GuardarDatos;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CrearArchivos {
    //Crear el objeto clase Gson
    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE) //Para que no diferencie entre mays y minus.
            .setPrettyPrinting() //Pa' que lo imprima bonito el json
            .create(); //Para crear el objeto, aunque aun no entiendo bien los patrones de dise;o
    public CrearArchivos(List<GuardarDatos> guardarDatos){
        try{
            //Aqui se esta crean el archivo
            FileWriter createJson = new FileWriter("monedas.json");
            createJson.write(gson.toJson(guardarDatos));
            createJson.close();
        }catch(IOException e) {
            throw new RuntimeException(e);
        }

    }
}



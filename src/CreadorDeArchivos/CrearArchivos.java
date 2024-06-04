package CreadorDeArchivos;

import GuardarDatosAplicacion.GuardarDatos;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CrearArchivos {
    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();
    public CrearArchivos(List<GuardarDatos> guardarDatos) throws IOException {
        FileWriter escritura = new FileWriter("monedas.json");
        escritura.write(gson.toJson(guardarDatos));
        escritura.close();
    }
}



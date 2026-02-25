package com.bar.karaoke;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
// ESTA LÍNEA ES LA QUE QUITA EL ERROR DE LA CONSOLA
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class KaraokeController {

    private List<Peticion> listaPeticiones = new ArrayList<>();

    @PostMapping("/pedir")
    public String pedirCancion(@RequestBody Peticion nuevaPeticion) {
        listaPeticiones.add(nuevaPeticion);
        return "OK";
    }

    @GetMapping("/lista")
    public List<Peticion> verLista() {
        return listaPeticiones;
    }
}


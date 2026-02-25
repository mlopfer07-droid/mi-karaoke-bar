package com.bar.karaoke;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class KaraokeController {

    private List<String> listaPeticiones = new ArrayList<>();

    @PostMapping("/pedir")
    public String recibirCancion(@RequestBody Peticion peticion) {
        String registro = "🎤 " + peticion.getNombre() + " quiere cantar: " + peticion.getCancion();
        listaPeticiones.add(registro);
        System.out.println("NUEVA PETICIÓN EN EL BAR: " + registro);
        return "OK";
    }

    @GetMapping("/lista")
    public List<String> verLista() {
        return listaPeticiones;
    }
}
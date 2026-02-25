package com.example.demo;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class KaraokeController {
    private List<Peticion> listaPeticiones = new ArrayList<>();

    @PostMapping("/pedir")
    public String pedirCancion(@RequestBody Peticion p) {
        listaPeticiones.add(p);
        return "OK";
    }

    @GetMapping("/lista")
    public List<Peticion> verLista() {
        return listaPeticiones;
    }
}

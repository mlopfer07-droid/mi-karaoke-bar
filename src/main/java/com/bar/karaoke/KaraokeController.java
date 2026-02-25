package com.example.demo; // IMPORTANTE: Si tu paquete se llama diferente, cambia esta línea

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
/* El CrossOrigin permite que tu HTML (que está en tu ordenador) 
   pueda hablar con el servidor (que está en Render) 
*/
@CrossOrigin(origins = "*") 
public class KaraokeController {

    // Aquí se guardan las canciones mientras el servidor esté encendido
    private List<Peticion> listaPeticiones = new ArrayList<>();

    // 1. RECIBIR PEDIDO: El @RequestBody es la clave para que NO salgan rayas (---)
    @PostMapping("/pedir")
    public String pedirCancion(@RequestBody Peticion nuevaPeticion) {
        // Añadimos la canción a la lista
        listaPeticiones.add(nuevaPeticion);
        
        // Esto saldrá en la consola de Render para avisarte
        System.out.println("Canción recibida: " + nuevaPeticion.getNombre());
        
        return "¡Canción enviada correctamente!";
    }

    // 2. CONSULTAR LISTA: Esto es lo que lee tu admin.html cada 5 segundos
    @GetMapping("/lista")
    public List<Peticion> verLista() {
        return listaPeticiones;
    }

    // 3. LIMPIAR LISTA: Si entras en tu-url.render.com/limpiar se borra todo
    @GetMapping("/limpiar")
    public String limpiarLista() {
        listaPeticiones.clear();
        return "La lista ha sido vaciada.";
    }
}

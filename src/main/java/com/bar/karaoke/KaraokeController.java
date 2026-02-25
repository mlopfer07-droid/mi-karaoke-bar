@RestController
@CrossOrigin(origins = "*") // <--- AÑADE ESTO
public class KaraokeController {
    
    // ... tu lista ...

    @PostMapping("/pedir")
    public String pedirCancion(@RequestBody Peticion p) { // <--- AÑADE EL @RequestBody
        listaPeticiones.add(p);
        return "OK";
    }
}

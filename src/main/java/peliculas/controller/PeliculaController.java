package peliculas.controller;

import peliculas.model.Pelicula;
import peliculas.service.PeliculaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {

    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping
    public List<Pelicula> listarPeliculas() {
        return peliculaService.listarPeliculas();
    }

    @GetMapping("/{id}")
    public Pelicula obtenerPelicula(@PathVariable Long id) {
        return peliculaService.obtenerPeliculaPorId(id);
    }

    @PostMapping
    public Pelicula guardarPelicula(@RequestBody Pelicula pelicula) {
        return peliculaService.guardarPelicula(pelicula);
    }

    @PutMapping("/{id}")
    public Pelicula actualizarPelicula(@PathVariable Long id,
                                       @RequestBody Pelicula pelicula) {
        return peliculaService.actualizarPelicula(id, pelicula);
    }

    @DeleteMapping("/{id}")
    public void eliminarPelicula(@PathVariable Long id) {
        peliculaService.eliminarPelicula(id);
    }
}
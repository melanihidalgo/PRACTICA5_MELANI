package peliculas.service;

import peliculas.model.Pelicula;
import peliculas.repository.PeliculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService {

    private final PeliculaRepository peliculaRepository;

    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public List<Pelicula> listarPeliculas() {
        return peliculaRepository.findAll();
    }

    public Pelicula guardarPelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    public Pelicula obtenerPeliculaPorId(Long id) {
        return peliculaRepository.findById(id).orElse(null);
    }

    public Pelicula actualizarPelicula(Long id, Pelicula pelicula) {
        Pelicula peliculaExistente = peliculaRepository.findById(id).orElse(null);

        if (peliculaExistente != null) {
            peliculaExistente.setTitulo(pelicula.getTitulo());
            peliculaExistente.setDirector(pelicula.getDirector());
            peliculaExistente.setAnioLanzamiento(pelicula.getAnioLanzamiento());
            peliculaExistente.setGenero(pelicula.getGenero());
            peliculaExistente.setSinopsis(pelicula.getSinopsis());

            return peliculaRepository.save(peliculaExistente);
        }

        return null;
    }

    public void eliminarPelicula(Long id) {
        peliculaRepository.deleteById(id);
    }
}
package nl.novi.backendspringbootvinylshopcontroller.controllers;

import nl.novi.backendspringbootvinylshopcontroller.entities.Genre;
import nl.novi.backendspringbootvinylshopcontroller.services.GenreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public List<Genre> getAllGenres() {
        return genreService.findAllGenres();
    }

    @GetMapping("/{id}")
    public Genre getGenreById(@PathVariable Long id) {
        return genreService.findGenreById(id);
    }

    @PostMapping
    public Genre createGenre(@RequestBody Genre genreInput) {
        return genreService.createGenre(genreInput);
    }

    @PutMapping("/{id}")
    public Genre updateGenre(@PathVariable Long id, @RequestBody Genre genreInput) {
        return genreService.updateGenre(id, genreInput);
    }

    @DeleteMapping("/{id}")
    public void deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
    }
}

package nl.novi.backendspringbootvinylshopcontroller.controllers;

import nl.novi.backendspringbootvinylshopcontroller.entities.GenreEntity;
import nl.novi.backendspringbootvinylshopcontroller.services.GenreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;

    }

    @GetMapping
    public ResponseEntity<List<GenreEntity>> getAllGenres() {
        var genres = genreService.findAllGenres();
        return ResponseEntity.ok(genres);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreEntity> getGenreById(@PathVariable Long id) {
        var genre = genreService.findGenreById(id);
        return new ResponseEntity<>(genre, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GenreEntity> createGenre(@RequestBody GenreEntity genreInput) {
        GenreEntity savedGenre = genreService.createGenre(genreInput);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/"+savedGenre.getId()).build().toUriString());
        return ResponseEntity.created(uri).body(savedGenre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenreEntity> updateGenre(@PathVariable Long id, @RequestBody GenreEntity genreInput) {
        var updatedGenre = genreService.updateGenre(id, genreInput);
        return new ResponseEntity<>(updatedGenre, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

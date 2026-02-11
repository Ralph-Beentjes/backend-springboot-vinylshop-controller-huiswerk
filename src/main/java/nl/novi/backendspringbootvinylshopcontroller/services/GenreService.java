package nl.novi.backendspringbootvinylshopcontroller.services;

import nl.novi.backendspringbootvinylshopcontroller.entities.GenreEntity;
import nl.novi.backendspringbootvinylshopcontroller.repositories.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<GenreEntity> findAllGenres() {
        return genreRepository.findAll();
    }

    public GenreEntity findGenreById(Long id) {
        return genreRepository.findById(id).orElseThrow(()-> new RuntimeException("Genre not found"));
    }

    public GenreEntity createGenre(GenreEntity genre) {
        return genreRepository.save(genre);
    }

    public GenreEntity updateGenre(Long id, GenreEntity genreInput){
        GenreEntity existingGenre = findGenreById(id);
        if (existingGenre != null) {
            existingGenre.setDescription(genreInput.getDescription());
            existingGenre.setName(genreInput.getName());
            return genreRepository.save(existingGenre);
        } else {
            throw new RuntimeException("Genre not found");
        }
    }

    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }

}


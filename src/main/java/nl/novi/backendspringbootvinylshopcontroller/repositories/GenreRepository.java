package nl.novi.backendspringbootvinylshopcontroller.repositories;

import nl.novi.backendspringbootvinylshopcontroller.entities.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository <GenreEntity, Long> {
}

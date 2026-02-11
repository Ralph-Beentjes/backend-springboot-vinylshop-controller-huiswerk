package nl.novi.backendspringbootvinylshopcontroller.repositories;

import nl.novi.backendspringbootvinylshopcontroller.entities.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository <PublisherEntity, Long> {
}

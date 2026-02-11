package nl.novi.backendspringbootvinylshopcontroller.services;

import nl.novi.backendspringbootvinylshopcontroller.entities.PublisherEntity;
import nl.novi.backendspringbootvinylshopcontroller.repositories.PublisherRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<PublisherEntity> findAllPublishers() {
        return publisherRepository.findAll();
    }

    public PublisherEntity findPublisherById(Long id) {
        return publisherRepository.findById(id).orElseThrow(()-> new RuntimeException("Publisher not found"));
    }

    public PublisherEntity createPublisher(PublisherEntity publisher) {
        return publisherRepository.save(publisher);
    }

    public PublisherEntity updatePublisher(Long id, PublisherEntity publisher) {
        PublisherEntity updatedPublisher = findPublisherById(publisher.getId());
        if (updatedPublisher != null) {
            updatedPublisher.setName(publisher.getName());
            updatedPublisher.setAddress(publisher.getAddress());
            updatedPublisher.setContactDetails(publisher.getContactDetails());
            return publisherRepository.save(updatedPublisher);
        } else  {
            throw new RuntimeException("Publisher not found");
        }
    }

    public void deletePublisher(Long id) {
        publisherRepository.deleteById(id);
    }
}

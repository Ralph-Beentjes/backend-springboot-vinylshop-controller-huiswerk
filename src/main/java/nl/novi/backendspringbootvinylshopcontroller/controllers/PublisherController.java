package nl.novi.backendspringbootvinylshopcontroller.controllers;

import nl.novi.backendspringbootvinylshopcontroller.entities.GenreEntity;
import nl.novi.backendspringbootvinylshopcontroller.entities.PublisherEntity;
import nl.novi.backendspringbootvinylshopcontroller.services.PublisherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping
    public ResponseEntity<List<PublisherEntity>> getAllPublishers(){
        var publishers = publisherService.findAllPublishers();
        return ResponseEntity.ok(publishers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherEntity> getPublisherById(@PathVariable Long id) {
        var genre = publisherService.findPublisherById(id);
        return new ResponseEntity<>(genre, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PublisherEntity> createPublisher(@RequestBody PublisherEntity publisherInput) {
        PublisherEntity savedPublisher = publisherService.createPublisher(publisherInput);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/"+savedPublisher.getId()).build().toUriString());
        return ResponseEntity.created(uri).body(savedPublisher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublisherEntity> updatePublisher(@PathVariable Long id, @RequestBody PublisherEntity publisherInput) {
        var updatedPublisher = publisherService.updatePublisher(id, publisherInput);
        return new ResponseEntity<>(updatedPublisher, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublisher(@PathVariable Long id) {
        publisherService.deletePublisher(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

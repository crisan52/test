package cr.com.ufinet.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cr.com.ufinet.test.model.Bird;
import cr.com.ufinet.test.service.BirdService;

@RestController
@CrossOrigin
public class BirdController {

  @Autowired
  private BirdService birdService;

  // Insert a bird into database
  @PostMapping("/bird")
  public ResponseEntity<Bird> saveBird(@RequestBody Bird bird) {
    Bird savedBird = birdService.saveBird(bird);
    return new ResponseEntity<>(savedBird, HttpStatus.CREATED);
  }

  // Get a bird by id
  @GetMapping("/bird")
  public ResponseEntity<Bird> getBird(@RequestParam(name = "id") int id) {
    Bird bird = birdService.getBird(id);
    return new ResponseEntity<>(bird, HttpStatus.OK);
  }

  // Get all the birds registered
  @GetMapping("/birds")
  public List<Bird> getBirds() {
    return birdService.getBirds();
  }

  // Update an existing bird
  @PatchMapping("/bird")
  public ResponseEntity<Bird> updateBird(@RequestParam(name = "id") int id, @RequestBody Bird bird) {
    Bird updatedBird = birdService.updateBird(id, bird);
    return new ResponseEntity<>(updatedBird, HttpStatus.OK);
  }

  // Delete an existing bird
  @DeleteMapping("/bird")
  public ResponseEntity<Bird> deleteBird(@RequestParam(name = "id") int id) {
    Bird deletedBird = birdService.deletebird(id);
    return new ResponseEntity<>(deletedBird, HttpStatus.OK);
  }

  // Get birds by Category
  @GetMapping("/birds-by-category")
  public List<Bird> getBirdsByCategory(@RequestParam(name = "category") String category) {
    return birdService.getBirdsByCategory(category);
  }

}
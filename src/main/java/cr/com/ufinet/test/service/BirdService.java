package cr.com.ufinet.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.com.ufinet.test.model.Bird;
import cr.com.ufinet.test.repository.BirdRepository;

@Service
public class BirdService {

  @Autowired
  private BirdRepository birdRepository;

  public Bird saveBird(Bird bird) {
    return birdRepository.save(bird);
  }

  public Bird getBird(int id) {
    return birdRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
  }

  public List<Bird> getBirds() {
    return birdRepository.findAll();
  }

  public Bird updateBird(int id, Bird bird) {
    Bird existingBird = birdRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    existingBird.setName(bird.getName());
    existingBird.setCategory(bird.getCategory());
    birdRepository.save(existingBird);
    return existingBird;
  }

  public Bird deletebird(int id) {
    Bird existingBird = birdRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    birdRepository.deleteById(id);
    return existingBird;
  }

  public List<Bird> getBirdsByCategory(String category) {
    return birdRepository.getBirdsByCategory(category);
  }
}

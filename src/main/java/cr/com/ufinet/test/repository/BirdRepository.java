package cr.com.ufinet.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cr.com.ufinet.test.model.Bird;

public interface BirdRepository extends JpaRepository<Bird, Integer> {
  @Query(value = "SELECT * FROM bird WHERE category = ?1", nativeQuery = true)
  List<Bird> getBirdsByCategory(String category);
}
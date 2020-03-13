package tech.gigant.his.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.gigant.his.domain.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}

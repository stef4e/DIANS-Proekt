package app.diansproekt.repository;

import app.diansproekt.model.Lokal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaLokalRepository extends JpaRepository<Lokal, Long> {

    Lokal findByName(String name);

}

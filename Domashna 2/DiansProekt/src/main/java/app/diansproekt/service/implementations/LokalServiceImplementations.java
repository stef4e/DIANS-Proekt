package app.diansproekt.service.implementations;

import app.diansproekt.model.Lokal;
import app.diansproekt.repository.JpaLokalRepository;
import app.diansproekt.service.LokalService;
import org.springframework.stereotype.Service;

@Service
public class LokalServiceImplementations implements LokalService {

    JpaLokalRepository jpaLokalRepository;

    public LokalServiceImplementations(JpaLokalRepository jpaLokalRepository) {
        this.jpaLokalRepository = jpaLokalRepository;
    }

    @Override
    public Lokal findByName(String name) {
        return jpaLokalRepository.findByName(name);
    }
}

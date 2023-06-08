package ucao.api.Ega.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucao.api.Ega.entity.Compte;

import java.util.List;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Integer> {
    List<Compte> findByClientId(Integer client_id);
}

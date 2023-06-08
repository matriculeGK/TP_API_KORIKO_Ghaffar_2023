package ucao.api.Ega.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucao.api.Ega.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}

package ucao.api.Ega.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ucao.api.Ega.entity.Operation;
import ucao.api.Ega.entity.OperationType;

import java.util.List;

public interface OperationRepository extends JpaRepository<Operation, Integer> {
    List<Operation> findByCompteIdAndType(Integer compte_id, OperationType type);
}

package pl.javastart.equipy.components.assignment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    Optional<Assignment> findByAsset_IdAndEndIsNull(Long assetId);
    /*
    Podkreślenie używane w nazwie metody pozwala odwołać się do zagnieżdzonego pola
    id obiektu Asset zawartego w obiekcie Assignment
    Przykład:
        Assignment assignment = new Assignment();
        Long id = assignment.getAsset().getId();  ← pobranie zagnieżdzonego pola id
        obiektu Asset zawartego w obiekcie Assignment
     */
}

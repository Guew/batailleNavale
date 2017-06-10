package fr.example.bataillenavale.repository;

import org.springframework.data.repository.CrudRepository;

import fr.example.bataillenavale.models.paramPartie.Partie;

public interface PartieRepository extends CrudRepository<Partie, Long> {

}

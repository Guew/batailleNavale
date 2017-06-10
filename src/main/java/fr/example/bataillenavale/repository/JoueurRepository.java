package fr.example.bataillenavale.repository;

import org.springframework.data.repository.CrudRepository;

import fr.example.bataillenavale.models.paramPartie.Joueur;

public interface JoueurRepository extends CrudRepository<Joueur, Long>{

}

package br.com.provazup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.provazup.model.Poi;

public interface IPoiRepository extends JpaRepository<Poi, Long> {

}

package com.darahimoveis.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.darahimoveis.application.model.Foto;

public interface FotoRepository extends JpaRepository<Foto, String>{

}

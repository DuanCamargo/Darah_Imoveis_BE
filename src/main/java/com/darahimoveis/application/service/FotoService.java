package com.darahimoveis.application.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.darahimoveis.application.model.Foto;
import com.darahimoveis.application.repository.FotoRepository;

@Service
public class FotoService {
	
	@Autowired
	FotoRepository fotoRepository;
	
	public void save(String descricao, MultipartFile file){	
		Foto foto = new Foto();
		foto.setDescricao_foto(descricao);;
		
		Byte[] byteObjects;
		try {
			byteObjects = new Byte[file.getBytes().length];
			int i = 0;
			for (byte b : file.getBytes()) {
				byteObjects[i++] = b;
			}
			foto.setFoto(byteObjects);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		fotoRepository.save(foto);
			
	}
	// criar um get findAllById
	public List<Foto> findAll(){
		List<Foto> fotos = fotoRepository.findAll();
		return fotos;
	}
}

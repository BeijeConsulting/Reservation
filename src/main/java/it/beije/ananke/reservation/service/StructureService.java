package it.beije.ananke.reservation.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.ananke.reservation.model.Structure;
import it.beije.ananke.reservation.repository.StructureRepository;

@Service
public class StructureService {
@Autowired
private StructureRepository structureRepository;

public Structure addStructure(Structure structure) {
	return structureRepository.save(structure);
}
public Structure getStructure(Integer id) {
	return structureRepository.findById(id).get();
	
}
public void removeStructure(Integer id) {
	 structureRepository.deleteById(id);
}

}

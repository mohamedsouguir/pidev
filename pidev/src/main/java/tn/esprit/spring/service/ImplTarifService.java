package tn.esprit.spring.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Child;
import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.entity.Tarif;

@Service
public class ImplTarifService implements TarifService {

	Tarif tarif;

	public List<Child> RemiseParEnfant(Parent parent) {
		
		List<Child> children = parent.getChild();
		// Iterator<Child> childrenIterator = children.iterator();
		if (parent.getKidsNumber() > 1) {
			// tri des enfants selon l'age
			Collections.sort(children, Comparator.comparingInt(Child::getAge));
			// la remise ne sera pas appliquée sur le premier enfant
			int i = 0;
			for (Child child : children) {
				if (i == 0) {
					tarif = new Tarif();
					tarif.setNouveauTarif(tarif.getPrixfixe());
					System.out.println("the normal tarif"+tarif.getNouveauTarif());
					child.setTarif(tarif);
				}
				
				if (i >= 1) {
					tarif = new Tarif();
					tarif.setNouveauTarif(tarif.getPrixfixe() - tarif.getPrixfixe() * tarif.getPrixpourcentage());
					child.setTarif(tarif);
				}
				i++;
			}

		}

		System.out.println("My new Result" + parent.getChild());
		return parent.getChild();

	}
	
	
	

}

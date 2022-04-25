package com.recrutement;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.recrutement.entities.Categorie;
import com.recrutement.entities.offre;
import com.recrutement.repositories.offreRepository;

@SpringBootTest
class RecrutementApiApplicationTests {

	
	@Test
	public void findByCategorieIdCat()
	{
	List<offre> prods;
		prods = offreRepository.findByCategorieIdCat(1L);
	for (offre p : prods)
	{
	System.out.println(p);
	}
	}

}

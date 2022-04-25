package com.recrutement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.recrutement.entities.Application;
import com.recrutement.entities.candidat;
import com.recrutement.entities.offre;
import com.recrutement.repositories.candidatRepository;
import com.recrutement.repositories.offreRepository;

@CrossOrigin(origins = "*")
@RestController
public class applicationController {
	@Autowired com.recrutement.services.applicationServiceImpl applicationServ ;
	
	@Autowired candidatRepository candidatRepo ;
	
	@Autowired offreRepository offreRepo ;
	@Autowired
	private JavaMailSender javaMailSender;
	
	public static String providersDirectory = System.getProperty("user.dir")+"/src/main/resources/static/uploads";

	
	@PostMapping("/application/{id_offre}/{id_cand}/{email}")
	   public ResponseEntity<Application> addApplication(@PathVariable(value = "id_cand") Long candidatId,
			   @PathVariable(value = "id_offre") Long offreId,
			   @PathVariable ("email") String email ,
			   @RequestBody Application applicationRequest){
			
			candidat c =candidatRepo.findById(candidatId).get();
				applicationRequest.setCandidat(c);
			 offre o =offreRepo.findById(offreId).get();
				applicationRequest.setOffre(o);
				Application app =applicationServ.saveApplication(applicationRequest);
				sendEmail(email, true);
		        return new ResponseEntity<>(app, HttpStatus.CREATED);
	}
	
	void sendEmail(String email, boolean state) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(email);
		if(state == true)
		{
		msg.setSubject("New application");
		msg.setText("Hello, someone has applied for your offre. "
		+
		"\n Go check it on our website "
		+ " \n Best Regards!");
		}
		else
		{
		msg.setSubject("Account Has Been disactivated");
		msg.setText("Hello, Your account has been disactivated.");
		}
		javaMailSender.send(msg);
		}
}

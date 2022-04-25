package com.recrutement.services;

import java.util.List;

import com.recrutement.entities.Application;

public interface applicationService {
	Application saveApplication(Application a) ;
	Application updateApplication(Application a);
	void deleteApplicationById(Long id);
	Application getAppplication(Long id);
	List<Application> getAllApplications();
}

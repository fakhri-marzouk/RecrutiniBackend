package com.recrutement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrutement.entities.Application;
import com.recrutement.repositories.applicationRepository;

@Service
public class applicationServiceImpl implements applicationService {
	@Autowired applicationRepository  applicationRepo ;
	@Override
	public Application saveApplication(Application a) {
		
		return applicationRepo.save(a);
	}

	@Override
	public Application updateApplication(Application o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteApplicationById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Application getAppplication(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Application> getAllApplications() {
		// TODO Auto-generated method stub
		return null;
	}

		
}

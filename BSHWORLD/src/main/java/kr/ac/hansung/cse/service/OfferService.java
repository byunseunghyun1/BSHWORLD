package kr.ac.hansung.cse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.cse.dao.OfferDao;
import kr.ac.hansung.cse.model.Offer;

@Service
public class OfferService {

	@Autowired
	private OfferDao offerDao;
	
	public List<Offer> getCurrent(){
		
		return offerDao.getOffer();
		
	}
	
	
public List<Offer> getCurrent1(){
		
		return offerDao.getOffer1();
		
	}

public List<Offer> getCurrent2(){
	
	return offerDao.getOffer2(2021);
	
}

	public void insert(Offer offer) {
		offerDao.insert(offer);
		
	}
	


	

	
}

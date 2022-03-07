package kr.ac.hansung.cse.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.hansung.cse.model.Offer;
import kr.ac.hansung.cse.service.OfferService;

@Controller
public class OfferController {

	
	@Autowired
	private OfferService offerService; 
	
	@RequestMapping("/offers")
	public String showOffers(Model model)
	{
		List<Offer> offers = offerService.getCurrent();
		model.addAttribute("offers",offers);
		
		return "offers";
		
	}
	
	@RequestMapping("/createoffer")
	public String createOffer(Model model) {
		model.addAttribute("offer",new Offer());
		return "createoffer";
		
	}
	
	@RequestMapping("/apply")
	public String createOffer3(Model model) {
		model.addAttribute("offer",new Offer());
		return "apply";
		
	}
	
	@RequestMapping(value="/detail",method = RequestMethod.GET)
	public String createOffer5(Model model,String learnedyear,String semester) {
		
		List<Offer> offers = offerService.getCurrent1();
		model.addAttribute("offers",offers);
		
		model.addAttribute("learnedyear",learnedyear);
		model.addAttribute("semester",semester);

		return "detail";
			
	}
	
	

	
	@RequestMapping("/applycheck")
	public String createOffer4(Model model) {
		
		List<Offer> offers = offerService.getCurrent1();
		model.addAttribute("offers",offers);
		
		return "applycheck";
		
	}
	

	
	@RequestMapping("/learned")
	public String createOffer2(Model model) {
		model.addAttribute("offer",new Offer());
		
		
		List<Offer> offers = offerService.getCurrent();
		model.addAttribute("offers",offers);
		
		
		
		return "learned";
		
	}
	
	
	
	
	
	@RequestMapping("docreate")
	public String doCreate(Model model,@Valid Offer offer, BindingResult result) {
		//System.out.println(offer);
		
		if(result.hasErrors()) {
			
			System.out.println("=====Form data does not validated ====");
			List<ObjectError> errors =result.getAllErrors();
			for(ObjectError error:errors ) {
				
				System.out.println(error.getDefaultMessage());
			}
			return "apply";
		}
		offerService.insert(offer);
		
		return "offercreated"; 
	}
	
}

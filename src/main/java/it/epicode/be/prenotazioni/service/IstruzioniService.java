package it.epicode.be.prenotazioni.service;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import it.epicode.be.prenotazioni.exception.IstruzioniException;



@Service
@PropertySource("classpath:application.properties")
public class IstruzioniService {
	
	@Value("${gestioneprenotazioni.istruzioniItaliano}")
	private String italiano;
	@Value("${gestioneprenotazioni.istruzioniInglese}")
	private  String english;
	
	public String getIstruzioni(@PathVariable String language) {
		if(language.equals("it")) {
			return italiano;
		}
		else if(language.equals("en")) {
			return english;
		}
		else {
			throw new IstruzioniException("lingua non supportata | unsupported language");
		}
		
	}

}

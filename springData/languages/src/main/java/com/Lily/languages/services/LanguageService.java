package com.Lily.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Lily.languages.models.Language;
import com.Lily.languages.repositories.LanguageRepository;


@Service
public class LanguageService {
	private  LanguageRepository langRepo;
	public LanguageService(LanguageRepository repo) {
		this.langRepo = repo;
	}
// getAll
	public List<Language> allLanguages() {
		return langRepo.findAll();
	}
//Get One by id
	public Language findLanguage(Long id) {
		return this.langRepo.findById(id).orElse(null);
	}
	// createLanguage
	public Language createLanguage(Language newlang) {
		return this.langRepo.save(newlang);
	}
	// updateLanguage
	public Language updateLanguage(Language updatedlang, Long id) {
		if(updatedlang.getId() == null) {
			updatedlang.setId(id);
		}
		return langRepo.save(updatedlang);
	}
	// deleteLanguage
	public void deleteLanguage(Long id) {
		this.langRepo.deleteById(id);
	}
}
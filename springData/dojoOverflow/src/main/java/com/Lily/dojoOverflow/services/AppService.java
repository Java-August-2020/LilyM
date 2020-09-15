package com.Lily.dojoOverflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Lily.dojoOverflow.models.Answer;
import com.Lily.dojoOverflow.models.NewQuestion;
import com.Lily.dojoOverflow.models.Question;
import com.Lily.dojoOverflow.models.Tag;
import com.Lily.dojoOverflow.repositories.AnswerRepository;
import com.Lily.dojoOverflow.repositories.QuestionRepository;
import com.Lily.dojoOverflow.repositories.TagRepository;

@Service
public class AppService {
	private QuestionRepository qRepo;
	private TagRepository tRepo;
	private AnswerRepository aRepo;
	public AppService(QuestionRepository qRepo, AnswerRepository aRepo, TagRepository tRepo) {
		this.qRepo = qRepo;
		this.tRepo = tRepo;
		this.aRepo = aRepo;
	}
	//Display all questions in index.jsp
	public List<Question> getQuestions() {
		return this.qRepo.findAll();
	}
	//Show specific question in show.jsp
	public Question getQuestion(Long id) {
		return this.qRepo.findById(id).orElse(null);
	}
	//Wow -create new Question after validation from model NewQuestion
	public void createQuestion(NewQuestion question) {
		// TODO: make a real question here
		List<Tag> questionsTags = new ArrayList<Tag>();
		for(String subject: question.splitTags()) {
			Tag tag = this.tRepo.findBySubject(subject).orElse(null);
			if(tag == null) {
				tag = new Tag(subject);
				this.tRepo.save(tag);
			}
			// prevent dupe tags
			if(!questionsTags.contains(tag))
				questionsTags.add(tag);
		}
		Question newQuestion = new Question(question.getQuestion(), questionsTags);
		this.qRepo.save(newQuestion);
	}
	//Save new created Answer
	public Answer createAnswer(Answer answer) {
		return this.aRepo.save(answer);
	}
}
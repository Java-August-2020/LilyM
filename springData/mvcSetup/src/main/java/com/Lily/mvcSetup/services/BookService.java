package com.Lily.mvcSetup.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Lily.mvcSetup.models.Book;
import com.Lily.mvcSetup.repositories.BookRepository;


@Service
public class BookService {
    
    // initialize the books variable with values
    private List<Book> books = new ArrayList(Arrays.asList(
            new Book("Harry Potter and the Sorcerer's Stone", "A boy wizard saving the world", "english", 309),
            new Book("The Great Gatsby", "The story primarily concerns the young and mysterious millionaire Jay Gatsby", "english", 180),
            new Book("Moby Dick", "The saga of Captain Ahab", "english", 544),
            new Book("Don Quixote", "Life of a retired country gentleman", "english", 150),
            new Book("The Odyssey", "Ancient Greek epic poem", "english", 475)
            ));
    
    public List<Book> allBooks() {
        return books;
    }
    
    public Book findBookByIndex(int index) {
        if (index < books.size()){
            return books.get(index);
        }else{
            return null;
        }
    }

    public void updateBook(int id, Book book) {
        if (id < books.size()){
            books.set(id, book);
        }
    }
    public void destroyBook(int id) {
        if (id < books.size()){
            books.remove(id);
        }
    }
 //if passed validation-Add Book.  
//    validate and Post -create form  will access data instantiating a new Book type and binding to our view model. 
    public void addBook(Book book) {
        books.add(book);
    }
    
// // updatePet
// 	public Dog updateDog(Long id, Dog updatedDog) {
// 		return this.dRepo.save(updatedDog);
// 	}
// 	
// 	// deletePet
// 	public void deletePet(Long id) {
// 		this.dRepo.deleteById(id);
// 	}
    
    //for controller BooksAPI
				// adding the book repository as a dependency
				private final BookRepository bookRepository;
				 
				 public BookService(BookRepository bookRepository) {
				     this.bookRepository = bookRepository;
				 }
				    // returns all the books
//				    public List<Book> allBooks() {
//				        return bookRepository.findAll();
//				    } 
				    // creates a book
				    public Book createBook(Book b) {
				        return bookRepository.save(b);
				    }
				    // retrieves a book
				    public Book findBook(Long id) {
				        Book otherBook = bookRepository.findById(id).orElse(null);
				        return otherBook;
				            }
    
}
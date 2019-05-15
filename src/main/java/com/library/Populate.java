package com.library;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.repository.repository.dao.BookDao;
import com.library.repository.repository.dao.UserDao;
import com.library.repository.repository.domain.BookEntity;
import com.library.repository.repository.domain.UserEntity;

@Component
public class Populate {

	
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private UserDao userDao;
	
	public void initData() {		
		BookEntity bookEntity1 = createBookEntity("Tessa is a good girl with a sweet, reliable boyfriend back home. She's got direction, ambition, and a mother who's intent on keeping her that way. But she's barely moved into her freshman dorm when she runs into Hardin. With his tousled brown hair, cocky British accent, and tattoos, Hardin is cute and different from what she's used to. ", "After - Film Tie-In", LocalDateTime.now(), 1, "Anna Todd");		
		BookEntity bookEntity2 = createBookEntity("There was the time before Tessa met Hardin, and then there's everything AFTER Life will never be the same... Tessa is a good girl with a sweet, reliable boyfriend back home. She's got direction, ambition, and a mother who's intent on keeping her that way. ", "After", LocalDateTime.now(), 3, "Anna Todd");
		BookEntity bookEntity3 = createBookEntity("When Jessica Farris signs up for a psychology study conducted by the mysterious Dr. Shields, she thinks all she'll have to do is answer a few questions, collect her money, and leave. But as the questions grow more and more intense and invasive and the sessions become outings where Jess is told what to wear and how to act, she begins to feel as though Dr. Shields may know what she's thinking . . . and what she's hiding.", "An Anonymous Girl", LocalDateTime.now(), 1, "Greer Hendricks - Sarah Pekkanen");
		BookEntity bookEntity4 = createBookEntity("Frida Kahlo (1907-1954), as an artist and a woman, has a unique international appeal. Her instantly recognizable work draws extensively on her life and her extraordinarily personal reflections upon it.", "Frida Kahlo: Making Her Self Up", LocalDateTime.now(), 4, "Circe Henestrosa - Claire Wilcox");
		BookEntity bookEntity5 = createBookEntity("Fixie Farr can't help herself. Straightening a crooked object, removing a barely-there stain, helping out a friend . . . she just has to put things right. It's how she got her nickname, after all. ", "I Owe You One", LocalDateTime.now(), 10, "Circe Henestrosa - Claire Wilcox");
		BookEntity bookEntity6 = createBookEntity("Follow Dorothy, and her loyal dog Toto, as they are carried away from Kansas by a cyclone to the wonderful world of Oz. Wandering down the yellow brick road Dorothy meets her three famous companions - a Scarecrow longing for a brain, a Tin Woodman wishing for a heart, a cowardly Lion yearning for some courage - and together they travel to the...", "The Wizard of Oz", LocalDateTime.now(), 1, "L. Frank Baum");
		BookEntity bookEntity7 = createBookEntity("Billy Milligan was a man tormented by twenty-four distinct personalities battling for supremacy - a battle that culminated when he awoke in jail, arrested for the kidnap and rape of three women. In a landmark trial, Billy was acquitted of his crimes by reason of insanity caused by multiple personality disorder - the first such court decision in history.", "The Minds of Billy Milligan", LocalDateTime.now(), 1, "Daniel Keyes");
		BookEntity bookEntity8 = createBookEntity("`Whitney Scharer's storytelling is utterly immersive and gorgeous in its details . . . This is a powerful, sensual and gripping portrait of the forging of an artist's soul.' Madeleine Miller, author of Circe `I'd rather take a photograph than be one,' says Lee Miller, shortly after she arrives in Paris in 1929. Gorgeous and talented, Lee has left behind a successful modelling career at Vogue to pursue her dream of being an artist. ", "The Age of Light", LocalDateTime.now(), 2, "Whitney Scharer");
		BookEntity bookEntity9 = createBookEntity("66 million years ago the dinosaurs were wiped from the face of the earth. Today, Dr. Steve Brusatte, one of the leading scientists of a new generation of dinosaur hunters, armed with cutting edge technology, is piecing together the complete story of how the dinosaurs ruled the earth for 150 million years.", "The Rise and Fall of the Dinosaurs", LocalDateTime.now(), 2, "Steve Brusatte");
		
		
		bookDao.save(bookEntity1);
		bookDao.save(bookEntity2);
		bookDao.save(bookEntity3);
		bookDao.save(bookEntity4);
		bookDao.save(bookEntity5);
		bookDao.save(bookEntity6);
		bookDao.save(bookEntity7);
		bookDao.save(bookEntity8);
		bookDao.save(bookEntity9);
		
		UserEntity userEntity = new UserEntity();
		
		userEntity.setPassword("user");
		userEntity.setUsername("user");
		
		userDao.save(userEntity);
	}
		
	private BookEntity createBookEntity(String description, String title, LocalDateTime releaseDate, int quantity, String author) {
		BookEntity bookEntity = new BookEntity();
		
		bookEntity.setDescription(description);
		bookEntity.setQuantity(quantity);
		bookEntity.setReleaseDate(releaseDate);
		bookEntity.setTitle(title);
		bookEntity.setAuthor(author);
		
		return bookEntity;
	}
	
}

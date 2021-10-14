/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclasses;

import entity.Book;
import entity.Author;
import entity.History;
import entity.User;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author User
 */
public class App {
    public void run(){
       // System.out.println("Hello");
        Book book = new Book();
        book.setBookName("Voina i mir");
        book.setReleaseYear(2010);
        Author[] authors = new Author[1];
        Author author = new Author();
        author.setFirstName("Lev");
        author.setLastName("Tolstoy");
        author.setBirthYear(1828);
        authors[0] = author;
        book.setAuthors(authors);
        System.out.printf("Создана книга: %s, автор: %s %s, год издания: %d%n", 
                            book.getBookName(),
                            book.getAuthors()[0].getFirstName(),
                            book.getAuthors()[0].getLastName(),
                            book.getReleaseYear()
                );
        User user = new User();
        user.setFirstName("Daniil");
        user.setLastName("Mozgov");
        user.setTel("+372 4757 4739");
        System.out.printf("Читатель: %s %s, номер телефона: %s%n",
                            user.getFirstName(),
                            user.getLastName(),
                            user.getTel()
                );
        History history = new History();
        history.setBook(book);
        history.setUser(user);
        Calendar c = new GregorianCalendar();
        history.setGivenBook(c.getTime());
        System.out.printf("Читатель %s %s взял читать книгу \"%s\", %s%n",
                            history.getUser().getFirstName(),
                            history.getUser().getLastName(),
                            history.getBook().getBookName(),
                            history.getGivenBook()
                );
        c = new GregorianCalendar();
        history.setReturnBook(c.getTime());
        System.out.printf("Читатель %s %s вернул книгу \"%s\", %s%n",
                            history.getUser().getFirstName(),
                            history.getUser().getLastName(),
                            history.getBook().getBookName(),
                            history.getReturnBook()
                );
    }
}

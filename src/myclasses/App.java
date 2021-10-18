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
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class App {
    private Book[] books = new Book[10];
    private User[] users = new User[10];
    public void run(){
        String repeat = "yes";
        Scanner scanner = new Scanner(System.in);
      do{
          System.out.println("Выбирите номер задачи: ");
          System.out.println("0: Закрыть программу");
          System.out.println("1: Добавить Читателя");
          System.out.println("2: Добавить Книгу");
          System.out.println("3: Вывести список книг");
          System.out.println("4: Выдать книгу читателью");
          System.out.println("5: Список читателей");
          int task = scanner.nextInt(); scanner.nextLine();
          switch (task) {
              case 0:
                  repeat = "no";
                  break;
              case 1:
                  
                  int amountUsers = (scanner.nextInt());scanner.nextLine();
                  User user = new User();
                  for (int i = 0; i < amountUsers; i++) {
                      
                      System.out.print("Введите имя читателя: ");
                      user.setFirstName(scanner.nextLine());
                      System.out.print("Введите фамилию читателя: ");
                      user.setLastName(scanner.nextLine());
                      System.out.print("Введите телефон читателя: ");
                      user.setTel(scanner.nextLine());
                      users[i] = user;
                      System.out.println("Читатель инициирован: "+user.toString());
                  }
                  for (int i = 0; i < users.length; i++) {
                      if (users[i] == null) {
                          users[i] = user;
                          break;
                      }
                  }
                  
                  break;
              case 2:
                  Book book = new Book();
                  System.out.print("Введите имя книги: ");
                  book.setBookName(scanner.nextLine());
                  System.out.print("Введите год выпуска книги: ");
                  book.setReleaseYear(scanner.nextInt());scanner.nextLine();
                  System.out.print("Введите количевсвто авторов : ");
                  int amountAuthors = (scanner.nextInt());scanner.nextLine();
                  Author[] authors = new Author[amountAuthors];
                  for (int i = 0; i < amountAuthors; i++) {
                      Author author = new Author();
                       System.out.print("Введите имя автора книги: "+(i+1)+": ");
                       author.setFirstName(scanner.nextLine());
                       System.out.print("Введите фамилию автора книги: ");
                       author.setLastName(scanner.nextLine());
                       authors[i] = author;
                  }
                  book.setAuthors(authors);
                  for (int i = 0; i < books.length; i++) {
                      if(books[i] == null){
                          books[i] = book;
                          break;
                      }
                  }
                  System.out.println("Книга инициирована: "+book.toString());
                  System.out.println("Автор "+authors.toString());
                  break;
              case 3:
                  System.out.println("Список книг");
                  for (int i = 0; i < books.length; i++) {
                      if (books[i] != null) {
                          System.out.printf("%d. %s. %s. %d.%n",
                                    i+i,
                                    books[i].getBookName(),
                                    Arrays.toString(books[i].getAuthors()),
                                    books[i].getReleaseYear()
                              );
                      }    
                  }
                  break;
              case 4:
                  System.out.println("--------Выдать книгу----------");
                  System.out.println("Список книг: ");
                  for (int i = 0; i < books.length; i++) {
                    if (books[i] != null) {
                          System.out.printf("%d. %s. %s. %d.%n",
                                    i+i,
                                    books[i].getBookName(),
                                    Arrays.toString(books[i].getAuthors()),
                                    books[i].getReleaseYear()
                              );
                      }
                  }
                  System.out.println("Выбирите номер книги: ");
                  int numberBook = scanner.nextInt();scanner.nextLine();
                  
                  System.out.println("--------------");
                  break;
              case 5:
                  System.out.println("Список книг");
                  for (int i = 0; i < users.length; i++) {
                      if (users[i] != null) {
                          System.out.printf("%d. %s. %s. %n. %n",
                                    i+i,
                                    users[i].getFirstName(),
                                    users[i].getLastName(),
                                    users[i].getTel(),
                                    Arrays.toString(users)
                              );
                      }    
                  }
                  break;
              default:
                  System.out.println("Выбирите номер из списка");;
          }
      }while("yes".equals(repeat));
      System.out.println("Bye!");
    }       
}

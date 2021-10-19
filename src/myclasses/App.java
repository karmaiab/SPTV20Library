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
    private Scanner scanner = new Scanner(System.in);
    private Book[] books = new Book[10];
    private User[] users = new User[10];
    private History[] histories = new History[10];
    private Calendar c = new GregorianCalendar();
    public void run(){
        String repeat = "yes";
      do{
          System.out.println("Выбирите номер задачи: ");
          System.out.println("0: Закрыть программу");
          System.out.println("1: Добавить Читателя");
          System.out.println("2: Добавить Книгу");
          System.out.println("3: Вывести список книг");
          System.out.println("4: Выдать книгу читателью");
          System.out.println("5: Вернуть книгу в библиотеку");
          System.out.println("6: Список читателей");
          System.out.println("7: Список выданых книг");
          int task = scanner.nextInt(); scanner.nextLine();
          switch (task) {
              case 0:
                  repeat = "no";
                  break;
              case 1:
                  addUser();
                  break;
              case 2:
                  addBook();
                  break;
              case 3:
                  listBook();
                  break;
              case 4:
                  givenBook();
                  break;
              case 5:
                  returnBook();
                  break;
              case 6:
                  userList();
                  break;
              case 7:
                  givenBookList();
                  break;
              default:
                  System.out.println("Выбирите номер из списка");;
          }
      }while("yes".equals(repeat));
      System.out.println("Bye!");
    } 

    private void addUser() {
        User user = new User();
                  System.out.print("Введите имя читателя: ");
                  user.setFirstName(scanner.nextLine());
                  System.out.print("Введите фамилию читателя: ");
                  user.setLastName(scanner.nextLine());
                  System.out.print("Введите телефон читателя: ");
                  user.setTel(scanner.nextLine());
                  System.out.println("Читатель инициирован: "+user.toString());
                  for (int i = 0; i < users.length; i++) {
                      if (users[i] == null) {
                          users[i] = user;
                          break;
                      }
                  }
                  
    }

    private void addBook() {
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
    }

    private void listBook() {
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
    }

    private void givenBook() {
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
                  System.out.println("Список читателей");
                  for (int i = 0; i < users.length; i++) {
                      if (users[i] != null) {
                          System.out.printf("%d. %s %s. %s%n",
                                    i+i,
                                    users[i].getFirstName(),
                                    users[i].getLastName(),
                                    users[i].getTel()
                              );
                      }    
                  }
                  System.out.println("Введите номер читателья");
                  int numberUser = scanner.nextInt();scanner.nextLine();
                  
                  History history = new History();
                  history.setBook(books[numberBook]);
                  history.setUser(users[numberUser]);
                  Calendar c = new GregorianCalendar();
                  history.setGivenBook(c.getTime());
                  for (int i = 0; i < histories.length; i++) {
                        if(histories[i] == null){
                           histories[i] = history;
                           break;
                        }
                  }
                  System.out.println("--------------");
    }

    private void returnBook() {
        System.out.println("----Возрат книги-----");
                  System.out.println("Список выданых книг");
                  for (int i = 0; i < histories.length; i++) {
                      if(histories[i] != null && histories[i].getReturnBook() == null){
                          System.out.printf("%d. Книгу %s, читает %s %s%n",
                                  i+1,
                                  histories[i].getBook().getBookName(),
                                  histories[i].getUser().getFirstName(),
                                  histories[i].getUser().getLastName()
                          );
                      }
                  }
                  System.out.println("Номер книги пж: ");
                  int numberHistory = scanner.nextInt();scanner.nextLine();
                  c = new GregorianCalendar();
                  histories[numberHistory - 1].setReturnBook(c.getTime());
    }

    private void userList() {
        System.out.println("Список читателей");
                  for (int i = 0; i < users.length; i++) {
                      if (users[i] != null) {
                          System.out.printf("%d. %s %s. %s%n",
                                    i+i,
                                    users[i].getFirstName(),
                                    users[i].getLastName(),
                                    users[i].getTel()
                              );
                      }    
                  }
    }

    private void givenBookList() {
        System.out.println("Список выданых книг");
                  for (int i = 0; i < histories.length; i++) {
                      if(histories[i] != null){
                          System.out.printf("%d. %s %s %d%n",
                                  i+i,
                                  histories[i].getBook().getBookName(),
                                  Arrays.toString(histories[i].getBook().getAuthors()),
                                  histories[i].getBook().getReleaseYear()
                          );
                          
                      }
                  }
    }
    
}

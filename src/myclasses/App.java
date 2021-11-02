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
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import tools.SaverToFiles;

/**
 *
 * @author User
 */
public class App {
    private Scanner scanner = new Scanner(System.in);
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<History> histories = new ArrayList<>();
    private Calendar c = new GregorianCalendar();
    private SaverToFiles saverToFiles = new SaverToFiles();

    
    public App(){
        books = saverToFiles.loadBooks();
        users = saverToFiles.loadUsers();
        histories = saverToFiles.loadHistories();
    }
    
    
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
                  users.add(user);
                  saverToFiles.saveUsers(users);
                  
    }

    private void addBook() {
        Book book = new Book();
                  System.out.print("Введите имя книги: ");
                  book.setBookName(scanner.nextLine());
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
                  System.out.print("Введите год выпуска книги: ");
                  book.setReleaseYear(scanner.nextInt());scanner.nextLine();
                  System.out.println("Введите количество книг");
                  book.setQuantity(scanner.nextInt());scanner.nextLine();
                  book.setCount(book.getQuantity());
                  books.add(book);
                  System.out.println("Книга инициирована: "+book.toString());
                  saverToFiles.saveBooks(books);
                  
    }

    private void listBook() {
        System.out.println("Список книг");
                  for (int i = 0; i < books.size(); i++) {
                      if (books.get(i) != null
                              && books.get(i).getCount() > 0
                              && books.get(i).getCount() < books.get(i).getQuantity() + 1) { 
                           System.out.printf("%d. %s. %s. %d.%n"
                                ,i+1
                                ,books.get(i).getBookName()
                                ,Arrays.toString(books.get(i).getAuthors())
                                ,books.get(i).getReleaseYear()
                            );
                      }else if(books.get(i) != null) {
                          System.out.printf("%d. %s. %s. %d. - all books in hand until: %s%n",
                                    i+1,
                                    books.get(i).getBookName(),
                                    Arrays.toString(books.get(i).getAuthors()),
                                    books.get(i).getReleaseYear(),
                                    showReturnDateBook(books.get(i))
                          );
                  }
    }
    }
    private String showReturnDateBook(Book book){
        LocalDate givenDate = null;
        for (int i = 0; i < histories.size(); i++) {
            if((histories.get(i).getBook().getBookName()).equals(book.getBookName()) && histories.get(i).getReturnBook() == null){
                if (givenDate == null) {
                    givenDate = histories.get(i).getGivenBook().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                }
                if (givenDate.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli() < histories.get(i).getGivenBook().getTime()) {
                    givenDate = histories.get(i).getGivenBook().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                }
            }
        }
        LocalDate returnDateBook = givenDate.plusDays(14);
        return returnDateBook.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        
    }

    private void givenBook() {
        System.out.println("--------Выдать книгу----------");
                  System.out.println("Список книг: ");
                  int n = 0;
                  for (int i = 0; i < books.size(); i++) {
                    if (books.get(i) != null && books.get(i).getCount() > 0) {
                          System.out.printf("%d. %s. %s. %d.%n",
                                    i+1,
                                    books.get(i).getBookName(),
                                    Arrays.toString(books.get(i).getAuthors()),
                                    books.get(i).getReleaseYear()
                              );
                          n++;
                      }
                  }
                  if (n < 1) {
                      System.out.println("Нет книг для чтение");
                      return;
                  }
                  System.out.println("Выбирите номер книги: ");
                  int numberBook = scanner.nextInt();scanner.nextLine();
                  System.out.println("Список читателей");
                  for (int i = 0; i < users.size(); i++) {
                      if (users.get(i) != null) {
                          System.out.printf("%d. %s %s. %s%n",
                                    i+1,
                                    users.get(i).getFirstName(),
                                    users.get(i).getLastName(),
                                    users.get(i).getTel()
                              );
                      }    
                  }
                  System.out.println("Введите номер читателья");
                  int numberUser = scanner.nextInt();scanner.nextLine();
                  History history = new History();
                  history.setBook(books.get(numberBook - 1));
                  history.setUser(users.get(numberUser - 1));
                  Calendar c = new GregorianCalendar();
                  history.setGivenBook(c.getTime());
                  histories.add(history);
                  history.getBook().setCount(history.getBook().getCount() - 1);
                  saverToFiles.saveBooks(books);
                  saverToFiles.saveHistories(histories);
                  System.out.println("--------------");
    }

    private void returnBook() {
        System.out.println("----Возрат книги-----");
                  System.out.println("Список выданых книг");
                  int n = 0;
                  for (int i = 0; i < histories.size(); i++) {
                      //печатаем книгу если она !null, выдана и
                      if(histories.get(i) != null 
                              && histories.get(i).getReturnBook() == null
                              && (
                                    histories.get(i).getBook().getCount()
                                    < histories.get(i).getBook().getQuantity() + 1
                              )
                        ){
                          System.out.printf("%d. Книгу %s, читает %s %s%n",
                                  i+1,
                                  histories.get(i).getBook().getBookName(),
                                  histories.get(i).getUser().getFirstName(),
                                  histories.get(i).getUser().getLastName()
                          );
                          n++;
                      }
                  }
                  System.out.println("Номер книги пж: ");
                  int numberHistory = scanner.nextInt();scanner.nextLine();
                  c = new GregorianCalendar();
                  histories.get(numberHistory - 1).setReturnBook(c.getTime());
//                  histories.get(numberHistory - 1).getBook().setCount(
//                        histories.get(numberHistory - 1)
//                                .getBook()
//                                .getCount() +1
//                  );
                  for (int i = 0; i < books.size(); i++) {
                      if (books.get(i).getBookName().equals(histories.get(numberHistory - 1).getBook().getBookName())) {
                          books.get(i).setCount(books.get(i).getCount() + 1);
                          break;
                      }
        }
                  saverToFiles.saveBooks(books);
                  saverToFiles.saveHistories(histories);
    }

    private void userList() {
        System.out.println("Список читателей");
                  for (int i = 0; i < users.size(); i++) {
                      if (users.get(i) != null) {
                          System.out.printf("%d. %s %s. %s%n",
                                    i+1,
                                    users.get(i).getFirstName(),
                                    users.get(i).getLastName(),
                                    users.get(i).getTel()
                              );
                      }    
                  }
    }

    private boolean givenBookList() {
        System.out.println("Список выданых книг");
        int n = 0;
                  for (int i = 0; i < histories.size(); i++) {
                      if(histories.get(i) != null 
                              && histories.get(i).getReturnBook() == null
                              &&(
                                    histories.get(i).getBook().getCount() 
                                    < histories.get(i).getBook().getQuantity()+1
                              ) 
                              
                              ){
                          System.out.printf("%d. the book: \"%s\" is reading:%s %s%n",
                                  i+1,
                                  histories.get(i).getBook().getBookName(),
                                  histories.get(i).getUser().getFirstName(),
                                  histories.get(i).getUser().getLastName()
                          );
                          n++;
                      }
                  }
                  if (n < 1) {
                      System.out.println("Нет выданных книг");
                      return false;
                }   
                  return true;
    }
    
}

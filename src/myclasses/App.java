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
import java.util.Scanner;

/**
 *
 * @author User
 */
public class App {
    public void run(){
        String repeat = "yes";
        Scanner scanner = new Scanner(System.in);
      do{
          System.out.println("Выбирите номер задачи: ");
          System.out.println("0: Закрыть программу");
          System.out.println("1: Добавить Читателя");
          int task = scanner.nextInt(); scanner.nextLine();
          switch (task) {
              case 0:
                  repeat = "no";
                  break;
              case 1:
                  User user = new User();
                  System.out.print("Введите имя читателя: ");
                  user.setFirstName(scanner.nextLine());
                  System.out.print("Введите фамилию читателя: ");
                  user.setLastName(scanner.nextLine());
                  System.out.print("Введите телефон читателя: ");
                  user.setTel(scanner.nextLine());
                  System.out.println("Читатель инициирован: "+user.toString());
                  break;
              default:
                  System.out.println("Выбирите номер из списка");;
          }
      }while("yes".equals(repeat));
      System.out.println("Bye!");
    }       
}

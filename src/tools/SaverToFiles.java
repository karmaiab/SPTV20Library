/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import entity.Book;
import entity.History;
import entity.User;
import interfaces.Keeping;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class SaverToFiles implements Keeping{

    @Override
    public void saveBooks(List<Book> books) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("books");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(books);
            oos.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaverToFiles.class.getName()).log(Level.SEVERE, "Нет файла books", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaverToFiles.class.getName()).log(Level.SEVERE, "Ошибка ввода", ex);
        }
    }

    @Override
    public List<Book> loadBooks() {
       List<Book> books = new ArrayList<>();
       FileInputStream fis = null;
       ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("books");
            ois = new ObjectInputStream(fis);
            books = (List<Book>) ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaverToFiles.class.getName()).log(Level.SEVERE, "books еще не создан", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaverToFiles.class.getName()).log(Level.SEVERE, "ошибка чтения", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaverToFiles.class.getName()).log(Level.SEVERE, "нет такого файла", ex);
        }
       return books;
    }

    @Override
    public void saveUsers(List<User> users) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("users");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
            oos.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaverToFiles.class.getName()).log(Level.SEVERE, "Нет файла User", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaverToFiles.class.getName()).log(Level.SEVERE, "Ошибка ввода", ex);
        }
    }

    @Override
    public List<User> loadUsers() {
       List<User> users = new ArrayList<>();
       FileInputStream fis = null;
       ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("users");
            ois = new ObjectInputStream(fis);
            users = (List<User>) ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaverToFiles.class.getName()).log(Level.SEVERE, "users еще не создан", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaverToFiles.class.getName()).log(Level.SEVERE, "ошибка чтения", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaverToFiles.class.getName()).log(Level.SEVERE, "нет такого файла", ex);
        }
       return users;
    }

    @Override
    public void saveHistories(List<History> histories) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("histories");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(histories);
            oos.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaverToFiles.class.getName()).log(Level.SEVERE, "Нет файла histories", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaverToFiles.class.getName()).log(Level.SEVERE, "Ошибка ввода", ex);
        }
    }

    @Override
    public List<History> loadHistories() {
        List<History> histories = new ArrayList<>();
       FileInputStream fis = null;
       ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("histories");
            ois = new ObjectInputStream(fis);
            histories = (List<History>) ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaverToFiles.class.getName()).log(Level.SEVERE, "histories еще не создан", ex);
        } catch (IOException ex) {
            Logger.getLogger(SaverToFiles.class.getName()).log(Level.SEVERE, "ошибка чтения", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaverToFiles.class.getName()).log(Level.SEVERE, "нет такого файла", ex);
        }
       return histories;
    }
    
}

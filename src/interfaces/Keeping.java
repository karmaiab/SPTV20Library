/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entity.Book;
import entity.History;
import entity.User;
import java.util.List;

/**
 *
 * @author User
 */
public interface Keeping {
    public void saveBooks(List<Book> books);
    public List<Book> loadBooks();
    public void saveUsers(List<User> users);
    public List<User> loadUsers();
    public void saveHistories(List<History> histories);
    public List<History> loadHistories();
}

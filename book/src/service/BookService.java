package service;

import pojo.Book;
import pojo.Page;

import java.util.List;

public interface BookService {
    public void addBook(Book book);
    public void deleteBookById(Integer id);
    public void updateBook(Book book);
    public Book queryBookById(Integer id);
    public List<Book> queryBooks();
    public Page<Book> pageservice(int pageNo);
    public Page<Book> queryBookByPrice(Integer small,Integer big,Integer pageNo);
}

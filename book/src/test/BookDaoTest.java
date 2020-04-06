package test;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import org.junit.Test;
import pojo.Book;

public class BookDaoTest {
    @Test
    public void searchbook(){
        BookDao bok=new BookDaoImpl();
        Book b=bok.queryBookById(15);
        System.out.println(b);

    }
}

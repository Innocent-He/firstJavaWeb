package test;

import org.junit.Test;
import pojo.Book;
import service.BookService;
import service.impl.BookServiceImp;

import java.util.List;

public class BookServiceTest {
    BookService bok=new BookServiceImp();
    @Test
    public void add(){

        bok.addBook(new Book(null,"贺高雲","魏丹怡",19.9,19,20,"static/img/default.jpg"));
    }
    @Test
    public void delete(){
        bok.deleteBookById(22);
    }
    @Test
    public void update(){
        bok.updateBook(new Book(23,"xiaokeai","哈哈哈",19.9,19,20,"static/img/default.jpg"));
    }
    @Test
    public void query(){
        System.out.println( bok.queryBookById(23));
    }
    @Test
    public void querys(){
        List<Book> books = bok.queryBooks();
        System.out.println(books);
    }
}

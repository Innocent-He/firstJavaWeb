package service.impl;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import pojo.Book;
import pojo.Page;
import service.BookService;

import java.util.List;

public class BookServiceImp implements BookService {
    BookDao Dao=new BookDaoImpl();
    Page page=new Page();
    @Override
    public void addBook(Book book) {
        Dao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        Dao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        Dao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return Dao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
       return Dao.queryBooks();
    }
    @Override
    public Page<Book>  pageservice(int pageNo){
        Page page=new Page();
        Integer bookTotalCount=Dao.queryForBookTotalCount();
        page.setBookTotal(bookTotalCount);
        if (bookTotalCount%page.getPageSize()>0){
            page.setPagetotal(bookTotalCount/page.getPageSize()+1);
        }else{
            page.setPagetotal(bookTotalCount/page.getPageSize());
        }
        page.setPageNo(pageNo);
        Integer begin=(page.getPageNo()-1)*page.getPageSize();
        page.setItems(Dao.queryForPageItems(begin,page.getPageSize()));
        return page;
    }
    @Override
    public Page<Book> queryBookByPrice(Integer small,Integer big,Integer pageNo){
        Page page=new Page();
        Integer bookTotalCount=Dao.queryForBookTotalByPricfe(small,big);
        page.setBookTotal(bookTotalCount);
        if (bookTotalCount%page.getPageSize()==0){
            page.setPagetotal(bookTotalCount/page.getPageSize());
        }else {
            page.setPagetotal(bookTotalCount/page.getPageSize()+1);
        }
        page.setPageNo(pageNo);
        Integer begin=(page.getPageNo()-1)*page.getPageSize();
        List<Book> books = Dao.queryForPageByPrice(small,big,begin);
        page.setItems(books);
        return  page;
    }
}

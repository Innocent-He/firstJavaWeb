package dao;

import pojo.Book;

import java.util.List;

public interface BookDao {
        public int addBook(Book book);

        public int deleteBookById(Integer id);

        public int updateBook(Book book);

        public Book queryBookById(Integer id);

        public List<Book> queryBooks();

        public List<Book> queryForPageItems(Integer begin, Integer pageSize);

        public Integer queryForBookTotalCount();
        public List<Book> queryForPageByPrice(Integer small,Integer big,Integer pageNo);
        public Integer queryForBookTotalByPricfe(Integer small,Integer big);
}
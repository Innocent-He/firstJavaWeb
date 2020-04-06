package dao.impl;

import dao.BookDao;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import pojo.Book;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql="insert into t_book(name,author,price,sales,stock,img_path) values(?,?,?,?,?,?)";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImg_path());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql="delete from t_book where id=?";
        return update(sql,id);
    }

    @Override
    public int updateBook(Book book) {
        String sql="update t_book set name=?,author=?,price=?,sales=?,stock=?,img_path=? where id=?";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImg_path(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql="select * from t_book where id=?";
        return queryForOne(Book.class,sql,id);
    }

    @Override
    public List<Book> queryBooks() {
       String sql="select id,name,author,price,sales,stock,img_path from t_book";
       return queryForList(Book.class,sql);
    }
    @Override
    public Integer queryForBookTotalCount(){
        String sql="select count(*) from t_book";
        Number count =(Number) queryForSingleValue(sql);
        return count.intValue();
    }
    @Override
    public List<Book> queryForPageItems(Integer begin,Integer pageSize){
        String sql="select id,name,author,price,sales,stock,img_path from t_book limit ?,?";
        return queryForList(Book.class,sql,begin,pageSize);
    }
    @Override
    public List<Book> queryForPageByPrice(Integer small,Integer big,Integer begin) {
        String sql="select * from t_book where price<? and price > ? limit ?,4  ";
        return queryForList(Book.class,sql,big,small,begin);
    }
    @Override
    public Integer queryForBookTotalByPricfe(Integer small,Integer big){
        String sql="select count(*) from t_book where price >? and price <?";
        Number count =(Number) queryForSingleValue(sql,small,big);
        return count.intValue();
    }

}

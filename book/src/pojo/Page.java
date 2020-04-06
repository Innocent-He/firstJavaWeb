package pojo;

import java.util.List;

public class Page<T> {
    private final Integer pageSize=4;
    private  Integer pageNo;
    private Integer bookTotal;
    private List<T> items;
    private Integer pagetotal;
    private String url;

    public Page() {
    }

    public Page(Integer pageNo, Integer bookTotal, List<T> items, Integer pagetotal, String url) {
        this.pageNo = pageNo;
        this.bookTotal = bookTotal;
        this.items = items;
        this.pagetotal = pagetotal;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getPagetotal() {
        return pagetotal;
    }

    public void setPagetotal(Integer pagetotal) {
        this.pagetotal = pagetotal;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if (pageNo<1){
            this.pageNo=1;
        }else if(pageNo>pagetotal){
            this.pageNo=pagetotal;
        }
        this.pageNo=pageNo;
    }

    public Integer getBookTotal() {
        return bookTotal;
    }

    public void setBookTotal(Integer bookTotal) {
        this.bookTotal = bookTotal;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageSize=" + pageSize +
                ", pageNo=" + pageNo +
                ", bookTotal=" + bookTotal +
                ", items=" + items +
                ", pagetotal=" + pagetotal +
                ", url='" + url + '\'' +
                '}';
    }
}

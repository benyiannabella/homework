package homework2;

public class Book {
   private String bookName;//Book attribute
   private int nrPage; //Book attribute
   private String bookType; //Book attribute


    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getNrPage() {
        return nrPage;
    }

    public void setNrPage(int nrPage) {
        this.nrPage = nrPage;
    }
}

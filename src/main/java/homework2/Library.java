package homework2;

import java.util.Arrays;

public class Library {
    private Book[] books; //library attribute, type Books array

    //library constructor - for new object creation
    public Library(Book[] books) {
        this.books = books;
    }

    //getter method
    public Book[] getBooks() {
        return books;
    }
    //setter method
    public void setBooks(Book[] books) {
        this.books = books;
    }

    //method to add new elements to our Books[] array
    public Book[] add(Book bookToAdd, Book[] libraryBooks) {
        Book[] newBookArray = Arrays.copyOf(libraryBooks, libraryBooks.length + 1);
        newBookArray[libraryBooks.length] = bookToAdd;
        return newBookArray;
    }

    //method to remove elements from our Books[] array
    public Book[] removeBook(int i, Book[] newBookArray) {
        // If the array is NULL or the index is not in array range - return the original array
        if (newBookArray == null
                || i < 0
                || i >= newBookArray.length) {
            return newBookArray;
        }
        Book[] newBookArray2 = new Book[newBookArray.length - 1];
        // Copy the elements from starting till index, from original to the new array
        System.arraycopy(newBookArray, 0, newBookArray2, 0, i);
        // Copy the elements from index + 1 till end, from original to the new array
        System.out.println();
        System.arraycopy(newBookArray, i + 1, newBookArray2, i, newBookArray.length - i-1);
        return newBookArray2;
    }

    //method to display the available books/description from our Books[] arrays
    public void getBookDetails(Book[] newBookArray) {
        System.out.println("We have the following books in our bigLibrary:");
        for (Book getBookList : newBookArray) {
            String type = getBookList.getBookType();
            if (type == "Novel") {
                System.out.println(getBookList.getBookType() + ": " + getBookList.getBookName() + ", with type "
                        + ((Novel) getBookList).getNovelType() + " and number of pages " + getBookList.getNrPage());
            } else {
                System.out.println(getBookList.getBookType() + ": " + getBookList.getBookName() + ", with paper quality "
                        + ((ArtAlbum) getBookList).getPaperQuality() + " and number of pages " + getBookList.getNrPage());
            }
        }
    }

}
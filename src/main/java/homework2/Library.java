package homework2;

import java.util.Arrays;

public class Library {
    Books[] books; //library attribute, type Books array

    //library constructor - for new object creation
    public Library(Books[] books) {
        this.books = books;
    }

    //getter method
    public Books[] getBooks() {
        return books;
    }
    //setter method
    public void setBooks(Books[] books) {
        this.books = books;
    }

    //method to add new elements to our Books[] array
    public Books[] add(Books booksToAdd, Books[] libraryBooks) {
        Books[] newBookArray = Arrays.copyOf(libraryBooks, libraryBooks.length + 1);
        newBookArray[libraryBooks.length] = booksToAdd;
        return newBookArray;
    }

    //method to remove elements from our Books[] array
    public Books[] removeBook(int i, Books[] newBookArray) {
        // If the array is NULL or the index is not in array range - return the original array
        if (newBookArray == null
                || i < 0
                || i >= newBookArray.length) {
            return newBookArray;
        }
        Books[] newBooksArray2 = new Books[newBookArray.length - 1];
        // Copy the elements from starting till index, from original to the new array
        System.arraycopy(newBookArray, 0, newBooksArray2, 0, i);
        // Copy the elements from index + 1 till end, from original to the new array
        System.out.println();
        System.arraycopy(newBookArray, i + 1, newBooksArray2, i, newBookArray.length - i-1);
        return newBooksArray2;
    }

    //method to display the available books/description from our Books[] arrays
    public void getBookDetails(Books[] newBookArray) {
        System.out.println("We have the following books in our bigLibrary:");
        for (Books getBooksList : newBookArray) {
            String type = getBooksList.getBookType();
            if (type == "Novel") {
                System.out.println(getBooksList.getBookType() + ": " + getBooksList.getBookName() + ", with type "
                        + ((Novels) getBooksList).getNovelType() + " and number of pages " + getBooksList.getNrPage());
            } else {
                System.out.println(getBooksList.getBookType() + ": " + getBooksList.getBookName() + ", with paper quality "
                        + ((ArtAlbum) getBooksList).getPaperQuality() + " and number of pages " + getBooksList.getNrPage());
            }
        }
    }

}
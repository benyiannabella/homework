package homework2;

import java.util.Arrays;

public class MainLibrary {
    public static void main(String[] args) {
        //create Novel objects and add values to attributes
        Novel novel1 = new Novel();
        novel1.setBookName("'Tom Sawyer'");
        novel1.setNovelType("'Adventure'");
        novel1.setNrPage(350);
        novel1.setBookType("Novel");

        Novel novel2 = new Novel();
        novel2.setBookName("'Elantris'");
        novel2.setNovelType("'Fantasy'");
        novel2.setNrPage(540);
        novel2.setBookType("Novel");

        //create ArtAlbum objects and add values to attributes
        ArtAlbum album1 = new ArtAlbum();
        album1.setBookName("'Leonardo Da Vinci'");
        album1.setPaperQuality("'Tick paper'");
        album1.setNrPage(150);
        album1.setBookType("Art Album");

        ArtAlbum album2 = new ArtAlbum();
        album2.setBookName("'Gothic'");
        album2.setPaperQuality("'Shiny paper'");
        album2.setNrPage(88);
        album2.setBookType("Art Album");

        //create Book[] array object and library object
        Book[] newBookArray = new Book[0];
        Library bigLibrary = new Library(newBookArray);
        //call the add method from the Libray class to add books to our array
        System.out.println("Number of books in our library before adding books: " + Arrays.toString(new int[]{newBookArray.length}));
        newBookArray = bigLibrary.add(novel1, newBookArray);
        newBookArray = bigLibrary.add(novel2, newBookArray);
        newBookArray = bigLibrary.add(album1, newBookArray);
        newBookArray = bigLibrary.add(album2, newBookArray);
        System.out.println("Number of books in our library after adding books: " + Arrays.toString(new int[]{newBookArray.length}));
        //call the getBookDetails method to display the books from our library
        bigLibrary.getBookDetails(newBookArray);

        //create a second Books[] array as a copy of our first array but without the removed element/s
        Book[] newBookArray2 = new Book[0];
        //call the removeBook method to remove a book from the array
        newBookArray2 = bigLibrary.removeBook(2, newBookArray);
        System.out.println("Number of books in our library after removing a book: " + Arrays.toString(new int[]{newBookArray2.length}));
        //call the getBookDetails method to display the new book list/details from our library
        bigLibrary.getBookDetails(newBookArray2);

    }

}



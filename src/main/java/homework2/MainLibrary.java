package homework2;

import java.util.Arrays;

public class MainLibrary {
    public static void main(String[] args) {
        //create Novels objects and add values to attributes
        Novels novel1 = new Novels();
        novel1.setBookName("Tom Sawyer");
        novel1.setNovelType("Adventure");
        novel1.setNrPage(350);
        novel1.setBookType("Novel");

        Novels novel2 = new Novels();
        novel2.setBookName("Elantris");
        novel2.setNovelType("Fantasy");
        novel2.setNrPage(540);
        novel2.setBookType("Novel");

        //create ArtAlbum objects and add values to attributes
        ArtAlbum album1 = new ArtAlbum();
        album1.setBookName("Leonardo Da Vinci");
        album1.setPaperQuality("Tick paper");
        album1.setNrPage(150);
        album1.setBookType("Art Album");

        ArtAlbum album2 = new ArtAlbum();
        album2.setBookName("Gothic");
        album2.setPaperQuality("Shiny paper");
        album2.setNrPage(88);
        album2.setBookType("Art Album");

        //create Books[] array object and library object
        Books[] newBookArray = new Books[0];
        Library bigLibrary = new Library(newBookArray);
        //call the add method from the Libray class to add books to our array
        newBookArray = bigLibrary.add(novel1, newBookArray);
        newBookArray = bigLibrary.add(novel2, newBookArray);
        newBookArray = bigLibrary.add(album1, newBookArray);
        newBookArray = bigLibrary.add(album2, newBookArray);
        System.out.println("The elements of our book array after adding some books: " + Arrays.toString(newBookArray));
        //call the getBookDetails method to display the books from our library
        bigLibrary.getBookDetails(newBookArray);

        //create a second Books[] array as a copy of our first array but without the removed element/s
        Books[] newBookArray2 = new Books[0];
        //call the removeBook method to remove a book from the array
        newBookArray2 = bigLibrary.removeBook(2, newBookArray);
        System.out.println("The elements of our array after removing a book are: " + Arrays.toString(newBookArray2));
        //call the getBookDetails method to display the new book list/details from our library
        bigLibrary.getBookDetails(newBookArray2);

    }

}



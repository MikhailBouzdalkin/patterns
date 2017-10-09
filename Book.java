/**
 * Created by PC on 18.09.2017.
 */
public class Book {
    private String publisher;
    private String author;
    private int numberOfPages;

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Book(String publisher, String author, int numberOfPages) {
        this.publisher = publisher;
        this.author = author;
        this.numberOfPages = numberOfPages;
    }

    public String getAuthor() {

        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
    public String toString(){
        return("Author: "+this.getAuthor()+"\nPublished House: "+getPublisher()+"\nNumber Of Pages: "+getNumberOfPages() );
    }
    public void printString(){
        System.out.println("Book");
    }
}

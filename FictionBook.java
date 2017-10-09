/**
 * Created by PC on 18.09.2017.
 */
public class FictionBook extends Book {
    String genre;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String toString(){
        return super.toString()+"\nGenre: "+this.genre;
    }

    public FictionBook(String publisher, String author, int numberOfPages, String genre) {
        super(publisher, author, numberOfPages);
        this.genre = genre;
    }
    public void printString(){
        System.out.println("FictionBook");
    }
    public static void main(String args){}
}

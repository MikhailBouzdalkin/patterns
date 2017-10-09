/**
 * Created by PC on 18.09.2017.
 */
public class ScienceBook extends Book {
    String subjects;
    String difficulty;

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public ScienceBook(String publisher, String author, int numberOfPages, String subjects, String difficulty) {
        super(publisher, author, numberOfPages);
        this.subjects = subjects;
        this.difficulty = difficulty;
    }
    public void printString(){
        System.out.println("ScienceBook");
    }
    public String toString(){
        return super.toString()+"\nSubjects: "+this.subjects+"\nDifficulty: "+this.difficulty;

    }
}

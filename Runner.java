public class Runner {
    public static void main(String[] args){
        Book[] books={new Book("Piter","Shildt",1000),
                new Book("Publish1","Shildt",1000),
                new Book("Publish2","Shildt",1000),
                new Book("Publish3","Shildt",1000),
                new ScienceBook("Piter","Author",100,"Physics","normal"),
                new ScienceBook("Piter","Author",100,"Psycology","overmind"),
                new ScienceBook("Piter","Author",100,"Biology","hard"),
                new FictionBook("Piter","Tolstoy",1000,"hisoric novel"),
                new FictionBook("Piter","Pushkin",100,"Evgeniy Onegin"),
                new FictionBook("Piter","Krilov",100,"Basny")};
        for(int i=0;i<10;i++){
            books[i].printString();
            System.out.println(books[i]);
        }

    }

}

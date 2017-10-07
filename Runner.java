/**
 * Created by PC on 18.09.2017.
 */
public class Runner {
    public static void main(String[] args){
        int sum=0;
        int total=0;
        Music[] mas={
                new Music("Track0",1000,true),
                new Music("Track1",100,false),
                new Music("Track2",100,false),
                new Music("Track3",100000,false),
                new Music("Track4",100,false),
                new Music("Track5",100,true),
                new Music("Track6",100000,false),
                new Music("Track7",1000,true),
                new Music("Track8",10,false),
                new Music("Track9",100,false)};
        for(int i=0;i<10;i++){
            total=total+mas[i].getCount();
            if(mas[i].isDownload()==true){
                sum++;
            }

        }
        System.out.println(total);
        System.out.println(sum);
    }

}

/**
 * Created by PC on 28.09.2017.
 */
public class CalculatorThread implements Runnable {


    public void run()
    {   ThreadGenerator tg=new ThreadGenerator();
        int count=tg.getCount();
     int result=0;

        for(int i =0;i<count;i++){
        result+=i;

    }
    ThreadGenerator.setResult(result);

    }


}

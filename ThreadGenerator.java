import java.util.Scanner;

/**
 * Created by PC on 28.09.2017.
 */
public class ThreadGenerator {
    private static int count;
    private static int result;
    private static boolean ready=true;

    public int getCount() {



        return count;
    }

    public  void setCount(int count) {

        ThreadGenerator.count = count;
    }

     public static void setResult(int result) {
        ThreadGenerator.result = result;
    }


    public int getResult() {
        try {  if(!ready) wait();
            ready=false;
            return result;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {notify();

        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        count=scan.nextInt();
        CalculatorThread thread = new CalculatorThread();
        new Thread(thread).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(result);
    }
}

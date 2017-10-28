/**
 * Created by PC on 23.09.2017.
 */
public class SurchargeException extends Exception {
    private Exception hidden;
    public SurchargeException(String s){
        super(s);

    }
    public SurchargeException(String s,Exception e){
        super(s,e);
        hidden=e;
    }
    public Exception getHiddenException(){
        return hidden;
    }
}

/**
 * Created by PC on 18.09.2017.
 */
public class Music {
    private String name;
    private int count;
    private boolean download;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isDownload() {
        return download;
    }

    public void setDownload(boolean download) {
        this.download = download;
    }


    public Music(String name, int count, boolean download) {
        this.name = name;
        this.count = count;
        this.download = download;
    }
    public static void main(String[] args){}

}

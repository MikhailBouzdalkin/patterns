import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by PC on 25.09.2017.
 */
public class User implements Comparable {
    private String nickname;
    private String login;
    private String pas;
    private String sex;
    private String date;


    public User(String nickname, String login, String pas, String sex, String date) {
        this.nickname = nickname;
        this.login = login;
        this.pas = pas;
        this.sex = sex;
        this.date = date;
    }

    @Override
    public int compareTo(Object o) {
        return this.nickname.compareTo(((User) o).nickname);

    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPas() {
        return pas;
    }

    public void setPas(String pas) {
        this.pas = pas;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "nickname='" + nickname + '\'' +
                ", login='" + login + '\'' +
                ", pas='" + pas + '\'' +
                ", sex='" + sex + '\'' +
                ", date=" + date +
                '}';
    }

    public static void writeToFIle(File f, ArrayList<User> arr) {

        BufferedWriter out = null;
        Iterator<User> iterator = arr.iterator();
        try {
            out = new BufferedWriter(new FileWriter(f));

            while (iterator.hasNext()) {
                User user = iterator.next();
                out.write(user.nickname + "\n");
                out.write(user.login + "\n");
                out.write(user.pas + "\n");
                out.write(user.sex + "\n");
                out.write(user.date + "\n");

            }
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static ArrayList<User> readFromFIle(File f, ArrayList<User> arr) {

        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(f));
            int i = 0;
            String str;
            while ((str = in.readLine()) != null) {

                User user = new User(str, in.readLine(), in.readLine(), in.readLine(), in.readLine());
                arr.add(user);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return arr;
    }
}

package pe.edu.utp.examenfinal.models;

/**
 * Created by elbuenpixel on 03/12/16.
 */

public class User {
    private String username;
    private String password;
    private int score;

    public int getScore() {
        return score;
    }

    public User() {
    }

    public User(String username, String password, int score) {
        this.username = username;
        this.password = password;
        this.score = score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

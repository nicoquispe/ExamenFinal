package pe.edu.utp.examenfinal.models;

import com.orm.SugarRecord;

/**
 * Created by elbuenpixel on 03/12/16.
 */

public class Students extends SugarRecord {
    private String firstName;
    private String lastName;
    private int nota;

    public Students(String firstName, String lastName, int nota) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nota = nota;
    }

    public Students() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}

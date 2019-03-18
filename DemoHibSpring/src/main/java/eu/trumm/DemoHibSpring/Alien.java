package eu.trumm.DemoHibSpring;


import javax.persistence.*;

@Entity
@Table(name = "alien_table")
public class Alien {

    @Id
    private int aid;
    // @Transient - the column aname is not created in the TABLE.

    private AlienName aname;
    //private String aname;
    // @Column(name = "alien_color") - the column gets different name than variable name.
    private String color;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public AlienName getAname() {
        return aname;
    }

    public void setAname(AlienName aname) {
        this.aname = aname;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

package TheatreTicketBookingSystem.domain;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Hasan on 10/31/2017.
 */
@Entity
public class Viewing {
    @Id
    @GeneratedValue
    private Long id;
    private Date show_date;
    private String time;
    @OneToMany(mappedBy = "reservation_id")
    private List<Reservation> reservation;

    @ManyToOne
    //@PrimaryKeyJoinColumn(name="email", referencedColumnName="email")
    private Horror horror;
    @OneToOne(cascade=CascadeType.ALL)
    private Action action;
    @OneToOne(cascade=CascadeType.ALL)
    private Documentary documentary;
    @OneToOne(cascade=CascadeType.ALL)
    private SciFi scifi;


    public Horror getHorror() {
        return horror;
    }

    public Action getAction() {
        return action;
    }

    public Documentary getDocumentary() {
        return documentary;
    }

    public SciFi getScifi() {
        return scifi;
    }


//    private List<? extends Seating_Class> seats;
//
//    public List<? extends Seating_Class> getSeats() {
//        return seats;
//    }

    public Long getId() {
        return id;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }


    public Date getShow_date() {
        return show_date;
    }

    public String getTime() {
        return time;
    }

//    public int getSeat_plan_id() {
//        return seat_plan_id;
//    }
    public Viewing() {}
    public Viewing(Builder builder){
        this.id = builder.id;
        this.show_date = builder.show_date;
        this.time = builder.time;
        this.reservation = builder.reservation;
        this.horror=builder.horror;
        this.action=builder.action;
        this.documentary=builder.documentary;
        this.scifi=builder.scifi;
       // this.seats = builder.seats;
    }

    public static class Builder{
        private Long id;
        private Date show_date;
        private String time;
        private List<Reservation> reservation;
        private Horror horror;
        private Action action;
        private Documentary documentary;
        private SciFi scifi;

        public Builder show_id(Long show_id) {
            this.id = show_id;
            return this;
        }

        public Builder reservation(List<Reservation> reservation) {
            this.reservation = reservation;
            return this;
        }

        public Builder show_date(Date show_date) {
            this.show_date = show_date;
            return this;
        }

        public Builder time(String time) {
            this.time = time;
            return this;
        }

//        public Builder recipe(Recipe recipe) {
//            this.recipe = recipe;
//            return this;
//        }
//
        public Builder action(Action action) {
            this.action = action;
            return this;
        }

        public Builder horror(Horror horror) {
            this.horror = horror;
            return this;
        }
        public Builder documentary(Documentary documentary) {
            this.documentary = documentary;
            return this;
        }
        public Builder scifi(SciFi scifi) {
            this.scifi = scifi;
            return this;
        }

        public Viewing build(){
            return  new Viewing(this);
        }
    }
}

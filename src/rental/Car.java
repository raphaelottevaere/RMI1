package rental;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Car {

    private int id;
    private CarType type;
    private List<Reservation> reservations;

    /***************
     * CONSTRUCTOR *
     ***************/
    
    public Car(int uid, CarType type) {
    	this.id = uid;
        this.type = type;
        this.reservations = new ArrayList<Reservation>();
    }

    /******
     * ID *
     ******/
    
    public int getId() {
    	return id;
    }
    
    /************
     * CAR TYPE *
     ************/
    
    public CarType getType() {
        return type;
    }

    /****************
     * RESERVATIONS *
     ****************/

    public boolean isAvailable(Date start, Date end) {
        if(!start.before(end))
            throw new IllegalArgumentException("Illegal given period");

        for(Reservation reservation : reservations) {
            if(reservation.getEndDate().before(start) || reservation.getStartDate().after(end))
                continue;
            return false;
        }
        return true;
    }
    
    public void addReservation(Reservation res) {
        reservations.add(res);
    }
    
    public void removeReservation(Reservation reservation) {
        // equals-method for Reservation is required!
        reservations.remove(reservation);
    }
    
    
    /***************************	
     * Extra needed functions
     ***************************/
    
    
    public List<Reservation> getAllReservationByRenter(String clientName){
    	List<Reservation> reservationsByRenter= new ArrayList<>();
    	for(Reservation r: reservations) {
    		if(r.getCarRenter().equals(clientName))
    			reservationsByRenter.add(r);
    	}
    	return reservationsByRenter;
    }
    
    public int getNbReservations() {
    	return reservations.size();
    }
    
    
    
    
}
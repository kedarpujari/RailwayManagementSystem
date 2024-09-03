public class Booking {
    private int bookingId;
    private Train train;
    private Passenger passenger;
    
    public Booking(int bookingId, Train train, Passenger passenger) {
        this.bookingId = bookingId;
        this.train = train;
        this.passenger = passenger;
    }

    public int getBookingId() {
        return bookingId;
    }

    public Train getTrain() {
        return train;
    }

    public Passenger getPassenger() {
        return passenger;
    }
    
    @Override
    public String toString() {
        return "Booking ID: " + bookingId + "\nTrain Info: " + train.toString() + 
               "\nPassenger Info: " + passenger.toString();
    }
}

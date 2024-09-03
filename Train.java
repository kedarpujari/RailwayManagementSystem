public class Train {
    private int trainNumber;
    private String trainName;
    private String source;
    private String destination;
    private int capacity;
    
    public Train(int trainNumber, String trainName, String source, String destination, int capacity) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.capacity = capacity;
    }
    
    public int getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getCapacity() {
        return capacity;
    }
    
    @Override
    public String toString() {
        return "Train Number: " + trainNumber + ", Train Name: " + trainName + 
               ", Source: " + source + ", Destination: " + destination + 
               ", Capacity: " + capacity;
    }
}

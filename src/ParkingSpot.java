public class ParkingSpot {
    int spotId;
    SpotSize size;
    boolean occupied;
    Vehicle parkedVehicle;

    ParkingSpot(int spotId, SpotSize size) {
        this.spotId = spotId;
        this.size = size;
        this.occupied = false;
        this.parkedVehicle = null;
    }

    public String getSpotId() {
        return spotId + "";
    }

    /**
     * Checks if parking size is more than or equal to given vehicle
     * @param vehicle vehicle to get parked at the spot
     * @return true if vehicle fits, else false
     */
    public boolean canFitVehicle(Vehicle vehicle) {
        return this.size.ordinal() >= vehicle.getRequiredSpotSize().ordinal();
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void park(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        occupied = true;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void unpark() {
        this.occupied = false;
        this.parkedVehicle = null;
    }
}

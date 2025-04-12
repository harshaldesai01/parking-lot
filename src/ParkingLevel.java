import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLevel {
    public int levelId;
    public List<ParkingSpot> parkingSpots;
    private Map<String, ParkingSpot> parkingSpotsByPlate;

    public ParkingLevel(int levelId, List<ParkingSpot> parkingSpots) {
        this.levelId = levelId;
        this.parkingSpots = parkingSpots;
        this.parkingSpotsByPlate = new HashMap<>();
    }

    public String getLevelId() {
        return levelId + "";
    }

    /**
     * Parks vehicle in an available spot if it fits
     * @param vehicle vehicle to be parked
     * @return true if vehicle successfully gets parked, false otherwise
     */
    public boolean parkVehicle(Vehicle vehicle) {
        for(ParkingSpot spot : parkingSpots) {
            if(!spot.isOccupied() && spot.canFitVehicle(vehicle)) {
                spot.park(vehicle);
                parkingSpotsByPlate.put(vehicle.getLicensePlate(), spot);
                System.out.println("Vehicle parked at Spot: " + spot.getSpotId());
                return true;
            }
        }
        return false;
    }

    /**
     * Finds the spot at which vehicle was parked and un-parks it
     * @param vehicle vehicle to be parked
     * @return true if vehicle is found and un-parked successfully, false otherwise
     */
    public boolean unparkVehicle(Vehicle vehicle) {
        ParkingSpot spot = parkingSpotsByPlate.get(vehicle.getLicensePlate());
        if(null != spot) {
            spot.unpark();
            parkingSpotsByPlate.remove(vehicle.getLicensePlate());
            System.out.println("Vehicle unparked from Spot: " + spot.getSpotId());
            return true;
        }
        System.out.println("Couldn't find vehicle at level: " + levelId);
        return false;
    }

    /**
     * Returns the count of all available spots in a parking level
     * @return available spots
     */
    public Integer getAvailableSpots() {
        int availableSpots = 0;
        for(ParkingSpot spot : parkingSpots) {
            if(!spot.isOccupied()) {
                availableSpots++;
            }
        }
        return availableSpots;
    }
}

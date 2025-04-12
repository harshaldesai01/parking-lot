import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    List<ParkingLevel> parkingLevels;

    public ParkingLot(List<ParkingLevel> parkingLevels) {
        this.parkingLevels = parkingLevels;
    }

    /**
     * Iterates over all levels, parks vehicle if it has spot available
     * @param vehicle vehicle to be parked
     * @return true if vehicle is successfully parked, false otherwise
     */
    boolean parkVehicle(Vehicle vehicle) {
        for(ParkingLevel parkingLevel : parkingLevels) {
            if(parkingLevel.parkVehicle(vehicle)) {
                System.out.println("Vehicle " + vehicle.getLicensePlate() + " parked at level:  " + parkingLevel.getLevelId());
                return true;
            }
        }
        System.out.println("No suitable parking spot available for vehicle: " + vehicle.getLicensePlate());
        return false;
    }

    /**
     * Iterates over all levels, finds it and unparks it
     * @param vehicle vehicle to be un-parked
     */
    void unparkVehicle(Vehicle vehicle) {
        for(ParkingLevel parkingLevel : parkingLevels) {
            if(parkingLevel.unparkVehicle(vehicle)) {
                System.out.println("Vehicle unparked from level:  " + parkingLevel.getLevelId());
                return;
            }
        }
        System.out.println("Vehicle not found at any level");
    }

    /**
     * Iterates over all parking levels and gets count of available spots
     * @return map of parking level and its available spot count
     */
    public Map<ParkingLevel, Integer> getAvailableSpots() {
        Map<ParkingLevel, Integer> availableSpots = new HashMap<>();
        for(ParkingLevel parkingLevel : parkingLevels) {
            availableSpots.put(parkingLevel, parkingLevel.getAvailableSpots());
        }
        return availableSpots;
    }
}

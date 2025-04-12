import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Setup Parking Spots
        List<ParkingSpot> level1Spots = Arrays.asList(
                new ParkingSpot(1, SpotSize.SMALL),
                new ParkingSpot(2, SpotSize.MEDIUM),
                new ParkingSpot(3, SpotSize.LARGE)
        );

        List<ParkingSpot> level2Spots = Arrays.asList(
                new ParkingSpot(4, SpotSize.MEDIUM),
                new ParkingSpot(5, SpotSize.LARGE)
        );

        // Setup Parking Levels
        ParkingLevel level1 = new ParkingLevel(1, level1Spots);
        ParkingLevel level2 = new ParkingLevel(2, level2Spots);

        List<ParkingLevel> parkingLevels = new ArrayList<>();
        parkingLevels.add(level1);
        parkingLevels.add(level2);

        // Create Parking Lot
        ParkingLot parkingLot = new ParkingLot(parkingLevels);

        // Vehicles
        Vehicle bike = new Bike("BIKE-001");
        Vehicle car = new Car("CAR-001");
        Vehicle truck = new Truck("TRUCK-001");

        // Park Vehicles
        parkingLot.parkVehicle(bike);
        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(truck);

        // Check available spots per level
        System.out.println("\nAvailable spots:");
        parkingLot.getAvailableSpots().forEach((level, count) ->
                System.out.println("Level " + level.getLevelId() + ": " + count + " spots available"));

        // Unpark car
        System.out.println("\nUnparking CAR-001...");
        parkingLot.unparkVehicle(car);

        // Check available spots again
        System.out.println("\nAvailable spots after unparking:");
        parkingLot.getAvailableSpots().forEach((level, count) ->
                System.out.println("Level " + level.getLevelId() + ": " + count + " spots available"));
    }
}
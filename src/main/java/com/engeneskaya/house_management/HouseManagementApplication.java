package com.engeneskaya.house_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HouseManagementApplication implements CommandLineRunner {

	@Autowired
	private HouseService houseService;

	public static void main(String[] args) {
		SpringApplication.run(HouseManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (houseService == null) {
			System.out.println("HouseService bean could not be injected!");
			return;
		}

		// Fiyatları yazdırma
		System.out.println("Total Price for Houses: " + houseService.getTotalPriceForHouses());
		System.out.println("Total Price for Villas: " + houseService.getTotalPriceForVillas());
		System.out.println("Total Price for Summer Houses: " + houseService.getTotalPriceForSummerHouses());
		System.out.println("Total Price for All Houses: " + houseService.getTotalPriceForAllHouses());

		// Ortalama metrekareleri yazdırma
		System.out.println("Average Area for Houses: " + houseService.getAverageAreaForHouses());
		System.out.println("Average Area for Villas: " + houseService.getAverageAreaForVillas());
		System.out.println("Average Area for Summer Houses: " + houseService.getAverageAreaForSummerHouses());
		System.out.println("Average Area for All Houses: " + houseService.getAverageAreaForAllHouses());

		// Oda ve salon sayısına göre filtreleme
		int rooms = 3;
		int livingRooms = 1;
		System.out.println("Houses with " + rooms + " rooms and " + livingRooms + " living rooms: ");
		houseService.filterHousesByRoomsAndLivingRooms(rooms, livingRooms)
				.forEach(h -> System.out.println(h.getName()));
	}
}

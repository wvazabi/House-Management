package com.engeneskaya.house_management;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {

    // Evler, Villalar, Yazlıklar listeleri
    private List<House> houseList;
    private List<Villa> villaList;
    private List<SummerHouse> summerHouseList;

    // Constructor
    public HouseService() {
        // Örnek verilerle dolduruyoruz
        houseList = List.of(
                new House("House 1", 300000, 120, 4, 1),
                new House("House 2", 250000, 100, 3, 1),
                new House("House 3", 350000, 140, 5, 2)
        );

        villaList = List.of(
                new Villa("Villa 1", 600000, 250, 5, 2),
                new Villa("Villa 2", 700000, 300, 6, 3),
                new Villa("Villa 3", 800000, 350, 7, 3)
        );

        summerHouseList = List.of(
                new SummerHouse("SummerHouse 1", 200000, 80, 2, 1),
                new SummerHouse("SummerHouse 2", 220000, 90, 3, 1),
                new SummerHouse("SummerHouse 3", 250000, 110, 4, 1)
        );
    }

    // Evlerin toplam fiyatını dönen metot
    public double getTotalPriceForHouses() {
        return houseList.stream().mapToDouble(House::getPrice).sum();
    }

    // Villaların toplam fiyatını dönen metot
    public double getTotalPriceForVillas() {
        return villaList.stream().mapToDouble(Villa::getPrice).sum();
    }

    // Yazlıkların toplam fiyatını dönen metot
    public double getTotalPriceForSummerHouses() {
        return summerHouseList.stream().mapToDouble(SummerHouse::getPrice).sum();
    }

    // Tüm evlerin toplam fiyatını dönen metot
    public double getTotalPriceForAllHouses() {
        return houseList.stream().mapToDouble(House::getPrice).sum()
                + villaList.stream().mapToDouble(Villa::getPrice).sum()
                + summerHouseList.stream().mapToDouble(SummerHouse::getPrice).sum();
    }

    // Evlerin ortalama metrekaresini dönen metot
    public double getAverageAreaForHouses() {
        return houseList.stream().mapToDouble(House::getArea).average().orElse(0);
    }

    // Villaların ortalama metrekaresini dönen metot
    public double getAverageAreaForVillas() {
        return villaList.stream().mapToDouble(Villa::getArea).average().orElse(0);
    }

    // Yazlıkların ortalama metrekaresini dönen metot
    public double getAverageAreaForSummerHouses() {
        return summerHouseList.stream().mapToDouble(SummerHouse::getArea).average().orElse(0);
    }

    // Tüm evlerin ortalama metrekaresini dönen metot
    public double getAverageAreaForAllHouses() {
        double totalArea = houseList.stream().mapToDouble(House::getArea).sum()
                + villaList.stream().mapToDouble(Villa::getArea).sum()
                + summerHouseList.stream().mapToDouble(SummerHouse::getArea).sum();
        long totalCount = houseList.size() + villaList.size() + summerHouseList.size();
        return totalCount > 0 ? totalArea / totalCount : 0;
    }

    // Oda ve salon sayısına göre evleri filtreleyip dönen metot
    public List<House> filterHousesByRoomsAndLivingRooms(int rooms, int livingRooms) {
        return houseList.stream()
                .filter(h -> h.getRooms() == rooms && h.getLivingRooms() == livingRooms)
                .toList();
    }
}
package com.laptrinhjavaweb.service;

public interface IRentAreaService {
    String findByBuildingId(Long buildingId);
    void save(String value, Long buildingId);
}

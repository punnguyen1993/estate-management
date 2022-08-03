package com.laptrinhjavaweb.dto.request;

public class DeleteRequest {
    private Long[] buildingIds;
    private Long[] customerIds;

    public Long[] getCustomerIds() {
        return customerIds;
    }

    public void setCustomerIds(Long[] customerIds) {
        this.customerIds = customerIds;
    }

    public Long[] getBuildingIds() {
        return buildingIds;
    }

    public void setBuildingIds(Long[] buildingIds) {
        this.buildingIds = buildingIds;
    }
}

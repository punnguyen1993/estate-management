package com.laptrinhjavaweb.builder;

public class CustomerSearchBuilder {
    private String fullName;
    private String phone;
    private String email;
    private Long staffId;
    private String companyName;
    private String demand;
    private String note;

    public String getFullName() {
        return fullName;
    }
    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }
    public Long getStaffId() {
        return staffId;
    }
    public String getCompanyName() {
        return companyName;
    }
    public String getDemand() {
        return demand;
    }
    public String getNote() {
        return note;
    }

    private CustomerSearchBuilder(Builder builder) {
        this.companyName = builder.companyName;
        this.demand = builder.demand;
        this.email = builder.email;
        this.fullName = builder.fullName;
        this.note = builder.note;
        this.phone = builder.phone;
        this.staffId = builder.staffId;
    }

    public static class Builder{
        private String fullName;
        private String phone;
        private String email;
        private Long staffId;
        private String companyName;
        private String demand;
        private String note;

        public Builder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setStaffId(Long staffId) {
            this.staffId = staffId;
            return this;
        }

        public Builder setCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder setDemand(String demand) {
            this.demand = demand;
            return this;
        }

        public Builder setNote(String note) {
            this.note = note;
            return this;
        }

        public CustomerSearchBuilder build(){
            return new CustomerSearchBuilder(this);
        }
    }
}

package com.asherbakov.transport;

import java.time.LocalDate;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Car {
    private String brand;
    private String model;
    private double engineVolume;
    private String color;
    private int productionYear;
    private String productionCountry;

    private Transmission transmission;
    private BodyType bodyType;
    private String registrationNumber;
    private int numberOfSeats;
    private TiresType tiresType;
    private Key key;
    private Insurance insurance;

    public class Key {
        private boolean remoteEngineStart;
        private boolean keylessAccess;

        public Key(boolean remoteEngineStart, boolean keylessAccess) {
            this.remoteEngineStart = remoteEngineStart;
            this.keylessAccess = keylessAccess;
        }

        public boolean isRemoteEngineStart() {
            return remoteEngineStart;
        }

        public boolean isKeylessAccess() {
            return keylessAccess;
        }

        @Override
        public String toString() {
            return "Key{" +
                    "remoteEngineStart=" + remoteEngineStart +
                    ", keylessAccess=" + keylessAccess +
                    '}';
        }
    }

    public class Insurance {
        private LocalDate insuranceValidityPeriod;
        private double costOfInsurance;
        private String insuranceNumber;

        public Insurance(LocalDate insuranceValidityPeriod, double costOfInsurance, String insuranceNumber) {
            this.insuranceValidityPeriod = insuranceValidityPeriod;
            if (!isActualInsurance(insuranceValidityPeriod)) {
                System.out.println("Нужно срочно ехать оформлять новую страховку!");
            }
            this.costOfInsurance = costOfInsurance;
            if (insuranceNumber != null && !insuranceNumber.isBlank() && insurerNumberCheck(insuranceNumber)) {
                this.insuranceNumber = insuranceNumber;
            } else {
                System.out.println("Номер страховки некорректный!");
            }
        }

        public LocalDate getInsuranceValidityPeriod() {
            return insuranceValidityPeriod;
        }

        public double getCostOfInsurance() {
            return costOfInsurance;
        }

        public String getInsuranceNumber() {
            return insuranceNumber;
        }

        public boolean isActualInsurance(LocalDate insuranceValidityPeriod) {
            boolean result = false;
            if (!insuranceValidityPeriod.isBefore(LocalDate.now())) {
                result = true;
            }
            return result;
        }

        public boolean insurerNumberCheck(String insuranceNumber) {
            boolean result = true;
            if (insuranceNumber.length() != 9) {
                result = false;
            }
            return result;
        }

        @Override
        public String toString() {
            return "Insurance{" +
                    "insuranceValidityPeriod=" + insuranceValidityPeriod +
                    ", costOfInsurance=" + costOfInsurance +
                    ", insuranceNumber='" + insuranceNumber + '\'' +
                    '}';
        }
    }

    public Car(String brand, String model, double engineVolume, String color, int productionYear, String productionCountry) {
        this(brand, model, engineVolume, color, productionYear, productionCountry, null, null, null, 0, null);
    }

    public Car(String brand, String model, double engineVolume, String color, int productionYear, String productionCountry, Transmission transmission, BodyType bodyType, String registrationNumber, int numberOfSeats, TiresType tiresType) {
        if (brand.isBlank()) {
            this.brand = null;
        } else {
            this.brand = brand;
        }
        if (model.isBlank()) {
            this.model = null;
        } else {
            this.model = model;
        }
        if (productionYear == 0) {
            this.productionYear = 2000;
        } else {
            this.productionYear = productionYear;
        }
        if (productionCountry.isBlank()) {
            this.productionCountry = null;
        } else {
            this.productionCountry = productionCountry;
        }
        if (bodyType != null) {
            this.bodyType = bodyType;
        } else {
            this.bodyType = BodyType.Sedan;
        }
        if (numberOfSeats > 0) {
            this.numberOfSeats = numberOfSeats;
        } else {
            this.numberOfSeats = 4;
        }

        setTransmission(transmission);
        setRegistrationNumber(registrationNumber);
        setColor(color);
        setTiresType(tiresType);
        setEngineVolume(engineVolume);
    }

     public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public String getProductionCountry() {
        return productionCountry;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        if (engineVolume == 0.0) {
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (!color.isBlank() && color != null) {
            this.color = color;
        } else {
            this.color = "Белый";
        }
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        if (transmission != null) {
            this.transmission = transmission;
        } else {
            this.transmission = Transmission.MT;
        }
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        if (registrationNumber != null && registrationNumberIsCorrect(registrationNumber)) {
            this.registrationNumber = registrationNumber;
        } else {
            this.registrationNumber = "х000хх000";
        }
    }

    public TiresType getTiresType() {
        return tiresType;
    }

    public void setTiresType(TiresType tiresType) {
        if (tiresType != null) {
            this.tiresType = tiresType;
        } else {
            this.tiresType = TiresType.Summer;
        }
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        if (key != null) {
            this.key = key;
        }
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        if (insurance != null) {
            this.insurance = insurance;
        }
    }

    public boolean registrationNumberIsCorrect(String number) {
        String regex = "\\D\\d{3}\\D{2}\\d{2,3}";
        return Pattern.matches(regex, registrationNumber);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", engineVolume=" + engineVolume +
                ", color='" + color + '\'' +
                ", productionYear=" + productionYear +
                ", productionCountry='" + productionCountry + '\'' +
                ", transmission=" + transmission +
                ", bodyType=" + bodyType +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", tiresType=" + tiresType +
                ", key=" + getKey() +
                ", insurance=" + getInsurance() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.engineVolume, engineVolume) == 0 && productionYear == car.productionYear && brand.equals(car.brand) && model.equals(car.model) && color.equals(car.color) && productionCountry.equals(car.productionCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume, color, productionYear, productionCountry);
    }
}

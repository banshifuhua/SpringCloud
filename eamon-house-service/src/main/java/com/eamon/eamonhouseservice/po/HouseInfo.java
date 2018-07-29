package com.eamon.eamonhouseservice.po;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "house_info", schema = "spring_cloud", catalog = "")
@IdClass(HouseInfoPK.class)
public class HouseInfo {
    private long id;
    private String city;
    private String region;
    private String name;
    private String address;
    private double lng;
    private double lat;
    private String estateType;
    private String houseNum;
    private String roomNum;
    private int floor;
    private int height;
    private double area;
    private int roomCount;
    private int hallCount;
    private int rent;
    private Timestamp purchaseDate;
    private int purchasePrice;
    private int price;
    private int totalPrice;
    private Timestamp evalDate;
    private String liveStatus;
    private int removeStatus;
    private String uid;
    private long eid;
    private int level;
    private double growthRate;
    private int appreciation;
    private double roseRanking;
    private double avgpriceRanking;
    private String rentalRatio;
    private double maxLoanMoney;
    private String tag;
    private int liquidityRating;
    private int oneYearTotalPrice;
    private String houseRoomNum;
    private Date leaseStartDate;
    private Date leaseEndDate;
    private Integer rentCycle;
    private String rentCycleUnit;
    private Date lastRentDate;
    private Integer minSellPrice;
    private Integer maxSellPrice;
    private Double totalScore;
    private Double minAdviceValue;
    private Double maxAdviceValue;
    private Timestamp addDate;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "region")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "lng")
    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    @Basic
    @Column(name = "lat")
    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    @Basic
    @Column(name = "estate_type")
    public String getEstateType() {
        return estateType;
    }

    public void setEstateType(String estateType) {
        this.estateType = estateType;
    }

    @Basic
    @Column(name = "house_num")
    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    @Basic
    @Column(name = "room_num")
    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    @Basic
    @Column(name = "floor")
    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Basic
    @Column(name = "height")
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Basic
    @Column(name = "area")
    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Basic
    @Column(name = "room_count")
    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    @Basic
    @Column(name = "hall_count")
    public int getHallCount() {
        return hallCount;
    }

    public void setHallCount(int hallCount) {
        this.hallCount = hallCount;
    }

    @Basic
    @Column(name = "rent")
    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    @Basic
    @Column(name = "purchase_date")
    public Timestamp getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Timestamp purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Basic
    @Column(name = "purchase_price")
    public int getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    @Basic
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "total_price")
    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Basic
    @Column(name = "eval_date")
    public Timestamp getEvalDate() {
        return evalDate;
    }

    public void setEvalDate(Timestamp evalDate) {
        this.evalDate = evalDate;
    }

    @Basic
    @Column(name = "live_status")
    public String getLiveStatus() {
        return liveStatus;
    }

    public void setLiveStatus(String liveStatus) {
        this.liveStatus = liveStatus;
    }

    @Id
    @Column(name = "remove_status")
    public int getRemoveStatus() {
        return removeStatus;
    }

    public void setRemoveStatus(int removeStatus) {
        this.removeStatus = removeStatus;
    }

    @Basic
    @Column(name = "uid")
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "eid")
    public long getEid() {
        return eid;
    }

    public void setEid(long eid) {
        this.eid = eid;
    }

    @Basic
    @Column(name = "level")
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Basic
    @Column(name = "growth_rate")
    public double getGrowthRate() {
        return growthRate;
    }

    public void setGrowthRate(double growthRate) {
        this.growthRate = growthRate;
    }

    @Basic
    @Column(name = "appreciation")
    public int getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(int appreciation) {
        this.appreciation = appreciation;
    }

    @Basic
    @Column(name = "rose_ranking")
    public double getRoseRanking() {
        return roseRanking;
    }

    public void setRoseRanking(double roseRanking) {
        this.roseRanking = roseRanking;
    }

    @Basic
    @Column(name = "avgprice_ranking")
    public double getAvgpriceRanking() {
        return avgpriceRanking;
    }

    public void setAvgpriceRanking(double avgpriceRanking) {
        this.avgpriceRanking = avgpriceRanking;
    }

    @Basic
    @Column(name = "rental_ratio")
    public String getRentalRatio() {
        return rentalRatio;
    }

    public void setRentalRatio(String rentalRatio) {
        this.rentalRatio = rentalRatio;
    }

    @Basic
    @Column(name = "max_loan_money")
    public double getMaxLoanMoney() {
        return maxLoanMoney;
    }

    public void setMaxLoanMoney(double maxLoanMoney) {
        this.maxLoanMoney = maxLoanMoney;
    }

    @Basic
    @Column(name = "tag")
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Basic
    @Column(name = "liquidity_rating")
    public int getLiquidityRating() {
        return liquidityRating;
    }

    public void setLiquidityRating(int liquidityRating) {
        this.liquidityRating = liquidityRating;
    }

    @Basic
    @Column(name = "one_year_total_price")
    public int getOneYearTotalPrice() {
        return oneYearTotalPrice;
    }

    public void setOneYearTotalPrice(int oneYearTotalPrice) {
        this.oneYearTotalPrice = oneYearTotalPrice;
    }

    @Basic
    @Column(name = "house_room_num")
    public String getHouseRoomNum() {
        return houseRoomNum;
    }

    public void setHouseRoomNum(String houseRoomNum) {
        this.houseRoomNum = houseRoomNum;
    }

    @Basic
    @Column(name = "lease_start_date")
    public Date getLeaseStartDate() {
        return leaseStartDate;
    }

    public void setLeaseStartDate(Date leaseStartDate) {
        this.leaseStartDate = leaseStartDate;
    }

    @Basic
    @Column(name = "lease_end_date")
    public Date getLeaseEndDate() {
        return leaseEndDate;
    }

    public void setLeaseEndDate(Date leaseEndDate) {
        this.leaseEndDate = leaseEndDate;
    }

    @Basic
    @Column(name = "rent_cycle")
    public Integer getRentCycle() {
        return rentCycle;
    }

    public void setRentCycle(Integer rentCycle) {
        this.rentCycle = rentCycle;
    }

    @Basic
    @Column(name = "rent_cycle_unit")
    public String getRentCycleUnit() {
        return rentCycleUnit;
    }

    public void setRentCycleUnit(String rentCycleUnit) {
        this.rentCycleUnit = rentCycleUnit;
    }

    @Basic
    @Column(name = "last_rent_date")
    public Date getLastRentDate() {
        return lastRentDate;
    }

    public void setLastRentDate(Date lastRentDate) {
        this.lastRentDate = lastRentDate;
    }

    @Basic
    @Column(name = "min_sell_price")
    public Integer getMinSellPrice() {
        return minSellPrice;
    }

    public void setMinSellPrice(Integer minSellPrice) {
        this.minSellPrice = minSellPrice;
    }

    @Basic
    @Column(name = "max_sell_price")
    public Integer getMaxSellPrice() {
        return maxSellPrice;
    }

    public void setMaxSellPrice(Integer maxSellPrice) {
        this.maxSellPrice = maxSellPrice;
    }

    @Basic
    @Column(name = "total_score")
    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }

    @Basic
    @Column(name = "min_advice_value")
    public Double getMinAdviceValue() {
        return minAdviceValue;
    }

    public void setMinAdviceValue(Double minAdviceValue) {
        this.minAdviceValue = minAdviceValue;
    }

    @Basic
    @Column(name = "max_advice_value")
    public Double getMaxAdviceValue() {
        return maxAdviceValue;
    }

    public void setMaxAdviceValue(Double maxAdviceValue) {
        this.maxAdviceValue = maxAdviceValue;
    }

    @Basic
    @Column(name = "add_date")
    public Timestamp getAddDate() {
        return addDate;
    }

    public void setAddDate(Timestamp addDate) {
        this.addDate = addDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HouseInfo houseInfo = (HouseInfo) o;
        return id == houseInfo.id &&
                Double.compare(houseInfo.lng, lng) == 0 &&
                Double.compare(houseInfo.lat, lat) == 0 &&
                floor == houseInfo.floor &&
                height == houseInfo.height &&
                Double.compare(houseInfo.area, area) == 0 &&
                roomCount == houseInfo.roomCount &&
                hallCount == houseInfo.hallCount &&
                rent == houseInfo.rent &&
                purchasePrice == houseInfo.purchasePrice &&
                price == houseInfo.price &&
                totalPrice == houseInfo.totalPrice &&
                removeStatus == houseInfo.removeStatus &&
                eid == houseInfo.eid &&
                level == houseInfo.level &&
                Double.compare(houseInfo.growthRate, growthRate) == 0 &&
                appreciation == houseInfo.appreciation &&
                Double.compare(houseInfo.roseRanking, roseRanking) == 0 &&
                Double.compare(houseInfo.avgpriceRanking, avgpriceRanking) == 0 &&
                Double.compare(houseInfo.maxLoanMoney, maxLoanMoney) == 0 &&
                liquidityRating == houseInfo.liquidityRating &&
                oneYearTotalPrice == houseInfo.oneYearTotalPrice &&
                Objects.equals(city, houseInfo.city) &&
                Objects.equals(region, houseInfo.region) &&
                Objects.equals(name, houseInfo.name) &&
                Objects.equals(address, houseInfo.address) &&
                Objects.equals(estateType, houseInfo.estateType) &&
                Objects.equals(houseNum, houseInfo.houseNum) &&
                Objects.equals(roomNum, houseInfo.roomNum) &&
                Objects.equals(purchaseDate, houseInfo.purchaseDate) &&
                Objects.equals(evalDate, houseInfo.evalDate) &&
                Objects.equals(liveStatus, houseInfo.liveStatus) &&
                Objects.equals(uid, houseInfo.uid) &&
                Objects.equals(rentalRatio, houseInfo.rentalRatio) &&
                Objects.equals(tag, houseInfo.tag) &&
                Objects.equals(houseRoomNum, houseInfo.houseRoomNum) &&
                Objects.equals(leaseStartDate, houseInfo.leaseStartDate) &&
                Objects.equals(leaseEndDate, houseInfo.leaseEndDate) &&
                Objects.equals(rentCycle, houseInfo.rentCycle) &&
                Objects.equals(rentCycleUnit, houseInfo.rentCycleUnit) &&
                Objects.equals(lastRentDate, houseInfo.lastRentDate) &&
                Objects.equals(minSellPrice, houseInfo.minSellPrice) &&
                Objects.equals(maxSellPrice, houseInfo.maxSellPrice) &&
                Objects.equals(totalScore, houseInfo.totalScore) &&
                Objects.equals(minAdviceValue, houseInfo.minAdviceValue) &&
                Objects.equals(maxAdviceValue, houseInfo.maxAdviceValue) &&
                Objects.equals(addDate, houseInfo.addDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, city, region, name, address, lng, lat, estateType, houseNum, roomNum, floor, height, area, roomCount, hallCount, rent, purchaseDate, purchasePrice, price, totalPrice, evalDate, liveStatus, removeStatus, uid, eid, level, growthRate, appreciation, roseRanking, avgpriceRanking, rentalRatio, maxLoanMoney, tag, liquidityRating, oneYearTotalPrice, houseRoomNum, leaseStartDate, leaseEndDate, rentCycle, rentCycleUnit, lastRentDate, minSellPrice, maxSellPrice, totalScore, minAdviceValue, maxAdviceValue, addDate);
    }
}

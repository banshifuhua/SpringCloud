package com.eamon.eamonhouseservice.po;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class HouseInfoPK implements Serializable {
    private long id;
    private int removeStatus;

    @Column(name = "id")
    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "remove_status")
    @Id
    public int getRemoveStatus() {
        return removeStatus;
    }

    public void setRemoveStatus(int removeStatus) {
        this.removeStatus = removeStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HouseInfoPK that = (HouseInfoPK) o;
        return id == that.id &&
                removeStatus == that.removeStatus;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, removeStatus);
    }
}

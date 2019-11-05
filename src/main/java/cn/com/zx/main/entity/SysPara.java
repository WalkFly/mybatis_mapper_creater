package cn.com.zx.main.entity;

import java.io.Serializable;

public class SysPara extends BaseEntity implements Serializable {
    private Integer vacancyAlarmLimitDays;
    private Integer specialGroupUnopenedAlarmLimitDays;
    private Integer sysLogExpireTime;

    public Integer getVacancyAlarmLimitDays() {
        return vacancyAlarmLimitDays;
    }

    public void setVacancyAlarmLimitDays(Integer vacancyAlarmLimitDays) {
        this.vacancyAlarmLimitDays = vacancyAlarmLimitDays;
    }

    public Integer getSpecialGroupUnopenedAlarmLimitDays() {
        return specialGroupUnopenedAlarmLimitDays;
    }

    public void setSpecialGroupUnopenedAlarmLimitDays(Integer specialGroupUnopenedAlarmLimitDays) {
        this.specialGroupUnopenedAlarmLimitDays = specialGroupUnopenedAlarmLimitDays;
    }

    public Integer getSysLogExpireTime() {
        return sysLogExpireTime;
    }

    public void setSysLogExpireTime(Integer sysLogExpireTime) {
        this.sysLogExpireTime = sysLogExpireTime;
    }
}

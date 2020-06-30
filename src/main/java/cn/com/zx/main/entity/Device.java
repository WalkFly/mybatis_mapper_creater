package cn.com.zx.main.entity;

import java.util.Date;

public class Device {
    private Long id;

    private String deviceName;

    private String deviceUuid;

    private String deviceKey;

    private String deviceModel;

    private String deviceMacAddr;

    private String deviceCurHwVersion;

    private String deviceCurSwVersion;

    private String deviceCurFmVersion;

    private Short deviceSignalPower;

    private Short deviceTxPower;

    private Byte deviceSignalEcl;

    private Short deviceSignalSnr;

    private Integer deviceSignalPci;

    private Integer deviceLinkQuality;

    private Integer deviceSignalIndicator;

    private Long productId;

    private String deviceImei;

    private String deviceImsi;

    private Date lastCommunicateTime;

    private Short deviceTimezone;

    private Date deviceRegisterTime;

    private Date deviceRemoveTime;

    private Byte deviceOnlineState;

    private Integer deviceHeartbeatCycle;

    private Byte deviceUpgradeState;

    private Long deviceParentId;

    private Boolean virtualDeviceFlag;

    private Byte validState;

    private String createBy;

    private Date createTime;

    private String modifiedBy;

    private Date modifiedTime;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    public String getDeviceUuid() {
        return deviceUuid;
    }

    public void setDeviceUuid(String deviceUuid) {
        this.deviceUuid = deviceUuid == null ? null : deviceUuid.trim();
    }

    public String getDeviceKey() {
        return deviceKey;
    }

    public void setDeviceKey(String deviceKey) {
        this.deviceKey = deviceKey == null ? null : deviceKey.trim();
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel == null ? null : deviceModel.trim();
    }

    public String getDeviceMacAddr() {
        return deviceMacAddr;
    }

    public void setDeviceMacAddr(String deviceMacAddr) {
        this.deviceMacAddr = deviceMacAddr == null ? null : deviceMacAddr.trim();
    }

    public String getDeviceCurHwVersion() {
        return deviceCurHwVersion;
    }

    public void setDeviceCurHwVersion(String deviceCurHwVersion) {
        this.deviceCurHwVersion = deviceCurHwVersion == null ? null : deviceCurHwVersion.trim();
    }

    public String getDeviceCurSwVersion() {
        return deviceCurSwVersion;
    }

    public void setDeviceCurSwVersion(String deviceCurSwVersion) {
        this.deviceCurSwVersion = deviceCurSwVersion == null ? null : deviceCurSwVersion.trim();
    }

    public String getDeviceCurFmVersion() {
        return deviceCurFmVersion;
    }

    public void setDeviceCurFmVersion(String deviceCurFmVersion) {
        this.deviceCurFmVersion = deviceCurFmVersion == null ? null : deviceCurFmVersion.trim();
    }

    public Short getDeviceSignalPower() {
        return deviceSignalPower;
    }

    public void setDeviceSignalPower(Short deviceSignalPower) {
        this.deviceSignalPower = deviceSignalPower;
    }

    public Short getDeviceTxPower() {
        return deviceTxPower;
    }

    public void setDeviceTxPower(Short deviceTxPower) {
        this.deviceTxPower = deviceTxPower;
    }

    public Byte getDeviceSignalEcl() {
        return deviceSignalEcl;
    }

    public void setDeviceSignalEcl(Byte deviceSignalEcl) {
        this.deviceSignalEcl = deviceSignalEcl;
    }

    public Short getDeviceSignalSnr() {
        return deviceSignalSnr;
    }

    public void setDeviceSignalSnr(Short deviceSignalSnr) {
        this.deviceSignalSnr = deviceSignalSnr;
    }

    public Integer getDeviceSignalPci() {
        return deviceSignalPci;
    }

    public void setDeviceSignalPci(Integer deviceSignalPci) {
        this.deviceSignalPci = deviceSignalPci;
    }

    public Integer getDeviceLinkQuality() {
        return deviceLinkQuality;
    }

    public void setDeviceLinkQuality(Integer deviceLinkQuality) {
        this.deviceLinkQuality = deviceLinkQuality;
    }

    public Integer getDeviceSignalIndicator() {
        return deviceSignalIndicator;
    }

    public void setDeviceSignalIndicator(Integer deviceSignalIndicator) {
        this.deviceSignalIndicator = deviceSignalIndicator;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getDeviceImei() {
        return deviceImei;
    }

    public void setDeviceImei(String deviceImei) {
        this.deviceImei = deviceImei == null ? null : deviceImei.trim();
    }

    public String getDeviceImsi() {
        return deviceImsi;
    }

    public void setDeviceImsi(String deviceImsi) {
        this.deviceImsi = deviceImsi == null ? null : deviceImsi.trim();
    }

    public Date getLastCommunicateTime() {
        return lastCommunicateTime;
    }

    public void setLastCommunicateTime(Date lastCommunicateTime) {
        this.lastCommunicateTime = lastCommunicateTime;
    }

    public Short getDeviceTimezone() {
        return deviceTimezone;
    }

    public void setDeviceTimezone(Short deviceTimezone) {
        this.deviceTimezone = deviceTimezone;
    }

    public Date getDeviceRegisterTime() {
        return deviceRegisterTime;
    }

    public void setDeviceRegisterTime(Date deviceRegisterTime) {
        this.deviceRegisterTime = deviceRegisterTime;
    }

    public Date getDeviceRemoveTime() {
        return deviceRemoveTime;
    }

    public void setDeviceRemoveTime(Date deviceRemoveTime) {
        this.deviceRemoveTime = deviceRemoveTime;
    }

    public Byte getDeviceOnlineState() {
        return deviceOnlineState;
    }

    public void setDeviceOnlineState(Byte deviceOnlineState) {
        this.deviceOnlineState = deviceOnlineState;
    }

    public Integer getDeviceHeartbeatCycle() {
        return deviceHeartbeatCycle;
    }

    public void setDeviceHeartbeatCycle(Integer deviceHeartbeatCycle) {
        this.deviceHeartbeatCycle = deviceHeartbeatCycle;
    }

    public Byte getDeviceUpgradeState() {
        return deviceUpgradeState;
    }

    public void setDeviceUpgradeState(Byte deviceUpgradeState) {
        this.deviceUpgradeState = deviceUpgradeState;
    }

    public Long getDeviceParentId() {
        return deviceParentId;
    }

    public void setDeviceParentId(Long deviceParentId) {
        this.deviceParentId = deviceParentId;
    }

    public Boolean getVirtualDeviceFlag() {
        return virtualDeviceFlag;
    }

    public void setVirtualDeviceFlag(Boolean virtualDeviceFlag) {
        this.virtualDeviceFlag = virtualDeviceFlag;
    }

    public Byte getValidState() {
        return validState;
    }

    public void setValidState(Byte validState) {
        this.validState = validState;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy == null ? null : modifiedBy.trim();
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}
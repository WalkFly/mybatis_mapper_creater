package cn.com.zx.main.entity;

import java.util.Date;

/**
 * card 实体类
 * 2019-04-19 12:55:54
 */

public class Card extends BaseEntity {

    //卡编号(卡的外部编号)，如果为身份证，即为身份证号
    private String cardNo;

    //身份证号，用以对应实际开卡人
    private String identityCard;

    //卡的物理编号(出厂时设定，主要通过读卡器读取)
    private String cardUuid;

    //卡片原始类型：0-IC卡；1-身份证；2-CPU卡
    private Byte cardNativeType;

    //卡片自定义类型：0-工程卡；1-工程开门卡；2-工程关门卡；3-物业卡；4-房东卡；5-住户卡
    private Byte cardDefinedType;

    //卡片在当前合同下面的顺序号，取值1-255
    private Short cardSn;

    //卡片关联的合同号，如果为工程模式卡，则该字段为0
    private Long contractId;

    //卡片生效时间
    private Date cardStartTime;

    //卡片过期时间
    private Date cardExpireTime;

    //卡片是否被复制标识：0-未复制；1-已复制
    private Boolean cardCopiedFlag;

    //卡上的图片，一般为URL地址
    private String cardPic;

    private String cardCryptKey;

    //人脸特征数据
    private String faceData;

    //授权机关
    private String authority;

    //黑名单标识
    private Boolean blackFlag;

//    //关联的指令ID，可根据该ID间接获取该门卡在平台端或锁端的状态
//    private Long commandId;


    public Card() {
    }

    public Card(String identityCard, String cardUuid, Long contractId, String cardPic, String faceData) {
        this.cardNo = identityCard;
        this.identityCard = identityCard;
        this.cardUuid = cardUuid;
        this.contractId = contractId;
        this.cardPic = cardPic;
        this.faceData = faceData;
        this.cardDefinedType = (byte) 4;
        this.cardNativeType = (byte) 1;
        this.setValidState((byte) 2);
        this.blackFlag = false;
    }

    public String getCardCryptKey() {
        return cardCryptKey;
    }

    public void setCardCryptKey(String cardCryptKey) {
        this.cardCryptKey = cardCryptKey;
    }

    public String getFaceData() {
        return faceData;
    }

    public void setFaceData(String faceData) {
        this.faceData = faceData;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setCardUuid(String cardUuid) {
        this.cardUuid = cardUuid;
    }

    public String getCardUuid() {
        return cardUuid;
    }

    public void setCardNativeType(Byte cardNativeType) {
        this.cardNativeType = cardNativeType;
    }

    public Byte getCardNativeType() {
        return cardNativeType;
    }

    public void setCardDefinedType(Byte cardDefinedType) {
        this.cardDefinedType = cardDefinedType;
    }

    public Byte getCardDefinedType() {
        return cardDefinedType;
    }

    public void setCardSn(Short cardSn) {
        this.cardSn = cardSn;
    }

    public Short getCardSn() {
        return cardSn;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setCardStartTime(Date cardStartTime) {
        this.cardStartTime = cardStartTime;
    }

    public Date getCardStartTime() {
        return cardStartTime;
    }

    public void setCardExpireTime(Date cardExpireTime) {
        this.cardExpireTime = cardExpireTime;
    }

    public Date getCardExpireTime() {
        return cardExpireTime;
    }

    public void setCardCopiedFlag(Boolean cardCopiedFlag) {
        this.cardCopiedFlag = cardCopiedFlag;
    }

    public Boolean getCardCopiedFlag() {
        return cardCopiedFlag;
    }

    public void setCardPic(String cardPic) {
        this.cardPic = cardPic;
    }

    public String getCardPic() {
        return cardPic;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }

//    public void setCommandId(Long commandId) {
//        this.commandId = commandId;
//    }
//
//    public Long getCommandId() {
//        return commandId;
//    }

    public Boolean getBlackFlag() {
        return blackFlag;
    }

    public void setBlackFlag(Boolean blackFlag) {
        this.blackFlag = blackFlag;
    }
}


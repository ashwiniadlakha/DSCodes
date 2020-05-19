/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package AirtelGame;

/**
 * @author ashwini.adlakha
 * @version $Id: HoliTool.java, v 0.1 2020-05-06 5:02 PM ashwini.adlakha Exp $$
 */
public enum HoliTool {


        Balloon("", "", 10),
        Water_Bucket("", "", 20),
        Water_Gun("", "", 20),
        Sweets("", "", 40);

    private String code;
    private String description;
    private int cashRequired;

    private HoliTool(String code, String description, int cashRequired){
            this.code = code;
            this.description = description;
            this.cashRequired = cashRequired;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCashRequired() {
        return cashRequired;
    }

    public void setCashRequired(int cashRequired) {
        this.cashRequired = cashRequired;
    }


}
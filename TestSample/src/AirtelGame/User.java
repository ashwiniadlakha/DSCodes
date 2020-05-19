/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package AirtelGame;

import java.util.List;

/**
 * @author ashwini.adlakha
 * @version $Id: User.java, v 0.1 2020-05-06 4:58 PM ashwini.adlakha Exp $$
 */
public class User {



    private int id;
    private int cashAvailaible;
    private List<HoliTool> holiTool;


    public User(int id, int cashAvailaible, List<HoliTool> holiTool){
        this.id = id;
        this.cashAvailaible = cashAvailaible;
        this.holiTool = holiTool;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCashAvailaible() {
        return cashAvailaible;
    }

    public void setCashAvailaible(int cashAvailaible) {
        this.cashAvailaible = cashAvailaible;
    }

    public List<HoliTool> getHoliTool() {
        return holiTool;
    }

    public void setHoliTool(List<HoliTool> holiTool) {
        this.holiTool = holiTool;
    }


}
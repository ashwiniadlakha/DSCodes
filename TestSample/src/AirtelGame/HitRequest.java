/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package AirtelGame;

/**
 * @author ashwini.adlakha
 * @version $Id: HitRequest.java, v 0.1 2020-05-06 5:24 PM ashwini.adlakha Exp $$
 */
public class HitRequest {

    User requestCreator;
    User requestRecipient;
    HoliTool toolUsed;

    public HitRequest(User requestCreator, User requestRecipient, HoliTool holiTool){
        this.requestCreator = requestCreator;
        this.requestRecipient = requestRecipient;
        this.toolUsed = holiTool;
    }
}
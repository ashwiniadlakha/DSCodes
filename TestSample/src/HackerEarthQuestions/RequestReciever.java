/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package HackerEarthQuestions;

/**
 * @author dongsheng.hds
 * @version $Id: RequestReciever.java, v 0.1 2020-05-29 8:34 AM dongsheng.hds Exp $$
 */
public interface RequestReciever {

    void recieveRequest(String sessionId) throws Exception;
}
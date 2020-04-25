package HackerRankQuestions; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author ashwini.adlakha
 * @version $Id: HackerRankQuestions.CSVReader.java, v 0.1 2020-01-27 11:31 PM ashwini.adlakha Exp $$
 */
public class CSVReader {


    public static void main(String[] args) {

        String csvFile = "/Users/ashwini/Downloads/APCashierSheet3.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] AssetFluxDetails = line.split(cvsSplitBy);

                System.out.println("Country [sofa= " + AssetFluxDetails[0] + " , extendInfo=" + AssetFluxDetails[2] + "]");

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
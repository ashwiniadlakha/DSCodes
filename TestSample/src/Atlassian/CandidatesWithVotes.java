/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package Atlassian;

import java.util.Comparator;

/**
 * @author ashwini.adlakha
 * @version $Id: CandidatesWithVotes.java, v 0.1 2020-05-29 10:19 AM ashwini.adlakha Exp $$
 */
public class CandidatesWithVotes implements Comparable<CandidatesWithVotes> {
    public String candidate;
    public Integer vote;

    @Override
    public int compareTo(CandidatesWithVotes o) {
        return o.vote-this.vote;
    }
}
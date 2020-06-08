/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package Atlassian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author ashwini.adlakha
 * @version $Id: Election.java, v 0.1 2020-05-29 9:35 AM ashwini.adlakha Exp $$
 */
public class Election {

    static Map<String, CandidatesWithVotes> votesForCandidates = new HashMap<String, CandidatesWithVotes>();
    static PriorityQueue<CandidatesWithVotes> votesPriorityQueue = new PriorityQueue<CandidatesWithVotes>();



    public static void main(String a[]) {

        List<String> votes = getEqualCaseVotes();


        for (String vote : votes) {
            addVoteToMap(vote);
        }

        List<String> candidatesWithMaxVote = getCandidateWithMaxVotes();



        for(String candidate : candidatesWithMaxVote) {
            System.out.println(candidate);
        }



    }


    int result = 0;

    public int maxLength(List<String> arr) {

        getMaxUniqueCount(arr,  0 , "");
        return result;

    }

    void getMaxUniqueCount(List<String> arr, int index, String resultString){


        if(index == arr.size() -1 && getUniqueStringCount(resultString) > result){
            result = resultString.length();
            return;
        }

        if(index == arr.size() -1){
            return;
        }

        getMaxUniqueCount(arr, index+1, resultString);
        getMaxUniqueCount(arr, index+1, resultString+arr.get(index));

    }

    int getUniqueStringCount(String val){

        char[] valArray = val.toCharArray();
        char[] uniqueCount = new char[26];
        for(char c : valArray){
            if(uniqueCount[(c-'a')] == 0){
                uniqueCount[(c-'a')] = 1;
            }else{
                return -1;
            }
        }

        return val.length();

    }

    //Blank Votes
    //Equal votesPriorityQueue
    //Normal


    private static void addVoteToMap(String vote) {

        if(vote!=null && !vote.equals("")) {
            CandidatesWithVotes voteCount = votesForCandidates.get(vote);
            if (voteCount == null) {
                voteCount = new CandidatesWithVotes();
                voteCount.candidate = vote;
                voteCount.vote = 1;
                votesForCandidates.put(vote, voteCount);
                votesPriorityQueue.add(voteCount);
            } else {
                voteCount.vote = voteCount.vote+1 ;
            }
        }
    }

    public static List<String> getVotesPriorityQueue() {
        List<String> votes = new ArrayList<String>();
        votes.add("SAM");
        votes.add("SAM");
        votes.add("MAX");
        votes.add("ALEX");
        return votes;
    }


    public static List<String> getEqualCaseVotes() {
        List<String> votes = new ArrayList<String>();
        votes.add("SAM");
        votes.add("SAM");
        votes.add("MAX");
        votes.add("MAX");
        votes.add("ALEX");
        return votes;
    }

    public static List<String> getWithEmptyCaseVotes() {
        List<String> votes = new ArrayList<String>();
        votes.add("SAM");
        votes.add("SAM");
        votes.add("MAX");
        votes.add("MAX");
        votes.add("ALEX");
        votes.add("");
        votes.add(null);
        votes.add("");
        votes.add("");
        return votes;
    }


    public static List<String> getCandidateWithMaxVotes() {

        List<String> maxVotedCandidateList = new ArrayList<String>();
        Integer maxVotes = 0;
        while(!votesPriorityQueue.isEmpty()){
            CandidatesWithVotes candidatesWithVotes = votesPriorityQueue.remove();
            if(maxVotes == 0){
                maxVotes = candidatesWithVotes.vote;
                maxVotedCandidateList.add(candidatesWithVotes.candidate);
            }else{
                if(maxVotes == candidatesWithVotes.vote){
                    maxVotedCandidateList.add(candidatesWithVotes.candidate);
                }
            }
        }
        return maxVotedCandidateList;

        /*List<String> maxVotedCandidateList = new ArrayList<String>();
        Integer maxVotes = 0;
        Set<String> candidates = votesForCandidates.keySet();

        for(String candidate : candidates){
            Integer vote = votesForCandidates.get(candidate);
            if(maxVotes < vote){
                maxVotes = vote;
            }
        }

        for(String candidate : candidates){
            Integer vote = votesForCandidates.get(candidate);
            if(maxVotes == vote){
                maxVotedCandidateList.add(candidate);
            }
        }

        return maxVotedCandidateList;*/
    }
}


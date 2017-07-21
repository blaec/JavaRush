package com.javarush.task.task36.task3611;


import java.util.*;

/* 
Сколько у человека потенциальных друзей?
*/

public class Solution {
    private boolean[][] humansRelationships;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.humansRelationships = generateRelationships();

        Set<Integer> allFriendsAndPotentialFriends = solution.getAllFriendsAndPotentialFriends(4, 2);
        System.out.println(allFriendsAndPotentialFriends);                              //expected: [0, 1, 2, 3, 5, 7]
        Set<Integer> potentialFriends = solution.removeFriendsFromSet(allFriendsAndPotentialFriends, 4);
        System.out.println(potentialFriends);                                           //expected: [2, 5, 7]
    }

    public Set<Integer> getAllFriendsAndPotentialFriends(int index, int deep) {
        //напишите тут ваш код
        Set<Integer> result = new HashSet<>();
        if (deep == 0) return result;
        for (int i = 0; i < humansRelationships.length; i++) {
            if (i < index) {
                if (humansRelationships[index][i]) {
                    result.add(i);
                    result.addAll(getAllFriendsAndPotentialFriends(i, deep - 1));
                }
            } else {
                if (humansRelationships[i][index]) {
                    result.add(i);
                    result.addAll(getAllFriendsAndPotentialFriends(i, deep - 1));
                }
            }
        }
        result.remove(index);
        return result;
    }
//
//    public Set<Integer> getAllFriendsAndPotentialFriends(int index, int deep) {
//        //напишите тут ваш код DEEP == 0 NOT WORK HERE
//        Set<Integer> allFriends = null;
//        Set<Integer> nextDeep = null;
//        Set<Integer> allPotentialFriends = null;
//
//        for (int x = 0; x < deep; x++) {
//            if (x == 0) {
//                allFriends = getFriends(index, index);
//                nextDeep = allFriends;
//            }
//            else if (x > 0) {
//                Set<Integer> potentialFriends = null;
//                for (Integer a : nextDeep) {
//                    if (potentialFriends != null) {
//                        potentialFriends.addAll(getFriends(a, index));
//                    }
//                    else {
//                        potentialFriends = getFriends(a, index);
//                    }
//                }
//
//                if (allPotentialFriends != null) {
//                    allPotentialFriends.addAll(potentialFriends);
//                }
//                else {
//                    allPotentialFriends = potentialFriends;
//                }
//                nextDeep = potentialFriends;
//            }
//        }
//        allFriends.addAll(allPotentialFriends);
//        return allFriends;
//    }
//
//    private Set<Integer> getFriends(int index, int current) {
//        Set<Integer> sample = new HashSet<>();
//        for (int i = 0; i < humansRelationships.length; i++) {
//            if (i != current) {
//                if (i < index && humansRelationships[index][i]) {
//                    sample.add(i);
//                } else if (i > index && humansRelationships[i][index]) {
//                    sample.add(i);
//                }
//            }
//        }
//        return sample;
//    }


    //remove people from set, with which you have already had relationship
    public Set<Integer> removeFriendsFromSet(Set<Integer> set, int index) {
        for (int i = 0; i < humansRelationships.length; i++) {
            if ((i < index) && (index < humansRelationships.length) && humansRelationships[index][i]) {
                set.remove(i);
            } else if ((i > index) && humansRelationships[i][index]) {
                set.remove(i);
            }
        }
        return set;
    }

    //return test data
    private static boolean[][] generateRelationships() {
        return new boolean[][]{
                {true},                                                                 //0
                {true, true},                                                           //1
                {false, true, true},                                                    //2
                {false, false, false, true},                                            //3
                {true, true, false, true, true},                                        //4
                {true, false, true, false, false, true},                                //5
                {false, false, false, false, false, true, true},                        //6
                {false, false, false, true, false, false, false, true}                  //7
        };
    }
}
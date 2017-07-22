package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("C:\\Users\\blaec\\Google Drive\\Java\\javaRush\\projects\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task39\\task3913\\logs\\"));
        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
        System.out.println(logParser.getIPsForUser("Amigo", null, new Date()));
        System.out.println(logParser.getIPsForStatus(Status.OK, null, new Date()));
        System.out.println(logParser.getIPsForEvent(Event.SOLVE_TASK, null, new Date()));
        System.out.println(" ===== USERS =====");
        System.out.println(logParser.getAllUsers());
        System.out.println(logParser.getNumberOfUsers(new Date(), null));
        System.out.println("getNumberOfUserEvents: " + logParser.getNumberOfUserEvents("Amigo", null, null));
        System.out.println("getUsersForIP: " + logParser.getUsersForIP("127.0.0.1",  new Date(), null));
        System.out.println("getLoggedUsers: " + logParser.getLoggedUsers(null, new Date()));
        System.out.println("getDownloadedPluginUsers: " + logParser.getDownloadedPluginUsers(null, new Date()));
        System.out.println("getSolvedTaskUsers [18]: " + logParser.getSolvedTaskUsers(null, null, 18));
        System.out.println(" ===== DATES =====");
        System.out.println("for user & event: " + logParser.getDatesForUserAndEvent("Amigo", Event.SOLVE_TASK, null, null));
        System.out.println("status FAILED: " + logParser.getDatesWhenSomethingFailed(null, null));
        System.out.println("status ERROR: " + logParser.getDatesWhenErrorHappened(null, null));
        System.out.println("first log: " + logParser.getDateWhenUserLoggedFirstTime("Amigo", null, null));
        System.out.println("solved task: " + logParser.getDateWhenUserSolvedTask("Amigo", 18,null, null));
        System.out.println("WRITE_MESSAGE: " + logParser.getDatesWhenUserWroteMessage("Eduard Petrovich Morozko",null, null));
        System.out.println(" ===== DATES =====");
        System.out.println("all events: " + logParser.getAllEvents(null, null));
        System.out.println("all events for user: " + logParser.getEventsForUser("Eduard Petrovich Morozko", null, null));
        System.out.println("all events FAILED: " + logParser.getFailedEvents(null, null));
        System.out.println("count task attemts to solve: " + logParser.getNumberOfAttemptToSolveTask(18,null, null));
        System.out.println("count successful task attemts to solve: " + logParser.getNumberOfSuccessfulAttemptToSolveTask(18,null, null));
        System.out.println("get solved map: " + logParser.getAllSolvedTasksAndTheirNumber(null, null));
        System.out.println(" ===== QLQuery =====");
        System.out.println("query - get ip: " + logParser.execute("get ip"));
        System.out.println("query - get user: " + logParser.execute("get user"));
        System.out.println("query - get date: " + logParser.execute("get date"));
        System.out.println("query - get event: " + logParser.execute("get event"));
        System.out.println("query - get status: " + logParser.execute("get status"));
        System.out.println("query - get ips for event: " + logParser.execute("get ip for event = \"DONE_TASK\""));
        System.out.println("query - get ips for user between dates: " + logParser.execute("get ip for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\""));
        System.out.println("query - get ips for event: " + logParser.execute("get ip for event = \"LOGIN\" and date between \"11.12.2011 0:00:00\" and \"03.01.2016 23:59:59\""));
    }
}
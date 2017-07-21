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
    }
}
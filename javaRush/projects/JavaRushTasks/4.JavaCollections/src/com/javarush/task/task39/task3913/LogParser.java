package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.io.*;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    List<LogRecord> logLines = null;

    public LogParser(Path logDir) {
        logLines = new ArrayList<>();

        // Loop all the files (*.log) in logDir folder and add lines to logLines list
        File dir = new File(String.valueOf(logDir));
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                if (child.toString().toLowerCase().endsWith(".log"))
                    readLogFile(child);
            }
        }
    }

    // ~~~~~~~~~~~~~~~~~~~~ IPQuery implementation ~~~~~~~~~~~~~~~~~~~~
    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return getIpSet(null, after, before);
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return getIpSet(user, after, before);
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return getIpSet(event, after, before);
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return getIpSet(status, after, before);
    }

    // ~~~~~~~~~~~~~~~~~~~~ UserQuery implementation ~~~~~~~~~~~~~~~~~~~~
    @Override
    public Set<String> getAllUsers() {
        Set<String> users = new HashSet<>();

        for (LogRecord log : logLines) {
            users.add(log.getUser());
        }

        return users;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();

        for (LogRecord log : logLines) {
            if (isDateValid(log.getDate(), after, before))
                users.add(log.getUser());
        }

        return users.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        Set<Event> events = new HashSet<>();

        for (LogRecord log : logLines) {
            if (isDateValid(log.getDate(), after, before) && user.equals(log.getUser())) {
                events.add(log.getEvent());
            }
        }

        return events.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        Set<String> users = new HashSet<>();

        for (LogRecord log : logLines) {
            if (isDateValid(log.getDate(), after, before) && ip.equals(log.getIp())) {
                users.add(log.getUser());
            }
        }

        return users;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        return getUserSet(Event.LOGIN, after, before, -1);
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        return getUserSet(Event.DOWNLOAD_PLUGIN, after, before, -1);
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        return getUserSet(Event.WRITE_MESSAGE, after, before, -1);
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        return getUserSet(Event.SOLVE_TASK, after, before, -1);
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        return getUserSet(Event.SOLVE_TASK, after, before, task);
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        return getUserSet(Event.DONE_TASK, after, before, -1);
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        return getUserSet(Event.DONE_TASK, after, before, task);
    }

    // ~~~~~~~~~~~~~~~~~~~~ DateQuery implementation ~~~~~~~~~~~~~~~~~~~~
    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        Set<Date> dates = new HashSet<>();

        for (LogRecord log : logLines) {
            if (isDateValid(log.getDate(), after, before) && user.equals(log.getUser()) && event.equals(log.getEvent())) {
                dates.add(log.getDate());
            }
        }

        return dates;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        return getDateSet(Status.FAILED, after, before);
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        return getDateSet(Status.ERROR, after, before);
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        Date date = null;

        for (LogRecord log : logLines) {
            if (isDateValid(log.getDate(), after, before)
                    && user.equals(log.getUser())
                    && Event.LOGIN.equals(log.getEvent())) {

                if (date == null) date = log.getDate();
                else date = date.getTime() < log.getDate().getTime() ? date : log.getDate();
            }
        }

        return date;
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        return getEventDate(user, Event.SOLVE_TASK, task, after, before);
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        return getEventDate(user, Event.DONE_TASK, task, after, before);
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        return getDateSet(user, Event.WRITE_MESSAGE, after, before);
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        return getDateSet(user, Event.DOWNLOAD_PLUGIN, after, before);
    }

    // ~~~~~~~~~~~~~~~~~~~~ EventQuery implementation ~~~~~~~~~~~~~~~~~~~~
    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getAllEvents(after, before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        return getEventSet(false, null, after, before);
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        return getEventSet(true, ip, after, before);
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        return getEventSet(false, user, after, before);
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        return getEventSet(Status.FAILED, after, before);
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        return getEventSet(Status.ERROR, after, before);
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        return countSolved(Event.SOLVE_TASK, task, after, before);
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        return countSolved(Event.DONE_TASK, task, after, before);
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        return getTaskNumber(Event.SOLVE_TASK, after, before);
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        return getTaskNumber(Event.DONE_TASK, after, before);
    }

    // ~~~~~~~~~~~~~~~~~~~~ QLQuery implementation ~~~~~~~~~~~~~~~~~~~~
    @Override
    public Set<Object> execute(String query) {
        Set<Object> output = new HashSet<>();
        String field1 = null;
        String field2 = null;
        String value1 = null;
        String after = null;
        String before = null;

        // read fields
        Pattern pattern = Pattern.compile("get (ip|user|date|event|status)"
                + "( for (ip|user|date|event|status) = \"(.+?)\")?"
                + "( and date between \"(.+?)\" and \"(.+?)\")?");
        Matcher matcher = pattern.matcher(query);
        if (matcher.find()) {
            field1 = matcher.group(1);
            field2 = matcher.group(3);
            value1 = matcher.group(4);
            after = matcher.group(6);
            before = matcher.group(7);
        }

        // Loop the log and populate the appropriate Set
        for (LogRecord log : logLines) {
            if (matchFound(log, field2, value1, after, before)) {
                switch (field1) {
                    case "ip":      output.add(log.getIp());        break;
                    case "user":    output.add(log.getUser());      break;
                    case "date":    output.add(log.getDate());      break;
                    case "event":   output.add(log.getEvent());     break;
                    case "status":  output.add(log.getStatus());    break;
                }
            }
        }

        return output;
    }

    // ~~~~~~~~~~~~~~~~~~~~ Private class methods ~~~~~~~~~~~~~~~~~~~~
    // Check if value for field matches the log line
    private boolean matchFound(LogRecord logRecord, String field, String value, String sAfter, String sBefore)  {
        boolean result = false;
        Date after = null;
        Date before = null;
        Date dateLog = null;
        DateFormat dateFormat = new SimpleDateFormat("d.M.yyyy H:m:s");

        // Parse dates from strings
        try { dateLog = dateFormat.parse(value);    } catch (ParseException | NullPointerException e) { }
        try { after = dateFormat.parse(sAfter);     } catch (ParseException | NullPointerException e) { }
        try { before = dateFormat.parse(sBefore);   } catch (ParseException | NullPointerException e) { }

        // If date inside the dates' range - proceed
        if (isDateValid(logRecord.getDate(), after, before)) {
            if (field == null) result = true;
            else {
                switch (field) {
                    case "ip":      result = value.equals(logRecord.getIp());                       break;
                    case "user":    result = value.equals(logRecord.getUser());                     break;
                    case "event":   result = Event.valueOf(value).equals(logRecord.getEvent());     break;
                    case "status":  result = Status.valueOf(value).equals(logRecord.getStatus());   break;
                    case "date":    result = logRecord.getDate().equals(dateLog);                   break;
                }
            }
        }

        return result;
    }

    // Get set of unique IPs by object (user, status, event or null)
    private Set<String> getIpSet(Object record, Date after, Date before) {
        Set<String> outIp = new HashSet<>();

        for (LogRecord log : logLines) {
            if (isDateValid(log.getDate(), after, before) && isFieldMatch(record, log)) {
                outIp.add(log.getIp());
            }
        }

        return outIp;
    }

    // Get set of unique Users by event
    private Set<String> getUserSet(Event event, Date after, Date before, int taskNo) {
        Set<String> outUser = new HashSet<>();

        for (LogRecord log : logLines) {
            // by default no task could be added
            boolean addUser = false;

            if (isDateValid(log.getDate(), after, before) && event.equals(log.getEvent())) {

                // if task number positive, then check its number
                // otherwise - allow to add the user
                if (taskNo > 0) {
                    if (String.valueOf(taskNo).equals(log.getTaskNo())) {
                        addUser = true;
                    }
                } else addUser = true;
            }

            // add user to set if all conditions were met
            if (addUser) outUser.add(log.getUser());
        }

        return outUser;
    }

    // Get set of unique Dates by status
    private Set<Date> getDateSet(Status status, Date after, Date before) {
        Set<Date> outDate = new HashSet<>();

        for (LogRecord log : logLines) {
            if (isDateValid(log.getDate(), after, before) && status.equals(log.getStatus()))
                outDate.add(log.getDate());
        }

        return outDate;
    }

    // Get set of unique Dates by event for a user
    private Set<Date> getDateSet(String user, Event event, Date after, Date before) {
        Set<Date> outDate = new HashSet<>();

        for (LogRecord log : logLines) {
            if (isDateValid(log.getDate(), after, before)
                    && event.equals(log.getEvent())
                    && user.equals(log.getUser()))

                outDate.add(log.getDate());
        }

        return outDate;
    }

    // Return date when user done some event
    private Date getEventDate(String user, Event event, int task, Date after, Date before) {
        Date date = null;

        for (LogRecord log : logLines) {
            if (isDateValid(log.getDate(), after, before)
                    && user.equals(log.getUser())
                    && event.equals(log.getEvent())
                    && String.valueOf(task).equals(log.getTaskNo())) {

                if (date == null) date = log.getDate();
                else date = date.getTime() < log.getDate().getTime() ? date : log.getDate();
            }
        }

        return date;
    }

    // Get set of unique all Events (or filter by ip or name)
    private Set<Event> getEventSet(boolean isIP, String record, Date after, Date before) {
        Set<Event> outEvent = new HashSet<>();

        for (LogRecord log : logLines) {
            boolean addRecord = false;

            // for all events (record == null) - always true
            // for ip and name - true only if match found
            if (record != null) {
                if (isIP) {
                    if (record.equals(log.getIp())) addRecord = true;
                }  else {
                    if (record.equals(log.getUser())) addRecord = true;
                }
            } else addRecord = true;

            // add event to set if condition met
            if (isDateValid(log.getDate(), after, before) && addRecord) {
                outEvent.add(log.getEvent());
            }
        }

        return outEvent;
    }

    // Get set of unique Events by status
    private Set<Event> getEventSet(Status status, Date after, Date before) {
        Set<Event> outEvent = new HashSet<>();

        for (LogRecord log : logLines) {
            if (isDateValid(log.getDate(), after, before) && status.equals(log.getStatus())) {
                outEvent.add(log.getEvent());
            }
        }

        return outEvent;
    }

    private Map<Integer, Integer> getTaskNumber (Event event, Date after, Date before) {
        Map<Integer, Integer> map = new HashMap<>();

        for (LogRecord log : logLines) {
            if (isDateValid(log.getDate(), after, before) && event.equals(log.getEvent())) {
                int key = Integer.parseInt(log.getTaskNo());
                int attempt = 0;

                try { attempt = map.get(key); }
                catch (NullPointerException e) {};

                map.put(key, ++attempt);
            }
        }

        return map;
    }

    // Return number of solved / done task
    private int countSolved(Event event, int task, Date after, Date before) {
        int count = 0;

        for (LogRecord log : logLines) {
            if (isDateValid(log.getDate(), after, before)
                    && event.equals(log.getEvent())
                    && String.valueOf(task).equals(log.getTaskNo())) {

                count++;
            }
        }

        return count;
    }

    // Read single log file and add its content to array list
    private void readLogFile(File log) {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(log));
            while (br.ready()) { logLines.add(new LogRecord(br.readLine())); }
            br.close();
        } catch (IOException e) { e.printStackTrace(); }
    }

    // Get Object instance of the record field
    private boolean isFieldMatch(Object recordField, LogRecord record) {
        boolean result = false;

        if      (recordField == null)           { result =  true; }
        else if (recordField instanceof String) { result = record.getUser().equals(recordField); }
        else if (recordField instanceof Event)  { result = record.getEvent().equals(recordField); }
        else if (recordField instanceof Status) { result = record.getStatus().equals(recordField); }

        return result;
    }

    // If date within date range
    private boolean isDateValid(Date inDate, Date after, Date before) {
        boolean result = true;

        // task 7 and on - change the condition form < and > to <= and >=
        if      (after != null  && (inDate.getTime() <= after.getTime()))    { result =  false; }
        else if (before != null && (inDate.getTime() >= before.getTime()))   { result =  false; }

        return result;
    }

    // ~~~~~~~~~~~~~~~~~~~~ Private inner class ~~~~~~~~~~~~~~~~~~~~
    private class LogRecord {
        private String ip;
        private String user;
        private Date date;
        private Event event;
        private String taskNo;
        private Status status;

        public LogRecord(String record) {

            // Parse single line in logLine array to elements: ip[0], user[1], date[2], event[3], status[4]
            // while log itself is tab-delimited
            String[] logLine = record.split("\t");

            // get ip and user
            ip = logLine[0].trim();
            user = logLine[1];

            // get date by converting string date representation to Date
            DateFormat dateFormat = new SimpleDateFormat("d.M.yyyy H:m:s");
            try {
                date = dateFormat.parse(logLine[2]);
            } catch (ParseException e) { e.printStackTrace(); }

            // get event & task
            String[] eventTask = logLine[3].split(" ");
            event = Event.valueOf(eventTask[0]);
            if (eventTask.length > 1) taskNo = eventTask[1];

            // get status
            status = Status.valueOf(logLine[4]);
        }

        public String getIp()       { return ip; }
        public String getUser()     { return user; }
        public Date getDate()       { return date; }
        public Event getEvent()     { return event; }
        public String getTaskNo()   { return taskNo; }
        public Status getStatus()   { return status; }
    }
}
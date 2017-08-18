package com.javarush.task.task23.task2309;

import com.javarush.task.task23.task2309.vo.*;

import java.util.List;

/* 
Анонимность иногда так приятна!
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.getUsers());
        print(solution.getLocations());
    }

    public static void print(List list) {
        String format = "Id=%d, name='%s', description=%s";
        for (Object obj : list) {
            NamedItem item = (NamedItem) obj;
            System.out.println(String.format(format, item.getId(), item.getName(), item.getDescription()));
        }
    }

    public List<User> getUsers() {
        AbstractDbSelectExecutor user = new AbstractDbSelectExecutor<User>() {

            @Override
            public String getQuery() {
                return "SELECT * FROM USER";
            }

        };
        return user.execute();
    }

    public List<Location> getLocations() {
        AbstractDbSelectExecutor location = new AbstractDbSelectExecutor<Location>() {
            @Override
            public String getQuery() {
                return "SELECT * FROM LOCATION";
            }
        };
        return location.execute();
    }

    public List<Server> getServers() {
        AbstractDbSelectExecutor server = new AbstractDbSelectExecutor<Server>() {

            @Override
            public String getQuery() {
                return "SELECT * FROM SERVER";
            }
        };
        return server.execute();
    }

    public List<Subject> getSubjects() {
        AbstractDbSelectExecutor subject = new AbstractDbSelectExecutor<Subject>() {

            @Override
            public String getQuery() {
                return "SELECT * FROM SUBJECT";
            }
        };
        return subject.execute();
    }

    public List<Subscription> getSubscriptions() {
        AbstractDbSelectExecutor subscription = new AbstractDbSelectExecutor<Subscription>() {

            @Override
            public String getQuery() {
                return "SELECT * FROM SUBSCRIPTION";
            }
        };
        return subscription.execute();
    }
}

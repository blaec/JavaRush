package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable{

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    @Override
    protected Solution clone() throws CloneNotSupportedException {
        Solution clonedSolution = new Solution();
        for (Map.Entry<String, User> pair : this.users.entrySet()) {
            User clonedUser = pair.getValue().clone();
            clonedSolution.users.put(pair.getKey(), clonedUser);
        }
        return clonedSolution;
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable{
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        protected User clone() throws CloneNotSupportedException {
            return new User(this.age, this.name);
        }

        @Override
        public int hashCode() {
            return name.hashCode() + 31 * age;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this)            return true;
            if (!(obj instanceof User)) return false;

            User user = (User) obj;
            if (age != user.age)            return false;
            if (!(name.equals(user.name)))  return false;

            return true;
        }
    }
}

package com.javarush.task.task20.task2002;

import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", ".txt", new File("C:/Users/blaec/"));
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("FirstName");
            user.setCountry(User.Country.OTHER);
            user.setBirthDate(new Date(63,0,16));
            javaRush.users.add(user);

            User user1 = new User();
            user1.setFirstName("FirstName1");
            user1.setLastName("LastName1");
            user1.setCountry(User.Country.RUSSIA);
            user1.setBirthDate(new Date(13,2,16));
            user1.setMale(true);
            javaRush.users.add(user1);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            if (!users.isEmpty()) {

                for (int i = 0; i < users.size(); i++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(users.get(i).getFirstName());
                    sb.append(" ").append(users.get(i).getLastName());
                    sb.append(" ").append(users.get(i).getCountry());
                    sb.append(" ").append(users.get(i).isMale());
                    sb.append(" ").append(users.get(i).getBirthDate().getTime()).append("\n");
                    outputStream.write(sb.toString().getBytes());
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            while (reader.ready()) {
                String[] line = reader.readLine().split(" ");
                User user = new User();
                if (!line[0].equals("null")) user.setFirstName(line[0]);
                if (!line[1].equals("null")) user.setLastName(line[1]);
                if (!line[2].equals("null")) {
                    if (line[2].equals(User.Country.OTHER.name()))
                        user.setCountry(User.Country.OTHER);
                    else if (line[2].equals(User.Country.RUSSIA.name()))
                        user.setCountry(User.Country.RUSSIA);
                    else if (line[2].equals(User.Country.UKRAINE.name()))
                        user.setCountry(User.Country.UKRAINE);
                }
                if (!line[3].equals("null")) user.setMale(Boolean.parseBoolean(line[3])) ;

                if (!line[4].equals("null")) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(Long.parseLong(line[4]));
                    user.setBirthDate(calendar.getTime());
                }
                this.users.add(user);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}

package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements ATableInterface {
        private ATableInterface element;

        public TableInterfaceWrapper(ATableInterface element) {
            this.element = element;
        }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            element.setModel(rows);
        }

        @Override
        public String getHeaderText() {
            return element.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            element.setHeaderText(newHeaderText);
        }
    }

    public interface ATableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);

    }

    public static void main(String[] args) {
    }
}
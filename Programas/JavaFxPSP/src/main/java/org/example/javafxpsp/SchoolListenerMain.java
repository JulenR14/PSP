package org.example.javafxpsp;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class SchoolListenerMain {

    public static void main(String[] args) {
        ObservableList<String> students = FXCollections.observableArrayList();
        School school = new School();
        students.addListener(school);
        students.add("David");
        students.add("Juan");
        students.remove("David");

        students.addListener(new ListChangeListener<School>() {
            @Override
            public void onChanged(Change<? extends School> c) {
                while (c.next()) {
                    if (c.wasPermutated()) {
                        for (int i = c.getFrom(); i < c.getTo(); ++i) {
                            //permutate
                        }
                    } else if (c.wasUpdated()) {
                        //update item
                    } else {
                        for (Item remitem : c.getRemoved()) {
                            remitem.remove(Outer.this);
                        }
                        for (Item additem : c.getAddedSubList()) {
                            additem.add(Outer.this);
                        }
                    }
                }
            }
        });
    }


}

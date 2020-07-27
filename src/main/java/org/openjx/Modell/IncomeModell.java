package org.openjx.Modell;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.openjx.Data;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.sql.Date;
import java.util.*;

public class IncomeModell {

    private Date date;
    private String comment, name;
    private long income;
    public Gson gson = new Gson();


    Data data = new Data();
    FileOutputStream outputStream;
    String filename = "Incomes.json";


    public IncomeModell() {

    }

    public static <T extends Comparable<T>> void sort(final List<Date> key, List<?>... lists) {

        if (key == null || lists == null)
            return;

        for (List<?> list : lists) {

            if (key.size() != list.size())
                return;
        }
        if (key.size() < 2)
            return;

        List<Integer> indices = new ArrayList<Integer>();
        for (int i = 0; i < key.size(); i++)
            indices.add(i);


        indices.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer i, Integer j) {
                return key.get(i).compareTo(key.get(j));
            }
        });

        Map<Integer, Integer> swapMap = new HashMap<>(indices.size());
        List<Integer> swapFrom = new ArrayList<>(indices.size()),
                swapTo = new ArrayList<>(indices.size());


        for (int i = 0; i < key.size(); i++) {
            int k = indices.get(i);
            while (i != k && swapMap.containsKey(k))
                k = swapMap.get(k);

            swapFrom.add(i);
            swapTo.add(k);
            swapMap.put(i, k);
        }


        for (List<?> list : lists)
            for (int i = 0; i < list.size(); i++)
                Collections.swap(list, swapFrom.get(i), swapTo.get(i));
    }



    public void write() {

        System.out.println(gson.toJson(data));
        String s = gson.toJson(data);

        try {
            outputStream = new FileOutputStream("Incomes.json");
            outputStream.write(s.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void read() {
        try {
            JsonReader reader = new JsonReader(new FileReader(filename));
            data = gson.fromJson(reader, Data.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    public void setDate(Date date) {
        this.date = date;
        data.setDates(date);
    }

    public void setComment(String comment) {
        this.comment = comment;
        data.setComments(comment);
    }

    public void setName(String name) {
        this.name = name;
        data.setNames(name);
    }

    public void setIncome(Long income) {
        this.income = income;
        data.setIncomes(income);
    }

    public void sortInputs() {
        Collections.sort(data.getDates());


    }

    public Data getData() {
        return data;
    }
}

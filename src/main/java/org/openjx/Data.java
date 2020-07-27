package org.openjx;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Data {


    private List<Date> dates = new ArrayList<>();
    private List<String> names = new ArrayList<>();
    private List<Long> incomes = new ArrayList<>();
    private List<String> comments= new ArrayList<>();

    public List<Date> getDates() {
        return dates;
    }

    public List<String> getNames() {
        return names;
    }

    public List<Long> getIncomes() {
        return incomes;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setDates(Date dates) {
        this.dates.add(dates);
    }

    public void setNames(String names) {
        this.names.add(names);
    }

    public void setIncomes(Long incomes) {
        this.incomes.add(incomes);
    }

    public void setComments(String comments) {
        this.comments.add(comments);
    }
}

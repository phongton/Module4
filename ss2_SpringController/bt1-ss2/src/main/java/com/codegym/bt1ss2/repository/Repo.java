package com.codegym.bt1ss2.repository;

import com.codegym.bt1ss2.model.Condiment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class Repo implements IRepo{
   private static List<Condiment> condiments;

static {
    condiments = new ArrayList<>();
    condiments.add(new Condiment("Lettuce"));
    condiments.add(new Condiment("Tomato"));
    condiments.add(new Condiment("Mustard"));
    condiments.add(new Condiment("Sprouts"));

}
    @Override
    public List<Condiment> condimentList() {
        return condiments;
    }
}

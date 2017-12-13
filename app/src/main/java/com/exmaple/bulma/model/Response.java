package com.exmaple.bulma.model;

import com.prashant.java.bulmabuilder.BulmaBuilder;

import java.util.List;

@BulmaBuilder
public class Response {

    private List<CategoriesBean> categories;
    private List<RankingsBean> rankings;

    public List<CategoriesBean> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoriesBean> categories) {
        this.categories = categories;
    }

    public List<RankingsBean> getRankings() {
        return rankings;
    }

    public void setRankings(List<RankingsBean> rankings) {
        this.rankings = rankings;
    }

}

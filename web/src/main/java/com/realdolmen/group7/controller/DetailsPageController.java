package com.realdolmen.group7.controller;

import com.realdolmen.group7.service.SearchServiceImpl;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by PMTBF30 on 13/11/2017.
 */

@Named
@SessionScoped
public class DetailsPageController implements Serializable{

    @Inject
    private SearchServiceImpl searchService;

    @Inject
    private SearchController searchController;

    @Inject
    private SearchResultController searchResultController;


    public SearchServiceImpl getSearchService() {
        return searchService;
    }

    public void setSearchService(SearchServiceImpl searchService) {
        this.searchService = searchService;
    }

    public SearchController getSearchController() {
        return searchController;
    }

    public void setSearchController(SearchController searchController) {
        this.searchController = searchController;
    }

    public SearchResultController getSearchResultController() {
        return searchResultController;
    }

    public void setSearchResultController(SearchResultController searchResultController) {
        this.searchResultController = searchResultController;
    }
}

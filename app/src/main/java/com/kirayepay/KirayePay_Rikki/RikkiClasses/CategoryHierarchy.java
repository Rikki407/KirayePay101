package com.kirayepay.KirayePay_Rikki.RikkiClasses;

import com.kirayepay.KirayePay_Rikki.Network.Responses.CategoriesContainments;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by rikki on 8/3/17.
 */

public class CategoryHierarchy
{
    private static HashMap<Integer,ArrayList<CategoriesContainments>> subcategories = new HashMap<>();

    public static HashMap<Integer, ArrayList<CategoriesContainments>> getSubcategories() {
        return subcategories;
    }

    public static void setSubcategories(HashMap<Integer, ArrayList<CategoriesContainments>> subcategories) {
        CategoryHierarchy.subcategories = subcategories;
    }
}

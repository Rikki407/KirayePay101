package com.kirayepay.kirayepay101.RikkiClasses;

import java.util.HashMap;

/**
 * Created by rikki on 8/3/17.
 */

public class Acquire {
    public static final String API_KEY = "VZE6G37Kx8S1n7fnQBaSsK8cAu6zyF5h1aV8OznB9gofAt9iJYoeOs3aLfHz";
    public static boolean NETWORK_CONNECTED = false;
    public static int MAIN_CAT_COUNT = 0;
    public static int SUBCAT_NUM = 0;
    public static boolean IS_LISTVIEW = true;
    public static final int NORMAL_CALL = 0;
    public static final int MOSTVIEWED_CALL = 1;
    public static final int GOOGLE_AUTH = 1;
    public static final int FACEBOOK_AUTH = 2;
    public static final int EMAIL_AUTH = 3;

    public static final String USER_NAME="un";
    public static final String USER_ID="ui";
    public static final String USER_EMAIL="ue";
    public static final String USER_AUTH_METHOD="uea";
    public static final String USER_DETAILS = "user_details";
    public static int PRICE_SEEKBAR_MAX = 0;
    public static int INIT_ABC_PAGER_POS = -2;
    public static int SECURITY_SEEKBAR_MAX = 0;
    public static int PRICE_SEEKBAR_CURR = Integer.MAX_VALUE;
    public static int SECURITY_SEEKBAR_CURR = Integer.MAX_VALUE;

    public static String IP_ADDRESS = "noaddress";

    public static HashMap<Integer,Boolean> RENTAL_OPTIONS = new HashMap<>();
    /*
        CONDITION = 100 means new condition
        CONDITION = 200 means used condition
        CONDITION = 300 means both condition
     */
    public static String CONTDITITON = "Both";

    public static String MAIN_URI = "_";



}
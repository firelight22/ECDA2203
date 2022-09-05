package com.quentinrouet.bddarticle;

/**
 * Created by quentin for BddArticle on 05/09/2022.
 */
public class ArticleContract {
   public static final String NOM_TABLE = "article";
   public static final String COL_ID = "id";
   public static final String COL_NOM = "nom";
   public static final String COL_DESCRIPTION = "description";
   public static final String COL_PRIX = "prix";
   public static final String COL_NOTE = "note";
   public static final String COL_IS_ACHETE = "is_achete";
   public static final String COL_URL = "url";

   public static final String CREATE_TABLE = " CREATE TABLE "+ NOM_TABLE +"( "+
           COL_ID + " INTEGER PRIMARY KEY,"+
           COL_NOM + "TEXT,"+
           COL_DESCRIPTION + "TEXT,"+
           COL_PRIX + "REAL,"+
           COL_NOTE + "REAL,"+
           COL_IS_ACHETE + "NUMERIC,"+
           COL_URL + "TEXT);";
   public static final String DROP_TABLE = "DROP TABLE " + NOM_TABLE + ";";
}

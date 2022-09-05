package com.quentinrouet.bddarticle;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by quentin for BddArticle on 05/09/2022.
 */
public class ArticleDao {
   private SQLiteDatabase db;

   public ArticleDao(DbHelper helper) {
      this.db = helper.getWritableDatabase();
   }

   public long insert(Article article){
      ContentValues valeursArticles = new ContentValues();
      valeursArticles.put(ArticleContract.COL_DESCRIPTION,article.getDescription());
      valeursArticles.put(ArticleContract.COL_PRIX,article.getPrix());
      valeursArticles.put(ArticleContract.COL_IS_ACHETE,article.isAchete());
      valeursArticles.put(ArticleContract.COL_NOTE,article.getDegreEnvie());
      valeursArticles.put(ArticleContract.COL_URL,article.getUrl());
      valeursArticles.put(ArticleContract.COL_NOM,article.getNom());
      return db.insert(ArticleContract.NOM_TABLE,null,valeursArticles);
   }
}

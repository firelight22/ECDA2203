package com.quentinrouet.tpdoghttp;

import java.util.List;

/**
 * Created by quentin for BddArticle on 07/09/2022.
 */
public class DogFact {
   private List<String> facts;

   public DogFact(List<String> facts) {
      this.facts = facts;
   }

   public List<String> getFacts() {
      return facts;
   }

   public void setFacts(List<String> facts) {
      this.facts = facts;
   }
}

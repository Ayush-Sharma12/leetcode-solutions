class FoodRatings {
   
    Map<String, Integer> foodWithRatings; // food with ratings
    Map<String, TreeSet<String>> foodType; // cuisine with variety of food
    Map<String, String> foodToCuisine; // food with cuisine
   
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
          int n = foods.length;
          this.foodWithRatings = new HashMap<>();
          this.foodType = new HashMap<>();

          this.foodToCuisine = new HashMap<>();

          for(int i = 0; i<n; i++) {
              foodWithRatings.put(foods[i], ratings[i]);
              foodToCuisine.put(foods[i], cuisines[i]);
             
              if(!foodType.containsKey(cuisines[i])) {
                     TreeSet<String> set = new TreeSet<>((s1, s2) ->{
                            int r1 = foodWithRatings.get(s1);
                            int r2 = foodWithRatings.get(s2);

                            if(r1 != r2) return r2 - r1;

                            return s1.compareTo(s2);
                     });

                     set.add(foods[i]);
                     foodType.put(cuisines[i], set);

              } else{
                    TreeSet<String> set = foodType.get(cuisines[i]);
                    set.add(foods[i]);
                    foodType.put(cuisines[i], set);
              }
          }

    }
    
    public void changeRating(String food, int newRating) {

           String cuisine = foodToCuisine.get(food);
           TreeSet<String> set = foodType.get(cuisine);

           set.remove(food);
          
           foodWithRatings.put(food, newRating);

           set.add(food);
          
    }
    
    public String highestRated(String cuisine) {
         return foodType.get(cuisine).first();
   }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
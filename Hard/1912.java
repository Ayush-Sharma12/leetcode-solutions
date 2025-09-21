class MovieRentingSystem {

  class Pair  {
        int shop;
        int movie;
        int price;

        Pair(int shop, int movie, int price) {
            this.shop = shop;
            this.movie = movie;
            this.price = price;
        }
 }

    class MyDS { // My Data Structure
        TreeSet<Pair> allShops; // for accesing cheapest 5 shops
        Map<Integer, Pair> shopToPair; // for getting help to remove pair from treeset in case of rent

        MyDS(TreeSet<Pair> allShops, Map<Integer, Pair> shopToPair) {
            this.allShops = allShops;
            this.shopToPair = shopToPair;
        }
    }

    Map<Integer, MyDS> unRentedMap;
    TreeSet<Pair> rentedSet;  
    public MovieRentingSystem(int n, int[][] entries) {
        this.unRentedMap = new HashMap<>();
        this.rentedSet = new TreeSet<>(
             (p1, p2) ->{
                      if(p1.price != p2.price) return p1.price - p2.price;

                      if(p1.shop != p2.shop) return p1.shop - p2.shop;

                      return p1.movie - p2.movie;
             }
        );

        for (int[] entry : entries) {
            int shop = entry[0];
            int movie = entry[1];
            int price = entry[2];

            Pair pair = new Pair(shop, movie, price);

            if (!unRentedMap.containsKey(movie)) {

                TreeSet<Pair> treeSet = new TreeSet<>(
                        (p1, p2) -> {

                            if (p1.price != p2.price)
                                return p1.price - p2.price;

                            return p1.shop - p2.shop;
                        });
                Map<Integer, Pair> shopToPair = new HashMap<>();

                treeSet.add(pair);
                shopToPair.put(shop, pair);

                MyDS myDs = new MyDS(treeSet, shopToPair);

                unRentedMap.put(movie, myDs);
            } else {
                MyDS myDs = unRentedMap.get(movie);

                myDs.allShops.add(pair);
                myDs.shopToPair.put(shop, pair);
            }

        }
    }

    public List<Integer> search(int movie) {

        List<Integer> shops = new ArrayList<>();
        
        MyDS myDs = unRentedMap.get(movie);

        if(myDs == null) return shops;  

        TreeSet<Pair> treeSet = myDs.allShops;

        if (treeSet.isEmpty())
            return shops;

        int size = Math.min(treeSet.size(), 5);

        Iterator<Pair> itr = treeSet.iterator();
        int count = 0;
        while (itr.hasNext() && count++ < size) {
            Pair pair = itr.next();

            shops.add(pair.shop);
        }
       
       return shops;
    }

   

    public void rent(int shop, int movie) {
          MyDS myDs = unRentedMap.get(movie);
          Pair pair = myDs.shopToPair.get(shop);
          myDs.allShops.remove(pair);

          rentedSet.add(pair);   
   }

    public void drop(int shop, int movie) {
          MyDS myDs = unRentedMap.get(movie);
          Pair pair = myDs.shopToPair.get(shop);
          myDs.allShops.add(pair); 
          rentedSet.remove(pair);
    }

    public List<List<Integer>> report() {
            List<List<Integer>> rentedList = new ArrayList<>();

            if(rentedSet.isEmpty()) return rentedList; 

            int size = Math.min(5, rentedSet.size());

            Iterator<Pair> itr = rentedSet.iterator();
            int count = 0;  
            while(itr.hasNext() && count++ < size) {
                   Pair pair = itr.next();
                   List<Integer> list = new ArrayList<>();

                   list.add(pair.shop);
                   list.add(pair.movie);

                   rentedList.add(list);
            }  

            return rentedList;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */
class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {

        Set<Integer> unhappy = new HashSet<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();

        int user = 1;
        for (int[] language : languages) {

            Set<Integer> set = new HashSet<>();
            for (int lang : language) {
                set.add(lang);
            }

            map.put(user++, set);
        }

        for (int[] friendship : friendships) {
            int user1 = friendship[0];
            int user2 = friendship[1];
            boolean canTeach = true;

            for (int l = 1; l <= n; l++) {
                if (map.get(user1).contains(l) && map.get(user2).contains(l)) {

                    canTeach = false;
                    break;
                }
            }

            if (canTeach) {
                unhappy.add(user1);
                unhappy.add(user2);

            }
        }

        int[] freq = new int[n + 1];
        int maxKnownLanguage = 0;
        for (int sadUser : unhappy) {
            for (int language : map.get(sadUser)) {
                freq[language]++;
                maxKnownLanguage = Math.max(maxKnownLanguage, freq[language]);
            }

        }

        return Math.abs(unhappy.size() - maxKnownLanguage);

    }
}
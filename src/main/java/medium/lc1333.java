package medium;

// https://leetcode.com/problems/filter-restaurants-by-vegan-friendly-price-and-distance/
// 1333. Filter Restaurants by Vegan-Friendly, Price and Distance
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class lc1333 {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        
        
        return Arrays.stream(restaurants).filter(v -> v[2] >= veganFriendly && v[3] <= maxPrice && v[4] <= maxDistance)
            .sorted((a, b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1])
            .map(r -> r[0])
            .collect(Collectors.toList());
    
    }
}
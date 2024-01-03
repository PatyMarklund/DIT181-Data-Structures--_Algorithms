import java.util.Arrays;

public class Autocomplete {
    private Term[] dictionary;
    private int lengthOfResult;

    // Initializes the dictionary from the given array of terms.
    public Autocomplete(Term[] dictionary) {
        this.dictionary = dictionary;
        sortDictionary();
    }

    // Sorts the dictionary in *case-insensitive* lexicographic order.
    // Complexity: O(N log N) where N is the number of dictionary terms
    private void sortDictionary() {
        // TODO
        Arrays.sort(dictionary, Term.byLexicographicOrder);

        //throw new UnsupportedOperationException();
    }

    // Returns all terms that start with the given prefix, in descending order of weight.
    // Precondition: the internal dictionary is in lexicographic order.
    // Complexity: O(log N + M log M) where M is the number of matching terms
    public Term[] allMatches(String prefix) {
        // TODO
        Term search = new Term(prefix, 0);

        int firstIndex = RangeBinarySearch.firstIndexOf(dictionary, search, Term.byPrefixOrder(prefix.length()));
        int lastIndex = RangeBinarySearch.lastIndexOf(dictionary, search, Term.byPrefixOrder(prefix.length()));

        this.lengthOfResult = numberOfMatches(prefix);
        Term[] allMatches = new Term[lengthOfResult];

        int j = 0;
        if(firstIndex != -1 && lastIndex != -1){
            for (int i = firstIndex; i <= lastIndex ; i++) {
                allMatches[j++] = dictionary[i];
            }
        }

        Arrays.sort(allMatches, Term.byReverseWeightOrder);
        return allMatches;

        //throw new UnsupportedOperationException();
    }

    // Returns the number of terms that start with the given prefix.
    // Precondition: the internal dictionary is in lexicographic order.
    // Complexity: O(log N) where N is the number of dictionary terms
    public int numberOfMatches(String prefix) {
        // TODO

        Term newSearch = new Term(prefix, 0);

        int firstIndex = RangeBinarySearch.firstIndexOf(dictionary, newSearch, Term.byPrefixOrder(prefix.length()));
        int lastIndex = RangeBinarySearch.lastIndexOf(dictionary, newSearch, Term.byPrefixOrder(prefix.length()));

        if (firstIndex < 0){
            return 0;
        }else {
            return lastIndex - firstIndex + 1;
        }


        //throw new UnsupportedOperationException();
    }

}

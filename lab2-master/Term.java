
import java.util.Comparator;

public class Term {
    private String word;
    private long weight;

    // Initializes a term with a given word and weight.
    public Term(String word, long weight) {
        this.word = word;
        this.weight = weight;
    }

    // Gets the word.
    public String getWord() {
        return word;
    }

    // Gets the weight.
    public long getWeight() {
        return weight;
    }

    // Extracts a prefix from the word.
    // If `len` is larger than the word length, the prefix is the entire word.
    public String getPrefix(int len) {
        // TODO
        String prefix = null;
        if (len > word.length()){
            prefix = getWord();
        }else if (getWord().length() >= len){
            prefix = getWord().substring(0, len);
        }
        return prefix;
        //throw new UnsupportedOperationException();
    }

    // Compares two terms in case-insensitive lexicographic order.
    // TODO
    public static final Comparator<Term> byLexicographicOrder = (term1, term2) -> term1.getWord().compareToIgnoreCase(term2.getWord());

    // Compares two terms in descending order by weight.
    //Comparator.comparingLong(Term::getWeight);
    //Long.valueOf(x).compareTo(Long.valueOf(y))
    // TODO
    public static final Comparator<Term> byReverseWeightOrder = Comparator.comparingLong(Term::getWeight).reversed();

    // This method returns a comparator that compares the two terms in case-insensitive
    // lexicographic order, but using only the first k characters of each word.
    public static Comparator<Term> byPrefixOrder(int k) {
        // TODO
        // Hint: use getPrefix and byLexicographicOrder.
        return (term1, term2) -> term1.getPrefix(k).compareToIgnoreCase(term2.getPrefix(k));
        //throw new UnsupportedOperationException();
    }

    /*
    // If you are stuck with creating comparators, here is a silly example that considers all integers equal:
    public static final Comparator<Integer> example0 = new Comparator<Integer>() {
        public int compare(Integer a, Integer b) {
            return 0;
        }
    };

    // And here is the same example using functional syntax:
    public static final Comparator<Integer> example1 = (a, b) -> {
        return 0;
    };

    // This is the same as the following:
    public static final Comparator<Integer> example2 = (a, b) -> 0;
    */

    // Returns a string representation of this term in the following format:
    // the weight, followed by whitespace, followed by the word.
    public String toString() {
        return String.format("%12d    %s", this.getWeight(), this.getWord());
    }

}

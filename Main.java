import java.util.*;

class Card {
    private final String suit;
    private final String color;
    private final String value;

    public Card(String suit, String color, String value) {
        this.suit = suit;
        this.color = color;
        this.value = value;
    }

    @Override
    public String toString() {
        return suit + ", " + color + ", " + value;
    }
}

class Deck {
    private final List<Card> cards;
    private static final String[] SUITS = {"Tréboles", "Corazones", "Picas", "Diamantes"};
    private static final String[] VALUES = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

    public Deck() {
        cards = new ArrayList<>();
        for (String suit : SUITS) {
            String color = (suit.equals("Corazones") || suit.equals("Diamantes")) ? "Rojo" : "Negro";
            for (String value : VALUES) {
                cards.add(new Card(suit, color, value));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
        System.out.println("Se mezcló el Deck.");
    }

    public void head() {
        if (!cards.isEmpty()) {
            System.out.println(cards.remove(0));
            System.out.println("Quedan " + cards.size() + " cartas en el deck.");
        } else {
            System.out.println("No hay más cartas en el deck.");
        }
    }

    public void pick() {
        if (!cards.isEmpty()) {
            Random rand = new Random();
            System.out.println(cards.remove(rand.nextInt(cards.size())));
            System.out.println("Quedan " + cards.size() + " cartas en el deck.");
        } else {
            System.out.println("No hay más cartas en el deck.");
        }
    }

    public void hand() {
        if (cards.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                System.out.println(cards.remove(0));
            }
            System.out.println("Quedan " + cards.size() + " cartas en el deck.");
        } else {
            System.out.println("No hay suficientes cartas en el deck.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        deck.head();
        deck.pick();
        deck.hand();
    }
}

package org.max.seminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.max.seminar.exception.DeckEmptyException;
import org.max.seminar.type.Ranks;
import org.max.seminar.type.Suits;

import java.util.ArrayList;

    public class GetCardTest {
        Card checkCard;
        Deck deck;

        @BeforeEach
        void getNewDeck() {
            checkCard = new Card(Ranks.TWO, Suits.CLUBS);
            ArrayList<Card> arrayList = new ArrayList<>();
            arrayList.add(checkCard);
            deck = new Deck(arrayList);
        }

        //  Карта берется из пустой колоды
        @Test
        void testGetCardEmptyDeck() throws DeckEmptyException {
            // Given - подготовка
            deck = new Deck(new ArrayList<Card>());
            // When - функционал
            // Then - проверка
            Assertions.assertThrows(DeckEmptyException.class, deck::getCard);
        }

        // Карта берется из полной колоды, колода-1
        @Test
        void testGetCardFullDeck() throws DeckEmptyException {
            //Given
            DeckService deckService = new DeckService();
            deck = deckService.getNewDeck();
            Card check = deck.getCards().get(0);
            int size = deck.getCards().size();
            //Then
            Card result = deck.getCard();
            //When
            Assertions.assertEquals(check, result);
            Assertions.assertEquals(size - 1, deck.getCards().size());
        }

        @Test
        void testGetCardWithOneCard() throws DeckEmptyException {
            //Then
            Card result = deck.getCard();

            //When
            Assertions.assertEquals(checkCard, result);
            Assertions.assertEquals(0, deck.getCards().size());
        }
}

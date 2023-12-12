package org.max.home;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MyGameTest {
    Player gamer;
    Game game;
    List<Door> doors;

    @BeforeEach
    void SetUp () {
        doors = new ArrayList<>();
    }

    // Меняет выбор - проигрывает
    @Test
    void testGamePlayerChangeChoiceAndLoose () {
        // Given
        gamer = new Player("Игрок", true);
        doors.add(new Door(true));
        doors.add(new Door(false));
        doors.add(new Door(false));
        game = new Game(gamer, doors);
        // When
        boolean check = game.round(0).isPrize();
        // Then
        Assertions.assertFalse(check);

    }

    // Меняет выбор - выигрывает
    @Test
    void testGamePlayerChangeChoiceAndWin () {
        // Given
        gamer = new Player("Игрок", true);
        doors.add(new Door(false));
        doors.add(new Door(false));
        doors.add(new Door(true));
        game = new Game(gamer, doors);
        // When
        boolean check = game.round(0).isPrize();
        // Then
        Assertions.assertTrue(check);

    }

    // Не меняет выбор - проигрывает
    @Test
    void testGamePlayerNotChangeChoiceAndLoose () {
        // Given
        gamer = new Player("Игрок", false);
        doors.add(new Door(true));
        doors.add(new Door(false));
        doors.add(new Door(false));
        game = new Game(gamer, doors);
        // When
        boolean check = game.round(0).isPrize();
        // Then
        Assertions.assertTrue(check);

    }

    // Не меняет выбор - выигрывает
    @Test
    void testGamePlayerNotChangeChoiceAndWin () {
        // Given
        gamer = new Player("Игрок", false);
        doors.add(new Door(false));
        doors.add(new Door(false));
        doors.add(new Door(true));
        game = new Game(gamer, doors);
        // When
        boolean check = game.round(0).isPrize();
        // Then
        Assertions.assertFalse(check);

    }
}

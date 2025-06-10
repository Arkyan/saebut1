package latice.model.infoplayer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldReturnPlayerName_whenGettingName() {
        Player player = new Player("Player1");
        assertEquals("Player1", player.getName());
    }

    @Test
    public void shouldReturnNonNullBag_whenGettingPlayerBag() {
        Player player = new Player("Player1");
        assertNotNull(player.getPlayerBag());
    }

    @Test
    public void shouldReturnNonNullRack_whenGettingPlayerRack() {
        Player player = new Player("Player1");
        assertNotNull(player.getRack());
    }

    @Test
    public void shouldIncreasePoints_whenAddingPoints() {
        Player player = new Player("Player1");
        int initialPoints = player.getPoints();
        int pointsToAdd = 10;
        player.addPoints(pointsToAdd);
        assertEquals(initialPoints + pointsToAdd, player.getPoints());
    }

    @Test
    public void shouldUpdateNumberOfTilesPutOnBoard_whenSetIsCalled() {
        Player player = new Player("Player1");
        int tilesToSet = 5;
        player.setNumberOfTilesPutOnBoard(tilesToSet);
        assertEquals(tilesToSet, player.getNumberOfTilesPutOnBoard());
    }

    @Test
    public void shouldReturnTrue_whenPlayerHasAtLeastOneAction() {
        Player player = new Player("Player1");
        assertTrue(player.playerCanPlay());
    }

    @Test
    public void shouldReturnFalse_whenPlayerHasNoActionsLeft() {
        Player player = new Player("Player1");
        player.useAction(); // uses the default one action
        assertFalse(player.playerCanPlay());
    }

    @Test 
    public void shouldTrackNumberOfActions_whenUsingAndResettingActions() {
        Player player = new Player("Player1");
        assertEquals(1, player.getNumberOfActions()); // default action
        player.useAction();
        assertEquals(0, player.getNumberOfActions());
        player.initializeNumberOfActions();
        assertEquals(1, player.getNumberOfActions());
    }

    @Test
    public void shouldDecreaseNumberOfActions_whenUsingAction() {
        Player player = new Player("Player1");
        player.useAction(); 
        assertEquals(0, player.getNumberOfActions(), "Player should have zero actions left after using one.");
    }

    @Test
    public void shouldThrowException_whenUsingActionWithoutAnyLeft() {
        Player player = new Player("Player1");
        player.useAction(); // uses the only action

        Exception exception = assertThrows(IllegalStateException.class, player::useAction);
        assertEquals("No actions left for this player.", exception.getMessage());
    }

    @Test
    public void shouldIncreaseActionsAndDecreasePoints_whenBuyingActionWithEnoughPoints() {
        Player player = new Player("Player1");
        player.addPoints(4); 
        player.buyAction();
        assertEquals(2, player.getPoints(), "Player's points should decrease by 2 after buying an action.");
        assertEquals(2, player.getNumberOfActions(), "Player should have one more action after purchase.");
    }

    @Test
    public void shouldThrowException_whenBuyingActionWithoutEnoughPoints() {
        Player player = new Player("Player1");
        Exception exception = assertThrows(IllegalStateException.class, player::buyAction);
        assertEquals("Not enough points to buy an action.", exception.getMessage());
    }
}

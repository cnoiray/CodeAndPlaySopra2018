/**
 *
 */
package fr.goat.controller;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import fr.goat.bo.MapPOJO;
import fr.goat.utils.GameStatut;
import fr.goat.utils.ResultCoupStatut;

/**
 * @author cnoiray
 */
class TestAPI {

    @org.junit.jupiter.api.Test
    void test() {
        final ControllerAPI controller = new ControllerAPI();

        final String teamId = controller.getIdEquipeAPI();
        assertTrue(teamId != null);

        // if versus
        final String nextAdversaireId = controller.getNextAdversaireAPI(teamId);
        assertTrue(nextAdversaireId != null && !"NA".equals(nextAdversaireId));
        // end if versus

        // if practisse
        final String nextIAAdversaireId = controller.chooseGameAPI(1, teamId);
        assertTrue(nextIAAdversaireId != null && !"NA".equals(nextIAAdversaireId));

        final String gameId = controller.nextGameToPlayVsIaAPI(teamId);
        assertTrue(gameId != null);
        // end if practisse

        final GameStatut statutGame = controller.getGameStatutAPI(teamId, gameId);
        assertEquals(GameStatut.OUI, statutGame);

        final MapPOJO map = controller.getGameAPI(gameId);
        assertEquals("player1:nom:Bob ,nbr de piece:12 ,dernier mvt:2D4 ,"
            + "player2:nom:Nelly ,nbr de piece:9 ,dernier mvt:VP ,"
            + "player3:nom:Jack ,nbr de piece:1 ,dernier mvt:6D2 ,"
            + "player4:nom:Viper ,nbr de piece:25 ,dernier mvt:CD3 ," + "longueur:125 ," + "largeur:99", map
                .toString());

        final Object coord = controller.lastMoveAPI(gameId);

        final ResultCoupStatut result = controller.playAPI(gameId, teamId, "10", "1");
        assertEquals(ResultCoupStatut.OK, result);
    }
}
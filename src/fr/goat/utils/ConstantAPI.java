/**
 *
 */
package fr.goat.utils;

/**
 * @author cnoiray
 */
public class ConstantAPI {

    /**
     * adresse de base de l'API
     */
    public static String URL = "http://informations.codeandplay.date";

    /**
     * Retourne systématiquement "pong"
     */
    public static String PING = "/test-ws/ping";

    /**
     * Envoie l'identifiant de l'équipe à partir de son nom et du mot de passe associé
     * {0} = nomEquipe
     * {1} = motDePasse
     */
    public static String GET_UTILISATEUR_ID = "/test-ws/player/getIdEquipe/{0}/{1}";

    /**
     * Retourne l’identifiant de la partie à laquelle l’équipe doit participer "NA" si aucune partie n'est
     * ouverte pour cette équipe.
     * {0} = idEquipe
     */
    public static String GET_NEXT_ADVERSAIRE = "/test-ws/versus/next/{0}";

    /////// CONTRE LES BOTS ///////
    /**
     * Crée une nouvelle partie contre une IA du niveau souhaité pour l’équipe concernée "NA" si la partie ne
     * peut pas être créée
     * {0} = level
     * {1} = idEquipe
     */
    public static String CREATE_IA_GAME = "/test-ws/practice/new/{0}/{1}";

    /**
     * Retourne l’identifiant de la partie en cours ou initialisée à lquelle l’équipe doit participer "NA" si
     * aucune partie n’est ouverte
     * {0} = idEquipe
     */
    public static String GET_NEXT_IA_GAME_ID = "/test-ws/practice/next/{0}";

    /////// DEROULEMENT DE LA PARTIE ///////
    /**
     * Indique si c’est au tour de l'équipe indiquée de jouer dans la partie concernée retourne : "OUI" si
     * c'est au tour du joueur "NON" si ce n'est pas au joueur "GAGNE" si le joueur a gagné la partie "PERDU"
     * si le joueur a perdu la partie "ANNULE" si la partie a été annulée (uniquement dans le cas d'une partie
     * contre un bot)
     * {0} = idPartie
     * {1} = idEquipe
     */
    public static String GET_GAME_STATUT = "/test-ws/game/status/{0}/{1}";

    /**
     * Retourne le plateau de jeu de la partie concernée Si le format n'est pas renseigné ou si le format
     * indiqué est json, la réponse sera au format JSON. Sinon, la réponse sera une String à parser.
     * {0} = idPartie
     */
    public static String GET_GAME_BOARD = "/test-ws/game/board/{0}";

    /**
     * Retourne le dernier coup joué sur le plateau de la partie indiquée "coordX,coordY" (détail pendant le
     * Code & Play)
     * {0} = idPartie
     */
    public static String GET_LAST_MOVE = "/test-ws/game/getlastmove/{0}";

    /**
     * Joue un coup dans la partie concernée, pour l’équipe concernée aux coordonnées X et Y données Retourne:
     * "OK" si le coup est accepté. "KO" si le coup est refusé/interdit. "GAGNE" si c'est le dernier coup
     * gagnant. "PTT" (Pas Ton Tour) si ce n'est pas au tour du joueur
     * {0} = idPartie
     * {1} = idEquipe
     * {2} = coordX
     * {3} = coordY
     */
    public static String PLAY = "/test-ws/game/play/{0}/{1}/{2}/{3}";
}
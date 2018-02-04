package controllers;

import play.*;
import play.mvc.*;
import java.util.*;
import models.*;

public class Application extends Controller {

    public static void index() {
        List<Match> listMatch = Match.all().fetch(10);
        render(listMatch);
    }

    public static void createMatch() {
        render();
    }

    public static void makeBet(Match match) {
        render(match);
    }

    public static void checkRates(Match match, int nakedRedTeam, int nakedBlueTeam, int vinTeam) {

        String msg = match.checkVins(nakedRedTeam, nakedBlueTeam, vinTeam);
        render(msg);
    }
}
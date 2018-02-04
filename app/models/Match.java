package models;

import java.util.*;
import javax.persistence.*;
import play.data.validation.*;
import play.db.jpa.*;

/**
 * Модель матчей
 */
@Entity
public class Match extends Model {
    // Перечисление выйгравших команд
    public enum VinsTeam
    {
        NONE_TEAM,
        RED_TEAM,
        BLUE_TEAM
    }

    @ManyToOne
    public Team redTeam;            // Первая команда

    @ManyToOne
    public Team blueTeam;           // Вторая команда

                                    // Счет
    public int nakedRedTeam;
    public int nakedBlueTeam;

    // Конструктор
    public Match(Team redTeam, Team blueTeam, String score, int nakedRedTeam, int nakedBlueTeam) {
        this.redTeam = redTeam;
        this.blueTeam = blueTeam;
        this.nakedRedTeam = nakedRedTeam;
        this.nakedBlueTeam = nakedBlueTeam;
    }

    // Название матча
    public String getTitle() {
        return redTeam.name + " - " + blueTeam.name;
    }

    // Получить победителя (пока без перечислений)
    public int getVin() {
        int res = 0;

        if (nakedRedTeam > nakedBlueTeam) {
            res = 1;
        } else if (nakedRedTeam < nakedBlueTeam) {
            res = 2;
        }

        return res;
    }

    // Проверка выбора пользователя
    public String checkVins (int nakedRedTeam, int nakedBlueTeam, int team) {
        String res = "";
        if (this.getVin() == team) {
            res += "Вы угадали победителя.";
        }
        if (this.nakedRedTeam == nakedRedTeam && this.nakedBlueTeam == nakedBlueTeam) {
            res += "Вы угадали счет.";
        }
        if (res =="") {
            res = "Вы ничего не угадали.";
        }

        return res;
    }
}
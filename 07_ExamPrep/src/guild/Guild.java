package guild;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Guild {
    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (roster.size() < capacity) {
            roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                roster.remove(player);
                return true;
            }
        }
        return false;
    }

    public void promotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                player.setRank("Member");
                return;
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                player.setRank("Trial");
                return;
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> kickedPlayers = new ArrayList<>();
        for (int j = 0; j <roster.size() ; j++) {

            if (roster.get(j).getClazz().equals(clazz)) {
                kickedPlayers.add(roster.get(j));
                roster.remove(roster.get(j));

        }
        }
        Player[] newPlayers = new Player[kickedPlayers.size()];
//        Collections.addAll(kickedPlayers,newPlayers);
        for (int i = 0; i < kickedPlayers.size(); i++) {
            newPlayers[i] = kickedPlayers.get(i);
        }
        return newPlayers;
    }

    public int count() {
        return roster.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        String result = String.format("Players in the guild: %s:%n", this.name);
        sb.append(result);
        for (Player player : roster) {
            sb.append(player);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

}

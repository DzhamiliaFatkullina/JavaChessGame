package src.players;

/**
 * @author Dzhamilia Fatkullina
 */

public enum PlayerType {
    BLACK("B"), WHITE("W");
    private String value;

    PlayerType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

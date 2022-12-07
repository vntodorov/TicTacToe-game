package resources.models.players;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Player {

    private final List<Integer> positions;

    protected Player() {
        positions = new ArrayList<>();
    }

    public void addPosition(int position) {
        positions.add(position);
    }

    public boolean contains(int position) {
        return positions.contains(position);
    }

    public Collection<Integer> getPositions() {
        return positions;
    }


}

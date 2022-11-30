package resources.models.players;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractPositionsList {

    private List<Integer> positions;

    protected AbstractPositionsList(){
        positions = new ArrayList<>();
    }

    public void addPosition(int position){
        positions.add(position);
    }

    public boolean contains(int position){
        return positions.contains(position);
    }

    public Collection<Integer> getPositions(){
        return positions;
    }


}

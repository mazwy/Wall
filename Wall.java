package horus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

interface Structure {
    // zwraca dowolny element o podanym kolorze
    Optional<Block> findBlockByColor(String color);

    // zwraca wszystkie elementy z danego materiału
    List<Block> findBlocksByMaterial(String material);

    //zwraca liczbę wszystkich elementów tworzących strukturę
    int count();
}

public class Wall implements Structure {
    private List<Block> blocks;

    @Override
    public Optional<Block> findBlockByColor(String color) {
        for (Block b : blocks) {
            if (b.getColor().equals(color))
                return Optional.of(b);
        }

        return Optional.empty();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        List<Block> list = new ArrayList<>();

        for (Block b : blocks) {
            if (b.getMaterial().equals(material))
                list.add(b);
        }

        return list;
    }

    @Override
    public int count() {
        int count = 0;

        for (Block b : blocks)
            count++;

        return count;
    }
}

interface Block {
    String getColor();
    String getMaterial();
}

interface CompositeBlock extends Block {
    List<Block> getBlocks();
}
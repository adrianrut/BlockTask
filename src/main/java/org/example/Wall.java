package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Wall implements Structure, CompositeBlock {

   private final List<Block> blocks;

    public Wall() {
        this.blocks = new ArrayList<>();
    }

    public void add(Block block) {
        blocks.add(block);
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return blocks.stream()
                .filter(block -> block.getColor().contains(color))
                .findAny();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return blocks.stream()
                .filter(block -> block.getMaterial().contains(material))
                .collect(Collectors.toList());
    }

    @Override
    public int count() {
        return blocks.size();
    }


    @Override
    public String getColor() {
        return getBlocks().stream()
                .map(Block::getColor)
                .distinct()
                .collect(Collectors.joining(", "));
    }

    @Override
    public String getMaterial() {
        return getBlocks().stream()
                .map(Block::getMaterial)
                .distinct()
                .collect(Collectors.joining(", "));
    }

    @Override
    public List<Block> getBlocks() {
        return this.blocks;
    }
}

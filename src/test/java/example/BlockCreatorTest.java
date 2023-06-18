package example;

import org.example.Block;
import org.example.BlockCreator;
import org.example.Wall;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class BlockCreatorTest {

    Wall wall = new Wall();

    BlockCreator blockCreator1 = new BlockCreator("red", "plastic");
    BlockCreator blockCreator2 = new BlockCreator("yellow", "wood");

    @Test
    public void shouldFindBlockByColor() {
        //given
        wall.add(blockCreator1);
        //when
        Optional<Block> red = wall.findBlockByColor("red");
        //then
        assertTrue(red.isPresent());
        assertEquals(red.get().getColor(), "red");
    }

    @Test
    public void shouldNotFindBlockByColor() {
        //given
        wall.add(blockCreator2);
        //when
        Optional<Block> red = wall.findBlockByColor("red");
        //then
        assertFalse(red.isPresent());
    }

    @Test
    public void shouldFindBlockByMaterial() {
        //given
        wall.add(blockCreator1);
        //when
        List<Block> plastic = wall.findBlocksByMaterial("plastic");
        //then
        assertEquals(plastic.get(0).getMaterial(), "plastic");
    }

    @Test
    public void shouldGiveEmptyListWhenMaterialNotFind() {
        //given
        wall.add(blockCreator2);
        //when
        List<Block> plastic = wall.findBlocksByMaterial("plastic");
        //then
        assertEquals(plastic.size(), 0);
    }

    @Test
    public void shouldGiveSizeOfBlocksListWHenIsNotEmpty() {
        //given
        wall.add(blockCreator2);
        //when
        int size = wall.count();
        //then
        assertEquals(size, 1);
    }

    @Test
    public void shouldGiveZeroOfBlocksListWHenIsEmpty() {
        //given
        //when
        int size = wall.count();
        //then
        assertEquals(size, 0);
    }


}
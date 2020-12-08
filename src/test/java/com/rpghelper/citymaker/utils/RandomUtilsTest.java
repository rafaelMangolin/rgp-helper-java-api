package com.rpghelper.citymaker.utils;

import com.rpghelper.citymaker.exceptions.InvalidIntervalException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RandomUtilsTest {

    @Test
    public void whenPassAValidInterval_returnAValueOfThatInterval(){
        Integer min = 0;
        Integer max = 10;
        Integer value = RandomUtils.getRandom(min,max);
        assertThat(value)
                .isGreaterThanOrEqualTo(min)
                .isLessThanOrEqualTo(max);

        min = 1;
        max = 1;
        value = RandomUtils.getRandom(min,max);
        assertThat(value)
                .isGreaterThanOrEqualTo(min)
                .isLessThanOrEqualTo(max);
    }


    @Test
    public void whenPassAbInvalidInterval_expectInvalidIntervalException(){
        Integer min = 11;
        Integer max = 10;
        InvalidIntervalException exception = assertThrows(
                InvalidIntervalException.class,
                ()->{
                    RandomUtils.getRandom(11,10);
                });
        String expectedMessage = "The interval between [11, 10] is invalid.";
        String actualMessage = exception.getMessage();

        assertTrue(expectedMessage.equals(actualMessage));
    }


    @Test
    public void whenPassAList_expectAnElementOfThatList(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Integer selected = RandomUtils.getRandom(list);
        assertTrue(list.contains(selected));
    }

    @Test
    public void whenPassAVoidList_expectNoneElement(){
        List<Integer> list = new ArrayList<>();

        Integer selected = RandomUtils.getRandom(list);
        assertNull(selected);
    }

    @Test
    public void whenPassAnElementWithMoreWeight_expectThatElementBeChosenMoreOften(){
        Map<String,Integer> map = new HashMap<>();

        map.put("one",1);
        map.put("two",3);

        Integer countOne = 0;
        Integer countTwo = 0;

        for(int i = 0; i < 1000;i++){
            if(RandomUtils.getRandomWeighted(map).equals("one")){
                countOne++;
            }else{
                countTwo++;
            }
        }
        assertThat(countOne).isLessThan(countTwo);
    }

    @Test
    public void whenPassAnList_expectThatElementBeOnThatList(){
        Map<String,Integer> map = new HashMap<>();

        map.put("one",1);
        map.put("two",3);

        String selected = RandomUtils.getRandomWeighted(map);
        assertTrue(map.keySet().contains(selected));
    }

    @Test
    public void whenPassAnVoidList_expectNull(){
        Map<String,Integer> map = new HashMap<>();

        String selected = RandomUtils.getRandomWeighted(map);
        assertNull(selected);
    }

}
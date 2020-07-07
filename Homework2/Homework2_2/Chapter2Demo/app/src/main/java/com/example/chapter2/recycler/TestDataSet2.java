package com.example.chapter2.recycler;

import java.util.ArrayList;
import java.util.List;

public class TestDataSet2 {

    public static List<TestData2> getData() {
        List<TestData2> result = new ArrayList();
        result.add(new TestData2("111111"));
        result.add(new TestData2("222222"));
        result.add(new TestData2("333333"));
        result.add(new TestData2("444444"));
        result.add(new TestData2("555555"));

        return result;
    }

}

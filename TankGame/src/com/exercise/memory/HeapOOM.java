package com.exercise.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xuanchi Guo
 * @project TankGameHSP
 * @created 6/19/23
 * VM args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {
    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject()); // java.lang.OutOfMemoryError: Java heap space
        }
    }
}

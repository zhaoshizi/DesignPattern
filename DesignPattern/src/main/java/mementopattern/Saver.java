package mementopattern;

import java.util.ArrayList;
import java.util.List;

public class Saver{
    List<Record> recordList = new ArrayList<Record>();

    public void addRecord(Record record){
        recordList.add(record);
    }

    public Record getRecord(int index){
        return recordList.get(index);
    }

}
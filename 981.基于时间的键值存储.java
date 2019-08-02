import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=981 lang=java
 *
 * [981] 基于时间的键值存储
 */
class TimeMap {
    int lasttime = Integer.MIN_VALUE;
    String lastvalue;
    HashMap<String,List<struct>> hashMap;
    class struct{
        String value;
        int timestamp;
        public struct(String value,int timestamp){
            this.value=value;
            this.timestamp=timestamp;
        }
    }
    Comparator<struct> comp;
    /** Initialize your data structure here. */
    public TimeMap() {
       hashMap = new HashMap<>(10);
       comp = new Comparator<struct>() {
        @Override
        public int compare(struct o1, struct o2) {
        return (o1.timestamp < o2.timestamp ? -1 : (o1.timestamp == o2.timestamp ? 0 : 1));
       }
    };

    }
    
    public void set(String key, String value, int timestamp) {
    
        if(!hashMap.containsKey(key)){
            List<struct> list =new ArrayList<struct>();
            list.add(new struct(value,timestamp));
            hashMap.put(key, list);
        }
        else hashMap.get(key).add(new struct(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (timestamp<lasttime) {
            return lastvalue;
        }
        int pos = Collections.binarySearch(hashMap.get(key),new struct("",timestamp) ,comp);
        if(pos>=0){
            System.out.println(pos);

            return hashMap.get(key).get(pos).value;}
        else {
            pos=-pos;
            pos-=2;
            if(pos==-1)return "";
            if(pos+1<hashMap.get(key).size())lasttime=hashMap.get(key).get(pos).timestamp;
             lastvalue = hashMap.get(key).get(pos).value;
 
            return lastvalue;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */


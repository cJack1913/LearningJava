package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GetMaxRepeatStr {

	public static void getMaxRepeatStr(List<String> list) {
		// 将list中的所有不同的str作为key,出现次数作为value放入map
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String str : list) {
			if (map.containsKey(str)) {
				map.put(str, map.get(str) + 1);
			} else {
				map.put(str, 1);
			}
		}
		// 将map转成以Entry为元素的list4map，对list4map进行排序
		List<Entry<String, Integer>> list4map = new ArrayList<Map.Entry<String, Integer>>(
				map.entrySet());
		Collections.sort(list4map, new Comparator<Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1,
					Entry<String, Integer> o2) {
				return (o2.getValue() - o1.getValue());
			}
		});
		// 输出前十个
		if (map.size() <= 10) {
			for(Entry<String, Integer> e: list4map){
				System.out.println(e.getKey()+":"+e.getValue());
			}
		} else {
			for (int i = 0; i < 10; i++) {
				System.out.println(list4map.get(i).getKey() + ":"
						+ list4map.get(i).getValue());
			}
		}
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("a");
		list.add("d");
		list.add("e");
		list.add("c");
		list.add("b");
		list.add("a");
		list.add("a");
		list.add("f");
		list.add("g");
		list.add("h");
		list.add("i");
		list.add("j");
		list.add("k");
		list.add("i");
		getMaxRepeatStr(list);
	}

}

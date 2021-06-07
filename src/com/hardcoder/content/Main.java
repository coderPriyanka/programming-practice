package com.hardcoder.content;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		
//		Map<String, String> pathParams = new HashMap<>();
//		pathParams.put("shipmentId", "1234");
//		pathParams.put("trackingId", "546379190");
//		
//		Map<String, String> queryParams = new HashMap<>();
//		queryParams.put("tracking-experinence", "external");
//		queryParams.put("trackingId", "546379190");
//		
//		Map serviceDetails = new HashMap();
//		
//		serviceDetails.put("method", "GET");
//		serviceDetails.put("uri", "localhost:8080");
//		
//		Vector pathParamKeys = new Vector();
//		pathParamKeys.add("shipmentId");
//		pathParamKeys.add("trackingId");
//		serviceDetails.put("pathParams", pathParamKeys);
//		
//		Vector queryParamKeys = new Vector();
//		queryParamKeys.add("tracking-experinence");
//		serviceDetails.put("queryParams", queryParamKeys);
		
//		String key = "method";
//		System.out.println(serviceDetails.get(key));
//		key = "uri";
//		System.out.println(serviceDetails.get(key));
//		String key = "pathParams";
//		List path = resolvePathParams(serviceDetails.get(key));
//		for (Object p : path) {
//			System.out.print(p.toString() + " ");
//		}
//		System.out.println();
//		System.out.println();
//		key = "queryParams";
//		List query = resolvePathParams(serviceDetails.get(key));
//		for (Object q : query) {
//			System.out.print(q.toString());
//		}
//		System.out.println();
		Scanner in = new Scanner(System.in);
//		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> -1 * a.compareTo(b));
//		List<Integer> list = new ArrayList<>();
//		list.add(5);
//		list.add(12);
//		list.add(10);
//		list.add(15);
//		list.add(7);
//		Collections.sort(list);
//		for (int i = 0; i < 5; i++) {
//			System.out.print(list.get(i) + " ");
//		}
//		System.out.println();
//		Collections.sort(list, (a, b) -> -1 * a.compareTo(b));
//		for (int i = 0; i < 5; i++) {
//			System.out.print(list.get(i) + " ");
//		}
//		System.out.println();
//		for (int i = 0; i < 5; i++) {
//			pq.add(in.nextInt());
//		}
//		while (!pq.isEmpty()) {
//			System.out.println(pq.poll());
//		}
		byte b = (byte) 255;
		System.out.println(b + 2);
		in.close();
	}

	private static List<?> resolvePathParams(Object object) {
		List<?> list = new ArrayList<>();
		if (object.getClass().isArray()) {
			list = Arrays.asList((Object[]) object);
		} else {
			list = new ArrayList<>((Collection<?>) object);
		}
		return list;
	}

}

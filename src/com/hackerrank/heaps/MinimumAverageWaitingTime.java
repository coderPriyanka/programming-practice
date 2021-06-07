package com.hackerrank.heaps;
import java.util.*;

public class MinimumAverageWaitingTime {
    
    static long minimumAverage(long[][] customers) {
        long min = customers[0][0];
        if (min != 0) {
            for (int i = 0; i < customers.length; i++) {
                customers[i][0] -= min;
            }
        }
        int numCustomers = customers.length;
        long lastArrivalTime = customers[numCustomers - 1][0];
        long waitingTime = customers[0][1], minWaitingTime = customers[0][1];
        PriorityQueue<CustomerOrder> customerOrders = new PriorityQueue<>();
        int start = 1;
        long end = Math.min(waitingTime, lastArrivalTime);
        while (start < numCustomers && customers[start][0] <= end) {
            customerOrders.add(new CustomerOrder(customers[start][0], customers[start][1]));
            start++;
        }
        while (!customerOrders.isEmpty()) {
            CustomerOrder customerOrder = customerOrders.poll();
            waitingTime += customerOrder.cookingTime;
            minWaitingTime += (waitingTime - customerOrder.arrivalTime);
            end = (int) Math.min(waitingTime, lastArrivalTime);
            while (start < numCustomers && customers[start][0] <= end) {
                customerOrders.add(new CustomerOrder(customers[start][0], customers[start][1]));
                start++;
            }
        }
        if (start < numCustomers) {
            long[][] newCustomers = new long[numCustomers - start][2];
            int i = 0;
            while (start < numCustomers) {
                newCustomers[i][0] = customers[start][0];
                newCustomers[i][1] = customers[start][1];
                start++;
                i++;
            }
            minWaitingTime += minimumAverage(newCustomers);
        }
        return minWaitingTime / numCustomers;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[][] customers = new long[n][2];
        for (int i = 0; i < n; i++) {
            customers[i][0] = scanner.nextLong();
            customers[i][1] = scanner.nextLong();
        }
        Arrays.sort(customers, (a, b) -> Long.compare(a[0], b[0]));
        System.out.println(minimumAverage(customers));
        scanner.close();
    }
}

class CustomerOrder implements Comparable<CustomerOrder> {
    long arrivalTime;
    long cookingTime;
    public CustomerOrder(long arrivalTime, long cookingTime) {
        this.arrivalTime = arrivalTime;
        this.cookingTime = cookingTime;
    }
    public int compareTo(CustomerOrder customerOrder) {
        return this.cookingTime <= customerOrder.cookingTime ? -1 : 1;
    }
}

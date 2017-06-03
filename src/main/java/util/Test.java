package util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Karn on 2017/2/19.
 */
public class Test {
    public static void main(String[] args){
        int[] nums = new int[10];
        int num;
        Scanner scanner = new Scanner(System.in);
        int i=0;
        while((num = scanner.nextInt()) != -1){
            nums[i++] = num;
        }
        System.out.println(lengOfLIS(nums));
    }

    class Node{
        public int data;
        public Node next;
        public Node(int data){
            this.data = data;
        }

    }

    public void findLastKthData(Node head, int k){
        Node p1 = head;
        Node p2 = head;
        for(int i=0;i<k;i++)
            p2 = p2.next;
        while (p2!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        System.out.println(p1.data);
    }

    public void addNode(Node head,Node node){
        if(head == null){
            head = node;
            return;
        }
        Node tmp = head;
        while(tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = node;
    }

    public static int lengOfLIS(int[] nums){
        int[] dp = new int[nums.length];
        int ans = 0;
        for(int num:nums){
            int index = Arrays.binarySearch(dp,0,ans,num);
            if(index < 0){
                index = -(index + 1);
            }
            dp[index] = num;
            if(index == ans){
                ans++;
            }
        }
        return ans;
    }
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        int ans = 0;
        int len =  s.length();
        int i = 0;
        for(int j = 0; j < len; j++){
            Character ch = s.charAt(j);
            if(map.containsKey(ch)){
                i = Math.max(map.get(ch) + 1,i);
            }
            map.put(ch,j);
            ans = Math.max(ans,j - i + 1);
        }
        return ans;
    }
    public boolean detectCapitalUse(String word) {
        boolean flag = true;
        Character ch = word.charAt(0);
        if(Character.isUpperCase(ch)){
            for(int i = 1;i<word.length();i++){
                if(!Character.isLowerCase(word.charAt(i))){
                    flag = false;
                    break;
                }
            }
            if(flag == true){
                return flag;
            }
            flag = true;
            for(int i = 1;i<word.length();i++){
                if(!Character.isUpperCase(word.charAt(i))){
                    flag = false;
                    break;
                }
            }
            if(flag == true){
                return flag;
            }
        }
        else{
            for(int i = 1;i<word.length();i++){
                if(!Character.isLowerCase(word.charAt(i))){
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}

//class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(int x) { val = x; }
//}
//
//public class Solution {
//    public int getMinimumDifference(TreeNode root) {
//        int min = Integer.MAX_VALUE;
//        for(TreeNode node = root;node != null;node = root.left){
//            min = Math.min(min,Math.abs(root.val - node.val));
//        }
//    }
//}
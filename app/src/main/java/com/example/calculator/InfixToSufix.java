package com.example.calculator;

import android.util.Log;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

//中缀表达式转后缀
public class InfixToSufix {
    public static ArrayList Sufix(StringBuilder str){
        //识别到"(-"补'0'
        Log.d("EqualCh1","这里有错吗1");
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='-'&&str.charAt(i-1)=='('){
                str.insert(i,'0');
            }
        }
        StringBuilder temp = new StringBuilder(); // 当做中间字符串，临时存放数字，方便往list中添加

        List<String> list = new ArrayList<>(); // 用于存储分割后的数字和符号

        ArrayList<String> result = new ArrayList<>(); //作为结果集合，后缀表达式保存在其中
        //以下这部分是中转后的预处理，没啥大用，但是记得改
        for(int i=0;i<str.length();i++){
            // 判断是不是数字
            if ((str.charAt(i) >= '0' && str.charAt(i) <= '9') || str.charAt(i) == '.'){
                //如果此位为'.'，且这个时候中间字符串为空，自动补0
                if (str.charAt(i) == '.' && temp.length() == 0){
                    temp.append(0); // 添加0，在添加'.'
                    temp.append(str.charAt(i));
                } else {// 是数字，就往中间字符串添加
                    temp.append(str.charAt(i));
                }
                //最后一位就直接加进去
                if(i==str.length()-1){
                    list.add(temp.toString());
                }
            }else{//不是数字
                if(temp.length()!=0){
                    //如果temp长不为’0‘即有符号，将符号加入list
                    list.add(temp.toString());
                }
                //加入符号
                list.add(String.valueOf(str.charAt(i)));
                //清空全部temp串
                temp.delete(0,temp.length());
            }
        }
        //偷偷输出看下结果ps:话说这个超级遍历好帅啊
        for(String tList:list){
            Log.d("EqualCh1",tList + " ");
        }
        //定义堆栈，要开始了欧
        Stack<String> stack = new Stack<>();
        //在这里定义入栈优先级，加sin/cos时记得用String什么的
        Map<Character,Integer> map = new HashMap<>();
        map.put('S',0);
        map.put('C',0);
        map.put('(',1);
        map.put(')',1);
        map.put('*',2);
        map.put('/',2);
        map.put('+',3);
        map.put('-',3);
//        map.put('S',4);
//        map.put('C',4);
        for(String s:list){
            //不为数字时
            if ( s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-") || s.equals("(") || s.equals(")")||s.equals("S")||s.equals("C") ) {
                //没元素时就直接加入
                if(stack.size()==0){
                    Log.d("EqualCh1","(1)最初的入栈"+s);
                    stack.push(s);
                }else{
                    //有元素时判断优先级决定下一步（ps:这里改优先级欧）
                    if(s.equals(")")){
                        Log.d("EqualCh1","不会没到这吧");
                        //防一波崩溃，避免空栈操作
                        if(!stack.empty()){
                            Log.d("EqualCh1","(3)进入if"+stack.peek()+"取值："+stack.peek().equals("(")+" 第二取值："+stack.peek().equals('('));
                            while(!(stack.peek().equals("("))){
                                Log.d("EqualCh1","不会进不了while吧");
                                //出栈并add到结果里
                               result.add( stack.pop());
                                if (stack.empty()){//容错，不然会有EmptyStackException,见上面
                                    break;
                                }
                                if(!stack.empty()) {
                                    if (stack.peek().equals("S") || stack.peek().equals("C")) {
                                        Log.d("EqualCh1", "进S/C啦");
                                        result.add(stack.pop());
                                    }
                                }
                                if(stack.empty()){
                                    break;
                                }
                            }
                            //要是上面一顿出栈后还有并且是'（'就pop掉
                            if(!stack.empty()){
                                if(stack.peek().equals("(")){
                                    stack.pop();
                                    Log.d("EqualCh1","掉了没");
                                }
                                if(!stack.empty()) {
                                    if (stack.peek().equals("S") || stack.peek().equals("C")) {
                                        result.add(stack.pop());
                                        Log.d("EqualCh1", "进第二个S/C啦");
                                    }
                                }
                            }
                        }
                    }else{
                        Log.d("EqualCh1","else入了12血");
                        if (s.equals("(")){ //如果是'('将其入栈
                            Log.d("EqualCh1","入了12血");
                            stack.push(s);
                        }else{
                            if (stack.peek().charAt(0) != '(') {
                                Log.d("EqualCh1","小一");
                                if (map.get(s.charAt(0)) < map.get(stack.peek().charAt(0))) { //栈顶符号的优先级高于元素优先级，也就是数字小，进栈
                                    Log.d("EqualCh1","in小一");
                                    stack.push(s);
                                }else{
                                    //栈顶元素优先级低于当前元素，把低的全部输出
                                    while ((map.get(s.charAt(0)) >= map.get(stack.peek().charAt(0))) && !stack.empty()){
                                        // System.out.print(stack.pop() + " ");
                                        //按优先级顺序加入符号
                                        result.add(stack.pop());
                                        //防止暴毙
                                        if (stack.empty()){
                                            break;
                                        }
                                        //有左括号也退出来继续等右括号
                                        if (stack.peek().equals("(")){
                                            break;
                                        }
                                    }
                                    stack.push(s);
                                }
                            }else{
                                Log.d("EqualCh1","难道说");
                                stack.push(s);
                            }
                        }
                    }
                }
            }else{
                //是数字就直接加入
                Log.d("EqualCh1","(2)添加数字"+s);
                result.add(s);
            }
        }
        //最终都结束了就把栈里全pop了
        while(!stack.empty()){
            Log.d("EqualCh1","难道说66");
            result.add(stack.pop());
        }
        for(int i=0;i<result.size();i++){
        Log.d("EqualCh1",result.get(i));}
        return result;
    }
    //这里是简单的计算后缀的说
    public static String Cal(ArrayList arrayList){
        Log.d("EqualCh1","我大跳2,这里大危机");
        int length=arrayList.size();
        String[] arr=new String[length];
        for(int i=0;i<arrayList.size();i++){
            arr[i]=(String)arrayList.get(i);
        }
        Log.d("asdfg", arrayList.toString());
        List<String> list=new ArrayList<>();
        for(String anArr:arr){
            int size=list.size();
            switch(anArr){
                case "+":
                    BigDecimal a=new BigDecimal(list.remove(size-2)).add(new BigDecimal(list.remove(size - 2)));
                    list.add(a.stripTrailingZeros().toString()); //去掉结果最后的0
                    break;
                case "-":
                    BigDecimal b=new BigDecimal(list.remove(size-2)).subtract(new BigDecimal(list.remove(size - 2)));
                    list.add(b.stripTrailingZeros().toString());
                    break;
                case "*":
                    BigDecimal c=new BigDecimal(list.remove(size-2)).multiply(new BigDecimal(list.remove(size - 2)));
                    list.add(c.stripTrailingZeros().toString());
                    break;
                case "/":
                    BigDecimal d=new BigDecimal(list.remove(size-2)).divide(new BigDecimal(list.remove(size - 2)));
                    list.add(d.stripTrailingZeros().toString());
                    break;
                case "S":
                    double e=Math.sin(Double.valueOf(list.remove(size-1)));
                    list.add(""+e);
                    break;
                case "C":
                    double f=Math.cos(Double.valueOf(list.remove(size-1)));
                    list.add(""+f);
                    break;
                //数字就直接加进去
                default:
                    list.add(anArr);
                    break;
            }
        }
        if(list.size()==1){
            if(list.get(0).length()<30){
                BigDecimal bd = new BigDecimal(list.get(0));
                return bd.toPlainString(); //BigDecimal默认直接输出
            }else{
                double d = Double.valueOf(list.get(0));
                return String.valueOf(d); //Double会使用科学计数法输出
            }
        }else{
            return "运算错误";
        }
    }

}

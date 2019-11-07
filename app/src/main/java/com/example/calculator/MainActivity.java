package com.example.calculator;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.media.VolumeShaper;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.*;
import android.annotation.SuppressLint;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textview;
    private StringBuilder sb = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏标题栏
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
        //隐藏通知栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
        setContentView(R.layout.activity_main);
        //定义控件
        Button button0=findViewById(R.id.bt_num0);
        Button button1=findViewById(R.id.bt_num1);
        Button button2=findViewById(R.id.bt_num2);
        Button button3=findViewById(R.id.bt_num3);
        Button button4=findViewById(R.id.bt_num4);
        Button button5=findViewById(R.id.bt_num5);
        Button button6=findViewById(R.id.bt_num6);
        Button button7=findViewById(R.id.bt_num7);
        Button button8=findViewById(R.id.bt_num8);
        Button button9=findViewById(R.id.bt_num9);
        Button buttonAC = findViewById(R.id.bt_AC);
        Button buttonDelete = findViewById(R.id.bt_delete);
        Button buttonDot =  findViewById(R.id.bt_dot);
        Button buttonEqual =  findViewById(R.id.bt_equal);
        Button buttonAdd =  findViewById(R.id.bt_add);
        Button buttonDec =  findViewById(R.id.bt_dec);
        Button buttonMulti =  findViewById(R.id.bt_multi);
        Button buttonBracketLeft =  findViewById(R.id.bt_l);
        Button buttonBracketRight =  findViewById(R.id.bt_r);
        Button buttonDiv =  findViewById(R.id.bt_div);
        Button buttonPct = findViewById(R.id.bt_div100);
        Button buttonSin=findViewById(R.id.bt_sin);
        Button buttonCos=findViewById(R.id.bt_cos);
        textview=findViewById(R.id.contentText);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonAC.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
        buttonBracketLeft.setOnClickListener(this);
        buttonBracketRight.setOnClickListener(this);
        buttonDec.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
        buttonDot.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
        buttonMulti.setOnClickListener(this);
        buttonPct.setOnClickListener(this);
        buttonSin.setOnClickListener(this);
        buttonCos.setOnClickListener(this);
    }

    private int count_negative = 0; //负数标记
    private boolean equals = false;
    private int count_bracket_left = 0;
    private int count_bracket_right = 0;


    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view){

        switch(view.getId()){
            //sin
            case R.id.bt_sin:
                if (equals) {
                    sb = sb.delete(0, sb.length());
                    equals = false;
                }
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ')') {
                    sb = sb.append("*S(");
                } else {
                    sb = sb.append("S(");
                }
                textview.setText(sb.toString());
                break;
            //cos
            case R.id.bt_cos:
                if (equals) {
                    sb = sb.delete(0, sb.length());
                    equals = false;
                }
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ')') {
                    sb = sb.append("*C(");
                } else {
                    sb = sb.append("C(");
                }
                textview.setText(sb.toString());
                break;
            //数字
            case R.id.bt_num0:
                if (equals) {
                    sb = sb.delete(0, sb.length());
                    equals = false;
                }
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ')') {
                    sb = sb.append("*0");
                } else {
                    sb = sb.append("0");
                }
                textview.setText(sb.toString());
                break;
            case R.id.bt_num1:
                if (equals) {
                    sb = sb.delete(0, sb.length());
                    equals = false;
                }
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ')') {
                    sb = sb.append("*1");
                } else {
                    sb = sb.append("1");
                }
                textview.setText(sb.toString());
                break;
            case R.id.bt_num2:
                if (equals) {
                    sb = sb.delete(0, sb.length());
                    equals = false;
                }
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ')') {
                    sb = sb.append("*2");
                } else {
                    sb = sb.append("2");
                }
                textview.setText(sb.toString());
                break;
            case R.id.bt_num3:
                if (equals) {
                    sb = sb.delete(0, sb.length());
                    equals = false;
                }
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ')') {
                    sb = sb.append("*3");
                } else {
                    sb = sb.append("3");
                }
                textview.setText(sb.toString());
                break;
            case R.id.bt_num4:
                if (equals) {
                    sb = sb.delete(0, sb.length());
                    equals = false;
                }
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ')') {
                    sb = sb.append("*4");
                } else {
                    sb = sb.append("4");
                }
                textview.setText(sb.toString());
                break;
            case R.id.bt_num5:
                if (equals) {
                    sb = sb.delete(0, sb.length());
                    equals = false;
                }
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ')') {
                    sb = sb.append("*5");
                } else {
                    sb = sb.append("5");
                }
                textview.setText(sb.toString());
                break;
            case R.id.bt_num6:
                if (equals) {
                    sb = sb.delete(0, sb.length());
                    equals = false;
                }
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ')') {
                    sb = sb.append("*6");
                } else {
                    sb = sb.append("6");
                }
                textview.setText(sb.toString());
                break;
            case R.id.bt_num7:
                if (equals) {
                    sb = sb.delete(0, sb.length());
                    equals = false;
                }
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ')') {
                    sb = sb.append("*7");
                } else {
                    sb = sb.append("7");
                }
                textview.setText(sb.toString());
                break;
            case R.id.bt_num8:
                if (equals) {
                    sb = sb.delete(0, sb.length());
                    equals = false;
                }
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ')') {
                    sb = sb.append("*8");
                } else {
                    sb = sb.append("8");
                }
                textview.setText(sb.toString());
                break;
            case R.id.bt_num9:
                if (equals) {
                    sb = sb.delete(0, sb.length());
                    equals = false;
                }
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ')') {
                    sb = sb.append("*9");
                } else {
                    sb = sb.append("9");
                }
                textview.setText(sb.toString());
                break;
            //删除
            case R.id.bt_delete:
                if(sb.length()!=0){
                    sb.deleteCharAt(sb.length()-1);
                }
                textview.setText(sb.toString());
                break;
            //全清
            case R.id.bt_AC:
                sb.delete(0,sb.length());
                textview.setText(sb.toString());
                break;
            //左括号
            case R.id.bt_l:
                if (sb.length() > 0 && (sb.charAt(sb.length() - 1) >= '0' && sb.charAt(sb.length() - 1) <= '9')) { //当前面是数字是，自动添加为'*('
                    sb = sb.append("*(");
                }
                if (sb.length() == 0) { //如果此时字符串是空的，也就是说想在式子最前面添加括号，就添加括号
                    sb = sb.append("(");
                }
                if (sb.length() > 0 && (sb.charAt(sb.length() - 1) == '*' || sb.charAt(sb.length() - 1) == '/' || sb.charAt(sb.length() - 1) == '+' || sb.charAt(sb.length() - 1) == '-')) { //如果当括号前面是符号时添加括号
                    sb = sb.append("(");
                }
                textview.setText(sb.toString());
                break;
            //右括号
            case R.id.bt_r:
                int count_num = 0; //数字的数目
                count_bracket_left = count_bracket_right = 0;
                if (sb.length() != 0) {
                    for (int i = sb.length() - 1; i >= 0; i--) { //对字符串进行遍历，如果存在左括号且括号中有数字，标记转为真,
                        if (count_bracket_left == 0 && (sb.charAt(i) >= '0' && sb.charAt(i) <= '9')) {
                            count_num++;
                        }
                        if (sb.charAt(i) == '(') {
                            count_bracket_left++;
                        }
                        if (sb.charAt(i) == ')') {
                            count_bracket_right++;
                        }
                    }
                    Log.d("count_bracket", String.valueOf(count_bracket_left+" "+count_bracket_right));
                    if ((count_bracket_left > count_bracket_right) && count_num > 0) { //当标记均为真，也就是存在左括号时且在左括号前面有数字，才让添加括号
                        sb = sb.append(')');
                    }
                }
                textview.setText(sb.toString());
                break;
            //除法
            case R.id.bt_div:
                if (sb.length() != 0) {
                    if (sb.charAt(sb.length() - 1) >= '0' && sb.charAt(sb.length() - 1) <= '9') {
                        sb.append("/");
                    }
                }
                textview.setText(sb.toString());
                break;
            //乘法
            case R.id.bt_multi:
                if (sb.length() != 0) {
                    if (sb.charAt(sb.length() - 1) >= '0' && sb.charAt(sb.length() - 1) <= '9') {
                        sb.append("*");
                    }
                }
                textview.setText(sb.toString());
                break;
            //减法
            case R.id.bt_dec:
                if (sb.length() != 0) {
                    if (sb.charAt(sb.length() - 1) >= '0' && sb.charAt(sb.length() - 1) <= '9') {
                        sb.append("-");
                    }
                }
                textview.setText(sb.toString());
                break;
            //加法
            case R.id.bt_add:
                if (sb.length() != 0) {
                    if (sb.charAt(sb.length() - 1) >= '0' && sb.charAt(sb.length() - 1) <= '9'||sb.charAt(sb.length()-1)==')') {
                        sb.append("+");
                    }
                }
                textview.setText(sb.toString());
                break;
             //小数点
            case R.id.bt_dot:
                if(sb.length()!=0){
                    int count_dot=0;
                    //从后前往遍历，看当前最近数字有多少'.'
                    for(int i=sb.length()-1;i>=0;i--){
                        if(sb.charAt(i)=='.'){
                            count_dot++;
                        }
                        //遇到非数字就跳出（见'.'/'+^'跳）
                        if (!(sb.charAt(i) >= '0' && sb.charAt(i) <= '9')) {
                            break;
                        }
                    }
                    if(count_dot==0){
                        //处理例外（加减乘除，括号，根号的0.A）
                        if(sb.charAt(sb.length() - 1) == '*' || sb.charAt(sb.length() - 1) == '/' || sb.charAt(sb.length() - 1) == '+' || sb.charAt(sb.length() - 1) == '-'|| sb.charAt(sb.length() - 1) == '('){
                            sb.append("0.");
                        }else{
                            sb.append(".");
                        }
                    }
                }
                textview.setText(sb.toString());
                break;
            //等于
            case R.id.bt_equal:
                Log.d("EqualCh1","点击了");
                count_bracket_left=count_bracket_right=0;
                if(sb.length()!=0) {
                    //查括号数
                    Log.d("EqualCh1","进来了");
                    for (int i = 0; i < sb.length(); i++) {
                        if (sb.charAt(i) == '(')
                            count_bracket_left++;
                        if (sb.charAt(i) == ')')
                            count_bracket_right++;
                    }
                    if (count_bracket_left != count_bracket_right) {
                        Toast.makeText(MainActivity.this, "请注意括号匹配", Toast.LENGTH_SHORT).show();

                    } else if ((sb.charAt(sb.length() - 1) >= '0' && sb.charAt(sb.length() - 1) <= '9') || sb.charAt(sb.length() - 1) == ')') {
                        Log.d("EqualCh1","运算！！！");
                        equals = true;
                        count_negative = 0;
                        try {
                            Log.d("EqualCh1","TRY: "+sb);
                            //调用函数中缀转后缀并计算
                            textview.setText(InfixToSufix.Cal(InfixToSufix.Sufix(sb)));
                            sb = sb.delete(0, sb.length());
                            sb.append(textview.getText().toString());
                            //横屏判断
                            Configuration mConfiguration = this.getResources().getConfiguration();
                            int ori=mConfiguration.orientation;
                            //进制转换
                            if(ori == mConfiguration.ORIENTATION_LANDSCAPE) {
                                int temp = Integer.parseInt(textview.getText().toString());
                                TextView textViewHEX = findViewById(R.id.HEX_Text);
                                textViewHEX.setText("HEX:" + Integer.toHexString(temp));
                                TextView textViewOCT = findViewById(R.id.OCT_Text);
                                textViewOCT.setText("OCT:" + Integer.toOctalString(temp));
                                TextView textViewBIN = findViewById(R.id.BIN_Text);
                                textViewBIN.setText("BIN:" + Integer.toBinaryString(temp));
                            }
                        } catch (Exception e) {
                            textview.setText("Error");
//                            Log.d("EqualCh1",e.getMessage());
                            sb = sb.delete(0, sb.length());
                        }
                    }
                }

                break;
            //百分号
            case R.id.bt_div100:

                break;
            default:
                break;
        }

    }


}


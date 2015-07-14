package com.example.administrator.calculatorapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity{
    double op1=0,op2=0;//记录两次输入的值
    char operation;//记录运算符
    EditText input;//输入文本框
    boolean isInputChar=false;//判断是否输入了运算符
    TextView memory;//记忆文本
    Button plus,minus,multi,divide,equal;//运算符
    Button back,clean,cleanAll;//文本数据处理（回退、本次输
    //入清零、所有输入清零）
    Button mclean,mread,msave;//数据记忆（清除、读取、保存）
    Button[] btn=new Button[10];//数字
    Button dot;//点
    Button sign;//正负数转换

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input=(EditText)findViewById(R.id.et_input);
        memory=(TextView)findViewById(R.id.tv_mem);
        //运算符
        plus=(Button)findViewById(R.id.button_plus);
        minus=(Button)findViewById(R.id.button_minus);
        multi=(Button)findViewById(R.id.button_multi);
        divide=(Button)findViewById(R.id.button_div);
        equal=(Button)findViewById(R.id.button_equal);
        //设置点击监听
        plus.setOnClickListener(listener);
        minus.setOnClickListener(listener);
        multi.setOnClickListener(listener);
        divide.setOnClickListener(listener);
        equal.setOnClickListener(listener);
        //记忆
        back=(Button)findViewById(R.id.button_bk);
        clean=(Button)findViewById(R.id.button_ce);
        cleanAll=(Button)findViewById(R.id.button_c);

        back.setOnClickListener(listener);
        clean.setOnClickListener(listener);
        cleanAll.setOnClickListener(listener);
        //数据记忆
        mclean=(Button)findViewById(R.id.button_mc);
        mread=(Button)findViewById(R.id.button_mr);
        msave=(Button)findViewById(R.id.button_ms);

        mclean.setOnClickListener(listener);
        mread.setOnClickListener(listener);
        msave.setOnClickListener(listener);
        //数字
        btn[0]=(Button)findViewById(R.id.button_0);
        btn[1]=(Button)findViewById(R.id.button_1);
        btn[2]=(Button)findViewById(R.id.button_2);
        btn[3]=(Button)findViewById(R.id.button_3);
        btn[4]=(Button)findViewById(R.id.button_4);
        btn[5]=(Button)findViewById(R.id.button_5);
        btn[6]=(Button)findViewById(R.id.button_6);
        btn[7]=(Button)findViewById(R.id.button_7);
        btn[8]=(Button)findViewById(R.id.button_8);
        btn[9]=(Button)findViewById(R.id.button_9);

        for(int i=0;i<10;i++){
            btn[i].setOnClickListener(listener);
        }
        //点
        dot=(Button)findViewById(R.id.button_dot);

        dot.setOnClickListener(listener);
        //正负数转换
        sign=(Button)findViewById(R.id.button_sign);

        sign.setOnClickListener(listener);
    }
    //按钮监听
    private OnClickListener listener=new OnClickListener(){
        public void onClick(View v) {
            // TODO Auto-generated method stub
            //获取输入数据
            String inputText=input.getText().toString();
            //对输入数据进行判断
            switch(v.getId()){
                case R.id.button_bk://后退
                    if(inputText.length()>1)
                        input.setText(inputText.substring(0, inputText.length()-1));
                    else if(inputText.length()==1){
                        input.setText("0");
                    }
                    if(input.getText().toString().compareTo("-")==0){//去除负号
                        input.setText("0");
                    }
                    break;
                case R.id.button_ce://此次输入清零
                    input.setText("0");
                    if(isInputChar)
                        op2=0;
                    else
                        op1=0;
                    break;
                case R.id.button_c://全部清零，重新计算
                    input.setText("0");
                    op1=0;
                    op2=0;
                    isInputChar=false;
                    break;
                case R.id.button_mc://清空记忆数据
                    memory.setText("0");
                    break;
                case R.id.button_mr://取出记忆数据并显示
                    if(memory.getText().toString().compareTo("0")!=0){//记忆数据不为0时才显示
                        input.setText(memory.getText());
                        if(isInputChar)
                            op2=Double.parseDouble(memory.getText().toString());
                        op1=Double.parseDouble(memory.getText().toString());
                    }
                    break;
                case R.id.button_ms://取当前文本编辑框内的数据作为记忆数据
                    memory.setText(input.getText());
                    break;
                case R.id.button_dot://点
                    boolean nodot=(inputText.indexOf(".")==-1);//判断数据中是否已存在点
                    if(nodot)
                        input.append(".");
                    break;
                case R.id.button_sign://负数或正数
                    try{
                        double data=Double.parseDouble(inputText);
                        if(data!=0){
                            data=data*(-1);
                            input.setText(String.valueOf(data));
                        }
                        else
                            input.setText("-");
                    }catch(NumberFormatException err){
                        input.setText("Number Format Exception!");
                    }
                    break;
                //记录运算符
                case R.id.button_div:
                case R.id.button_multi:
                case R.id.button_minus:
                case R.id.button_plus:
                    operation=((Button)v).getText().toString().charAt(0);
                    isInputChar=true;
                    op1=Double.valueOf(inputText);
                    //input.append(String.valueOf(operation));
                    input.setText("0");
                    break;
                case R.id.button_equal:
                    op2=Double.valueOf(inputText);
                    dealEqual(operation,op1,op2);
                    break;
                default://输入数字
                    String num=((Button)v).getText().toString();
                    if(inputText.length()==1){
                        if(inputText.compareTo("0")==0)
                            input.setText(num);
                        else
                            input.append(num);
                    }
                    else
                        input.append(num);
                    break;
            }
        }
    };
    //处理‘=’按钮
    public void dealEqual(char ch,double op1,double op2){
        if(isInputChar){
            if(ch=='+')
                op1+=op2;
            else if(ch=='-')
                op1-=op2;
            else if(ch=='*')
                op1*=op2;
            else if(ch=='/')
                op1/=op2;
        }
        input.setText(String.valueOf(op1));
    }
}

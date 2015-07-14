package com.example.administrator.calculatorapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity{
    double op1=0,op2=0;//��¼���������ֵ
    char operation;//��¼�����
    EditText input;//�����ı���
    boolean isInputChar=false;//�ж��Ƿ������������
    TextView memory;//�����ı�
    Button plus,minus,multi,divide,equal;//�����
    Button back,clean,cleanAll;//�ı����ݴ������ˡ�������
    //�����㡢�����������㣩
    Button mclean,mread,msave;//���ݼ��䣨�������ȡ�����棩
    Button[] btn=new Button[10];//����
    Button dot;//��
    Button sign;//������ת��

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input=(EditText)findViewById(R.id.et_input);
        memory=(TextView)findViewById(R.id.tv_mem);
        //�����
        plus=(Button)findViewById(R.id.button_plus);
        minus=(Button)findViewById(R.id.button_minus);
        multi=(Button)findViewById(R.id.button_multi);
        divide=(Button)findViewById(R.id.button_div);
        equal=(Button)findViewById(R.id.button_equal);
        //���õ������
        plus.setOnClickListener(listener);
        minus.setOnClickListener(listener);
        multi.setOnClickListener(listener);
        divide.setOnClickListener(listener);
        equal.setOnClickListener(listener);
        //����
        back=(Button)findViewById(R.id.button_bk);
        clean=(Button)findViewById(R.id.button_ce);
        cleanAll=(Button)findViewById(R.id.button_c);

        back.setOnClickListener(listener);
        clean.setOnClickListener(listener);
        cleanAll.setOnClickListener(listener);
        //���ݼ���
        mclean=(Button)findViewById(R.id.button_mc);
        mread=(Button)findViewById(R.id.button_mr);
        msave=(Button)findViewById(R.id.button_ms);

        mclean.setOnClickListener(listener);
        mread.setOnClickListener(listener);
        msave.setOnClickListener(listener);
        //����
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
        //��
        dot=(Button)findViewById(R.id.button_dot);

        dot.setOnClickListener(listener);
        //������ת��
        sign=(Button)findViewById(R.id.button_sign);

        sign.setOnClickListener(listener);
    }
    //��ť����
    private OnClickListener listener=new OnClickListener(){
        public void onClick(View v) {
            // TODO Auto-generated method stub
            //��ȡ��������
            String inputText=input.getText().toString();
            //���������ݽ����ж�
            switch(v.getId()){
                case R.id.button_bk://����
                    if(inputText.length()>1)
                        input.setText(inputText.substring(0, inputText.length()-1));
                    else if(inputText.length()==1){
                        input.setText("0");
                    }
                    if(input.getText().toString().compareTo("-")==0){//ȥ������
                        input.setText("0");
                    }
                    break;
                case R.id.button_ce://�˴���������
                    input.setText("0");
                    if(isInputChar)
                        op2=0;
                    else
                        op1=0;
                    break;
                case R.id.button_c://ȫ�����㣬���¼���
                    input.setText("0");
                    op1=0;
                    op2=0;
                    isInputChar=false;
                    break;
                case R.id.button_mc://��ռ�������
                    memory.setText("0");
                    break;
                case R.id.button_mr://ȡ���������ݲ���ʾ
                    if(memory.getText().toString().compareTo("0")!=0){//�������ݲ�Ϊ0ʱ����ʾ
                        input.setText(memory.getText());
                        if(isInputChar)
                            op2=Double.parseDouble(memory.getText().toString());
                        op1=Double.parseDouble(memory.getText().toString());
                    }
                    break;
                case R.id.button_ms://ȡ��ǰ�ı��༭���ڵ�������Ϊ��������
                    memory.setText(input.getText());
                    break;
                case R.id.button_dot://��
                    boolean nodot=(inputText.indexOf(".")==-1);//�ж��������Ƿ��Ѵ��ڵ�
                    if(nodot)
                        input.append(".");
                    break;
                case R.id.button_sign://����������
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
                //��¼�����
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
                default://��������
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
    //����=����ť
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

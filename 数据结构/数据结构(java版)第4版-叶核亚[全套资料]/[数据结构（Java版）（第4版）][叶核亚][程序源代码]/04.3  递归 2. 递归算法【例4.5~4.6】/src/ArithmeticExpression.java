//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��7��16��
//4.3 �ݹ�
//����4.6�� �õݹ��㷨�����������ʽ��ֵ��

public class ArithmeticExpression                          //�������ʽ��������������λ���㣩
{
    private String infix;                                  //��׺�������ʽ�ַ���
    private int index;                                     //��ǰ�ַ����

    public ArithmeticExpression(String infix)              //���췽����infixָ����׺���ʽ�ַ���
    {
        this.infix = infix;
        this.index = 0;
    }
    
    //�����index��ʼ��һ�����ӣ��������ʽ����������ֵ�����н��жࡴ��Ӽ�����
    public int intValue() 
    {
        int value1 = term();                               //���㡴���ò�����1
        while (this.index < this.infix.length())           //���жࡴ��ļӼ�����
        {
            char op = this.infix.charAt(this.index);
            if (op=='+' || op=='-')                        //��ס�����
            {   this.index++;
                int value2 = term();                       //���㡴���ò�����2
                switch (op)                                //��������мӼ�����
                {   case '+': value1 += value2; break;     //value1�洢������
                    case '-': value1 -= value2; break;
                }                
            }
            else break;                                    //����')'ʱ���������
        }
        return value1;  
    }
    
    private int term()                 //�����index��ʼ��һ��������н��жࡴ���ӡ��ĳ˳�����
    {
        int value1 = factor();                             //���㡴���ӡ���ò�����1
        while (this.index < this.infix.length())           //���жࡴ���ӡ��ĳ˳�����
        {
            char op = this.infix.charAt(this.index);
            if (op=='*' || op=='/' || op=='%')             //��ס�����
            {   this.index++;
                int value2 = factor();                     //���㡴���ӡ���ò�����2
                switch (op)                                //�������ӡ����г˳�����
                {   case '*': value1 *= value2; break;     //value1�洢������
                    case '/': value1 /= value2; break;     //����Ϊ0ʱ��Java�׳������쳣ArithmeticException: / by zero
                    case '%': value1 %= value2; break;
                }                
            }
            else break;                                    //����')'��'+'��'-'ʱ�������ӡ�����
        }
        return value1;  
    }
    
    //�����index��ʼ��һ�������ӡ������а�����()Ϊ����ӱ��ʽ����ӵݹ����    
    private int factor()
    {
        if (this.infix.charAt(this.index)=='(')
        {   this.index++;                                  //����'('
            int value = intValue();                        //����()�����ڵ��ӱ��ʽ����ӵݹ����
            this.index++;                                  //����')'
            return value;
        }
        return constant(); 
    }

    private int constant()                                 //���ش�index��ʼ��һ����������
    {
        if (this.index < this.infix.length())
        {
            char op=this.infix.charAt(this.index);
            int sign=1, value=0;
            if (op=='+' || op=='-')
            {    sign = op=='-' ? -1 : 1;                  //����λ����ס��������� 
                 this.index++;                             //��������λ
            }
            while (this.index < this.infix.length())
            {
                char ch = this.infix.charAt(this.index);
                if (ch>='0' && ch<='9')
                {   value = value*10+ch-'0';               //value��ס��ǰ��õ�����ֵ
                    this.index++;
                }
                else break;
            }
            return value*sign;                             //�����з��ŵ�����ֵ
        }
        throw new NumberFormatException("\""+this.infix.substring(this.index-1)+"\"����ת��������");
    }
    
    public static void main(String args[])
    {
        String[] infix={"+123+10*(+53-49+20)/((-25+35)*2+10)+(-11)+0"};    //�ܹ�ʶ��+��-��Ϊ����
//                         "123","+123","-123","(-123)",
//                         "1+-2","1-+2","-1+((-2))","1+2+3","1*2*3","-1*-2*-3"};
//                       null,                   //���д�Java�׳��ն����쳣java.lang.NullPointerException
//                       "","+1+","++",          //Java�׳��쳣java.lang.StringIndexOutOfBoundsException
//                       "+","-"};               //�������׳��쳣java.lang.NumberFormatException: "+"����ת��������
        for (int i=0; i<infix.length; i++)
            System.out.println(infix[i]+"="+new ArithmeticExpression(infix[i]).intValue());
    }    
    
    //��˼����4-5��          
/*    private int constant()                                 //���ش�index��ʼ��һ����������
    {
       if (this.index < this.infix.length())
       {
            int j=this.index;            
            char ch = this.infix.charAt(j);
            if (ch=='+' || ch=='-')
                j++;
            while (j < this.infix.length())
            {
                ch = this.infix.charAt(j);
                if (ch>='0' && ch<='9')
                    j++;
                else break;
            }
            int value=MyInteger.parseInt(this.infix.substring(this.index,j));//�ַ���ת��Ϊ����ֵ
            this.index=j;
            System.out.println("this.index="+this.index+"��value="+value);
            return value;
        }
        throw new NumberFormatException("\""+this.infix.substring(this.index-1)+"\"����ת��������");
    }*/
}
/*
�������н�����£�
+123+10*(+53-49+20)/((-25+35)*2+10)+(-11)+0=120
123=123
+123=123
-123=-123
(-123)=-123
1+-2=-1
1-+2=-1
-1+(-2)=-3
1+2+3=6
1*2*3=6
-1*-2*-3=-6

��infix=null���׳��ն����쳣java.lang.NullPointerException��
��infix=""���׳��쳣java.lang.StringIndexOutOfBoundsException

*/
//author��Yeheya��2014-9-23



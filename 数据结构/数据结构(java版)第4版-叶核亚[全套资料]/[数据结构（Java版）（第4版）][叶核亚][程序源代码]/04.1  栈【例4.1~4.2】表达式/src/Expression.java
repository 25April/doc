//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��7��3��
//4.1 ջ
//����4.2�� ʹ��ջ������ʽ��ֵ��
//StringBuffer

public class Expression 
{
    public static StringBuffer toPostfix(String infix)     //���ؽ�infix��׺���ʽת���ɵĺ�׺���ʽ
    {
        Stack<String> stack = new SeqStack<String>(infix.length());  //�����ջ��˳��ջ
        StringBuffer postfix = new StringBuffer(infix.length()*2);   //��׺���ʽ�ַ���
        int i=0;
        while (i<infix.length())
        {
            char ch=infix.charAt(i); 
            switch (ch)
            {
                case '+': case '-':                        //���������������
                    while (!stack.isEmpty() && !stack.peek().equals("("))//��ջ��������Ƚ�
                        postfix.append(stack.pop());       //��ջ�������ӵ���׺���ʽ��
                    stack.push(ch+"");                     //��ǰ�������ջ
                    i++;  break;
                    
                case '*': case '/':                        //����*��/ �����
                    while (!stack.isEmpty() && (stack.peek().equals("*") || stack.peek().equals("/")))
                        postfix.append(stack.pop());       //ջ�����ȼ��ߵ��������ջ
                    stack.push(ch+"");
                    i++;  break;
                    
                case '(':                                  //���������ţ���ջ
                    stack.push(ch+"");
                    i++;  break;
                    
                case ')':
                    String out = stack.pop();              //���������ţ���ջ����ջ�շ���null
                    while (out!=null && !out.equals("("))  //ֱ����ջ�����Ϊ������
                    {   postfix.append(out);
                        out = stack.pop();
                    }
                    i++;  break;
                    
                default:                                   //�������֣���ӵ���׺���ʽ
                    while (i<infix.length() && ch>='0' && ch<='9')
                    {   postfix.append(ch);
                        i++;
                        if (i<infix.length())
                            ch=infix.charAt(i);
                    }
                    postfix.append(" ");                   //��ӿո���Ϊ��ֵ֮��ķָ���
            }
        }
        while (!stack.isEmpty())                           //�����������ջ
            postfix.append(stack.pop());                   //��ӵ�postfix��֮��
        return postfix;
    }
    
    public static int toValue(StringBuffer postfix)        //�����׺���ʽ��ֵ
    {
//        LinkedStack<int> stack = new LinkedStack<int>();//�﷨��
        Stack<Integer> stack = new LinkedStack<Integer>(); //������ջ����ʽջ
        int value=0;
        for (int i=0; i<postfix.length(); i++)             //�������׺���ʽ�е��ַ�
        {    
            char ch=postfix.charAt(i);
            if (ch>='0' && ch<='9')                        //���������ַ�
            {
                value=0;
                while (ch!=' ')                            //�������ַ���ת��Ϊ����ֵ
                {
                    value = value*10 + ch-'0';
                    ch = postfix.charAt(++i);
                }
                stack.push(value);                         //new Integer(value)����������ջ��Java�Զ���int������װ��Integer����
            }
            else
                if (ch!=' ')
                {
                    int y=stack.pop(), x=stack.pop();      //��ջ������������ע���ջ����Java�Զ�����intValue()������Integer����ת����int����
                    switch (ch)                            //����������ֱ����
                    {
                        case '+': value=x+y;  break;
                        case '-': value=x-y;  break;
                        case '*': value=x*y;  break;
                        case '/': value=x/y;  break;       //������������Ϊ0���׳������쳣
                    }
                    System.out.print(x+(ch+"")+y+"="+value+"��");//��ʾ�������
                    stack.push(value);                     //��������ջ
                }
        }
        return stack.pop();                                //����������
    }
    
    public static void main(String args[])
    {
        String[] infix={"123",
                        "123+10*(45-50+20)/((35-25)*2+10)-11",//��4.2 ��׺���ʽ��û��������
               //����         "+123+10*(+53-49+20)/((-25+35)*2+10)+(-11)",//��4.6 �ݹ��㷨����ʽ��������
                        "45+(10-15)*((25+35)/(60-40))-11"};  //ͼ6.21 ���ʽ��������
        for (int i=0; i<infix.length; i++)
        {
            StringBuffer postfix = toPostfix(infix[i]);    //ת���ɺ�׺���ʽ
//            System.out.println("infix="+infix[i]+"\npostfix="+postfix);
            System.out.println("infix="+infix[i]+"��length()="+infix[i].length());
            System.out.println("postfix="+postfix+"��length()="+postfix.length());
            System.out.println("value="+toValue(postfix)+"\n");
        }
    }
}
/*
�������н�����£�
infix=123��length()=3
postfix=123 ��length()=4
value=123
                                       //��4.2��׺���ʽ��û��������
infix=123+10*(45-50+20)/((35-25)*2+10)-11��length()=35
postfix=123 10 45 50 -20 +*35 25 -2 *10 +/+11 -��length()=39
45-50=-5��-5+20=15��10*15=150��35-25=10��10*2=20��20+10=30��150/30=5��123+5=128��128-11=117��value=117

                                       //ͼ6.21 ���ʽ��������
infix=45+(10-15)*((25+35)/(60-40))-11��length()=31
postfix=45 10 15 -25 35 +60 40 -/*+11 -��length()=31
10-15=-5��25+35=60��60-40=20��60/20=3��-5*3=-15��45+-15=30��30-11=19��value=19


infix= 121+10*(53-49+20)/((35-25)*2+10)+11/0
postfix= 121 10 53 49 -20 +*35 25 -2 *10 +/+11 0 /+
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at Expression.value(Expression.java:79)
	at Expression.main(Expression.java:93)

*/
//@author��Yeheya��2014-10-7
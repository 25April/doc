//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��7��3�գ�JDK 8.05
//4.1 ջ
//����4.1��  ����ƥ����﷨��顣

public class Bracket
{
    //���infix���ʽ�е�Բ�����Ƿ�ƥ�䣬��ƥ�䣬���ؿմ������򷵻ش�����Ϣ
    public static String isMatched(String infix)
    {
        SeqStack<String> stack = new SeqStack<String>(infix.length());
                   //�����ӿڶ���stack������ʵ��Stack<T>�ӿڵ�˳��ջ���ʵ����������ջ
//      Stack<String> stack = new LinkedStack<String>();
        
        for (int i=0; i<infix.length(); i++)
        {    
            char ch=infix.charAt(i);
            switch(ch)
            {
                case '(': stack.push(ch+"");               //��������ջ
                          System.out.println(stack.toString());                          
                          break;
                          
                case ')': if (stack.isEmpty() || !stack.pop().equals("("))  //����������ʱ����ջ
                              return "����(";                //����ջ�ַ��Ƿ�Ϊ������
            }    
        }
        return (stack.isEmpty()) ? "" : "����)";             //���ؿմ���ʾû�д���
    }    

    public static void main(String args[])
    {
        String infix="((1+2)*3+4))("; 
        System.out.println(infix+"  ���������"+Bracket.isMatched(infix));
    }
}

/*
����������ʱ����infix�ֱ��ʾ��ͬ�ı��ʽ�ַ��������н�����£�
((1+2)*3+4) 
((1+2)*3+4  ������)
((1+2)*3+4))(  �������������(

*/

//@author��Yeheya��2014-7-3

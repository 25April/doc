//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��7��3�գ�JDK 8.05
//4.1 ջ

public class Stack_ex 
{
	public static void main(String args[])
	{
	    SeqStack<String> stack1 = new SeqStack<String>(20); //�����ջ
	    System.out.print("Push: ");
	    char ch='a';
	    for(int i=0;i<5;i++)
	    {
	        String str = (char)(ch+i)+"";
	        stack1.push(str);
	        System.out.print(str+"  ");
	    }    

        LinkedStack<Integer> stack2 = new LinkedStack<Integer>();
        System.out.print("\nPush: ");
        for (int i=1; i<=5; i++)
        {
            Integer intobj = new Integer(i);
            stack2.push(intobj);
            System.out.print(intobj+"  ");
        }    

	    System.out.println("\nStack: "+stack2.toString());
	    System.out.print("Pop : ");
	    while(!stack2.isEmpty())                  //ȫ����ջ
	        System.out.print(stack2.pop().toString()+"  ");
	    System.out.println();
	}
}
/*
�������н�����£�
Push: a  b  c  d  e  
Stack: (e, d, c, b, a) 
Pop : e  d  c  b  a  

Push: 1  2  3  4  5  
Stack: (5, 4, 3, 2, 1) 
Pop : 5  4  3  2  1  

*/
//@author��Yeheya��2014-7-3
//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��6��25��
//3.2.2   �����ַ�����
//java.lang.String�����

public class String_ex 
{
    public static void main(String args[])
    {
    	//�մ�����
/*    	String empty=null;                                 //�ն���
        System.out.println("null="+empty);
    	empty = new String();                              //�մ�
        System.out.println("new String()="+empty+"��length()="+empty.length());
    	empty = "";                                        //�մ�
        System.out.println("\"\"="+empty+"��length()="+empty.length());
    	empty = new String("");                            //�մ�
        System.out.println("new String(\"\")="+empty+"��length()="+empty.length());
*/        
        //��1�� ���쳣���ַ���
        //���췽����ȡ�ַ������Ӵ��ȣ�����ݴ���ԣ���β��'\0'
//        String s1=new String(null,0,1);//The constructor String(String) is ambiguous����ȷ��
        char[] value={'a','b','c','d','e','\0','f','g','h','i','j','k'};
        int begin=0, n=value.length-begin;        
        String s1=new String(value, begin, n);             //begin��š�n���ȶ����ݴ��׳��쳣
        System.out.println("���죬\""+s1+"\".length()="+s1.length());        
        
        //���Ӵ�
        String s2=s1.substring(1,s1.length());            //begin��end��Ų��ݴ��׳��쳣
        System.out.println("�Ӵ���\""+s2+"\".length()="+s2.length());
        
/*
        //indexOf(ch,i)����i�ݴ�
        char ch='k';
        i=-i;
        System.out.println("\""+s1+"\".indexOf('"+ch+"',"+i+")="+s1.indexOf(ch,i));
                                                                //��i�ݴ���i<0����0��ʼ����
        */
        
        //test
//        System.out.println("new String()==\"\"? "+(new String()==""));
//        System.out.println("new String()==null? "+(new String()==null));
//        System.out.println("new String().length()= "+new String().length());
//      System.out.println("new String().isEmpty()? "+(new String().isEmpty()));
//      System.out.println("\"\".length()= "+"".length());
//      System.out.println("\"\".isEmpty()? "+("".isEmpty()));
        
    }
}
/*
//�մ�����
null=null
new String()=��length()=0
""=��length()=0
new String("")=��length()=0

//���췽������
���죬"abcde fghijk".length()=12
�Ӵ���"bcde fghi".length()=8

//test
new String()==""? false
new String()==null? false
new String().length()= 0
new String().isEmpty()? true
"".length()= 0
"".isEmpty()? true
*/

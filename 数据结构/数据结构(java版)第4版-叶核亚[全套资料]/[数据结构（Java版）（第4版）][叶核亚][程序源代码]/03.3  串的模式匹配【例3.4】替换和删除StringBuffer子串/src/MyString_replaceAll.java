//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��6��25��
//3.2.2   �����ַ�����
//3.3   ����ģʽƥ��
//��˼����3-4��ʵ����3-13���Ĵ�

public class MyString_replaceAll 
{
    public static void main(String args[]) 
    {
        MyString target=new MyString("AABABBABAC"), pattern=new MyString("AB"), str=new MyString("ABA");

        System.out.println("\""+target+"\".replaceAll(\""+pattern+"\", \""+str+"\")=\""+target.replaceAll(pattern, str)+"\"");
        pattern=new MyString("ABA");               //ģʽ��
        str=new MyString("");          //�滻��
        System.out.println("\""+target+"\".replaceAll(\""+pattern+"\", \""+str+"\")=\""+
                target.replaceAll(pattern, str)+"\"");
    }
}
/*
"AABABBABAC".replaceAll("AB", "ABA")="AABAABABAABAAC"//??
"AABABBABAC".replaceAll("ABA", "")="ABBC"


//ͼ3.11���滻�Ӵ�����3.3����
"ababdabcdabcabc".replaceFirst("abc", "xy")=ababdxydabcabc
"ababdabcdabcabc".replaceAll("abc", "xy")=ababdxydxyxy

//ͼ3.11���滻�Ӵ�����3.4����
"aaaa".replaceFirst("a", "ab")=abaaa
"aaaa".replaceAll("a", "ab")=abababab


//Brute-Forceģʽƥ���㷨
//MyString target=new MyString("abbabaaba"), pattern=new MyString("aba");//ͼ3.10
//MyString target=new MyString("aabaaa"), pattern=new MyString("aab");   //������
//MyString target=new MyString("aaaaaa"), pattern=new MyString("aab");     //����
//System.out.println("\""+target+"\".indexOf_BF(\""+pattern+"\")="+target.indexOf_BF(pattern));
}
*/
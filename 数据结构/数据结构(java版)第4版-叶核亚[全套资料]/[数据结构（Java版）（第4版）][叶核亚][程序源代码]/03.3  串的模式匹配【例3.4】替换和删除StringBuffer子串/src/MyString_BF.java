//�����ݽṹ��Java�棩����5�棩�������ߣ�Ҷ���ǣ�2015��2��7��
//3.3   ����ģʽƥ��
//3.3.1 Brute-Force�㷨        

public class MyString_BF 
{
    public static void main(String args[]) 
    {
//        MyString target=new MyString("aababcd"), pattern=new MyString("abcd"); //ͼ3.11��ƥ��ɹ�
//        MyString target=new MyString("abcdabc"), pattern=new MyString("abcd"); //ͼ3.12(a)��ƥ��ɹ���������  	
//        MyString target=new MyString("aaaaa"), pattern=new MyString("aab");      //ͼ3.12(b)��������ƥ�䲻�ɹ�

    	//ϰ����
        MyString target=new MyString("aaabaaaba"), pattern=new MyString("aaaa"); //ϰ3-9(2)BF��ϰͼ3.4

        System.out.println("\""+target+"\".indexOf(\""+pattern+"\")="+target.indexOf(pattern));
    }
}
/*
�������н�����£�
t0=p0��t1!=p1                                               //ƥ��4��
t1=p0��t2=p1��t3!=p2
t2!=p0
t3=p0��t4=p1��t5=p2��t6=p3��	BF.count=10
"aababcd".indexOf("abcd")=3                                //ͼ3.11��ƥ��ɹ�


t0=p0��t1=p1��t2=p2��t3=p3��	BF.count=4                     //ƥ��1��
"abcdabc".indexOf("abcd")=0                                //ͼ3.12(a)��ƥ��ɹ���������


t0=p0��t1=p1��t2!=p2                                         //ƥ��n-m+1=3��
t1=p0��t2=p1��t3!=p2
t2=p0��t3=p1��t4!=p2
	BF.count=9                                              //�Ƚ�(n-m+1)*m�Σ�O(n*m)
"aaaaa".indexOf("aab")=-1                                   //ͼ3.12(b)��������ƥ�䲻�ɹ�


t0=p0��t1=p1��t2=p2��t3!=p3                                  //ϰ3-9(2)BF��ƥ��5�Σ�ϰ����ͼ3.4
t1=p0��t2=p1��t3!=p2��
t2=p0��t3!=p1��
t3!=p0��
t4=p0��t5=p1��t6=p2��t7!=p3��
t5=p0��t6=p1��t7!=p2��
	BF.count=17
"aaabaaaba".indexOf("aaaa")=-1


**/
//@author��Yeheya��2015-2-26

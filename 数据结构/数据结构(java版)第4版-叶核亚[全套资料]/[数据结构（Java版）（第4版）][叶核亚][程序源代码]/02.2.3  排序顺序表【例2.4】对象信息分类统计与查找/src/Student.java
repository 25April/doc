//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��9��8�գ�JDK 8.11
//��2.2  ���Ա��˳��洢��ʵ��
//��2.2.3  ����˳���
//����2.4��  ������Ϣ�ķ���ͳ�ơ����Һ����������

public class Student extends Object implements Comparable<Student>  //ѧ����
{
    String name;                                 //����
    int score;                                   //ĳ�ſγ̳ɼ�

    public Student(String name, int score)       //���췽��
    {
        this.name = name;
        this.score = score;
    }
    
    public String toString()                     //���ض���������ַ�������ʽΪ��(,)��������
    {
        return "("+this.name+","+this.score+")";
    }

    public boolean equals(Object obj)            //�Ƚ϶����Ƿ���ȣ����Ƚ�name���ⰴnameʶ��Student���󡣸���
    {
        return this==obj || (obj instanceof Student) &&  this.name.equals(((Student)obj).name);
                                    //����String���equals(Object)�������Ƚ������Ƿ����
    }
    
    public int compareTo(Student stu)            //�Ƚ϶����С��ʵ��Comparable<T>�ӿ�
    {
        return this.score - stu.score;           //���ɼ��Ƚ϶����С
    }
}

/*  //������ȷ��������ͬ
    public boolean equals(Object obj)
    {
        if (this==obj)
            return true;
        if (obj instanceof Student)
            return this.name.equals(((Student)obj).name);
                                       //����String���equals(Object)�������Ƚ������Ƿ����
        return false;
    }
*/
//@author��Yeheya��2014-9-8

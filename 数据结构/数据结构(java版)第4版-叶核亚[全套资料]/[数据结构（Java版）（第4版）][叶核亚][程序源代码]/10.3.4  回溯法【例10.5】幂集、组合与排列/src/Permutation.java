//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��11��15��
//10.3   �㷨��Ʋ���
//10.3.4   ���ݷ�
//����10.5��  ��һ�����ϵ��ݼ���
//��4�����С���˼����10-7�� 

//P(m,n)���У����set����n��Ԫ����ѡ��m��Ԫ�ص��������У���m=nʱ�� ��Ϊȫ���С�Ĭ��ȫ���У����ݷ�
public class Permutation  extends Backtrack
{
    protected Object[] set;                      //����

    //���췽����setָ�����ϣ���set.length��Ԫ����ѡ��m��Ԫ�ص��������С�
    public Permutation(Object[] set, int m)
    {
        super(set.length, m);                    //����set.length���������߶�Ϊm������x[]Ԫ�ظ���Ϊm
        this.set = set;
    }
    public Permutation(Object[] set)             //���췽����setָ�����ϣ�Ĭ��ȫ����
    {
        this(set, set.length);                   //���߶�Ϊ����Ԫ�ظ���
    }

    public void printAll()                       //�����set���ϵ�����Ԫ����ѡ��m��Ԫ�ص��������С�����
    {
        System.out.print("P("+this.x.length+","+set.length+")���У�");
        super.printAll();                        //���ø��౻���ǵ�ͬ������
    }

    protected  boolean restrict(int i)           //Լ��������Ԫ�ز��ظ�������m��n����
    {
        for (int j=0; j<i; j++)
            if (x[j]==x[i])                      //Ԫ���ظ�
                return false;
        return true;
    }

    protected void print()                       //���һ���⣨���ϣ�����ʽΪ��{,}��������
    {
        System.out.print("{");
        if (this.x.length>0)
        {
            System.out.print(this.set[x[0]]);
            for (int i=1; i<this.x.length; i++)
                System.out.print(","+this.set[x[i]]);
        }
        System.out.print("}��");
    }

    public static void main(String args[]) 
    {
        String[] setstr={"A","B","C"};
        for (int m=0; m<=setstr.length; m++)
            new Permutation(setstr,m).printAll();//����
    }
}

/*
�������н�����£�
P(0,3)���У�{}��  1����
P(1,3)���У�{A}��{B}��{C}��  3����
P(2,3)���У�{A,B}��{A,C}��{B,A}��{B,C}��{C,A}��{C,B}��  6����
P(3,3)���У�{A,B,C}��{A,C,B}��{B,A,C}��{B,C,A}��{C,A,B}��{C,B,A}��  6����


//û������restrict(int i)
//���ͬ�������ʽ��ͬ��        new Backtrack(3,3).printAll();           //��3������3��Ԫ�ص�ȫ���У����ظ��ģ�n^n����
{A,A,A}��{A,A,B}��{A,A,C}��{A,B,A}��{A,B,B}��{A,B,C}��{A,C,A}��{A,C,B}��{A,C,C}��{B,A,A}��{B,A,B}��{B,A,C}��{B,B,A}��{B,B,B}��{B,B,C}��{B,C,A}��{B,C,B}��{B,C,C}��{C,A,A}��{C,A,B}��{C,A,C}��{C,B,A}��{C,B,B}��{C,B,C}��{C,C,A}��{C,C,B}��{C,C,C}��  27��ѡ��

*/
//@author��Yeheya��2014-11-15

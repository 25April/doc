//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��11��4��
//10.3   �㷨��Ʋ���
//10.3.4   ���ݷ�
//����10.5��  ���ϵ��ݼ�����������С�
//��3�� ���
//�ݹ���ݣ��㷨������ռ����������Լ����֦���޽��֦��������
//��Լ����֦���޽��֦��������

public class Combination  extends PowerSet       //��ϣ��̳��ݼ�
{
    CombinationNumber cnum;                      //�����������10.3

    public Combination(Object[] set)             //���췽����setָ������
    {
        super(set);
        this.cnum = new CombinationNumber(set.length);
    }

    public void printAll(int m)                  //�����set���ϵ�����Ԫ����ѡ��m��Ԫ�ص�������ϡ�����
    {
        System.out.print("C("+m+","+set.length+")="+cnum.get(m, set.length)+"����ϣ�");
        this.backtrack(m,0,0);
        System.out.println();
    }
    
    //��set���ϵ�����Ԫ����ѡ��m��Ԫ�ص�������ϣ���ý��x[i]ֵ��0��i<x.length��
    //��num��0����ʾx[]��ȡֵΪ1�ĸ�����
    //�ݹ���ݣ��㷨������ռ����������Լ����֦���޽��֦������������
    protected void backtrack(int m, int i, int num) 
    {
        if (i<this.x.length)
        {
            if (num+this.x.length-i>m)           //�޽��֦������num��ʣ��n-i��ѡ����ܵõ���ʱ
            {
                this.x[i]=0;                     //���ӽ��ȡֵ
                backtrack(m, i+1, num);          //��������������ý�x[i+1]ֵ��num+0���ݹ����
            }
            if (num<m)                           //Լ����֦����������Լ������ʱ
            {
                this.x[i]=1;                     //�Һ��ӽ��ȡֵ
                backtrack(m, i+1, num+1);        //��������������ý�x[i+1]ֵ��num+1���ݹ����
            }
        }
        else                                     //����Ҷ�ӽ�㣬���һ����
        {
//            this.count++;                        //�����
            print();                             //���set��һ���Ӽ�
        } 
    }

    public static void main(String args[]) 
    {
        String[] setstr={"A","B","C"};
        Combination set = new Combination(setstr);
        for (int m=0; m<=setstr.length; m++)
            set.printAll(m);
        set.printAll();                          //���ø���ķ�������������Ӽ�
    }
}
/*
�������н�����£�
C(0,3)=1����ϣ�{} 
C(1,3)=3����ϣ�{C} {B} {A} 
C(2,3)=3����ϣ�{B,C} {A,C} {A,B} 
C(3,3)=1����ϣ�{A,B,C} 
*/

  //@author��Yeheya��2014-11-15

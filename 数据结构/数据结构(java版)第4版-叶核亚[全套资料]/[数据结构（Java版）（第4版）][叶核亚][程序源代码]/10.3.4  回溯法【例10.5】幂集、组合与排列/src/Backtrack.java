//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��11��4��
//10.3   �㷨��Ʋ���
//10.3.4   ���ݷ�
//����10.5��  ���ϵ��ݼ�����������С�
//��1�����ݷ�
//�ݹ����

public class Backtrack                           //���ݷ�������������н�
{
	protected int k, x[], count;                 //k������x[]�洢һ���⣬count�洢��ĸ���
    
    public Backtrack(int k, int n)               //k������һ�����nԪ��
    {
        this.k = k;
        this.x = new int[n];                     //Ԫ�س�ֵΪ0
//        for (int i=0; i<this.x.length; i++)
//        	x[i]=-1;
        this.count=0;
    }

    public void printAll()                       //������н⣬������ռ�k����
    {
        this.count=0;
        this.backtrack(0);                       //�ݹ���ݣ�������н�
        System.out.println("  "+count+"����");
    }
       
    //�ݹ���ݣ�������ռ�k��������ý�x[i]ֵ��0��i<x.length������Լ���������м�֦
    protected void backtrack(int i)
    {
        if (i<this.x.length)
            for (int j=0; j<this.k; j++)         //����k������
            {
                this.x[i]=j;                     //���ȡֵ����Χ0��k-1
                if (restrict(i))                 //Լ������
                    this.backtrack(i+1);         //������һ����������ý�x[i+1]ֵ���ݹ����
            }
        else                                     //����Ҷ�ӽ�㣬���һ����
        {
            this.count++;                        //�����
            this.print();                        //���һ����
        }
    }
    protected boolean restrict(int i)            //Լ������������Լ����֦���޽��֦
    {
//      printX(i+1);                           //���ÿ������ֵ����ʾ���ı���·��
        return true;                             //��û��Լ�����������ռ�������k����
    }
    protected void print()                       //���һ����x[]��ֵΪ0/1����ʽΪ��(,)��
    {
        System.out.print("(");
        if (this.x.length>0)
        {
            System.out.print(this.x[0]);
            for (int i=1; i<this.x.length; i++)
                System.out.print(","+this.x[i]);
        }
        System.out.print(")��");
    }
    //�̲�ûд
    private void printX(int n)                   //���һ�����һ���֣����ÿ������ֵ����ʾ���ı���·��
    {
        System.out.print("("+this.x[0]);
        for (int i=1; i<n; i++)
            System.out.print(","+this.x[i]);
        System.out.print(")");
    }
    
    public static void main(String args[]) 
    {
        new Backtrack(2,3).printAll();              //ͼ10.16������������3��Ԫ�ؼ��ϵ������Ӽ���3��
//        new Backtrack(3,3).printAll();           //��3������3��Ԫ�ص�ȫ���У����ظ���
    }
}
/*
�������н�����£�
     new Backtrack(2,3).printAll();              //ͼ10.16������������3��Ԫ�ؼ��ϵ������Ӽ���3��
(0,0,0)�� (0,0,1)�� (0,1,0)�� (0,1,1)�� (1,0,0)�� (1,0,1)�� (1,1,0)�� (1,1,1)��   8����

        new Backtrack(3,3).printAll();           //��3������3��Ԫ�ص�ȫ���У����ظ���
(0,0,0)��(0,0,1)��(0,0,2)��(0,1,0)��(0,1,1)��(0,1,2)��(0,2,0)��(0,2,1)��(0,2,2)��(1,0,0)��(1,0,1)��(1,0,2)��(1,1,0)��(1,1,1)��(1,1,2)��(1,2,0)��(1,2,1)��(1,2,2)��(2,0,0)��(2,0,1)��(2,0,2)��(2,1,0)��(2,1,1)��(2,1,2)��(2,2,0)��(2,2,1)��(2,2,2)��  27����

*/
//@author��Yeheya��2014-11-13

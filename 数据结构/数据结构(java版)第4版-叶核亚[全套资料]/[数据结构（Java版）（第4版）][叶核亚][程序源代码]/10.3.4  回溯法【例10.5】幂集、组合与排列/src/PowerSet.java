//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��11��4��
//10.3   �㷨��Ʋ���
//10.3.4   ���ݷ�
//����10.5��  ���ϵ��ݼ�����������С�
//��2���ݼ�

public class PowerSet  extends Backtrack         //�ݼ����̳�Backtrack�࣬���ݷ����
{
	protected Object[] set;                      //����
    
    public PowerSet(Object[] set)                //���췽����setָ������
    {
        super(2, set.length);                    //������������Ԫ�ظ����������ģ
        this.set = set;
    }

    protected void print()             //���һ���⣨set���Ӽ�����x[i]Ϊ1/0�ֱ���ʾ/���i��Ԫ�أ���ʽΪ��{,}��������
    {
        System.out.print("{");
        boolean first=true;                      //��һ��Ԫ��
        for (int i=0; i<this.x.length; i++)
        if (this.x[i]==1)
        {
            if (!first)
                System.out.print(",");
            else  first = !first;
            System.out.print(this.set[i].toString());
        }
        System.out.print("}��");
    }
    
    public static void main(String args[]) 
    {
        String[] set={"A","B","C"};
        //Integer[] set = {1,2,3};
        Array1.print(set);                       //����������飬����1.4
        System.out.println("���ϵ��ݼ���");
        new PowerSet(set).printAll();        
    }    
} 
/*
�������н�����£�
{}�� {C}�� {B}�� {B,C}�� {A}�� {A,C}�� {A,B}�� {A,B,C}��   8��ѡ��
{}��{3}��{2}��{2,3}��{1}��{1,3}��{1,2}��{1,2,3}��  8��ѡ��

*/
//@author��Yeheya��2014-11-13
//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��8��27��
//10.3   �㷨��Ʋ���
//10.3.1   ���η�
//10.3.2   ��̬�滮��
//����10.3��  ���÷��η��Ͷ�̬�滮�����������
        //��1�� ���η������β��Եݹ��㷨

public class CombinationNumber_���η�
{
    public static int combine(int m, int n)                //���������Cmn�����β��Եݹ��㷨
    {
        if (n>0 && (m==0 || m==n))                         //�߽�����
            return 1;                                      //ֱ�ӽ�����⣬û�еݹ����
        if (m>0 && n>m)                                    //�ݹ�����
            return combine(m-1, n-1) + combine(m, n-1);  
                                       //�ֽ��2�������⣬�ݹ���ã����ظ�������ϲ���Ľ�
        throw new IllegalArgumentException("m="+m+"��n="+n);//�׳���Ч�����쳣
    }

    public static void main(String args[]) 
    {
//        System.out.println("combine("+0+","+(-5)+")="+combine(0,-5));      //�쳣
//        System.out.println("combine("+(-5)+","+0+")="+combine(-5,0));      //�쳣
        int n=5;
        for (int m=0; m<=n; m++)
            System.out.println("combine("+m+","+n+")="+combine(m,n));      //���β��Եݹ��㷨
    }
}
/*
�������н�����£�
combine(0,5)=1
combine(1,5)=5
combine(2,5)=10
combine(3,5)=10
combine(4,5)=5
combine(5,5)=1
*/
  //@author��Yeheya��2014-11-4

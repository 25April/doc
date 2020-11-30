//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��8��27��
//10.3   �㷨��Ʋ���
//10.3.1   ���η�
//10.3.2   ��̬�滮��
//����10.3��  ���÷��η��Ͷ�̬�滮�����������
//��2�� ��̬�滮��

public class CombinationNumber                   //���������̬�滮��
{
    private int[][] yanghui;                     //�������
    
    public CombinationNumber(int n)
    {
        this.yanghui = new int[n+1][];           //����n+1�е�������ǣ������εĶ�ά����
        for (int i=0; i<this.yanghui.length; i++)
        {
            yanghui[i]= new int[i+1];            //ÿ������i+1��Ԫ�ص�һά����
            yanghui[i][0]=yanghui[i][i]=1;       //ÿ����βֵΪ1
            for (int j=1; j<i; j++)
                yanghui[i][j]=yanghui[i-1][j-1]+yanghui[i-1][j];
                             //��i��j��Ԫ��Ϊ����һ�У�i-1��ǰ����Ԫ�أ�j-1��j��֮��
        }
    }

    public int get(int m, int n)                 //���������Cmn
    {
        return this.yanghui[n][m];               //��������ǻ�����������m��nԽ�磬Java�׳��±�Խ���쳣
    }
    
    public void printYanghui()                   //����������
    {
        System.out.print("");
        for (int i=0; i<yanghui.length; i++)
        {
            System.out.print(String.format("%"+(yanghui.length-i+1)*2+"c",' '));//���ǰ���ո�
            for (int j=0; j<yanghui[i].length; j++)
                System.out.print(String.format("%4d",yanghui[i][j]));     //��ʽ�����
            System.out.println();
        }
    }
    
    public static void main(String args[])
    {
        int n=5;
        CombinationNumber cnum = new CombinationNumber(n);
        cnum.printYanghui();
        for (int m=0; m<=n; m++)
            System.out.println("C("+m+","+n+")="+cnum.get(m, n));
    }
}
/*
�������н�����£�
                 1
               1   1
             1   2   1
           1   3   3   1
         1   4   6   4   1
       1   5  10  10   5   1
C(0,5)=1
C(1,5)=5
C(2,5)=10
C(3,5)=10
C(4,5)=5
C(5,5)=1


      //        System.out.println("combination("+m+","+n+")="+combination(m,n));//��̬�滮��������һά����
*/
//@author��Yeheya��2014-8-27

/*
�������н�����£�
   1
   1   1
   1   2   1
   1   3   3   1
   1   4   6   4   1
   1   5  10  10   5   1
   1   6  15  20  15   6   1
   1   7  21  35  35  21   7   1
   1   8  28  56  70  56  28   8   1
   1   9  36  84 126 126  84  36   9   1

                         1
                       1   1
                     1   2   1
                   1   3   3   1
                 1   4   6   4   1
               1   5  10  10   5   1
             1   6  15  20  15   6   1
           1   7  21  35  35  21   7   1
         1   8  28  56  70  56  28   8   1
       1   9  36  84 126 126  84  36   9   1
*/
//@author��Yeheya��2014-8-27
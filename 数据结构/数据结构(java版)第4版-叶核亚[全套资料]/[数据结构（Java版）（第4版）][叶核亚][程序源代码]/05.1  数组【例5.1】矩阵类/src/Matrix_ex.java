//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��7��11��
//5.1   ����
//����5.1��  �����ࡣ
//��ʵ��5-1��

class Matrix_ex
{
    public static void main(String args[])
    {
        int[][] value1={{1,2,3},{4,5,6,7,8},{9}};
        Matrix mata=new Matrix(3, 4, value1);              //������󣬳�ֵ����ʱ�Զ���0�����Զ���Ԫ��
        mata.set(2,3,10);
        System.out.print("����5.1�� A"+mata.toString());
        //���ϡ���5.1��  
        
        //���¡�ʵ��5-1��
        System.out.println("\n//��ʵ��5.1��");
        Matrix matb=new Matrix(3,4);                       //����վ������
        matb.set(0,0,1);
        matb.set(1,1,1);
        matb.set(2,2,1);
        System.out.print("B"+matb.toString());
/*        Matrix matc = mata.plus(matb);
        System.out.print("C=A+B"+matc.toString());
        mata.add(matb);
        System.out.print("A+=B"+mata.toString());

        System.out.println("C.equals(A)��"+matc.equals(mata));
        System.out.print("A��ת�þ���"+mata.transpose().toString());
        System.out.print("B��ת�þ���"+matb.transpose().toString()+"\n");
        
        System.out.println("A�������Ǿ���"+mata.isUpTriangular());
        int m2[][]={{1,2,3,4},{0,5,6,7},{0,0,8,9}};
        Matrix mate=new Matrix(4,4,m2);                    //��ֵ����ʱ�Զ���0
        System.out.print("E"+mate.toString());
        System.out.println("E�������Ǿ���"+mate.isUpTriangular()+"\n");
        
        System.out.println("A�������Ǿ���"+mata.isDownTriangular());
        int m3[][]={{1},{2,3},{0,4},{5,6,7}};              //��ֵ����ʱ�Զ���0
        Matrix matf=new Matrix(4,4,m3);
        System.out.print("F"+matf.toString());
        System.out.println("F�������Ǿ���"+matf.isDownTriangular()+"\n");

        System.out.println("A�ǶԳƾ���"+mata.isSymmetric());
        int m4[][]={{1,2,3,4},{2},{3},{4}};
        Matrix matg=new Matrix(4,4,m4);
        System.out.print("G"+matg.toString());
        System.out.println("G�ǶԳƾ���"+matg.isSymmetric());*/
    }
}

/*
�������н�����£�
����5.1�� A ����Matrix��3��4����
     1     2     3     0
     4     5     6     7
     9     0     0     10

    //author��Yeheya��2014-7-16

//??
//��ʵ��5.1��
B ����Matrix��3��4����
     1     0     0     0
     0     1     0     0
     0     0     1     0
C=A+B ����Matrix��3��4����
     2     2     3     0
     4     6     6     7
     9     0     1    10
A+=B ����Matrix��3��4����
     2     2     3     0
     4     6     6     7
     9     0     1    10
C.equals(A)��true
A��ת�þ��� ����Matrix��4��3����
     2     4     9
     2     6     0
     3     6     1
     0     7    10
B��ת�þ��� ����Matrix��4��3����
     1     0     0
     0     1     0
     0     0     1
     0     0     0

A�������Ǿ���false
E ����Matrix��4��4����
     1     2     3     4
     0     5     6     7
     0     0     8     9
     0     0     0     0
E�������Ǿ���true

A�������Ǿ���false
F ����Matrix��4��4����
     1     0     0     0
     2     3     0     0
     0     4     0     0
     5     6     7     0
F�������Ǿ���true

A�ǶԳƾ���false
G ����Matrix��4��4����
     1     2     3     4
     2     0     0     0
     3     0     0     0
     4     0     0     0
G�ǶԳƾ���true

//author��Yeheya��2014-7-16


A ����Matrix��3��4����
     1     2     3     0
     4     5     6     7
     9     0     0    10
B ����Matrix��3��4����
     0     0     0     0
     0     1     0     0
     0     0     1     0
C=A+B ����Matrix��3��4����
     1     2     3     0
     4     6     6     7
     9     0     1    10
A+=B ����Matrix��3��4����
     1     2     3     0
     4     6     6     7
     9     0     1    10

//ϰ��5
C.equals(A)��true
A��ת�þ��� ����Matrix��4��3����
     1     4     9
     2     6     0
     3     6     1
     0     7    10
B��ת�þ��� ����Matrix��4��3����
     0     0     0
     0     1     0
     0     0     1
     0     0     0

A�������Ǿ���false
E ����Matrix��4��4����
     1     2     3     4
     0     5     6     7
     0     0     8     9
     0     0     0     0
E�������Ǿ���true

A�������Ǿ���false
F ����Matrix��4��4����
     1     0     0     0
     2     3     0     0
     0     4     0     0
     5     6     7     0
F�������Ǿ���true

A�ǶԳƾ���false
G ����Matrix��4��4����
     1     2     3     4
     2     0     0     0
     3     0     0     0
     4     0     0     0
G�ǶԳƾ���true

*/


//author��Yeheya��2014-7-11

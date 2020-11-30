//�����ݽṹ��Java�棩����5�棩�������ߣ�Ҷ���ǣ�2014��7��17��
//��5.2.2 ϡ������ѹ���洢
//4.  ϡ������еĵ�����
//����5.2��ϡ�����Ĵ洢�����㣬�����еĵ�����
//��ϰ��5-9����ʵ����5-3��

class LinkedMatrix_ϰ5_9
{
    public static void main(String args[])
    {
        //A
        Triple[] elemsa={new Triple(0,4,32), new Triple(0,7,15),
                         new Triple(2,0,59), new Triple(2,4,86), new Triple(2,7,43),
                         new Triple(6,0,18), new Triple(6,4,65)};
        LinkedMatrix mata = new LinkedMatrix(7,8,elemsa);
        System.out.print("��ϰ��5-9�� A ������Ԫ���еĵ�����\n"+mata.toString());
        mata.printMatrix();
        int i=6, j=0;
        System.out.println("MatrixA["+i+"]["+j+"]="+mata.get(i,j));
        mata.set(i,j,0);
        System.out.println("MatrixA["+i+"]["+j+"]="+mata.get(i,j));
        mata.set(i,j,28);
        System.out.println("MatrixA["+i+"]["+j+"]="+mata.get(i,j));
        mata.set(i,j,18);
        System.out.println("MatrixA["+i+"]["+j+"]="+mata.get(i,j));
       
        //B
        Triple[] elemsb={new Triple(0,5,77), new Triple(0,7,-5),
                         new Triple(1,0,11),
                         new Triple(2,4,-86), new Triple(2,5,51), new Triple(2,7,-34),
                         new Triple(6,4,-20)};
        LinkedMatrix matb = new LinkedMatrix(7,8,elemsb);
        System.out.print("\nB ������Ԫ���еĵ�����\n"+matb.toString());
        matb.printMatrix2();        
        
        //C=A��C+=B 
        LinkedMatrix matc = new LinkedMatrix(mata);        //��ȿ�������ʵ����5-3��
        System.out.println("\nC=A ������Ԫ���еĵ�����\n"+matc.toString());
        matc.set(i,j,28);                                  //�����Ƿ���Ԫ�ض���
        System.out.println("MatrixA["+i+"]["+j+"]="+mata.get(i,j));
        System.out.println("MatrixC["+i+"]["+j+"]="+matc.get(i,j));
        System.out.println("C.equals(A)��"+matc.equals(mata));
        
        matc.addAll(matb);
        System.out.println("\nC=A��C+=B ������Ԫ���еĵ�����\n"+matc.toString());
        matc.printMatrix();
        
        //D=A+B
        LinkedMatrix matd = mata.union(matb);              //��ʵ����5-3��
        System.out.println("\nD=A+B ������Ԫ���еĵ�����\n"+matd.toString());
        matd.printMatrix();
        System.out.println("D.equals(C)��"+matd.equals(matc));
        
        LinkedMatrix mate = mata.transpose();              //��ʵ����5-3��
        System.out.println("\nA��ת�þ���  ��Ԫ���еĵ�����\n"+mate.toString());
        mate.printMatrix();
    }
}
/*
�������н�����£�
��ϰ��5-9�� A ������Ԫ���еĵ�����
0 -> PolySinglyList((0,4,32),(0,7,15))
1 -> PolySinglyList()
2 -> PolySinglyList((2,0,59),(2,4,86),(2,7,43))
3 -> PolySinglyList()
4 -> PolySinglyList()
5 -> PolySinglyList()
6 -> PolySinglyList((6,0,18),(6,4,65))
����LinkedMatrix��7��8����
   0   0   0   0  32   0   0  15
   0   0   0   0   0   0   0   0
  59   0   0   0  86   0   0  43
   0   0   0   0   0   0   0   0
   0   0   0   0   0   0   0   0
   0   0   0   0   0   0   0   0
  18   0   0   0  65   0   0   0
MatrixA[6][0]=18
MatrixA[6][0]=0
MatrixA[6][0]=28
MatrixA[6][0]=18

B ������Ԫ���еĵ�����
0 -> PolySinglyList((0,5,77),(0,7,-5))
1 -> PolySinglyList((1,0,11))
2 -> PolySinglyList((2,4,-86),(2,5,51),(2,7,-34))
3 -> PolySinglyList()
4 -> PolySinglyList()
5 -> PolySinglyList()
6 -> PolySinglyList((6,4,-20))
����LinkedMatrix��7��8����
   0   0   0   0   0  77   0  -5
  11   0   0   0   0   0   0   0
   0   0   0   0 -86  51   0 -34
   0   0   0   0   0   0   0   0
   0   0   0   0   0   0   0   0
   0   0   0   0   0   0   0   0
   0   0   0   0 -20   0   0   0

C=A ������Ԫ���еĵ�����
0 -> PolySinglyList((0,4,32),(0,7,15))
1 -> PolySinglyList()
2 -> PolySinglyList((2,0,59),(2,4,86),(2,7,43))
3 -> PolySinglyList()
4 -> PolySinglyList()
5 -> PolySinglyList()
6 -> PolySinglyList((6,0,18),(6,4,65))

MatrixA[6][0]=18
MatrixC[6][0]=28
C.equals(A)��false

C=A��C+=B ������Ԫ���еĵ�����
0 -> PolySinglyList((0,4,32),(0,5,77),(0,7,10))
1 -> PolySinglyList((1,0,11))
2 -> PolySinglyList((2,0,59),(2,5,51),(2,7,9))
3 -> PolySinglyList()
4 -> PolySinglyList()
5 -> PolySinglyList()
6 -> PolySinglyList((6,0,28),(6,4,45))

����LinkedMatrix��7��8����
   0   0   0   0  32  77   0  10
  11   0   0   0   0   0   0   0
  59   0   0   0   0  51   0   9
   0   0   0   0   0   0   0   0
   0   0   0   0   0   0   0   0
   0   0   0   0   0   0   0   0
  28   0   0   0  45   0   0   0

D=A+B ������Ԫ���еĵ�����
0 -> PolySinglyList((0,4,32),(0,5,77),(0,7,10))
1 -> PolySinglyList((1,0,11))
2 -> PolySinglyList((2,0,59),(2,5,51),(2,7,9))
3 -> PolySinglyList()
4 -> PolySinglyList()
5 -> PolySinglyList()
6 -> PolySinglyList((6,0,18),(6,4,45))

����LinkedMatrix��7��8����
   0   0   0   0  32  77   0  10
  11   0   0   0   0   0   0   0
  59   0   0   0   0  51   0   9
   0   0   0   0   0   0   0   0
   0   0   0   0   0   0   0   0
   0   0   0   0   0   0   0   0
  18   0   0   0  45   0   0   0
D.equals(C)��false

A��ת�þ���  ��Ԫ���еĵ�����
0 -> PolySinglyList((0,2,59),(0,6,18))
1 -> PolySinglyList()
2 -> PolySinglyList()
3 -> PolySinglyList()
4 -> PolySinglyList((4,0,32),(4,2,86),(4,6,65))
5 -> PolySinglyList()
6 -> PolySinglyList()
7 -> PolySinglyList((7,0,15),(7,2,43))

����LinkedMatrix��8��7����
   0   0  59   0   0   0  18
   0   0   0   0   0   0   0
   0   0   0   0   0   0   0
   0   0   0   0   0   0   0
  32   0  86   0   0   0  65
   0   0   0   0   0   0   0
   0   0   0   0   0   0   0
  15   0  43   0   0   0   0


*/
//@author��Yeheya��2015-10-12

//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��8��22��
//��9��   ����  9.1~9.4 ����

public class Array9
{
    //����1.4 Array1
//  public static int[] randomInt(int n, int size)            //����n���������������������
//    public static void print(int[] value)                  //�������Ԫ��

	
    //9.1.1 ֱ�Ӳ�������
    public static void insertSort(int[] keys)              //ֱ�Ӳ�����������
    {
        System.out.println("ֱ�Ӳ�����������");
        for (int i=1; i<keys.length; i++)                  //n-1��ɨ�裬������ǰ����n-1����
        {
            int temp=keys[i], j;                           //ÿ�˽�keys[i]���뵽ǰ��������������
            for (j=i-1; j>=0 && temp<keys[j]; j--)         //����
//            for (j=i-1; j>=0 && temp>keys[j]; j--)         //����
                keys[j+1] = keys[j];                       //��ǰ��ϴ�Ԫ������ƶ�
            keys[j+1] = temp;                              //tempֵ�������λ��
            System.out.print("��"+i+"�� temp="+temp+"\t");
            Array1.print(keys);                          //��������м�������ʡ��
        }
    }
    
    //���������ֱ�Ӳ��������㷨ͬ�ϡ��̰�
    public static <T extends Comparable<? super T>> void insertSort(T[] value)
    {
        System.out.println("ֱ�Ӳ�����������");
        for (int i=1; i<value.length; i++)                 //n-1��ɨ��
        {
            T temp = value[i];                             //ÿ�˽�value[i]���뵽ǰ��������������
            int j;
            for (j=i-1; j>=0 && temp.compareTo(value[j])<0; j--)  //��ǰ��ϴ�Ԫ������ƶ�
                value[j+1] = value[j];
            value[j+1] = temp;                             //tempֵ�������λ��
            System.out.print("��"+i+"��: ");
            Array1.print(value);                          //����print(Object)��������м�������ʡ��
        }
    }

    //9.1.2   ϣ������
    public static void shellSort(int[] keys)               //ϣ�����������������룩
    {
        System.out.println("ϣ����������");
        for (int delta=keys.length/2; delta>0; delta/=2)   //�����ˣ���������ÿ�˼���
        {
            for (int i=delta; i<keys.length; i++)          //һ�˷������飬ÿ��ֱ�Ӳ�������
            {
                int temp=keys[i], j;                       //keys[i]�ǵ�ǰ������Ԫ��
                for (j=i-delta; j>=0 && temp<keys[j]; j-=delta) //����ֱ�Ӳ����������򣩣�Ѱ�Ҳ���λ��
//                for (j=i-delta; j>=0 && temp>keys[j]; j-=delta) //����ֱ�Ӳ������򣨽��򣩣�Ѱ�Ҳ���λ��
                    keys[j+delta] = keys[j];               //ÿ��Ԫ�����deltaԶ
                keys[j+delta] = temp;                      //����Ԫ��
            }
            System.out.print("delta="+delta+"  ");
            Array1.print(keys);
        }
    }

    //9.2.1   ð������
    private static void swap(int[] keys, int i, int j)     //����keys[i]��keys[j]Ԫ�أ�i��j��Χ�ɵ����߿���
    { 
        int temp = keys[j];
        keys[j] = keys[i];
        keys[i] = temp;
    }

    public static void bubbleSort(int[] keys)              //ð����������
    {
        bubbleSort(keys, true);
    }
    public static void bubbleSort(int[] keys, boolean asc) //ð������ascȡֵtrue�����򣩡�false������
    {
        System.out.println("ð������"+(asc?"��":"��")+"��");
        boolean exchange=true;                             //�Ƿ񽻻��ı��
        for (int i=1; i<keys.length && exchange; i++)      //�н���ʱ�ٽ�����һ�ˣ����n-1��
        {
            exchange=false;                                //�ٶ�Ԫ��δ���� 
            for (int j=0; j<keys.length-i; j++)            //һ�˱Ƚϡ�����
                if (asc ? keys[j]>keys[j+1] : keys[j]<keys[j+1])//����Ԫ�رȽϣ��������򽻻�
                {
                    swap(keys, j, j+1);
                    exchange=true;                         //�н��� 
                }
            System.out.print("��"+i+"�ˣ��±�0��"+(keys.length-i)+"��");
            Array1.print(keys);
        }
    }

    //9.2.2   ��������
    public static void quickSort(int[] keys)               //������������
    {
        System.out.println("������������");
        quickSort(keys, 0, keys.length-1);
    }
    //�Դ���keys����begin��end֮��������н���һ�˿������򣬵ݹ��㷨
    private static void quickSort(int[] keys, int begin, int end)
    {
        if (begin>=0 && begin<keys.length && end>=0 && end<keys.length && begin<end)//������Ч
        {
            int i=begin, j=end;                            //i��j�±�ֱ�������е�ǰ�����˿�ʼ
            int vot=keys[i];                               //�����е�һ��ֵ��Ϊ��׼ֵ
            while (i!=j)
            {
                while (i<j && keys[j]>=vot)                //�����򣩴Ӻ���ǰѰ�ҽ�Сֵ�����ƶ����׼ֵ���Ԫ��
//                while (i<j && vot>=keys[j])                //�����򣩴Ӻ���ǰѰ�ҽϴ�ֵ�����ƶ����׼ֵ���Ԫ��
                    j--;
                if (i<j)
                    keys[i++]=keys[j];                     //�����к�˽�СԪ����ǰ�ƶ�
                while (i<j && keys[i]<=vot)                //�����򣩴�ǰ���Ѱ�ҽϴ�ֵ�����ƶ����׼ֵ���Ԫ��
//                while (i<j && keys[i]>=vot)                //�����򣩴�ǰ���Ѱ�ҽ�Сֵ�����ƶ����׼ֵ���Ԫ��
                    i++;
                if (i<j)
                    keys[j--]=keys[i];                     //������ǰ�˽ϴ�Ԫ������ƶ�
            }
            keys[i]=vot;                                   //��׼ֵ��������λ��
            System.out.print("�±�"+begin+"��"+end+"�� vot="+vot+"��  ");
            Array1.print(keys);            
            quickSort(keys, begin, j-1);                   //ǰ�������������򣬵ݹ����
            quickSort(keys, i+1, end);                     //��������������򣬵ݹ����
        }
    }

    //9.3.1   ֱ��ѡ������
    public static void selectSort(int[] keys)              //ֱ��ѡ����������
    {
        System.out.println("ֱ��ѡ����������");
        for (int i=0; i<keys.length-1; i++)                //n-1������
        {
            int min=i;
            for (int j=i+1; j<keys.length; j++)            //ÿ���ڴ�keys[i]��ʼ����������Ѱ����СԪ��
                if (keys[j]<keys[min])                     //������
//                if (keys[j]>keys[min])                     //������
                     min = j;                              //min��ס������СԪ���±�
            System.out.print("��"+(i+1)+"�ˣ��±�"+i+"��"+(keys.length-1)+"��min="+min+"��");
            if (min!=i)                                    //��������СԪ�ؽ�����ǰ��
                swap(keys, i, min);
            Array1.print(keys);
        }
    }

    //����4�棩9.3.2   ������
/*    public static void heapSort(int[] keys)                //�����򣨽��򣩣���С��
    {
        heapSort(keys,true);
    }
    //�����򣬵�minheapΪtrueʱ��������С�ѣ��������򣻷��򴴽����ѣ���������
    public static void heapSort(int[] keys, boolean minheap)
    {
        for (int i=keys.length/2-1; i>=0; i--)             //������С/��ѣ������ֵ��С/��
            sift(keys, i, keys.length-1, minheap);
        System.out.print("��"+(minheap?"С":"��")+"�����У�");
        Array1.print(keys);
        System.out.println("�ǵݹ��㷨����С�ѣ� "+isHeap(keys,true)+"�����ѣ� "+isHeap(keys,false));
        System.out.print("������"+(minheap?"��":"��")+"�򣩣�");
        for (int i=keys.length-1; i>0; i--)                //ÿ�˽���С/��ֵ���������棬�ٵ�������С/���
        {
            swap(keys, 0, i);                              //����keys[0]��keys[i]
            sift(keys, 0, i-1, minheap);
        }
        Array1.print(keys);
    }
    //��keys��������parentΪ����������������С/��ѣ������з�ΧΪparent��end��
    private static void sift(int[] keys, int parent, int end, boolean minheap)
    {
//        System.out.print("sift  "+parent+".."+end+"  ");
        int child=2*parent+1;                              //child��parent������
        int value=keys[parent];
        while (child<=end)                                 //�ؽ�С/��ֵ���ӽ������ɸѡ
        {
            if (child<end && (minheap ? keys[child]>keys[child+1] : keys[child]<keys[child+1]))
                    child++;                               //child��ס����ֵ��С/����
            if (minheap ? value>keys[child] : value<keys[child])   //����ĸ���ֵ��С/��
            {   keys[parent] = keys[child];                //����С/���ӽ��ֵ����
                parent = child;                            //parent��child���߶�����һ��
                child = 2*parent+1;
            }
            else break;
        }
        keys[parent] = value;                              //��ǰ������ԭ��ֵ�������λ��
//        Array1.print(keys);
    }*/
    
    //����5�棩9.3.2   ������
    public static void heapSort(int[] keys)                //���������򣩣�����
    {
        heapSort(keys,true);
    }
    //��������ascȡֵΪtrue���������򣬴������ѣ������򣬴�����С��
    public static void heapSort(int[] keys, boolean asc) 
    {
        for (int i=keys.length/2-1; i>=0; i--)             //������С/��ѣ������ֵ��С/��
            sift(keys, i, keys.length-1, !asc);
        System.out.print("��"+((!asc)?"С":"��")+"�ѣ�");
        Array1.print(keys);
        System.out.println("�ǵݹ��㷨����С�ѣ� "+isHeap(keys,true)+"�����ѣ� "+isHeap(keys,false));
        System.out.print("������"+((!asc)?"��":"��")+"�򣩣�");
        for (int i=keys.length-1; i>0; i--)                //ÿ�˽���С/��ֵ���������棬�ٵ�������С/���
        {
            swap(keys, 0, i);                              //����keys[0]��keys[i]
            sift(keys, 0, i-1, !asc);
        }
        Array1.print(keys);
    }
    //��keys��������parentΪ����������������С/��ѣ������з�ΧΪparent��end��
    private static void sift(int[] keys, int parent, int end, boolean minheap)
    {
//        System.out.print("sift  "+parent+".."+end+"  ");
        int child=2*parent+1;                              //child��parent������
        int value=keys[parent];
        while (child<=end)                                 //�ؽ�С/��ֵ���ӽ������ɸѡ
        {
            if (child<end && (minheap ? keys[child]>keys[child+1] : keys[child]<keys[child+1]))
                    child++;                               //child��ס����ֵ��С/����
            if (minheap ? value>keys[child] : value<keys[child])   //����ĸ���ֵ��С/��
            {   keys[parent] = keys[child];                //����С/���ӽ��ֵ����
                parent = child;                            //parent��child���߶�����һ��
                child = 2*parent+1;
            }
            else break;
        }
        keys[parent] = value;                              //��ǰ������ԭ��ֵ�������λ��
//        Array1.print(keys);
    }
    //��˼����9-3��
    //�ж�valueָ�����������Ƿ�Ϊ�ѣ���minheapȡֵΪtrue������С�ѣ��������ѡ��ǵݹ��㷨
    public static boolean isHeap(int[] value, boolean minheap)
    {
        if (value.length==0)                               //�����в��Ƕѡ����޴˾䣬��������Ƕѣ����岻ͬ
            return false;
        for (int i=value.length/2-1; i>=0; i--)            //i������һ�������ĸ���㿪ʼ
        {
            int left=2*i+1;                                //left��i�����ӣ��϶�����
            if (minheap ? (value[i]>value[left] || left+1<value.length && value[i]>value[left+1])
                        : (value[i]<value[left] || left+1<value.length && value[i]<value[left+1]))
                return false;                              //��ֵ�ϴ�/Сʱ���϶�������С/���
        }
        return true;
    }

    //9.4   �鲢����
    public static void mergeSort(int[] X)                  //�鲢��������
    {
        System.out.println("�鲢��������");
        int[] Y = new int[X.length];                       //Y���鳤��ͬX����
        int n=1;                                           //���������г��ȣ���ֵΪ1
        while (n<X.length)
        {
            mergepass(X, Y, n);                            //һ�˹鲢����X���������������й鲢��Y
            n*=2;                                          //�����г��ȼӱ�
            if (n<X.length)
            {
                mergepass(Y, X, n);                        //һ�˹鲢����Y�����������������ٹ鲢��X
                n*=2;
            }
        }
    }
    
    //һ�˹鲢����X���������������������鲢��Y�У������г���Ϊn
    private static void mergepass(int[] X, int[] Y, int n)
    {
        System.out.print("�����г���n="+n+"  ");
        for (int i=0;  i<X.length;  i+=2*n)                //��X���������������й鲢��Y��
            merge(X, Y, i, i+n, n);                        //һ�ι鲢
        Array1.print(Y);
    }

    //һ�ι鲢������
    //��X�зֱ���begin1��begin2��ʼ���������������й鲢�����򣩵�Y�У������г���Ϊn
    private static void merge(int[] X, int[] Y, int begin1, int begin2, int n)
    {
        int i=begin1, j=begin2, k=begin1;
        while (i<begin1+n && j<begin2+n && j<X.length)     //��X���������������й鲢��Y��
            if (X[i]<X[j])                                 //�����򣩽���Сֵ���Ƶ�Y��
//            if (X[i]>X[j])                                 //�����򣩽��ϴ�ֵ���Ƶ�Y��
                Y[k++]=X[i++];
            else
                Y[k++]=X[j++];

        while (i<begin1+n && i<X.length)                   //��ǰһ��������ʣ��Ԫ�ظ��Ƶ�Y�У������г��ȿ��ܲ���n
            Y[k++]=X[i++];
        while (j<begin2+n && j<X.length)                   //����һ��������ʣ��Ԫ�ظ��Ƶ�Y��
            Y[k++]=X[j++];
    }
}
//@author��Yeheya��2014-8-29
//@author��Yeheya��2015-3-27


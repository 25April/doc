//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��6��22�գ�JDK 8.11
//��2.2  ���Ա��˳��洢��ʵ��
//��2.2.3  ����˳���
//��3���ã�5.2.2  ϡ�������Ԫ��˳��� �����򣬵�4��ûд
//��9.5.1   ˳���������㷨

//����˳����ࣨ���򣩣�T��T��ĳ�����������ʵ��Comparable<T>�ӿڣ��̳�˳�����
public class SortedSeqList<T extends Comparable<? super T>> extends SeqList<T>
{
    //���췽��
    public SortedSeqList()                                 //���������˳���
    {
        super();                                           //Ĭ�ϵ��ø��๹�췽��SeqList()
    }
    public SortedSeqList(int length)                       //���������˳�������Ϊlength
    {
        super(length);                                     //���ø��๹�췽��SeqList(length)����ʡ�ԣ�Ĭ�ϵ���super()
    }
    public SortedSeqList(T[] values)                       //��������˳�����values�����ṩԪ�أ�O(n2)
    {
        super(values.length);                              //����������˳���ָ������
        for (int i=0; i<values.length; i++)                //ֱ�Ӳ�������ÿ�˲���1��Ԫ�أ�//9.5.1 ˳���������㷨��
            this.insert(values[i]);                        //����Ԫ�أ����ݶ����Сȷ������λ�ã�O(n)
    }
    
    //�������췽��
    //��˳���list��������˳���ֱ�Ӳ��������㷨��O(n*n)��    //SeqList<T>�е�T������SortedSeqList<T>�е�T���ɱȽϴ�С
    public SortedSeqList(SeqList<? extends T> list)
    {
        super();                                           //����������˳���Ĭ�ϵ��ø��๹�췽��SeqList()
        for (int i=0; i<list.n; i++)             //2.2.3
            this.insert(list.get(i));                      //�������า�ǵ�insert(T)��������ֵ���룬O(n)
//      this.addAll(list);                       //forҲ��д�ɣ��̲Ĵ�ʱ��û�н���addAll()��//9.5.1

//����           this(list.element);                                //����SortedSeqList(T[] values) 
//���У�list.element������Object[]������T[]
    }//9.5.1   ˳���������㷨 ��д

    public SortedSeqList(SortedSeqList<? extends T> list)  //����˳���Ŀ������췽���������O(n)
    {
        super(list);                                       //����SeqList(SeqList<T>)��list��������ʵ�����������͸�ֵ����
    }
    //����toPreviousString()�����õ�������������Ա�

    //��֧�ָ���������������������串�ǲ��׳��쳣
    public void set(int i, T x)
    {
        throw new UnsupportedOperationException("set(int i, T x)");
    }

    //������Ҫ�ã������ǣ�����������׳��쳣����
    public int insert(int i, T x)
    {        
        throw new java.lang.UnsupportedOperationException("insert(int i, T x)");
    }
    
    //˳������״γ��ֵ���key���Ԫ�أ�����Ԫ�����i��0��i<n���������Ҳ��ɹ�����-1��O(n)������
    public int search(T key)
    {
//        System.out.print(this.getClass().getName()+".indexOf("+key+","+start+")��");
        for (int i=0; i<this.n && key.compareTo(this.get(i))>=0; i++)//������
        {
//            System.out.print(this.element[i]+"��");
            if (key.compareTo(this.get(i))==0)             //������ȣ�����ʱ��̬
                return i;
        }
        return -1;                                         //�ձ��δ�ҵ�ʱ
    }
    
    //����x��x!=null������x�����С˳�����ȷ������λ�ã����򣩣������ڵ�ֵ���֮ǰ������x��ţ�O(n)��
    //����T��compareTo()�����Ƚ϶����С�����Ǹ���insert(x)�������б�ͷ���ֵ��ͬ
    public int insert(T x)
    {
        int i=0;
        if (this.isEmpty() || x.compareTo(this.get(this.n-1))>0)//compareTo(T)�Ƚϴ�С
            i=this.n;                                      //���ֵβ���룬O(1) 
        else
            while (i<this.n && x.compareTo(this.get(i))>0) //Ѱ�Ҳ���λ�ã�����
                i++;
        super.insert(i, x);                      //���ø��౻���ǵ�insert(i,x)����������x��Ϊ��i��Ԫ�� 
        return i;
    }

    //�̳У�����ʱ��̬
/*    public T remove(T key)                                 //ɾ���״γ��ֵ���key���Ԫ�أ����ر�ɾ��Ԫ�أ����Ҳ��ɹ�����null������
    {
        return this.remove(this.search(key));              //�Ȳ��ң���remove(i)�������ҷ���-1����ɾ��
                                                           //����this.search(key)��������Ĳ��ҷ���
    }*/
    //2015��1��30�ղ��ԣ�У��������ȷ������Ҫ��д��

    
    //��˼����2-4��ϰ����
//    public void addAll(SeqList<? extends T> list)      //�̳�

//    public SeqList<T> union(SeqList<? extends T> list)     //�̳�
    public SortedSeqList<T> union(SeqList<? extends T> list) //���ǣ�����ֵ���Ͳ�ͬ����ֵ���ݣ���������SortedSeqList<? extends T> 
    {
        SortedSeqList<T> result = new SortedSeqList<T>(this);   //��������ʵ�����������ʵ����ֻ��һ�䲻ͬ
        result.addAll(list);                                //����˳���ϲ�����ֵ����
        return result;                                      //����SortedSeqList<T>����
    }

    //��ʵ��2-2��  ����˳������ӳ�Ա������Ҳ������������DifferentSortedSeqListʵ�֣�
    public int insertDifferent(T x)                        //���벻�ظ�Ԫ�ء����Ҳ��ɹ�ʱ�����롣����
    {
        int i=0;
        if (this.isEmpty() || x.compareTo(this.get(this.n-1))>0)//compareTo(T)�Ƚϴ�С
            i=this.n;                                      //���ֵβ���룬O(1) 
        else
            while (i<this.n && x.compareTo(this.get(i))>0) //Ѱ�Ҳ���λ�ã�����
                i++;
        if (x.compareTo(this.get(i))<0)                    //���벻�ظ�Ԫ��
        {
            super.insert(i, x);                            //���ø��౻���ǵ�insert(i,x)����������x��Ϊ��i��Ԫ�� 
            return i;
        }
        return -1;
    }
    //author��Yeheya��2015-4-28

    
    //8.2   ��������˳���Ķ��ַ�����     ��4��̲�û��д��д����Ķ��ַ�������
    //���ַ����ҹؼ���ΪkeyԪ�أ������ҳɹ������±꣬���򷵻�-1    
    public int binarySearch(T key)
    {
        return binarySearch(key, 0, this.n-1);
//    	return SortedArray.binarySearch((T)this.element, key);  //�﷨���󣬲��ܽ�Object[]ת����T[]
    }  
    //��begin��end��Χ�ڣ����ַ����ҹؼ���ΪkeyԪ�أ������ҳɹ������±꣬���򷵻�-1��
    //��key==null��Java���׳��ն����쳣����begin��endԽ�磬����-1
    public int binarySearch(T key, int begin, int end)
    {
        while (begin<=end)                                 //�߽���Ч
        {   int mid = (begin+end)/2;                       //ȡ�м�λ�ã���ǰ�Ƚ�Ԫ��λ��
            System.out.print(this.get(mid)+"? ");          //��ʾ�Ƚ��м�������ʡ��
            if (key.compareTo(this.get(mid))==0)           //���������
                return mid;                                //���ҳɹ�
            if (key.compareTo(this.get(mid))<0)            //key�����С
                end = mid-1;                               //���ҷ�Χ��С��ǰ���
            else begin = mid+1;                            //���ҷ�Χ��С������
        }
        return -1;                                         //���Ҳ��ɹ�
    }
    //���ܵ������·������������Ϊ���ܽ�Object[]ת����T[]        
    //SortedArray.binarySearch((T)this.element, begin, end, key);
    //���Ƚ�����������
    //@author��Yeheya��2014-8-9
    
    
    //��9��
    //9.5.1   ˳���������㷨
    //ע�⣬����3������������������飬û�и��ƶ��󣬲�������ڹ��ö�������
/*    public SortedSeqList(T[] values)             //��������˳�����values�����ṩԪ��
    {
        super(values);                           //����˳�����values�����ṩԪ��
        //����һ�������㷨��˳����this.element����Ԫ�ؽ��������㷨ʡ��
                
        Array9.insertSort(this.element);        //���������㷨����˳��������Ԫ�ؽ�������
                                                 //�������Ϊ���ܽ�Object[]ת����T[]        
    }
    
    //��˳���list��������˳���
    public SortedSeqList(SeqList<? extends T> list)    //SeqList<T>�е�T����SortedSeqList<T>��������T���ɱȽϴ�С
    {
        super(list);                             //˳������������˳���δ����Ԫ�ض���
        //���²���һ�������㷨��˳����this.element����Ԫ�ؽ��������㷨ʡ�ԣ���Ҫ����SeqList<T>�ĳ�Ա����element��n��������ߵ�Ȩ��Ӧ����Ϊprotected
//      Array9.insertSort((T)this.element);           //�﷨���󣬲��ܰ�Object[]ת����T[]
        for (int i=1; i<this.n; i++)             //ֱ�Ӳ�����������
        {
            T temp=(T)this.element[i];           //���棺ǿ������ת��Object��T������ȫ
            int j;
            for (j=i-1; j>=0 && temp.compareTo((T)this.element[j])<0; j--)  //(T)this.element[j]��T�ɱȽϴ�С
                this.element[j+1] = this.element[j];
            this.element[j+1] = temp;
        }
    }*/
    
    
    //9.5.1   ˳���������㷨
    //��ʵ����9-2��
    //�鲢��������˳������򣩣���list������Ԫ�ع鲢��this�У����ı�list��
    //this+=list��һ�ι鲢�㷨
    //����Java�Ķ�������ģ�ͣ��Զ����������ᵼ������C++�ظ��ͷŴ洢��Ԫ�ռ����⣬��û�и���Ԫ��
    //��list==null���׳��ն����쳣
    //��4��̲ķ�����ʡ��
    public void merge(SortedSeqList<? extends T> list)  
    {
        Object[] temp = this.element;
        this.element = new Object[(this.n+list.n)*2];  //���䵱ǰ˳�������
        int i=0, j=0, k=0;
        while (i<this.n && j<list.n)
            if (((T)temp[i]).compareTo((T)list.element[j])<=0)
                this.element[k++]=temp[i++];
            else
            	this.element[k++]=list.element[j++];

        while (i<this.n)
            this.element[k++]=temp[i++];
        while (j<list.n)
            this.element[k++]=list.element[j++];
        this.n+=list.n;
    }
    
    //����this��list�鲢�����򣩺������˳������ı�this��list˳���һ�ι鲢�㷨��������ʡ��
    public SortedSeqList<T> mergeWith(SortedSeqList<? extends T> list)  
    {
        SortedSeqList<T> templist = new SortedSeqList<T>((this.n+list.n)*2);
        int i=0, j=0, k=0;
        while (i<this.n && j<list.n)
            if (((T)this.element[i]).compareTo((T)list.element[j])<=0)
                templist.element[k++]=this.element[i++];
            else
                templist.element[k++]=list.element[j++];

        while (i<this.n)
            templist.element[k++]=this.element[i++];
        while (j<list.n)
            templist.element[k++]=list.element[j++];
        templist.n=this.n+list.n;
        return templist;
    }
}
    //@author��Yeheya��2014-8-19

//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��7��24��
//7.2   ͼ�ı�ʾ��ʵ��
//7.2.1   ͼ���ڽӾ����ʾ��ʵ��
//4. �ڽӾ����ʾ�Ĵ�Ȩͼ��

//�ڽӾ����ʾ�Ĵ�Ȩͼ�࣬T��ʾ����Ԫ�����ͣ��̳г���ͼ��
public class MatrixGraph<T> extends AbstractGraph<T>
{
    protected Matrix matrix;                               //������󣬴洢ͼ���ڽӾ���
    
    //�����ͼ��������Ϊ0������Ϊ0��lengthָ������˳����������ڽӾ�������
    public MatrixGraph(int length)
    {
        super(length);                                   //��������Ϊlength�Ŀ�˳���
        this.matrix = new Matrix(length);                //����length��length���󣬳�ֵΪ0
    }
    public MatrixGraph()                                   //�����ͼ��������Ϊ0������Ϊ0
    {
        this(10);                                          //����˳�����ڽӾ����Ĭ������Ϊ10
    }
    public MatrixGraph(T[] vertices)                       //��vertices���㼯�Ϲ���ͼ������Ϊ0
    {
        this(vertices.length);                             //����ָ�������Ŀ�ͼ
        for (int i=0; i<vertices.length; i++)
            this.insertVertex(vertices[i]);                //����һ������
    } 
    public MatrixGraph(T[] vertices, Triple[] edges)       //��vertices���㼯�Ϻ�edges�߼��Ϲ���ͼ
    {
        this(vertices);                                    //��vertices���㼯�Ϲ���ͼ��û�б�
        for (int j=0; j<edges.length; j++)
            this.insertEdge(edges[j]);                     //����һ����
    }

    public String toString()                               //����ͼ�Ķ��㼯�Ϻ��ڽӾ��������ַ���
    {
        String str = super.toString()+"�ڽӾ���:  \n";
//        str+=this.matrix.toString();
        int n = this.vertexCount();                        //������
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<n; j++)
                if (this.matrix.get(i,j)==MAX_WEIGHT)
                    str += "     ��";
                else  str += String.format("%6d", this.matrix.get(i,j));
            str+="\n";
        }
        return str;
    }
    //����7.1�� ��Ȩ����ͼ3�Ĺ��졢���뼰ɾ��������

    //��1�������
    public void insertEdge(int i, int j, int weight)       //����ߡ�vi,vj����ȨֵΪweight
    {
        if (i!=j)                                          //���ܱ�ʾ����
        {
            if (weight<=0 || weight>MAX_WEIGHT)            //�ߵ�Ȩֵ�ݴ���Ϊ�ޱߣ�ȡֵ��
                weight=MAX_WEIGHT;
            this.matrix.set(i,j,weight);                   //���þ���Ԫ��[i,j]ֵΪweight����i��jԽ�磬�׳����Խ���쳣
        }
        else throw new IllegalArgumentException("���ܲ���������i="+i+"��j="+j);
    }
    public void insertEdge(Triple edge)                    //����һ����
    {
        this.insertEdge(edge.row, edge.column, edge.value);
    }
    
    //��2�����붥��
    public int insertVertex(T x)                           //����Ԫ��Ϊx�Ķ��㣬����x�������
    {
        int i = this.vertexlist.insert(x);                 //����˳���β����x������x��ţ��Զ�����
        if (i >= this.matrix.getRows())                    //���ڽӾ�������������
            this.matrix.setRowsColumns(i+1,i+1);           //�������ݡ������ڽӾ���������ͬͼ�Ķ�����
        for (int j=0; j<i; j++)                            //��ʼ����i�С���Ԫ��ֵΪ�ޡ�i==jֵ��Ϊ0
        {
            this.matrix.set(i,j,MAX_WEIGHT);
            this.matrix.set(j,i,MAX_WEIGHT);  
        }
        return i;                                          //���ز��붥�����
    }     
    
    //��3��ɾ����
    public void removeEdge(int i, int j)                   //ɾ���ߡ�vi,vj��������Ȩֵ
    {
        if (i!=j)
            this.matrix.set(i, j, MAX_WEIGHT);             //���ñߵ�ȨֵΪ�ޡ���i��jԽ�磬�׳����Խ���쳣
    }
    public void removeEdge(Triple edge)                    //ɾ���ߣ�����Ȩֵ
    {
        this.removeEdge(edge.row, edge.column);
    }    
    
    //��4��ɾ������
    public void removeVertex(int i)                        //ɾ������vi�������й����ı�
    {
        int n=this.vertexCount();                          //ԭ������
        if (i>=0 && i<n)
        {
            this.vertexlist.remove(i);                     //ɾ������˳����i��Ԫ�أ���������1��  //˳���ɾ������iԽ�磬����null
            for (int j=i+1; j<n; j++)                      //��i+1��n-1��Ԫ������һ�У�nΪԭ������
                for (int k=0; k<n; k++)
                    this.matrix.set(j-1, k, this.matrix.get(j,k));
            for (int j=0; j<n; j++)
                for (int k=i+1; k<n; k++)                  //��i+1��n-1��Ԫ������һ��
                    this.matrix.set(j, k-1, this.matrix.get(j,k));
            this.matrix.setRowsColumns(n-1, n-1);          //�ڽӾ�����һ��һ��
        }
        else throw new IndexOutOfBoundsException("i="+i);  //�׳����Խ���쳣
    }
    
    //��5�� ����ڽӶ���ͱߵ�Ȩֵ���� 
    public int weight(int i, int j)           //����<vi,vj>�ߵ�Ȩֵ������ͼ����С�����������·�����㷨
    {
        return this.matrix.get(i,j);             //���ؾ���Ԫ��[i,j]ֵ����i��jԽ�磬�׳����Խ���쳣
    }
    
    //���ض���vi��vj��ĺ���ڽӶ������ ����j=-1������vi�ĵ�һ���ڽӶ�����ţ��������ں���ڽӶ��㣬����-1������7.3��ͼ�ı����㷨
    protected int next(int i, int j)
    {
        int n=this.vertexCount();
        if (i>=0 && i<n && j>=-1 && j<n && i!=j) 
            for (int k=j+1; k<n; k++)                      //��j=-1ʱ��k��0��ʼѰ�Һ���ڽӶ���
                if (this.matrix.get(i,k)>0 && this.matrix.get(i,k)<MAX_WEIGHT)//Ȩֵ��ʾ�б�
                    return k;
        return -1;         
    }  

    public void removeVertex(T vertex)           //ɾ������vertex��������ı�
    {
        int i=this.vertexlist.search(vertex);    //��˳����в���ֵΪvertex��Ԫ�أ��������
        this.removeVertex(i);                    //ɾ������vi��������ı�
    } 
}
//@author��Yeheya��2015-3-15

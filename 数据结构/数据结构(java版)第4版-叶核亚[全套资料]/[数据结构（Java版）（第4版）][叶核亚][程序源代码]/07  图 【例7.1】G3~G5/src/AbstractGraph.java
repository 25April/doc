//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��8��1��
//7.2  ͼ�ı�ʾ��ʵ��
//7.3  ͼ�ı���
//����ͨͼ������������������͹��������������

//7.2.1   ͼ���ڽӾ����ʾ��ʵ�� //2.  ��������ͼ���ʾ���㼯��
public abstract class AbstractGraph<T>                     //����ͼ�࣬T��ʾ����Ԫ������
{
    protected static final int MAX_WEIGHT=99999;//0x0000ffff;      //���Ȩֵ����ʾ�����ޣ���������Integer.MAX_VALUE;
    protected SeqList<T> vertexlist;                       //����˳����洢ͼ�Ķ��㼯��

    public AbstractGraph(int length)                       //�����ͼ��������Ϊ0��lengthָ������˳�������
    {
        this.vertexlist = new SeqList<T>(length);          //��������Ϊlength�Ŀ�˳���//��length<0��Java�׳������鳤���쳣
    }
    public AbstractGraph()                                 //�����ͼ��������Ϊ0
    {
        this(10);                                          //˳���Ĭ������Ϊ10
    }

    public int vertexCount()                               //����ͼ�Ķ�����
    {
        return this.vertexlist.size();                     //���ض���˳����Ԫ�ظ���
    }

    public String toString()                               //����ͼ�Ķ��㼯�������ַ���
    {
        return "���㼯�ϣ�"+this.vertexlist.toString()+"\n";
    }

    public T getVertex(int i)                              //���ض���viԪ��
    {
        return this.vertexlist.get(i);                     //��iԽ�磬�򷵻�null
    }//������

    public void setVertex(int i, T x)                      //���ö���viԪ��Ϊx
    {
        this.vertexlist.set(i,x);                          //��iԽ�磬���׳��쳣
    }
    
    //���³��󷽷�û�з����壬�������ṩʵ��
    public abstract int insertVertex(T x);                 //β����Ԫ��Ϊx�Ķ��㣬����x�������
    public abstract void removeVertex(int i);              //ɾ������vi�������й����ı�
    public abstract int weight(int i, int j);              //����<vi,vj>�ߵ�Ȩֵ

    //����vi��vj��ĺ���ڽӶ������ ����j=-1������vi�ĵ�һ���ڽӶ�����ţ��������ں���ڽӶ��㣬����-1��
    protected abstract int next(int i, int j);


    //7.3   ͼ�ı���    
    //7.3.1   ͼ�����������������
    public void DFSTraverse(int i)                         //����ͨͼ��һ��������������������Ӷ���vi����
    {
        boolean[] visited=new boolean[this.vertexCount()]; //���ʱ�����飬Ԫ�س�ֵΪfalse����ʾδ������
        int j=i;
        do
        {   if (!visited[j])                               //������vjδ�����ʡ���iԽ�磬Java���׳������±����Խ���쳣
            {
                System.out.print("{ ");
                this.depthfs(j, visited);                  //�Ӷ���vj������һ�������������
                System.out.print("} ");
            }
            j = (j+1) % this.vertexCount();                //��������ͨ������Ѱ��δ�����ʶ���
        } while (j!=i);
        System.out.println();
    }
    //�Ӷ���vi������һ�������������������һ����ͨ������visitedָ�����ʱ�����顣�ݹ��㷨
    private void depthfs(int i, boolean[] visited)
    {
        System.out.print(this.getVertex(i)+" ");           //���ʶ���vi
        visited[i] = true;                                 //���÷��ʱ��
        for (int j=this.next(i,-1); j!=-1; j=this.next(i,j))//j���λ��vi�������ڽӶ������
            if(!visited[j])                                //���ڽӶ���vjδ������
                depthfs(j, visited);                       //��vj������������������������ݹ����
    }

    //7.3.2   ͼ�Ĺ��������������
    public void BFSTraverse(int i)                         //����ͨͼ��һ�ι�����������������Ӷ���vi����
    {
        boolean[] visited = new boolean[this.vertexCount()]; //���ʱ������
        int j=i;
        do
        {   if (!visited[j])                               //������vjδ������
            {
                System.out.print("{ ");
                breadthfs(j, visited);                     //��vj������һ�ι����������
                System.out.print("} ");
            }
            j = (j+1) % this.vertexCount();                //��������ͨ������Ѱ��δ�����ʶ���
        } while (j!=i);
        System.out.println();
    }
        
    //�Ӷ���vi������һ�ι����������������һ����ͨ������ʹ�ö���
    private void breadthfs(int i, boolean[] visited)
    {
        System.out.print(this.getVertex(i)+" ");           //���ʶ���vi
        visited[i] = true;                                 //���÷��ʱ��
//        SeqQueue<Integer> que = new SeqQueue<Integer>(this.vertexCount());   //����˳�����
        LinkedQueue<Integer> que = new LinkedQueue<Integer>();   //������ʽ����
        que.add(i);                                        //���ʹ��Ķ���vi�����ӣ��Զ�ת����Integer(i))
        while (!que.isEmpty())                             //�����в���ʱѭ��
        {
            i = que.poll();                                //���ӣ��Զ�ת����int;
            for (int j=next(i,-1); j!=-1; j=next(i,j))     //j���λ��vi�������ڽӶ���
                if (!visited[j])                           //������vjδ���ʹ�
                {
                    System.out.print(this.getVertex(j)+" ");//���ʶ���vj
                    visited[j] = true;
                    que.add(j);                            //���ʹ��Ķ���vj������
//                    System.out.println("������У�"+que.toString());                    
                }
        }
    }

    //7.4.2   ��С�������Ĺ����㷨
    //Prim�㷨�������Ȩ����ͼ����С�������������С�������ĸ��߼�����
    public void minSpanTree()
    {
        Triple[] mst = new Triple[vertexCount()-1];        //��С�������ı߼��ϣ�����Ϊ������n-1
        for (int i=0; i<mst.length; i++)                   //�߼��ϳ�ʼ�����Ӷ���v0��������
            mst[i]=new Triple(0,i+1,this.weight(0,i+1));   //�����v0������������ı�

        for (int i=0; i<mst.length; i++)                   //ѡ��n-1���ߣ�ÿ��ȷ��һ��Ȩֵ��С�ıߡ�һ��ѡ�������㷨
        {
            System.out.print("mst�߼��ϣ�");
            for(int j=0; j<mst.length; j++)
                System.out.print(mst[j].toString()+",");            
            System.out.println();            
            
//�̲ĵ�1��ӡˢ��            int minweight=MAX_WEIGHT, min=i;               //��СȨֵ���ߵ��±�
            int min=i;//, minweight=mst[i].value;               //��СȨֵ���ߵ��±�
            for (int j=i+1; j<mst.length; j++)             //��i��n-1��Χ�ڣ�Ѱ��Ȩֵ��С�ı�
                if (mst[j].value < mst[min].value)//minweight)              //�����ڸ�СȨֵ���������Сֵ����
                {
//                    minweight = mst[j].value;              //��СȨֵ
                    min = j;                               //���浱ǰȨֵ��С�ߵ����
                }
            
            //��Ȩֵ��С�ıߣ���min�ǵã���������i��Ԫ�أ���ʾ�ñ߼���TE����
            Triple edge = mst[min];
            if (min!=i)
            {
                mst[min] = mst[i];
                mst[i] = edge;
            }
        
            //��i+1��n-1����������Ȩֵ��С�ı��滻
            int tv = edge.column;                          //�ղ���TV�Ķ���
            for (int j=i+1; j<mst.length; j++)
            {
                int v = mst[j].column;                     //ԭ����V-TV�е��յ�
                int weight = this.weight(tv,v);
                if (weight<mst[j].value)                   //��(tv,v)�߱ȵ�j���ߵ�Ȩֵ��С�����滻
                    mst[j] = new Triple(tv,v,weight);
            }
        }
        
        System.out.print("\n��С�������ı߼��ϣ�");
        int mincost=0;
        for (int i=0; i<mst.length; i++)                   //�����С�������ı߼��Ϻʹ���
        {
            System.out.print(mst[i]+" ");
            mincost += mst[i].value;
        }
        System.out.println("����С����Ϊ"+mincost);
    }

    //7.5   ���·��
    //7.5.1   �Ǹ�Ȩֵ�ĵ�Դ���·����Dijkstra�㷨��
    public void shortestPath(int i)              //���Ȩͼ�ж���vi�ĵ�Դ���·����Dijkstra�㷨
    {
        int n = this.vertexCount();              //ͼ�Ķ�����
        boolean[] vset = new boolean[n];         //��������·���Ķ��㼯�ϣ���ֵȫΪfalse
        vset[i] = true;                          //���Դ��vi�ڼ���S�С���iԽ�磬Java�׳����Խ���쳣
        int[] dist = new int[n];                 //���·������
        int[] path = new int[n];                 //���·�����յ��ǰһ������
        for (int j=0; j<n; j++)                  //��ʼ��dist��path����
        {
            dist[j] = this.weight(i,j);
            path[j] = (j!=i && dist[j]<MAX_WEIGHT) ? i : -1;
        }
//        System.out.print("\nvset����"+toString(vset));
//        System.out.print("\tpath����"+toString(path));
//        System.out.print("\tdist����"+toString(dist));
        
        for (int j=(i+1)%n; j!=i; j=(j+1)%n)     //Ѱ�Ҵ�vi��vj�����·����vj��V-S������
        {
            int mindist=MAX_WEIGHT, min=0;       //��·��������Сֵ�����±�
            for (int k=0; k<n; k++)
                if (!vset[k] && dist[k]<mindist)
                {
                    mindist = dist[k];           //·��������Сֵ
                    min = k;                     //·��������Сֵ�±�
                }
            if (mindist==MAX_WEIGHT)             //��û���������·�����㷨������ �����Է���ͨͼ����
                break;
            vset[min] = true;                    //ȷ��һ�����·�����յ�min���뼯��S
            for (int k=0; k<n; k++)              //������vi��V-S��������������·��������
                if (!vset[k] && this.weight(min,k)<MAX_WEIGHT && dist[min]+this.weight(min,k)<dist[k])
                {
                    dist[k] = dist[min] + this.weight(min,k);//�ø���·���滻
                    path[k] = min;                   //���·������min����
                }    
//            System.out.print("\nvset����"+toString(vset));
//            System.out.print("\tpath����"+toString(path));
//            System.out.print("\tdist����"+toString(dist));
        }

        System.out.print(this.getVertex(i)+"�ĵ�Դ���·����");
        for (int j=0; j<n; j++)                            //�������vi�ĵ�Դ���·��
            if (j!=i)
            {
                SinglyList<T> pathlink = new SinglyList<T>();//·����������¼���·�������ĸ����㣬���ڷ���
                pathlink.insert(0, this.getVertex(j));     //������������·���յ�vj
                for (int k=path[j]; k!=i && k!=j && k!=-1; k=path[k])
                    pathlink.insert(0, this.getVertex(k)); //������ͷ���뾭���Ķ��㣬����
                pathlink.insert(0, this.getVertex(i));     //���·�������vi
                System.out.print(pathlink.toString()+"����"+(dist[j]==MAX_WEIGHT ? "��" : dist[j])+"��");
            }
        System.out.println();
    }
    private static String toString(int[] value)        //�������ֵ
    {
        if (value!=null && value.length>0)
        {
            String str="{";
            int i=0;
            for(i=0; i<value.length-1; i++)
                str += (value[i]==MAX_WEIGHT ? "��" : value[i])+",";
            return str+(value[i]==MAX_WEIGHT ? "��" : value[i])+"}";
        }
        return null;        
    }
    //@author��Yeheya��2014-8-8

   
    //7.5.2   ÿ�Զ��������·����Floyd�㷨��
    public void shortestPath()                  //���Ȩͼÿ�Զ��������·�������ȣ�Floyd�㷨
    {
        int n=this.vertexCount();                          //ͼ�Ķ�����
        Matrix path=new Matrix(n), dist=new Matrix(n);     //���·�������Ⱦ��󣬳�ֵΪ0
        for (int i=0; i<n; i++)                            //��ʼ��dist��path����
            for (int j=0; j<n; j++)
            {   int w=this.weight(i,j);
                dist.set(i,j,w);                           //dist��ֵ��ͼ���ڽӾ���
                path.set(i,j, (i!=j && w<MAX_WEIGHT ? i : -1));
            }
        System.out.println("dist"+dist.toString()+"path"+path.toString()+"·������");
        printPathAll(path);

        for (int k=0; k<n; k++)                            //��vk��Ϊ����·�����м䶥��
        {
            System.out.println("\n��"+this.getVertex(k)+"��Ϊ�м䶥�㣬�滻·�����£�");
            for (int i=0; i<n; i++)                        //����ÿ�Դ�vi��vj·�������Ƿ����
                if (i!=k)
                    for (int j=0; j<n; j++)
                        if (j!=k && j!=i)
                        {
                        System.out.print(toPath(path,i,j)+"·������"+dist.get(i,j)+"���滻Ϊ"+
                            toPath(path,i,k)+","+toPath(path,k,j)+"·������"+(dist.get(i,k)+dist.get(k,j))+"��");
                        if (j!=k && j!=i && dist.get(i,j) > dist.get(i,k)+dist.get(k,j))//�����̣����滻
                        {
                            dist.set(i, j, dist.get(i,k)+dist.get(k,j));
                            path.set(i, j, path.get(k,j));
                            System.out.println("�ǣ�d"+i+j+"="+dist.get(i,j)+"��p"+i+j+"="+path.get(i,j));
                        }
                        else
                            System.out.println("��");
                        }
            System.out.println("dist"+dist.toString()+"path"+path.toString()+"·������");
            printPathAll(path);
        }
    
        System.out.println("\nÿ�Զ��������·�����£�");
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<n; j++)
                if (i!=j)
                    System.out.print(toPath(path,i,j)+"����"+(dist.get(i,j)==MAX_WEIGHT ? "��" : dist.get(i,j))+"��");
            System.out.println();
        }
    }
//    System.out.print(pathlink.toString()+"����"+(dist[j]==MAX_WEIGHT ? "��" : dist[j])+"��");
    
    private String toPath(Matrix path, int i, int j)           //����path·�������дӶ���vi��vj��һ��·���ַ���
    {
        SinglyList<T> pathlink = new SinglyList<T>();//·����������¼���·�������ĸ����㣬���ڷ���
        pathlink.insert(0, this.getVertex(j));     //������������·���յ�vj
        for (int k=path.get(i,j); k!=i && k!=j && k!=-1;  k=path.get(i,k))
            pathlink.insert(0, this.getVertex(k)); //������ͷ���뾭���Ķ��㣬����
        pathlink.insert(0, this.getVertex(i));     //���·�������vi
        return pathlink.toString();
    }
    private void printPathAll(Matrix path)                 //���path·��������ÿ�Զ�����·���ַ���
    {
        for (int i=0; i<path.getRows(); i++)
        {
            for (int j=0; j<path.getRows(); j++)                
                System.out.print(toPath(path,i,j)+" ");
            System.out.println();
        }
    }

/*    public static String toString(int[][] value) 
    {
        String str="";
    	for (int i=0; i<value.length; i++) 
    	{
            for (int j=0; j<value[i].length; j++) 
                str += value[i][j]==MAX_WEIGHT ? "  ��" : "  "+value[i][j];
            str+="\n";
    	}
        return str;
    }*/

    //10.3.4   ���ݷ���2014��11��4��    
}
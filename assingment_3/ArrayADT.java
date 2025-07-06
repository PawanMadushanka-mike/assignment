public class ArrayADT
{
    int[] arr;
    int size=0;

    public ArrayADT(int capacity)
    {
        arr=new int[capacity];

    }

    public boolean isEmpty()
    {
        return size==0;
    }

    public boolean isFull()
    {
        return size==arr.length;
    }

    public void insert(int index,int value)
    {
        if(index<0 || index>=arr.length)
        {
            throw new IndexOutOfBoundsException("Index is out of range");
        }

        else if(isFull())
        {
            System.out.println("Array is full");
        } 

        else
        {
            for(int i=size-1;i>=index;i--)
            {
                arr[i+1]=arr[i];

            }
            arr[index]=value;
            size++;
        }

    }

    public int secondLarge()
    {
        int first=Integer.MIN_VALUE;
        int second=Integer.MIN_VALUE;

        for(int i=0;i<size;i++)
        {
            if(arr[i]>first)
            {
                second=first;
                first=arr[i];
            }
            else if(arr[i]>second && arr[i]!=first)
            {
                second = arr[i];
            }
        }
            
        if(second==Integer.MIN_VALUE)
        {
            throw new IllegalStateException("All elements are equal or no second largest element");
        }

        return second;
            
        
    }

    public int countOccurence(int value)
    {
            int count=0;
            for(int i=0;i<size;i++)
            {
                if(arr[i]==value)
                {
                    count++;
                }
            }
            return count;
    }

        public void removeDuplicate()
        {
            for(int i=0;i<size-1;i++)
            {
                for(int j=i+1;j<size;)
                {
                    if(arr[i]==arr[j])
                    {
                        for(int k=j;k<size-1;k++)
                        {
                            arr[k]=arr[k+1];
                        }
                        arr[size-1]=0;
                        size--;
                        System.out.println("remove:"+arr[i]);
                    }
                    else
                    {
                        j++;
                    }
                }
            }
        }

        public void insertionSort()
        {
            int key;
            int i;
            for(int j=1;j<size;j++)
            {
                key=arr[j];
                i=j-1;
                while(i>=0 && arr[i]>key)
                {
                    arr[i+1]=arr[i];
                    i--;
                }
                arr[i+1]=key;
            }
            traverse();

            
        }

        public void traverse()
        {
            if (isEmpty())
            {
                System.out.println("array is empty");
            }

            else
            {
                for(int i=0;i<size;i++)
                {
                    System.out.print(arr[i]+",");
                }
                System.out.println("");
            }
        }
      
    



    public static void main(String args[])
    {
        ArrayADT a1=new ArrayADT(4);
        a1.insert(0,6);
        a1.insert(1,5);
        a1.insert(2,6);
        a1.insert(3,11);
        
        System.out.println(a1.secondLarge()+" is the second largest element");
        System.out.println("Number of occurences "+a1.countOccurence(6));
        a1.removeDuplicate();
        a1.insertionSort();

    }


}